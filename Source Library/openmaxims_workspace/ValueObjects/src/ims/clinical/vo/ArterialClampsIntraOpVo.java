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

package ims.clinical.vo;

/**
 * Linked to clinical.ArterialClampIntraOp business object (ID: 1072100147).
 */
public class ArterialClampsIntraOpVo extends ims.clinical.vo.ArterialClampIntraOpRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ArterialClampsIntraOpVo()
	{
	}
	public ArterialClampsIntraOpVo(Integer id, int version)
	{
		super(id, version);
	}
	public ArterialClampsIntraOpVo(ims.clinical.vo.beans.ArterialClampsIntraOpVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.theatreappointment = bean.getTheatreAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getTheatreAppointment().getId()), bean.getTheatreAppointment().getVersion());
		this.clampsite = bean.getClampSite();
		this.timeon = bean.getTimeOn() == null ? null : bean.getTimeOn().buildDateTime();
		this.timeoff = bean.getTimeOff() == null ? null : bean.getTimeOff().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.ArterialClampsIntraOpVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.theatreappointment = bean.getTheatreAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getTheatreAppointment().getId()), bean.getTheatreAppointment().getVersion());
		this.clampsite = bean.getClampSite();
		this.timeon = bean.getTimeOn() == null ? null : bean.getTimeOn().buildDateTime();
		this.timeoff = bean.getTimeOff() == null ? null : bean.getTimeOff().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.ArterialClampsIntraOpVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.ArterialClampsIntraOpVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.ArterialClampsIntraOpVoBean();
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
		if(fieldName.equals("THEATREAPPOINTMENT"))
			return getTheatreAppointment();
		if(fieldName.equals("CLAMPSITE"))
			return getClampSite();
		if(fieldName.equals("TIMEON"))
			return getTimeOn();
		if(fieldName.equals("TIMEOFF"))
			return getTimeOff();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTheatreAppointmentIsNotNull()
	{
		return this.theatreappointment != null;
	}
	public ims.scheduling.vo.Booking_AppointmentRefVo getTheatreAppointment()
	{
		return this.theatreappointment;
	}
	public void setTheatreAppointment(ims.scheduling.vo.Booking_AppointmentRefVo value)
	{
		this.isValidated = false;
		this.theatreappointment = value;
	}
	public boolean getClampSiteIsNotNull()
	{
		return this.clampsite != null;
	}
	public String getClampSite()
	{
		return this.clampsite;
	}
	public static int getClampSiteMaxLength()
	{
		return 150;
	}
	public void setClampSite(String value)
	{
		this.isValidated = false;
		this.clampsite = value;
	}
	public boolean getTimeOnIsNotNull()
	{
		return this.timeon != null;
	}
	public ims.framework.utils.DateTime getTimeOn()
	{
		return this.timeon;
	}
	public void setTimeOn(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.timeon = value;
	}
	public boolean getTimeOffIsNotNull()
	{
		return this.timeoff != null;
	}
	public ims.framework.utils.DateTime getTimeOff()
	{
		return this.timeoff;
	}
	public void setTimeOff(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.timeoff = value;
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
		if(this.theatreappointment == null)
			listOfErrors.add("TheatreAppointment is mandatory");
		if(this.clampsite == null || this.clampsite.length() == 0)
			listOfErrors.add("ClampSite is mandatory");
		else if(this.clampsite.length() > 150)
			listOfErrors.add("The length of the field [clampsite] in the value object [ims.clinical.vo.ArterialClampsIntraOpVo] is too big. It should be less or equal to 150");
		if(this.timeon == null)
			listOfErrors.add("TimeOn is mandatory");
		if(this.timeoff == null)
			listOfErrors.add("TimeOff is mandatory");
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
	
		ArterialClampsIntraOpVo clone = new ArterialClampsIntraOpVo(this.id, this.version);
		
		clone.theatreappointment = this.theatreappointment;
		clone.clampsite = this.clampsite;
		if(this.timeon == null)
			clone.timeon = null;
		else
			clone.timeon = (ims.framework.utils.DateTime)this.timeon.clone();
		if(this.timeoff == null)
			clone.timeoff = null;
		else
			clone.timeoff = (ims.framework.utils.DateTime)this.timeoff.clone();
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
		if (!(ArterialClampsIntraOpVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ArterialClampsIntraOpVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ArterialClampsIntraOpVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ArterialClampsIntraOpVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.theatreappointment != null)
			count++;
		if(this.clampsite != null)
			count++;
		if(this.timeon != null)
			count++;
		if(this.timeoff != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.scheduling.vo.Booking_AppointmentRefVo theatreappointment;
	protected String clampsite;
	protected ims.framework.utils.DateTime timeon;
	protected ims.framework.utils.DateTime timeoff;
	private boolean isValidated = false;
	private boolean isBusy = false;
}