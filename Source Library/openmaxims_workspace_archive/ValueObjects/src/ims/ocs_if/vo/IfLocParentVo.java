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

package ims.ocs_if.vo;

/**
 * Linked to core.resource.place.Location business object (ID: 1007100007).
 */
public class IfLocParentVo extends ims.core.vo.LocationLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public IfLocParentVo()
	{
	}
	public IfLocParentVo(Integer id, int version)
	{
		super(id, version);
	}
	public IfLocParentVo(ims.ocs_if.vo.beans.IfLocParentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.isactive = bean.getIsActive();
		this.isvirtual = bean.getIsVirtual();
		this.type = bean.getType() == null ? null : ims.core.vo.lookups.LocationType.buildLookup(bean.getType());
		this.displayinedtracking = bean.getDisplayInEDTracking();
		this.parentlocation = bean.getParentLocation() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getParentLocation().getId()), bean.getParentLocation().getVersion());
		this.codemappings = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getCodeMappings());
		this.address = bean.getAddress() == null ? null : bean.getAddress().buildVo();
		this.uppername = bean.getUpperName();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocs_if.vo.beans.IfLocParentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.isactive = bean.getIsActive();
		this.isvirtual = bean.getIsVirtual();
		this.type = bean.getType() == null ? null : ims.core.vo.lookups.LocationType.buildLookup(bean.getType());
		this.displayinedtracking = bean.getDisplayInEDTracking();
		this.parentlocation = bean.getParentLocation() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getParentLocation().getId()), bean.getParentLocation().getVersion());
		this.codemappings = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getCodeMappings());
		this.address = bean.getAddress() == null ? null : bean.getAddress().buildVo(map);
		this.uppername = bean.getUpperName();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocs_if.vo.beans.IfLocParentVoBean bean = null;
		if(map != null)
			bean = (ims.ocs_if.vo.beans.IfLocParentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocs_if.vo.beans.IfLocParentVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("PARENTLOCATION"))
			return getParentLocation();
		if(fieldName.equals("CODEMAPPINGS"))
			return getCodeMappings();
		if(fieldName.equals("ADDRESS"))
			return getAddress();
		if(fieldName.equals("UPPERNAME"))
			return getUpperName();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getParentLocationIsNotNull()
	{
		return this.parentlocation != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getParentLocation()
	{
		return this.parentlocation;
	}
	public void setParentLocation(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.parentlocation = value;
	}
	public boolean getCodeMappingsIsNotNull()
	{
		return this.codemappings != null;
	}
	public ims.core.vo.TaxonomyMapCollection getCodeMappings()
	{
		return this.codemappings;
	}
	public void setCodeMappings(ims.core.vo.TaxonomyMapCollection value)
	{
		this.isValidated = false;
		this.codemappings = value;
	}
	public boolean getAddressIsNotNull()
	{
		return this.address != null;
	}
	public ims.core.vo.PersonAddress getAddress()
	{
		return this.address;
	}
	public void setAddress(ims.core.vo.PersonAddress value)
	{
		this.isValidated = false;
		this.address = value;
	}
	public boolean getUpperNameIsNotNull()
	{
		return this.uppername != null;
	}
	public String getUpperName()
	{
		return this.uppername;
	}
	public static int getUpperNameMaxLength()
	{
		return 30;
	}
	public void setUpperName(String value)
	{
		this.isValidated = false;
		this.uppername = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.codemappings != null)
		{
			if(!this.codemappings.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.address != null)
		{
			if(!this.address.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 120)
			listOfErrors.add("The length of the field [name] in the value object [ims.ocs_if.vo.IfLocParentVo] is too big. It should be less or equal to 120");
		if(this.isvirtual == null)
			listOfErrors.add("IsVirtual is mandatory");
		if(this.type == null)
			listOfErrors.add("Type is mandatory");
		if(this.codemappings != null)
		{
			String[] listOfOtherErrors = this.codemappings.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.address != null)
		{
			String[] listOfOtherErrors = this.address.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.uppername == null || this.uppername.length() == 0)
			listOfErrors.add("UpperName is mandatory");
		else if(this.uppername.length() > 30)
			listOfErrors.add("The length of the field [uppername] in the value object [ims.ocs_if.vo.IfLocParentVo] is too big. It should be less or equal to 30");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		IfLocParentVo clone = new IfLocParentVo(this.id, this.version);
		
		clone.name = this.name;
		clone.isactive = this.isactive;
		clone.isvirtual = this.isvirtual;
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.core.vo.lookups.LocationType)this.type.clone();
		clone.displayinedtracking = this.displayinedtracking;
		clone.parentlocation = this.parentlocation;
		if(this.codemappings == null)
			clone.codemappings = null;
		else
			clone.codemappings = (ims.core.vo.TaxonomyMapCollection)this.codemappings.clone();
		if(this.address == null)
			clone.address = null;
		else
			clone.address = (ims.core.vo.PersonAddress)this.address.clone();
		clone.uppername = this.uppername;
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(IfLocParentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A IfLocParentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((IfLocParentVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((IfLocParentVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.parentlocation != null)
			count++;
		if(this.codemappings != null)
			count++;
		if(this.address != null)
			count++;
		if(this.uppername != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 4;
	}
	protected ims.core.resource.place.vo.LocationRefVo parentlocation;
	protected ims.core.vo.TaxonomyMapCollection codemappings;
	protected ims.core.vo.PersonAddress address;
	protected String uppername;
	private boolean isValidated = false;
	private boolean isBusy = false;
}