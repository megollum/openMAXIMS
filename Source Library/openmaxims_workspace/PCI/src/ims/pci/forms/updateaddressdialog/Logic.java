//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
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
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Andrei Stefan Bondar using IMS Development Environment (version 1.62 build 3014.30561)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.pci.forms.updateaddressdialog;

import ims.core.vo.CommChannelVo;
import ims.core.vo.CommChannelVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.PatientShortCollection;
import ims.core.vo.lookups.ChannelType;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.pci.forms.updateaddressdialog.GenForm.grdClientsRow;
import ims.pci.vo.ClientAddressVo;

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
		populateGrid(form.getGlobalContext().PCI.getClientParent());
		
		if(form.getGlobalContext().PCI.getClientAddressesIsNotNull())
		{
			form.customControlAddress().setValue(form.getGlobalContext().PCI.getClientAddresses());
		}
	}

	private String populatePhoneNumbers(PatientShort clientParent, ChannelType channelType) 
	{
		if(clientParent == null || !clientParent.getCommChannelsIsNotNull())
			return null;
		
		for(int i=0; i<clientParent.getCommChannels().size(); i++)
		{	
			if(clientParent.getCommChannels().get(i) != null && clientParent.getCommChannels().get(i).getChannelTypeIsNotNull() && clientParent.getCommChannels().get(i).getChannelType().equals(channelType))
			{
				
				return clientParent.getCommChannels().get(i).getCommValue();
			}
		}
		
		return null;
	}

	private void populateGrid(PatientShort clientParent) 
	{
		form.grdClients().getRows().clear();
		
		if(clientParent == null)
			return;
		
		PatientShortCollection childs = domain.listChilds(clientParent);
		
		grdClientsRow newRow = form.grdClients().getRows().newRow();
		updateRow(newRow, clientParent);
		
		for(int i=0; i<childs.size(); i++)
		{
			newRow = form.grdClients().getRows().newRow();
			updateRow(newRow, childs.get(i));
		}
	}

	private void updateRow(grdClientsRow newRow, PatientShort client) 
	{
		if(client == null)
			return;
		
		if(newRow == null)
			newRow = form.grdClients().getRows().newRow();
		
		newRow.setColClient(client.getNameIsNotNull() ? client.getName().toString() : null);
		newRow.setColCheck(true);
		
		newRow.setValue(client);
	}

	private void initialize() 
	{
		form.chkHome().setValue(false);
		form.chkMobile().setValue(false);
		
		form.setMode(FormMode.EDIT);
		form.customControlAddress().setMode(FormMode.EDIT);
	}

	@Override
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		Integer numberOfPersonUpdated = 0;
		
		if((numberOfPersonUpdated = save()) >= 0)
		{
			engine.showMessage("Address updated for " + numberOfPersonUpdated + " clients", "", MessageButtons.OK, MessageIcon.INFORMATION);
			engine.close(DialogResult.OK);
		}
	}
	
	private Integer save() 
	{
		String[] errors = validateUIRules(form.customControlAddress().validate()) ;
		Integer numberOfPersonUp = 0;
		
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return -1;
		}
		
		ClientAddressVo clientAddressVo = form.customControlAddress().getValue();
		PatientShortCollection clients = populateFromGrid();
		CommChannelVoCollection commChannels = getCommChannels();
	
		try 
		{
			numberOfPersonUp = domain.saveFamilyAddress(clients, clientAddressVo, commChannels);
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(e.getMessage());
			return -1;
		} 
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage(e.getMessage());
			return -1;
		}

		return numberOfPersonUp;
	}
	
	private CommChannelVoCollection getCommChannels() 
	{
		if(!form.chkHome().getValue() && !form.chkMobile().getValue())
			return null;
		
		CommChannelVoCollection clientCommChannels = new CommChannelVoCollection();
		
		if(form.chkHome().getValue() && form.txtHomePhone().getValue() != null && this.form.txtHomePhone().getValue().trim().length() > 0)
		{
			CommChannelVo clientHomePhone = new CommChannelVo();
			clientHomePhone.setChannelType(ChannelType.HOME_PHONE);
			clientHomePhone.setCommValue(this.form.txtHomePhone().getValue());
			clientCommChannels.add(clientHomePhone);
		}
		if(form.chkMobile().getValue() && this.form.txtMobilePhone().getValue() != null && this.form.txtMobilePhone().getValue().trim().length() > 0)
		{
			CommChannelVo clientMobilePhone = new CommChannelVo();
			clientMobilePhone.setChannelType(ChannelType.MOBILE);
			clientMobilePhone.setCommValue(this.form.txtMobilePhone().getValue());
			clientCommChannels.add(clientMobilePhone);
		}
		
		return clientCommChannels;
	}

	private PatientShortCollection populateFromGrid() 
	{
		PatientShortCollection clients = new PatientShortCollection();
		
		for(int i=0; i<form.grdClients().getRows().size(); i++)
		{
			if(form.grdClients().getRows().get(i).getColCheck())
			{
				clients.add(form.grdClients().getRows().get(i).getValue());
			}
		}
		
		return clients;
	}

	private String[] validateUIRules(String[] existingErrors) 
	{
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		
		Boolean noClientIsChecked = true;
		
		for(int i=0; i<form.grdClients().getRows().size(); i++)
		{
			if(form.grdClients().getRows().get(i).getColCheck())
			{
				noClientIsChecked = false;
				break;
			}
		}
		
		if(noClientIsChecked)
			listOfErrors.add("Select at least one client to update address.");
		
		if(form.chkHome().getValue() && (form.txtHomePhone().getValue() == null || form.txtHomePhone().getValue().trim().length() == 0))
		{
			listOfErrors.add("Please enter Home Phone.");
		}
		
		if(form.chkMobile().getValue() && (form.txtMobilePhone().getValue() == null || form.txtMobilePhone().getValue().trim().length() == 0))
		{
			listOfErrors.add("Please enter Mobile Phone.");
		}
		
		int errorCount = listOfErrors.size();
		String[] result = new String[errorCount];
		
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		
		return result;
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onFormModeChanged() 
	{
		updateControlsState();
	}

	private void updateControlsState() 
	{
		form.txtHomePhone().setEnabled(form.chkHome().getValue());
		form.txtMobilePhone().setEnabled(form.chkMobile().getValue());
	}

	@Override
	protected void onChkHomeValueChanged() throws PresentationLogicException 
	{
		form.txtHomePhone().setValue(form.chkHome().getValue() ? populatePhoneNumbers(form.getGlobalContext().PCI.getClientParent(), ChannelType.HOME_PHONE) : null);
		
		updateControlsState();
	}

	@Override
	protected void onChkMobileValueChanged() throws PresentationLogicException 
	{
		form.txtMobilePhone().setValue(form.chkMobile().getValue() ? populatePhoneNumbers(form.getGlobalContext().PCI.getClientParent(), ChannelType.MOBILE) : null);
		
		updateControlsState();
	}
}