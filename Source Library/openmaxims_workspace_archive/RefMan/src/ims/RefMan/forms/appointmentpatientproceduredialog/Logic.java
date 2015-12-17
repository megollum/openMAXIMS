// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.appointmentpatientproceduredialog;

import java.util.ArrayList;
import java.util.List;

import ims.RefMan.forms.appointmentpatientproceduredialog.GenForm.OutcomeEnumeration;
import ims.RefMan.vo.PatientProcedureApptDetailVo;
import ims.clinical.vo.lookups.CodingItemType;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.lookups.PatientProcedureStatus;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}

	private void open()
	{
		populateScreenFromData(form.getGlobalContext().RefMan.getAppointmentPatientProcedure());
		updateControlsState();
	}

	private void updateControlsState()
	{
		form.lblReason().setVisible(OutcomeEnumeration.rdoIncomplete.equals(form.Outcome().getValue()));
		form.cmbReason().setVisible(OutcomeEnumeration.rdoIncomplete.equals(form.Outcome().getValue()));
		form.cmbReason().setEnabled(FormMode.EDIT.equals(form.getMode()));
	}

	private void populateScreenFromData(PatientProcedureApptDetailVo patientProcedure)
	{
		if(patientProcedure == null)
			return;
		
		form.ccProcedure().setValue(patientProcedure);
		form.ccAuthoring().setValue(patientProcedure.getAuthoringInformation());
		form.chkPrimary().setValue(patientProcedure.getIsPrimaryProcedure());
		form.pdtProcDate().setValue(patientProcedure.getProcDate());
		
		PatientProcedureStatus status = patientProcedure.getProcedureStatus();
		form.Outcome().setValue(PatientProcedureStatus.PERFORMED.equals(status) ? OutcomeEnumeration.rdoComplete : (PatientProcedureStatus.INCOMPLETE.equals(status) ? OutcomeEnumeration.rdoIncomplete : null));
		
		form.cmbReason().setValue(patientProcedure.getIncompleteReason());
	}

	private void initialize()
	{
		form.ccProcedure().setCodingItemType(CodingItemType.PROCEDURE);
		form.ccProcedure().setIsRequired(true);
		form.ccProcedure().setParentEditing(true);
		
		form.ccProcedure().setEnabled(false);
	}

	@Override
	protected void onBtnCancelClick() throws PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onBtnSaveClick() throws PresentationLogicException
	{
		if(save())
			engine.close(DialogResult.OK);
	}

	private boolean save()
	{
		PatientProcedureApptDetailVo patientProcedure = populateDataFromScreen();
		
		String[] errors = patientProcedure.validate(validateUIRules());
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try
		{
			form.getGlobalContext().RefMan.setAppointmentPatientProcedure(domain.savePatientProcedure(patientProcedure));
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
			return false;
		}
		
		return true;
	}

	private String[] validateUIRules()
	{
		List<String> uiErrors = new ArrayList<String>();
		
		if(form.pdtProcDate().getValue() == null)
		{
			uiErrors.add("Procedure Date is mandatory.");
		}
		
		if(OutcomeEnumeration.rdoIncomplete.equals(form.Outcome().getValue()) && form.cmbReason().getValue() == null)
		{
			uiErrors.add("Reason is mandatory.");
		}
		
		String[] uiResults = new String[uiErrors.size()];
		uiErrors.toArray(uiResults);
		
		return uiResults;
	}

	private PatientProcedureApptDetailVo populateDataFromScreen()
	{
		PatientProcedureApptDetailVo patientProcedure = form.getGlobalContext().RefMan.getAppointmentPatientProcedure();
		
		patientProcedure.setIsPrimaryProcedure(form.chkPrimary().getValue());
		patientProcedure.setProcDate(form.pdtProcDate().getValue());
		patientProcedure.setProcedureStatus(OutcomeEnumeration.rdoComplete.equals(form.Outcome().getValue()) ? PatientProcedureStatus.PERFORMED : PatientProcedureStatus.INCOMPLETE);
		patientProcedure.setIncompleteReason(OutcomeEnumeration.rdoIncomplete.equals(form.Outcome().getValue()) ? form.cmbReason().getValue() : null);
		
		return patientProcedure;
	}

	@Override
	protected void onRadioButtonOutcomeValueChanged() throws PresentationLogicException
	{
		if(OutcomeEnumeration.rdoComplete.equals(form.Outcome().getValue()))
		{
			form.cmbReason().setValue(null);
		}
		
		updateControlsState();
	}
}