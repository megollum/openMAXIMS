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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.forms.implantsintraopdialog;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinical.domain.ImplantsIntraOpDialog.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.clinical.domain.ImplantsIntraOpDialog domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected void clearScreen()
	{
		this.form.intQuantity().setValue(null);
		this.form.dteExpiry().setValue(null);
		this.form.txtImplantDesc().setValue("");
		this.form.txtSize().setValue("");
		this.form.txtLotNo().setValue("");
		this.form.txtSerialNo().setValue("");
		this.form.txtManufacturer().setValue("");
		this.form.txtCatalogueNo().setValue("");
	}
	protected void populateScreenFromData(ims.clinical.vo.ImplantsIntraOpVo value)
	{
		clearScreen();
		if(value == null)
			return;

		this.form.intQuantity().setValue(value.getQuantityIsNotNull() ? value.getQuantity() : null);
		this.form.dteExpiry().setValue(value.getExpiryDateIsNotNull() ? value.getExpiryDate() : null);
		this.form.txtImplantDesc().setValue(value.getImplantDescriptionIsNotNull() ? value.getImplantDescription(): null);
		this.form.txtSize().setValue(value.getSizeIsNotNull() ? value.getSize(): null);
		this.form.txtLotNo().setValue(value.getLotNumberIsNotNull() ? value.getLotNumber(): null);
		this.form.txtSerialNo().setValue(value.getSerialNumberIsNotNull() ? value.getSerialNumber(): null);
		this.form.txtManufacturer().setValue(value.getManufacturerIsNotNull() ? value.getManufacturer(): null);
		this.form.txtCatalogueNo().setValue(value.getCatalogueNumberIsNotNull() ? value.getCatalogueNumber(): null);
	}
	protected ims.clinical.vo.ImplantsIntraOpVo populateDataFromScreen(ims.clinical.vo.ImplantsIntraOpVo value)
	{
		if(value == null)
			value = new ims.clinical.vo.ImplantsIntraOpVo();

		value.setQuantity(this.form.intQuantity().getValue());
		value.setExpiryDate(this.form.dteExpiry().getValue());
		value.setImplantDescription(this.form.txtImplantDesc().getValue());
		value.setSize(this.form.txtSize().getValue());
		value.setLotNumber(this.form.txtLotNo().getValue());
		value.setSerialNumber(this.form.txtSerialNo().getValue());
		value.setManufacturer(this.form.txtManufacturer().getValue());
		value.setCatalogueNumber(this.form.txtCatalogueNo().getValue());

		return value;
	}
	protected ims.clinical.vo.ImplantsIntraOpVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.clinical.vo.ImplantsIntraOpVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinical.domain.ImplantsIntraOpDialog domain;
}