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
 * Linked to clinical.PatientChartableOccurance business object (ID: 1072100130).
 */
public class PreOperativeChartOccurancVo extends ims.clinical.vo.PatientChartableOccuranceRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PreOperativeChartOccurancVo()
	{
	}
	public PreOperativeChartOccurancVo(Integer id, int version)
	{
		super(id, version);
	}
	public PreOperativeChartOccurancVo(ims.clinical.vo.beans.PreOperativeChartOccurancVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.theatreappointment = bean.getTheatreAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getTheatreAppointment().getId()), bean.getTheatreAppointment().getVersion());
		this.timeobserved = bean.getTimeObserved() == null ? null : bean.getTimeObserved().buildDateTime();
		this.chartableoccurancetype = bean.getChartableOccuranceType() == null ? null : ims.clinical.vo.lookups.ChartableOccuranceType.buildLookup(bean.getChartableOccuranceType());
		this.reportedby = bean.getReportedBy() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getReportedBy().getId()), bean.getReportedBy().getVersion());
		this.incidentnumber = bean.getIncidentNumber();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.PreOperativeChartOccurancVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.theatreappointment = bean.getTheatreAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getTheatreAppointment().getId()), bean.getTheatreAppointment().getVersion());
		this.timeobserved = bean.getTimeObserved() == null ? null : bean.getTimeObserved().buildDateTime();
		this.chartableoccurancetype = bean.getChartableOccuranceType() == null ? null : ims.clinical.vo.lookups.ChartableOccuranceType.buildLookup(bean.getChartableOccuranceType());
		this.reportedby = bean.getReportedBy() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getReportedBy().getId()), bean.getReportedBy().getVersion());
		this.incidentnumber = bean.getIncidentNumber();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.PreOperativeChartOccurancVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.PreOperativeChartOccurancVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.PreOperativeChartOccurancVoBean();
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
		if(fieldName.equals("TIMEOBSERVED"))
			return getTimeObserved();
		if(fieldName.equals("CHARTABLEOCCURANCETYPE"))
			return getChartableOccuranceType();
		if(fieldName.equals("REPORTEDBY"))
			return getReportedBy();
		if(fieldName.equals("INCIDENTNUMBER"))
			return getIncidentNumber();
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
	public boolean getTimeObservedIsNotNull()
	{
		return this.timeobserved != null;
	}
	public ims.framework.utils.DateTime getTimeObserved()
	{
		return this.timeobserved;
	}
	public void setTimeObserved(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.timeobserved = value;
	}
	public boolean getChartableOccuranceTypeIsNotNull()
	{
		return this.chartableoccurancetype != null;
	}
	public ims.clinical.vo.lookups.ChartableOccuranceType getChartableOccuranceType()
	{
		return this.chartableoccurancetype;
	}
	public void setChartableOccuranceType(ims.clinical.vo.lookups.ChartableOccuranceType value)
	{
		this.isValidated = false;
		this.chartableoccurancetype = value;
	}
	public boolean getReportedByIsNotNull()
	{
		return this.reportedby != null;
	}
	public ims.core.resource.people.vo.MemberOfStaffRefVo getReportedBy()
	{
		return this.reportedby;
	}
	public void setReportedBy(ims.core.resource.people.vo.MemberOfStaffRefVo value)
	{
		this.isValidated = false;
		this.reportedby = value;
	}
	public boolean getIncidentNumberIsNotNull()
	{
		return this.incidentnumber != null;
	}
	public String getIncidentNumber()
	{
		return this.incidentnumber;
	}
	public static int getIncidentNumberMaxLength()
	{
		return 25;
	}
	public void setIncidentNumber(String value)
	{
		this.isValidated = false;
		this.incidentnumber = value;
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
		if(this.timeobserved == null)
			listOfErrors.add("TimeObserved is mandatory");
		if(this.chartableoccurancetype == null)
			listOfErrors.add("ChartableOccuranceType is mandatory");
		if(this.reportedby == null)
			listOfErrors.add("ReportedBy is mandatory");
		if(this.incidentnumber == null || this.incidentnumber.length() == 0)
			listOfErrors.add("IncidentNumber is mandatory");
		else if(this.incidentnumber.length() > 25)
			listOfErrors.add("The length of the field [incidentnumber] in the value object [ims.clinical.vo.PreOperativeChartOccurancVo] is too big. It should be less or equal to 25");
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
	
		PreOperativeChartOccurancVo clone = new PreOperativeChartOccurancVo(this.id, this.version);
		
		clone.theatreappointment = this.theatreappointment;
		if(this.timeobserved == null)
			clone.timeobserved = null;
		else
			clone.timeobserved = (ims.framework.utils.DateTime)this.timeobserved.clone();
		if(this.chartableoccurancetype == null)
			clone.chartableoccurancetype = null;
		else
			clone.chartableoccurancetype = (ims.clinical.vo.lookups.ChartableOccuranceType)this.chartableoccurancetype.clone();
		clone.reportedby = this.reportedby;
		clone.incidentnumber = this.incidentnumber;
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
		if (!(PreOperativeChartOccurancVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PreOperativeChartOccurancVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PreOperativeChartOccurancVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PreOperativeChartOccurancVo)obj).getBoId());
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
		if(this.timeobserved != null)
			count++;
		if(this.chartableoccurancetype != null)
			count++;
		if(this.reportedby != null)
			count++;
		if(this.incidentnumber != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.scheduling.vo.Booking_AppointmentRefVo theatreappointment;
	protected ims.framework.utils.DateTime timeobserved;
	protected ims.clinical.vo.lookups.ChartableOccuranceType chartableoccurancetype;
	protected ims.core.resource.people.vo.MemberOfStaffRefVo reportedby;
	protected String incidentnumber;
	private boolean isValidated = false;
	private boolean isBusy = false;
}