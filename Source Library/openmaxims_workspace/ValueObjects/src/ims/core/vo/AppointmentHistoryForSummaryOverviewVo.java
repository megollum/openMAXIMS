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

package ims.core.vo;


public class AppointmentHistoryForSummaryOverviewVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AppointmentHistoryForSummaryOverviewVo()
	{
	}
	public AppointmentHistoryForSummaryOverviewVo(ims.core.vo.beans.AppointmentHistoryForSummaryOverviewVoBean bean)
	{
		this.type = bean.getType();
		this.hcp = bean.getHcp() == null ? null : bean.getHcp().buildVo();
		this.date = bean.getDate() == null ? null : bean.getDate().buildDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.AppointmentHistoryForSummaryOverviewVoBean bean)
	{
		this.type = bean.getType();
		this.hcp = bean.getHcp() == null ? null : bean.getHcp().buildVo(map);
		this.date = bean.getDate() == null ? null : bean.getDate().buildDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.AppointmentHistoryForSummaryOverviewVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.AppointmentHistoryForSummaryOverviewVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.AppointmentHistoryForSummaryOverviewVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getTypeIsNotNull()
	{
		return this.type != null;
	}
	public Integer getType()
	{
		return this.type;
	}
	public void setType(Integer value)
	{
		this.isValidated = false;
		this.type = value;
	}
	public boolean getHcpIsNotNull()
	{
		return this.hcp != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getHcp()
	{
		return this.hcp;
	}
	public void setHcp(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.hcp = value;
	}
	public boolean getDateIsNotNull()
	{
		return this.date != null;
	}
	public ims.framework.utils.Date getDate()
	{
		return this.date;
	}
	public void setDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.date = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof AppointmentHistoryForSummaryOverviewVo))
			return false;
		AppointmentHistoryForSummaryOverviewVo compareObj = (AppointmentHistoryForSummaryOverviewVo)obj;
		if(this.getType() == null && compareObj.getType() != null)
			return false;
		if(this.getType() != null && compareObj.getType() == null)
			return false;
		if(this.getType() != null && compareObj.getType() != null)
			return this.getType().equals(compareObj.getType());
		return super.equals(obj);
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		AppointmentHistoryForSummaryOverviewVo clone = new AppointmentHistoryForSummaryOverviewVo();
		
		clone.type = this.type;
		if(this.hcp == null)
			clone.hcp = null;
		else
			clone.hcp = (ims.core.vo.MemberOfStaffLiteVo)this.hcp.clone();
		if(this.date == null)
			clone.date = null;
		else
			clone.date = (ims.framework.utils.Date)this.date.clone();
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
		if (!(AppointmentHistoryForSummaryOverviewVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AppointmentHistoryForSummaryOverviewVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AppointmentHistoryForSummaryOverviewVo compareObj = (AppointmentHistoryForSummaryOverviewVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getType() == null && compareObj.getType() != null)
				return -1;
			if(this.getType() != null && compareObj.getType() == null)
				return 1;
			if(this.getType() != null && compareObj.getType() != null)
				retVal = this.getType().compareTo(compareObj.getType());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.type != null)
			count++;
		if(this.hcp != null)
			count++;
		if(this.date != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected Integer type;
	protected ims.core.vo.MemberOfStaffLiteVo hcp;
	protected ims.framework.utils.Date date;
	private boolean isValidated = false;
	private boolean isBusy = false;
}