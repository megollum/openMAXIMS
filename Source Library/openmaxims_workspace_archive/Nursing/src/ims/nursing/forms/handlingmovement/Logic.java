//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.53 build 2510.31460)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.handlingmovement;

import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.nursing.vo.HandlingMovementDetailVo;
import ims.nursing.vo.HandlingMovementDetailVoCollection;
import ims.nursing.vo.PatientHandlingMovementVo;
import ims.nursing.vo.PatientHandlingMovementVoCollection;
import ims.nursing.vo.lookups.MechanicalEquipCollection;
import ims.nursing.vo.lookups.PatientHandlingMovementCollection;

public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;
	
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		initialize();
		open();
	}

	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	protected void onBtnNewClick() throws PresentationLogicException
	{
		newInstance(true);
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}

	protected void onBtnCancelDetailsClick() throws PresentationLogicException
	{
		clearChildInstanceControls();
	}

	protected void onBtnOkClick() throws PresentationLogicException
	{
		addOrUpdateChild();
	}

	private boolean addOrUpdateChild()
	{
		if(form.dyngrdDetails().getSelectedRow() == null)
			newParentRow(form.getLocalContext().getSelectedParentInstance());

		HandlingMovementDetailVo voHandlingMovementDetail = form.getLocalContext().getSelectedChildInstance();

		if (voHandlingMovementDetail == null)
			voHandlingMovementDetail = new HandlingMovementDetailVo();

		populateChildInstanceData(voHandlingMovementDetail);

		if (form.dyngrdDetails().getValue() instanceof HandlingMovementDetailVo)
		{
			promoteUpdatedChild(voHandlingMovementDetail);
			newChildInstance();
			updateControlsState();
		}
		else
		{
			if (newChildRow(voHandlingMovementDetail))
				return true;
		}
		return false;
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add :
				newInstance(form.dyngrdDetails().getSelectedRow() != null && form.dyngrdDetails().getSelectedRow().getParent() == null);
			break;
			case GenForm.ContextMenus.GenericGrid.Update :
				updateInstance();
			break;
			case GenForm.ContextMenus.GenericGrid.Remove :
				removeChild();
		}
	}

	private void removeChild()
	{
		PatientHandlingMovementVo voParent = (PatientHandlingMovementVo) form.dyngrdDetails().getSelectedRow().getParent().getValue();
		form.dyngrdDetails().getRows().remove(form.dyngrdDetails().getSelectedRow());
		form.dyngrdDetails().setValue(voParent);
		updateContextMenusState();
	}

	public void initialize()
	{
		form.ctnHandling().setCollapsed(true);
		form.ctnHandling().lyrDetails().tabEmpty().setHeaderVisible(false);
		initialiseDetailsGrid();
	}

	private void initialiseDetailsGrid()
	{
		DynamicGridColumn col1 = form.dyngrdDetails().getColumns().newColumn("Movement", MOVEMENT_COLUMN);
		col1.setWidth(250);

		DynamicGridColumn col2 = form.dyngrdDetails().getColumns().newColumn("Equipment", EQUIPMENT_COLUMN);
		col2.setWidth(150);

		DynamicGridColumn col3 = form.dyngrdDetails().getColumns().newColumn("Other Equipment", OTHEREQUIPMENT_COLUMN);
		col3.setWidth(100);

		DynamicGridColumn col4 = form.dyngrdDetails().getColumns().newColumn("No. of Staff", NOOFSTAFF_COLUMN);
		col4.setWidth(160);
		
		DynamicGridColumn col5 = form.dyngrdDetails().getColumns().newColumn("Details", DETAILS_COLUMN);
		col5.setWidth(150);
		
		form.dyngrdDetails().setReadOnly(true);
		
	}

	public void open()
	{
		clear();
		resetContextVariables();

		if (form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
			populateParentRows(domain.listPatientHandlingMovementByCareContext(form.getGlobalContext().Core.getCurrentCareContext()));

		form.setMode(FormMode.VIEW);
	}


	private void newInstance(boolean bParentRecord)
	{
		if(bParentRecord)
			bindcmbMovementLookup();
			
		if(form.dyngrdDetails().getSelectedRow() != null && bParentRecord == false)
			newChildInstance();
		else
			newParentInstance();
		
		form.setMode(FormMode.EDIT);
	}

	private void newChildInstance()
	{
		clearChildInstanceControls();
		form.getLocalContext().setSelectedChildInstance(null);
		if(form.dyngrdDetails().getSelectedRow().getParent() != null)
			form.dyngrdDetails().setValue(form.dyngrdDetails().getSelectedRow().getParent().getValue());
	}

	/**
	 * Invoked when the user clicks OK to add a new element to the child array
	 * Basically we update the hierarchy grid with the newly added details
	 * clearing the control to facilitate new input. We then update the local
	 * context variable with the new child
	 * 
	 */
	private boolean newChildRow(HandlingMovementDetailVo voHandlingMovementDetail)
	{
		if (form.getLocalContext().getSelectedChildInstance() != null)
			return false;

		if (voHandlingMovementDetail.countFieldsWithValue() > 1)
		{
			String strErrors[] = voHandlingMovementDetail.validate();

			if (strErrors != null && strErrors.length > 0)
			{
				engine.showErrors(strErrors);
				return true;
			}

			promoteChild(voHandlingMovementDetail);
			clearChildInstanceControls();
		}
		return false;
	}

	private void updateInstance()
	{
		form.getLocalContext().setUpdatingParent(new Boolean(form.dyngrdDetails().getValue() instanceof PatientHandlingMovementVo));

		if (form.dyngrdDetails().getValue() instanceof HandlingMovementDetailVo)
		{
			HandlingMovementDetailVo voCachedChild = (HandlingMovementDetailVo) form.dyngrdDetails().getValue();
			if (voCachedChild.getID_HandlingMovementDetail() == null)
			{
				populateChildInstanceControls(voCachedChild);
			}
		}

		form.setMode(FormMode.EDIT);
	}

	private void getSelectedInstance()
	{
		// In update mode we can select nodes without displaying anything but
		// the context
		// menus can change based on what's selected so we need to update them
		if (form.getMode().equals(FormMode.EDIT))
		{
			updateContextMenusState();
			return;
		}

		// expand the selected parent
		if (form.dyngrdDetails().getValue() instanceof PatientHandlingMovementVo)
		{
			form.getLocalContext().setSelectedParentInstance((PatientHandlingMovementVo) form.dyngrdDetails().getValue());
			populateParentInstanceControls(form.getLocalContext().getSelectedParentInstance());
			form.getLocalContext().setSelectedChildInstance(null);
			clearChildInstanceControls();
		}
		else if (form.dyngrdDetails().getValue() instanceof HandlingMovementDetailVo)
		{
			form.getLocalContext().setSelectedParentInstance((PatientHandlingMovementVo) form.dyngrdDetails().getSelectedRow().getParent().getValue());
			form.getLocalContext().setSelectedChildInstance((HandlingMovementDetailVo) form.dyngrdDetails().getValue());
			populateChildInstanceControls(form.getLocalContext().getSelectedChildInstance());
		}

		updateControlsState();
	}

	private boolean save()
	{
		if (checkForUnsavedChild())
			return false;

		PatientHandlingMovementVo voPatHandlingMovement = populateInstanceData(form.getLocalContext().getSelectedParentInstance());

		if (voPatHandlingMovement.getCareContext() == null)
			voPatHandlingMovement.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());

		if (voPatHandlingMovement.getClinicalContact() == null)
			voPatHandlingMovement.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());

		String[] arrErrors = voPatHandlingMovement.validate();

		if (arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}

		try
		{
			form.getLocalContext().setSelectedParentInstance(domain.savePatientHandlingMovement(voPatHandlingMovement));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}

		setUpdatedChild();
		return true;
	}

	// We need to store the node which was last updated
	private void setUpdatedChild()
	{
		// Straight child update - Select the currently being updated child as
		// the one so show - post save
		if (form.dyngrdDetails().getValue() instanceof HandlingMovementDetailVo)
		{
			form.getLocalContext().setUpdatedChild((HandlingMovementDetailVo) form.dyngrdDetails().getValue());
		}
		else
		{
			// Find the most recently added child
			if (form.getLocalContext().getUpdatingParent().equals(Boolean.FALSE))
			{
				if(form.getLocalContext().getSelectedParentInstance() != null && form.getLocalContext().getSelectedParentInstance().getDetailsIsNotNull())
				{
					if(form.getLocalContext().getSelectedParentInstance().getDetails().size() > 0)
					{
						form.getLocalContext().getSelectedParentInstance().getDetails().sort();
						form.getLocalContext().setUpdatedChild(form.getLocalContext().getSelectedParentInstance().getDetails().get(form.getLocalContext().getSelectedParentInstance().getDetails().size() - 1));
					}
				}
			}

		}
	}

	/**
	 * Invoked as part of the save routine. The user may have entered data in
	 * the details tab and not bothered clicking ok. This method counts thae vo
	 * fields to decide if it should promote the unsaved data entry to the
	 * hierarchy grid before saving.
	 */
	private boolean checkForUnsavedChild()
	{
		if (form.getLocalContext().getSelectedChildInstance() == null)
		{
			if (addOrUpdateChild())
				return true;
		}
		return false;
	}

	private void promoteUpdatedChild(HandlingMovementDetailVo voEUltrasoundTreatment)
	{
		if (voEUltrasoundTreatment == null)
			return;
		populateChildRow(form.dyngrdDetails().getSelectedRow(), voEUltrasoundTreatment);
	}

	private void newParentInstance()
	{
		form.dyngrdDetails().setValue(null);
		PatientHandlingMovementVo voNewParent = new PatientHandlingMovementVo();
		form.ctnHandling().lyrDetails().tabHeader().customControlAuthoringInfo().initializeComponent();
		voNewParent.setAuthoringInformation(form.ctnHandling().lyrDetails().tabHeader().customControlAuthoringInfo().getValue());
		voNewParent.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		voNewParent.setDetails(new HandlingMovementDetailVoCollection());
		populateParentInstanceControls(voNewParent);
		form.getLocalContext().setSelectedParentInstance(voNewParent);
	}

	private void newParentRow(PatientHandlingMovementVo voNewParent)
	{
		if (voNewParent == null)
			return;

		DynamicGridRow parentRow = form.dyngrdDetails().getRows().newRow();
		
		DynamicGridCell cellMovement = parentRow.getCells().newCell( form.dyngrdDetails().getColumns().getByIdentifier(MOVEMENT_COLUMN), DynamicCellType.STRING);
		if(voNewParent.getAuthoringInformationIsNotNull())
			cellMovement.setValue(voNewParent.getAuthoringInformation().toString());		
		
		parentRow.setValue(voNewParent);
		parentRow.setBackColor(Color.Beige);
		parentRow.setExpanded(true);
		form.dyngrdDetails().setValue(voNewParent);
	}

	/**
	 * @calls the Domain Get for the selected node..
	 * 
	 */
	private void expandParentRow(DynamicGridRow selectedRow)
	{
		if (selectedRow.getValue() instanceof PatientHandlingMovementVo == false)
			return;

//		form.getLocalContext().setSelectedParentInstance((PatientHandlingMovementVo) selectedRow.getValue());
//		if (form.getLocalContext().getSelectedParentInstance() == null)
//			return;
//
		PatientHandlingMovementVo voParentInstance = ((PatientHandlingMovementVo)selectedRow.getValue());

		if (voParentInstance.getDetailsIsNotNull())
		{
			selectedRow.setExpanded(true);
			populateChildRows(selectedRow, voParentInstance.getDetails());
		}

		populateParentInstanceControls(voParentInstance);

	}

	/**
	 * Populates the Hierarchy tree with the contents of the
	 * PatientHandlingMovementVoCollection Selects the item that matches the
	 * current SOAP clinical contact Sets that items background colour to
	 * LightYellow and expands that node.
	 * 
	 * @param voCollPatientHandlingMovement
	 */
	private void populateParentRows(PatientHandlingMovementVoCollection voCollPatientHandlingMovement)
	{
		if (voCollPatientHandlingMovement == null || voCollPatientHandlingMovement.size() <= 0)
			return;

		for (int i = 0; i < voCollPatientHandlingMovement.size(); i++)
		{
			populateParentRow(voCollPatientHandlingMovement.get(i));
		}
	}

	private void populateParentRow(PatientHandlingMovementVo voPatHandlingMovement)
	{
		if (voPatHandlingMovement == null)
			return;
		
		DynamicGridRow parRow = form.dyngrdDetails().getRows().newRow();
		
		DynamicGridCell cellMovement = parRow.getCells().newCell( form.dyngrdDetails().getColumns().getByIdentifier(MOVEMENT_COLUMN), DynamicCellType.STRING);
		if(voPatHandlingMovement.getAuthoringInformationIsNotNull())
		{
			cellMovement.setValue(voPatHandlingMovement.getAuthoringInformation().toString(" - "));
			cellMovement.setTooltip(voPatHandlingMovement.getAuthoringInformation().toString(" - "));
		}

		parRow.setValue(voPatHandlingMovement);
		if (voPatHandlingMovement.getCareContextIsNotNull() && form.getGlobalContext().Core.getCurrentCareContextIsNotNull() && voPatHandlingMovement.getCareContext().getID_CareContext().equals(form.getGlobalContext().Core.getCurrentCareContext().getID_CareContext()))
		{
			//form.dyngrdDetails().setValue(voPatHandlingMovement);
			expandParentRow(parRow);
		}
	}

	/**
	 * Given a row in the hierarchy row get the collection of treatments
	 * associated with that ultrasound and and create a child treenode for each.
	 * Use a Red text colour to denote any as yes unsaved treatments.
	 * 
	 * @param voCollTreatments
	 * @param parRow
	 */
	private void populateChildRows(DynamicGridRow parRow, HandlingMovementDetailVoCollection voCollTreatments)
	{
		if (voCollTreatments == null || voCollTreatments.size() <= 0)
			return;

		voCollTreatments.sort();
		for (int i = 0; i < voCollTreatments.size(); i++)
		{
			if (parRow != null)
			{
				DynamicGridRow childRow = parRow.getRows().newRow();
				populateChildRow(childRow, voCollTreatments.get(i));
			}
		}
	}

	private void populateChildRow(DynamicGridRow childRow, HandlingMovementDetailVo voHandlingMovementDetail)
	{
		if (voHandlingMovementDetail == null)
			return;

		childRow.setValue(voHandlingMovementDetail);
		
		
		DynamicGridCell cellMovement = childRow.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(MOVEMENT_COLUMN), DynamicCellType.STRING);
		if(voHandlingMovementDetail.getMovementIsNotNull())
			cellMovement.setValue(voHandlingMovementDetail.getMovement().toString());
		

		DynamicGridCell cellEquipment = childRow.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(EQUIPMENT_COLUMN), DynamicCellType.MULTISELECT);

		MechanicalEquipCollection items = voHandlingMovementDetail.getMechanicalEquipment();
		if(items != null)
		{
			for(int y = 0; y < items.size(); y++)
			{
				cellEquipment.getItems().newItem(items.get(y));
				cellEquipment.getItems().get(y).setIdentifier(items.get(y));
				cellEquipment.getItems().get(y).setMarkerColor(items.get(y).getColor());
				cellEquipment.getItems().get(y).setChecked(true);
			}
			//WDEV-2935 
			cellEquipment.setMaxVisibleItemsForMultiSelect(items.size());
		}
		
		
		
		DynamicGridCell cellOtherEquipment = childRow.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(OTHEREQUIPMENT_COLUMN), DynamicCellType.STRING);
		cellOtherEquipment.setValue(voHandlingMovementDetail.getOtherEquipment());
		cellOtherEquipment.setTooltip(voHandlingMovementDetail.getOtherEquipment());
	
		DynamicGridCell cellNoOfStaff = childRow.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(NOOFSTAFF_COLUMN), DynamicCellType.INT);
		cellNoOfStaff.setValue(voHandlingMovementDetail.getNoOfStaff());
		
		DynamicGridCell cellDetails = childRow.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(DETAILS_COLUMN), DynamicCellType.STRING);
		cellDetails.setValue(voHandlingMovementDetail.getDetails());

		// if not saved then set the colour
		if (voHandlingMovementDetail.getID_HandlingMovementDetail() == null)
			childRow.setTextColor(Color.Red);
	}
	private void populateParentInstanceControls(PatientHandlingMovementVo voPatHandlingMovement)
	{
		if (voPatHandlingMovement != null)
			form.ctnHandling().lyrDetails().tabHeader().customControlAuthoringInfo().setValue(voPatHandlingMovement.getAuthoringInformation());
	}

	private void populateChildInstanceControls(HandlingMovementDetailVo voHandlingMovementDetail)
	{
		if (voHandlingMovementDetail == null)
			return;

		form.ctnHandling().lyrDetails().tabDetails().cmbMovement().setValue(voHandlingMovementDetail.getMovement());
		form.ctnHandling().lyrDetails().tabDetails().chklistMechEquip().setValues(voHandlingMovementDetail.getMechanicalEquipmentIsNotNull() ? voHandlingMovementDetail.getMechanicalEquipment() : null);
		form.ctnHandling().lyrDetails().tabDetails().txtOtherEquip().setValue(voHandlingMovementDetail.getOtherEquipment());
		form.ctnHandling().lyrDetails().tabDetails().intNoStaff().setValue(voHandlingMovementDetail.getNoOfStaff());
		form.ctnHandling().lyrDetails().tabDetails().txtDetails().setValue(voHandlingMovementDetail.getDetails());
	}

	private PatientHandlingMovementVo populateInstanceData(PatientHandlingMovementVo voPatHandlingMovement)
	{

		if (voPatHandlingMovement == null)
			voPatHandlingMovement = new PatientHandlingMovementVo();

		populateParentInstanceData(voPatHandlingMovement);

		if (form.getLocalContext().getSelectedChildInstance() == null)
		{
			populateChildCollectionFromGrid(voPatHandlingMovement);
		}
		else
		// Update child instance.
		{
			HandlingMovementDetailVo voUltraTreat = form.getLocalContext().getSelectedChildInstance();
			populateChildInstanceData(voUltraTreat);
			form.getLocalContext().setSelectedChildInstance(voUltraTreat);

			if (voPatHandlingMovement.getDetailsIsNotNull())
			{
				for (int i = 0; i < voPatHandlingMovement.getDetails().size(); i++)
				{
					if (voPatHandlingMovement.getDetails().get(i).getID_HandlingMovementDetail() == form.getLocalContext().getSelectedChildInstance().getID_HandlingMovementDetail())
					{
						voPatHandlingMovement.getDetails().set(i, form.getLocalContext().getSelectedChildInstance());
					}
				}
			}
		}
		return voPatHandlingMovement;
	}

	private void populateParentInstanceData(PatientHandlingMovementVo voPatHandlingMovement)
	{
		voPatHandlingMovement.setAuthoringInformation(form.ctnHandling().lyrDetails().tabHeader().customControlAuthoringInfo().getValue());
	}

	private void populateChildInstanceData(HandlingMovementDetailVo voHandlingMovementDetail)
	{
		voHandlingMovementDetail.setMovement(form.ctnHandling().lyrDetails().tabDetails().cmbMovement().getValue());
		voHandlingMovementDetail.setMechanicalEquipment(form.ctnHandling().lyrDetails().tabDetails().chklistMechEquip().getValues());
		voHandlingMovementDetail.setOtherEquipment(form.ctnHandling().lyrDetails().tabDetails().txtOtherEquip().getValue());
		voHandlingMovementDetail.setNoOfStaff(form.ctnHandling().lyrDetails().tabDetails().intNoStaff().getValue());
		voHandlingMovementDetail.setDetails(form.ctnHandling().lyrDetails().tabDetails().txtDetails().getValue());
	}

	private void populateChildCollectionFromGrid(PatientHandlingMovementVo voPatHandMovement)
	{
		if (form.dyngrdDetails().getValue() == null)
			return;

		if (voPatHandMovement.getDetails() == null)
			voPatHandMovement.setDetails(new HandlingMovementDetailVoCollection());

		DynamicGridRow parentRow = form.dyngrdDetails().getValue() instanceof PatientHandlingMovementVo ? form.dyngrdDetails().getSelectedRow() : form.dyngrdDetails().getSelectedRow().getParent();

		if (parentRow.getRows().size() > 0)
			voPatHandMovement.getDetails().clear();

		for (int i = 0; i < parentRow.getRows().size(); i++)
		{
			voPatHandMovement.getDetails().add((HandlingMovementDetailVo) parentRow.getRows().get(i).getValue());
		}
	}

	private void promoteChild(HandlingMovementDetailVo voEUltrasoundTreatment)
	{
		if (voEUltrasoundTreatment == null)
			return;
		DynamicGridRow childRow = form.dyngrdDetails().getSelectedRow().getRows().newRow();
		populateChildRow(childRow, voEUltrasoundTreatment);
	}

	public void updateControlsState()
	{
		//row state
		setRowsSelectableState();

		// The new button
		form.btnNew().setVisible(form.getGlobalContext().Core.getCurrentCareContextIsNotNull() && form.getMode().equals(FormMode.VIEW));

		// The update(edit) button
		form.btnUpdate().setVisible(form.getLocalContext().getSelectedParentInstanceIsNotNull() && form.getLocalContext().getSelectedParentInstance().getID_PatientHandlingMovementIsNotNull() && form.getMode().equals(FormMode.VIEW));
		
		// The collapsible container
		form.ctnHandling().setCollapsed(form.getLocalContext().getSelectedParentInstance() == null);

		// The empty tab
		if (form.dyngrdDetails().getValue() == null)
			form.ctnHandling().lyrDetails().showtabEmpty();

		// The Parent tab
		setParentTabVisability();

		// The details tab
		setDetailsTabVisibility();

		// Pick a tab to show
		showHeaderOrDetailsTab();

		// The context menus
		updateContextMenusState();
	}

	private void setRowsSelectableState()
	{
		if(form.getMode().equals(FormMode.EDIT))
		{
			for(int i=0;i<form.dyngrdDetails().getRows().size(); i++)
			{
				DynamicGridRow parentRow = form.dyngrdDetails().getRows().get(i);
				if(!parentRow.equals(form.dyngrdDetails().getSelectedRow()))
					parentRow.setSelectable(false);
				for(int p=0; p<parentRow.getRows().size(); p++)
				{
					if(!parentRow.getRows().get(p).equals(form.dyngrdDetails().getSelectedRow()))
						parentRow.getRows().get(p).setSelectable(false);
				}
			}
		}
		else
		{
			//enable all
			for(int i=0;i<form.dyngrdDetails().getRows().size(); i++)
			{
				DynamicGridRow parentRow = form.dyngrdDetails().getRows().get(i);
					parentRow.setSelectable(true);
				for(int p=0; p<parentRow.getRows().size(); p++)
				{
					parentRow.setSelectable(true);
				}
			}
		}
	}

	private void showHeaderOrDetailsTab()
	{
		if (form.getMode().equals(FormMode.VIEW))
		{
			// In view mode just show the selected node
			if (form.dyngrdDetails().getValue() instanceof PatientHandlingMovementVo)
				form.ctnHandling().lyrDetails().showtabHeader();
			else if (form.dyngrdDetails().getValue() instanceof HandlingMovementDetailVo)
				form.ctnHandling().lyrDetails().showtabDetails();
			else
				form.ctnHandling().lyrDetails().showtabEmpty();
		}
		else
		{
			if (form.getLocalContext().getUpdatingParent().equals(Boolean.TRUE))
				form.ctnHandling().lyrDetails().showtabHeader();
			else
				form.ctnHandling().lyrDetails().showtabDetails();
		}
	}

	private void setParentTabVisability()
	{
		form.ctnHandling().lyrDetails().tabHeader().setHeaderVisible(form.getLocalContext().getSelectedParentInstanceIsNotNull());
		enableParentControls();
	}

	private void setDetailsTabVisibility()
	{
		if (form.getMode().equals(FormMode.VIEW))
		{
			// In view mode, make the details tab visible if a detail instance
			// is selected in the hierarchy grid.
			form.ctnHandling().lyrDetails().tabDetails().setHeaderVisible(form.dyngrdDetails().getValue() instanceof HandlingMovementDetailVo);
		}
		else
		{
			// In edit mode, make the details tab visible if a hierarchy item
			// has been selected and we're not
			// editing a parent.
			form.ctnHandling().lyrDetails().tabDetails().setHeaderVisible(form.getLocalContext().getSelectedParentInstanceIsNotNull() && form.getLocalContext().getUpdatingParent().equals(Boolean.FALSE));

			setAddApplyCaption();
		}

		enableDetailsButtons();
	}

	private void setAddApplyCaption()
	{
		form.ctnHandling().lyrDetails().tabDetails().btnOk().setText("Add");

		if (form.getLocalContext().getSelectedChildInstance() == null && (form.dyngrdDetails().getValue() instanceof HandlingMovementDetailVo))
			form.ctnHandling().lyrDetails().tabDetails().btnOk().setText("Apply");

	}

	private void updateContextMenusState()
	{
		if (form.dyngrdDetails().getSelectedRow() != null)
		{
			// If the golden instance is currently selected we change the text
			// of the update context menu
			// based on whether a parent or child node is selected in the grid.
			if (form.dyngrdDetails().getValue() instanceof PatientHandlingMovementVo)
				form.getContextMenus().getGenericGridUpdateItem().setText("Edit Patient Handling Movement");
			else if (form.dyngrdDetails().getValue() instanceof HandlingMovementDetailVo)
				form.getContextMenus().getGenericGridUpdateItem().setText("Edit Details");

			// If the golden node is selected we can now only add child nodes so
			// set the menu text accordingly.
			form.getContextMenus().getGenericGridAddItem().setText("Add Details");

			// Only show the update menu if the user has selected an item to
			// update.
			form.getContextMenus().getGenericGridUpdateItem().setVisible((form.getMode().equals(FormMode.VIEW) && form.dyngrdDetails().getSelectedRow() != null) || (form.getMode().equals(FormMode.EDIT) && form.dyngrdDetails().getValue() instanceof HandlingMovementDetailVo && ((HandlingMovementDetailVo) form.dyngrdDetails().getValue()).getID_HandlingMovementDetail() == null));
		}
		else
		{
			form.getContextMenus().getGenericGridAddItem().setText("New Patient Handling Movement");
			form.getContextMenus().getGenericGridUpdateItem().setVisible(false);	
		}

		form.getContextMenus().getGenericGridAddItem().setVisible(form.getGlobalContext().Core.getCurrentCareContextIsNotNull() && form.getMode().equals(FormMode.VIEW));
		form.getContextMenus().getGenericGridRemoveItem().setVisible(form.getMode().equals(FormMode.EDIT) && form.dyngrdDetails().getValue() instanceof HandlingMovementDetailVo && ((HandlingMovementDetailVo) form.dyngrdDetails().getValue()).getID_HandlingMovementDetail() == null);

	}

	/**
	 * Set's the visibility of the OK and Cancel buttons. Essentially if we are
	 * adding a new child then we want to see both buttons Otherwise we don't
	 */
	private void enableDetailsButtons()
	{
		boolean boolVisible = (form.getMode().equals(FormMode.EDIT) && form.ctnHandling().lyrDetails().tabDetails().isHeaderVisible() && form.getLocalContext().getSelectedChildInstance() == null);

		form.ctnHandling().lyrDetails().tabDetails().btnOk().setVisible(boolVisible);
		form.ctnHandling().lyrDetails().tabDetails().btnCancelDetails().setVisible(boolVisible);
	}

	private void enableParentControls()
	{
		boolean boolEnabled = (form.getMode().equals(FormMode.EDIT) && (form.dyngrdDetails().getValue() == null || form.dyngrdDetails().getValue() instanceof PatientHandlingMovementVo));
		form.ctnHandling().lyrDetails().tabHeader().setcustomControlAuthoringInfoEnabled(boolEnabled);
	}

	public void clear()
	{
		form.dyngrdDetails().getRows().clear();
		clearChildInstanceControls();
	}

	private void clearChildInstanceControls()
	{
		//remove used movement items
		removeUsedMovements();	
		form.ctnHandling().lyrDetails().tabDetails().cmbMovement().setValue(null);
		form.ctnHandling().lyrDetails().tabDetails().chklistMechEquip().setValues(null);
		form.ctnHandling().lyrDetails().tabDetails().txtDetails().setValue(null);
		form.ctnHandling().lyrDetails().tabDetails().intNoStaff().setValue(null);
		form.ctnHandling().lyrDetails().tabDetails().txtOtherEquip().setValue(null);
	}

	private void removeUsedMovements()
	{
		PatientHandlingMovementCollection collUsedItems = new PatientHandlingMovementCollection();
		if(form.getLocalContext().getSelectedParentInstanceIsNotNull())
		{
			PatientHandlingMovementVo voPatHandlingMovement = form.getLocalContext().getSelectedParentInstance();
			if(voPatHandlingMovement.getDetailsIsNotNull())
			{
				for(int i=0; i<voPatHandlingMovement.getDetails().size(); i++)
				{
					if(voPatHandlingMovement.getDetails().get(i).getMovementIsNotNull())
						collUsedItems.add(voPatHandlingMovement.getDetails().get(i).getMovement());
				}
			}
		}
		for(int i=0;i<collUsedItems.size(); i++)
			form.ctnHandling().lyrDetails().tabDetails().cmbMovement().removeRow(collUsedItems.get(i));
	}
	private void resetContextVariables()
	{
		form.getLocalContext().setUpdatingParent(new Boolean(false));
		form.getLocalContext().setSelectedParentInstance(null);
		form.getLocalContext().setSelectedChildInstance(null);
	}

	protected void onBtnUpdateClick() throws PresentationLogicException
	{
		updateInstance();
	}
	
	protected void onDyngrdDetailsRowSelectionChanged(DynamicGridRow row)
	{
		getSelectedInstance();
	}
	
	private static final String MOVEMENT_COLUMN	= "1";	
	private static final String EQUIPMENT_COLUMN	= "2";	
	private static final String OTHEREQUIPMENT_COLUMN	= "3";	
	private static final String NOOFSTAFF_COLUMN	= "4";
	private static final String DETAILS_COLUMN	= "5";

	
}