// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.64 build 3155.28032)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.domain.impl;

import ims.admin.helper.Keywords;
import ims.admin.helper.MedicationManagement;
import ims.RefMan.domain.Presentation;
import ims.RefMan.domain.base.impl.BaseAtConsultationComponentImpl;
import ims.RefMan.domain.objects.AtConsultation;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.vo.AtConsultationVo;
import ims.RefMan.vo.AtConsultationVoCollection;
import ims.RefMan.vo.CatsReferralListVo;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.domain.AtConsultationVoAssembler;
import ims.RefMan.vo.domain.CatsReferralListVoAssembler;
import ims.core.clinical.domain.objects.Procedure;
import ims.core.clinical.domain.objects.Service;
import ims.core.domain.DiagnosisList;
import ims.core.domain.impl.DiagnosisListImpl;
import ims.core.vo.MedicationVo;
import ims.core.vo.PatientMedicationLiteVoCollection;
import ims.core.vo.ProcedureLiteVoCollection;
import ims.core.vo.ServiceShortVo;
import ims.core.vo.domain.PatientMedicationLiteVoAssembler;
import ims.core.vo.domain.ProcedureLiteVoAssembler;
import ims.core.vo.domain.ServiceVoAssembler;
import ims.core.vo.lookups.Specialty;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AtConsultationComponentImpl extends BaseAtConsultationComponentImpl
{ 
	private static final long serialVersionUID = 1L;

	public ims.RefMan.vo.PresentationReferralSummaryVo getPresentationReferralSummary(ims.RefMan.vo.CatsReferralRefVo catsRefVo)
	{
		Presentation pres = (Presentation)getDomainImpl(PresentationImpl.class);
		return pres.getPresentationReferralSummary(catsRefVo);
	}

	public ims.core.vo.MedicationLiteVoCollection listActiveMedication(String filter) throws ims.domain.exceptions.DomainInterfaceException
	{
		return null;
	}

	public ims.core.vo.DiagLiteVoCollection listActiveDiagnosis(String filter) throws ims.domain.exceptions.DomainInterfaceException
	{
		DiagnosisList diags = (DiagnosisList)getDomainImpl(DiagnosisListImpl.class);
		return diags.listActiveDiagnosis(filter);
	}

	public AtConsultationVo saveAtConsultation(AtConsultationVo voAtConsultation) throws StaleObjectException 
	{
		if(voAtConsultation == null)
			throw new CodingRuntimeException("Invalid voAtConsultation");
		if(!voAtConsultation.isValidated())
			throw new CodingRuntimeException("voAtConsultation not validated");
		
		DomainFactory factory = getDomainFactory();
		AtConsultation domainObject = AtConsultationVoAssembler.extractAtConsultation(factory, voAtConsultation);
		
		factory.save(domainObject);
		
		return AtConsultationVoAssembler.create(domainObject);
	}

	@SuppressWarnings("unchecked")
	public AtConsultationVo getConsultation(CatsReferralRefVo voCATSRef) 
	{
		if(voCATSRef != null)
		{
			DomainFactory factory = getDomainFactory();
			StringBuffer hql = new StringBuffer(" from AtConsultation atCons where "); 
			String andStr = " ";
		
			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();
		
			hql.append(andStr + " atCons.catsReferral.id = :cats");
 			markers.add("cats");
			values.add(voCATSRef.getID_CatsReferral());
			andStr = " and ";	

			List listAdditional = factory.find(hql.toString(), markers,values);
			if(listAdditional != null && listAdditional.size() > 0)
			{ 
				AtConsultationVoCollection voColl = AtConsultationVoAssembler.createAtConsultationVoCollectionFromAtConsultation(listAdditional);
				if(voColl != null && voColl.size() > 0)
					return voColl.get(0);
			}
		}
		return null;
	}

	/**
	 *  Will return a list of ProcedureHotlistItem domain objects based on procedure name and the provided specialty.
	 */
	@SuppressWarnings("unchecked")
	public ProcedureLiteVoCollection listHotlistProcedureShort(String procedureName, Specialty specialty) throws DomainInterfaceException 
	{
		// WDEV - 5979 - The search was using the function listHotlistProcedureShort from ClinicalCodingImpl.java
		// The function from listHotlistProcedureShort is set to throw DomainRuntimeException when specialty is null
		// but we may require to search for procedures without a specialty
		
		// Check for a valid Procedure name to search upon
		if (procedureName == null || procedureName.length() == 0)
			throw new DomainInterfaceException("Invalid search criteria. Clinical Procedure name must be provided.");
		
		// Get DomainFactory, initialize the parameters of the Query
		DomainFactory factory = getDomainFactory();
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();

		StringBuilder hqlQuery = new StringBuilder();
		hqlQuery.append("select distinct proc from ProcedureHotlist as procHotList left join procHotList.hotlistItem as procHotListItem right join procHotListItem.procedure as proc left join proc.keywords as kw where proc.isActive = :isActive ");
		names.add("isActive");
		values.add(Boolean.TRUE);
		
		// Add the specialty in case there is one provided
		if (specialty != null)
		{
			hqlQuery.append(" and procHotList.specialty = :spec");
			names.add("spec");
			values.add(getDomLookup(specialty));
		}
		
		// Search procedures after name and keywords (will return a domain objects list)
		List hits = Keywords.searchByKeywords(factory, procedureName, hqlQuery.toString(), names, values);

		// Build the list of the required domain object type (ProcedureHotlistItem)
		List ret = new ArrayList();
		for (int i = 0; i < hits.size(); i++)
		{
			ret.add(((Procedure)hits.get(i)));
		}
		
		// Return the list of the required domain object type (ProcedureHotlistItem)
		return ProcedureLiteVoAssembler.createProcedureLiteVoCollectionFromProcedure(ret);
	}

	public ServiceShortVo getCatsReferralService(CatsReferralRefVo voCatsReferralRef) 
	{
		CatsReferralListVo voCatsReferral = CatsReferralListVoAssembler.create((CatsReferral)getDomainFactory().getDomainObject(CatsReferral.class, voCatsReferralRef.getID_CatsReferral()));
		if (voCatsReferral != null)
			return ServiceVoAssembler.create((Service)getDomainFactory().getDomainObject(Service.class, voCatsReferral.getReferralDetails().getService().getID_Service()));

		return null;
	}
	public MedicationVo createOrUpdateMedication(MedicationVo value) throws StaleObjectException 
	{
		return new MedicationManagement(getDomainFactory()).createOrUpdateMedication(value);
	}

	@SuppressWarnings("unchecked")
	public PatientMedicationLiteVoCollection getPresentationReferralSummaryMedication(CatsReferralRefVo catsRefVo) 
	{
		if(catsRefVo != null)
		{
			DomainFactory factory = getDomainFactory();
			StringBuffer hql = new StringBuffer("select presRS.medicationOnReferral from PresentationReferralSummary presRS where "); 
			String andStr = " ";
		
			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();
		
			hql.append(andStr + " presRS.catsReferral.id = :cats");
 			markers.add("cats");
			values.add(catsRefVo.getID_CatsReferral());			

			List listAdditional = factory.find(hql.toString(), markers,values);
			if(listAdditional != null && listAdditional.size() > 0)
			{ 
				return PatientMedicationLiteVoAssembler.createPatientMedicationLiteVoCollectionFromPatientMedication(listAdditional);
			}
		}
		return null;
	}
}