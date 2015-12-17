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

package ims.hl7.vo;

/**
 * Linked to core.resource.people.Gp business object (ID: 1006100001).
 */
public class ifGPMessageQueueVo extends ims.core.resource.people.vo.GpRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ifGPMessageQueueVo()
	{
	}
	public ifGPMessageQueueVo(Integer id, int version)
	{
		super(id, version);
	}
	public ifGPMessageQueueVo(ims.hl7.vo.beans.ifGPMessageQueueVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.GPStatus.buildLookup(bean.getStatus());
		this.practices = ims.core.vo.Gp_PracticesVoCollection.buildFromBeanCollection(bean.getPractices());
		this.commchannels = ims.core.vo.CommChannelVoCollection.buildFromBeanCollection(bean.getCommChannels());
		this.codemappings = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getCodeMappings());
		this.address = bean.getAddress() == null ? null : bean.getAddress().buildVo();
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.hl7.vo.beans.ifGPMessageQueueVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo(map);
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.GPStatus.buildLookup(bean.getStatus());
		this.practices = ims.core.vo.Gp_PracticesVoCollection.buildFromBeanCollection(bean.getPractices());
		this.commchannels = ims.core.vo.CommChannelVoCollection.buildFromBeanCollection(bean.getCommChannels());
		this.codemappings = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getCodeMappings());
		this.address = bean.getAddress() == null ? null : bean.getAddress().buildVo(map);
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.hl7.vo.beans.ifGPMessageQueueVoBean bean = null;
		if(map != null)
			bean = (ims.hl7.vo.beans.ifGPMessageQueueVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.hl7.vo.beans.ifGPMessageQueueVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("PRACTICES"))
			return getPractices();
		if(fieldName.equals("COMMCHANNELS"))
			return getCommChannels();
		if(fieldName.equals("CODEMAPPINGS"))
			return getCodeMappings();
		if(fieldName.equals("ADDRESS"))
			return getAddress();
		if(fieldName.equals("SYSTEMINFORMATION"))
			return getSystemInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public ims.core.vo.PersonName getName()
	{
		return this.name;
	}
	public void setName(ims.core.vo.PersonName value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.GPStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.GPStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getPracticesIsNotNull()
	{
		return this.practices != null;
	}
	public ims.core.vo.Gp_PracticesVoCollection getPractices()
	{
		return this.practices;
	}
	public void setPractices(ims.core.vo.Gp_PracticesVoCollection value)
	{
		this.isValidated = false;
		this.practices = value;
	}
	public boolean getCommChannelsIsNotNull()
	{
		return this.commchannels != null;
	}
	public ims.core.vo.CommChannelVoCollection getCommChannels()
	{
		return this.commchannels;
	}
	public void setCommChannels(ims.core.vo.CommChannelVoCollection value)
	{
		this.isValidated = false;
		this.commchannels = value;
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
	public ims.core.vo.AddressVo getAddress()
	{
		return this.address;
	}
	public void setAddress(ims.core.vo.AddressVo value)
	{
		this.isValidated = false;
		this.address = value;
	}
	public boolean getSystemInformationIsNotNull()
	{
		return this.systeminformation != null;
	}
	public ims.vo.SystemInformation getSystemInformation()
	{
		return this.systeminformation;
	}
	public void setSystemInformation(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.systeminformation = value;
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
	
		ifGPMessageQueueVo clone = new ifGPMessageQueueVo(this.id, this.version);
		
		if(this.name == null)
			clone.name = null;
		else
			clone.name = (ims.core.vo.PersonName)this.name.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.GPStatus)this.status.clone();
		if(this.practices == null)
			clone.practices = null;
		else
			clone.practices = (ims.core.vo.Gp_PracticesVoCollection)this.practices.clone();
		if(this.commchannels == null)
			clone.commchannels = null;
		else
			clone.commchannels = (ims.core.vo.CommChannelVoCollection)this.commchannels.clone();
		if(this.codemappings == null)
			clone.codemappings = null;
		else
			clone.codemappings = (ims.core.vo.TaxonomyMapCollection)this.codemappings.clone();
		if(this.address == null)
			clone.address = null;
		else
			clone.address = (ims.core.vo.AddressVo)this.address.clone();
		if(this.systeminformation == null)
			clone.systeminformation = null;
		else
			clone.systeminformation = (ims.vo.SystemInformation)this.systeminformation.clone();
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
		if (!(ifGPMessageQueueVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ifGPMessageQueueVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ifGPMessageQueueVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ifGPMessageQueueVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.name != null)
			count++;
		if(this.status != null)
			count++;
		if(this.practices != null)
			count++;
		if(this.commchannels != null)
			count++;
		if(this.codemappings != null)
			count++;
		if(this.address != null)
			count++;
		if(this.systeminformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.core.vo.PersonName name;
	protected ims.core.vo.lookups.GPStatus status;
	protected ims.core.vo.Gp_PracticesVoCollection practices;
	protected ims.core.vo.CommChannelVoCollection commchannels;
	protected ims.core.vo.TaxonomyMapCollection codemappings;
	protected ims.core.vo.AddressVo address;
	protected ims.vo.SystemInformation systeminformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}