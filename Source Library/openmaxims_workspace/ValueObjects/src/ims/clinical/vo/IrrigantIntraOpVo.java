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
 * Linked to clinical.IrrigantIntraOp business object (ID: 1072100140).
 */
public class IrrigantIntraOpVo extends ims.clinical.vo.IrrigantIntraOpRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public IrrigantIntraOpVo()
	{
	}
	public IrrigantIntraOpVo(Integer id, int version)
	{
		super(id, version);
	}
	public IrrigantIntraOpVo(ims.clinical.vo.beans.IrrigantIntraOpVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.theatreappointment = bean.getTheatreAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getTheatreAppointment().getId()), bean.getTheatreAppointment().getVersion());
		this.estimatedbloodloss = bean.getEstimatedBloodLoss();
		this.overalltotalvolumein = bean.getOverallTotalVolumeIn();
		this.totalvolumeout = bean.getTotalVolumeOut();
		this.totalvolumedifference = bean.getTotalVolumeDifference();
		this.irrigationdetails = ims.clinical.vo.IrrigantDetailIntraOpVoCollection.buildFromBeanCollection(bean.getIrrigationDetails());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.IrrigantIntraOpVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.theatreappointment = bean.getTheatreAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getTheatreAppointment().getId()), bean.getTheatreAppointment().getVersion());
		this.estimatedbloodloss = bean.getEstimatedBloodLoss();
		this.overalltotalvolumein = bean.getOverallTotalVolumeIn();
		this.totalvolumeout = bean.getTotalVolumeOut();
		this.totalvolumedifference = bean.getTotalVolumeDifference();
		this.irrigationdetails = ims.clinical.vo.IrrigantDetailIntraOpVoCollection.buildFromBeanCollection(bean.getIrrigationDetails());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.IrrigantIntraOpVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.IrrigantIntraOpVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.IrrigantIntraOpVoBean();
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
		if(fieldName.equals("ESTIMATEDBLOODLOSS"))
			return getEstimatedBloodLoss();
		if(fieldName.equals("OVERALLTOTALVOLUMEIN"))
			return getOverallTotalVolumeIn();
		if(fieldName.equals("TOTALVOLUMEOUT"))
			return getTotalVolumeOut();
		if(fieldName.equals("TOTALVOLUMEDIFFERENCE"))
			return getTotalVolumeDifference();
		if(fieldName.equals("IRRIGATIONDETAILS"))
			return getIrrigationDetails();
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
	public boolean getEstimatedBloodLossIsNotNull()
	{
		return this.estimatedbloodloss != null;
	}
	public Integer getEstimatedBloodLoss()
	{
		return this.estimatedbloodloss;
	}
	public void setEstimatedBloodLoss(Integer value)
	{
		this.isValidated = false;
		this.estimatedbloodloss = value;
	}
	public boolean getOverallTotalVolumeInIsNotNull()
	{
		return this.overalltotalvolumein != null;
	}
	public Integer getOverallTotalVolumeIn()
	{
		return this.overalltotalvolumein;
	}
	public void setOverallTotalVolumeIn(Integer value)
	{
		this.isValidated = false;
		this.overalltotalvolumein = value;
	}
	public boolean getTotalVolumeOutIsNotNull()
	{
		return this.totalvolumeout != null;
	}
	public Integer getTotalVolumeOut()
	{
		return this.totalvolumeout;
	}
	public void setTotalVolumeOut(Integer value)
	{
		this.isValidated = false;
		this.totalvolumeout = value;
	}
	public boolean getTotalVolumeDifferenceIsNotNull()
	{
		return this.totalvolumedifference != null;
	}
	public Integer getTotalVolumeDifference()
	{
		return this.totalvolumedifference;
	}
	public void setTotalVolumeDifference(Integer value)
	{
		this.isValidated = false;
		this.totalvolumedifference = value;
	}
	public boolean getIrrigationDetailsIsNotNull()
	{
		return this.irrigationdetails != null;
	}
	public ims.clinical.vo.IrrigantDetailIntraOpVoCollection getIrrigationDetails()
	{
		return this.irrigationdetails;
	}
	public void setIrrigationDetails(ims.clinical.vo.IrrigantDetailIntraOpVoCollection value)
	{
		this.isValidated = false;
		this.irrigationdetails = value;
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
		if(this.irrigationdetails != null)
		{
			if(!this.irrigationdetails.isValidated())
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
		if(this.theatreappointment == null)
			listOfErrors.add("TheatreAppointment is mandatory");
		if(this.irrigationdetails != null)
		{
			String[] listOfOtherErrors = this.irrigationdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
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
	
		IrrigantIntraOpVo clone = new IrrigantIntraOpVo(this.id, this.version);
		
		clone.theatreappointment = this.theatreappointment;
		clone.estimatedbloodloss = this.estimatedbloodloss;
		clone.overalltotalvolumein = this.overalltotalvolumein;
		clone.totalvolumeout = this.totalvolumeout;
		clone.totalvolumedifference = this.totalvolumedifference;
		if(this.irrigationdetails == null)
			clone.irrigationdetails = null;
		else
			clone.irrigationdetails = (ims.clinical.vo.IrrigantDetailIntraOpVoCollection)this.irrigationdetails.clone();
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
		if (!(IrrigantIntraOpVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A IrrigantIntraOpVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((IrrigantIntraOpVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((IrrigantIntraOpVo)obj).getBoId());
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
		if(this.estimatedbloodloss != null)
			count++;
		if(this.overalltotalvolumein != null)
			count++;
		if(this.totalvolumeout != null)
			count++;
		if(this.totalvolumedifference != null)
			count++;
		if(this.irrigationdetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.scheduling.vo.Booking_AppointmentRefVo theatreappointment;
	protected Integer estimatedbloodloss;
	protected Integer overalltotalvolumein;
	protected Integer totalvolumeout;
	protected Integer totalvolumedifference;
	protected ims.clinical.vo.IrrigantDetailIntraOpVoCollection irrigationdetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}