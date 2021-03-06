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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.forms.edischargelist;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbCompleteLookup();
	abstract protected void defaultcmbCompleteLookupValue();
	abstract protected void bindcmbTTALookup();
	abstract protected void defaultcmbTTALookupValue();
	abstract protected void bindcmbSpecialtyLookup();
	abstract protected void defaultcmbSpecialtyLookupValue();
	abstract protected void bindcmbStatusLookup();
	abstract protected void defaultcmbStatusLookupValue();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbCompleteValueSet(Object value);
	abstract protected void onChkTTAValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbTTAValueSet(Object value);
	abstract protected void onCmbTTAValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdDischargeDetailsRowSelectionChanged(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroupSearchByValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbSpecialtyValueSet(Object value);
	abstract protected void onImbClearHcpClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchHcpClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbStatusValueSet(Object value);
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen(args);
			}
		});
		this.form.cmbComplete().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbCompleteValueSet(value);
			}
		});
		this.form.chkTTA().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkTTAValueChanged();
			}
		});
		this.form.cmbTTA().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTTAValueSet(value);
			}
		});
		this.form.cmbTTA().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbTTAValueChanged();
			}
		});
		this.form.dyngrdDischargeDetails().setDynamicGridRowSelectionChangedEvent(new DynamicGridRowSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row, ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdDischargeDetailsRowSelectionChanged(row);
			}
		});
		this.form.GroupSearchBy().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroupSearchByValueChanged();
			}
		});
		this.form.cmbSpecialty().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSpecialtyValueSet(value);
			}
		});
		this.form.imbClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbClearHcpClick();
			}
		});
		this.form.imbSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbSearchHcpClick();
			}
		});
		this.form.cmbStatus().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbStatusValueSet(value);
			}
		});
		this.form.getContextMenus().Clinical.getEDischargeListViewItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.EDischargeList.View, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbCompleteLookup();
		bindcmbTTALookup();
		bindcmbSpecialtyLookup();
		bindcmbStatusLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbCompleteLookup();
		bindcmbTTALookup();
		bindcmbSpecialtyLookup();
		bindcmbStatusLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbCompleteLookupValue();
		defaultcmbTTALookupValue();
		defaultcmbSpecialtyLookupValue();
		defaultcmbStatusLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
