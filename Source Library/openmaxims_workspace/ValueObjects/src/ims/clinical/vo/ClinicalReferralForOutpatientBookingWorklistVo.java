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
 * Linked to clinical.ClinicalReferrals business object (ID: 1072100112).
 */
public class ClinicalReferralForOutpatientBookingWorklistVo extends ims.clinical.vo.ClinicalReferralsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicalReferralForOutpatientBookingWorklistVo()
	{
	}
	public ClinicalReferralForOutpatientBookingWorklistVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClinicalReferralForOutpatientBookingWorklistVo(ims.clinical.vo.beans.ClinicalReferralForOutpatientBookingWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.currentreferralstatus = bean.getCurrentReferralStatus() == null ? null : bean.getCurrentReferralStatus().buildVo();
		this.refertohcp = bean.getReferToHCP() == null ? null : bean.getReferToHCP().buildVo();
		this.urgentreferral = bean.getUrgentReferral();
		this.datedecisiontorefer = bean.getDateDecisionToRefer() == null ? null : bean.getDateDecisionToRefer().buildDate();
		this.referringhcp = bean.getReferringHCP() == null ? null : bean.getReferringHCP().buildVo();
		this.refertoservice = bean.getReferToService() == null ? null : bean.getReferToService().buildVo();
		this.referraltype = bean.getReferralType() == null ? null : ims.clinical.vo.lookups.ClinicalReferralType.buildLookup(bean.getReferralType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.ClinicalReferralForOutpatientBookingWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.currentreferralstatus = bean.getCurrentReferralStatus() == null ? null : bean.getCurrentReferralStatus().buildVo(map);
		this.refertohcp = bean.getReferToHCP() == null ? null : bean.getReferToHCP().buildVo(map);
		this.urgentreferral = bean.getUrgentReferral();
		this.datedecisiontorefer = bean.getDateDecisionToRefer() == null ? null : bean.getDateDecisionToRefer().buildDate();
		this.referringhcp = bean.getReferringHCP() == null ? null : bean.getReferringHCP().buildVo(map);
		this.refertoservice = bean.getReferToService() == null ? null : bean.getReferToService().buildVo(map);
		this.referraltype = bean.getReferralType() == null ? null : ims.clinical.vo.lookups.ClinicalReferralType.buildLookup(bean.getReferralType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.ClinicalReferralForOutpatientBookingWorklistVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.ClinicalReferralForOutpatientBookingWorklistVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.ClinicalReferralForOutpatientBookingWorklistVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("CURRENTREFERRALSTATUS"))
			return getCurrentReferralStatus();
		if(fieldName.equals("REFERTOHCP"))
			return getReferToHCP();
		if(fieldName.equals("URGENTREFERRAL"))
			return getUrgentReferral();
		if(fieldName.equals("DATEDECISIONTOREFER"))
			return getDateDecisionToRefer();
		if(fieldName.equals("REFERRINGHCP"))
			return getReferringHCP();
		if(fieldName.equals("REFERTOSERVICE"))
			return getReferToService();
		if(fieldName.equals("REFERRALTYPE"))
			return getReferralType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientForOutpatientBookingWorklistVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientForOutpatientBookingWorklistVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getCurrentReferralStatusIsNotNull()
	{
		return this.currentreferralstatus != null;
	}
	public ims.clinical.vo.InternalReferralStatusForBookingWorklistVo getCurrentReferralStatus()
	{
		return this.currentreferralstatus;
	}
	public void setCurrentReferralStatus(ims.clinical.vo.InternalReferralStatusForBookingWorklistVo value)
	{
		this.isValidated = false;
		this.currentreferralstatus = value;
	}
	public boolean getReferToHCPIsNotNull()
	{
		return this.refertohcp != null;
	}
	public ims.core.vo.HcpLiteVo getReferToHCP()
	{
		return this.refertohcp;
	}
	public void setReferToHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.refertohcp = value;
	}
	public boolean getUrgentReferralIsNotNull()
	{
		return this.urgentreferral != null;
	}
	public Boolean getUrgentReferral()
	{
		return this.urgentreferral;
	}
	public void setUrgentReferral(Boolean value)
	{
		this.isValidated = false;
		this.urgentreferral = value;
	}
	public boolean getDateDecisionToReferIsNotNull()
	{
		return this.datedecisiontorefer != null;
	}
	public ims.framework.utils.Date getDateDecisionToRefer()
	{
		return this.datedecisiontorefer;
	}
	public void setDateDecisionToRefer(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datedecisiontorefer = value;
	}
	public boolean getReferringHCPIsNotNull()
	{
		return this.referringhcp != null;
	}
	public ims.core.vo.HcpLiteVo getReferringHCP()
	{
		return this.referringhcp;
	}
	public void setReferringHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.referringhcp = value;
	}
	public boolean getReferToServiceIsNotNull()
	{
		return this.refertoservice != null;
	}
	public ims.clinical.vo.ServiceConfigIntReferralBookingListVo getReferToService()
	{
		return this.refertoservice;
	}
	public void setReferToService(ims.clinical.vo.ServiceConfigIntReferralBookingListVo value)
	{
		this.isValidated = false;
		this.refertoservice = value;
	}
	public boolean getReferralTypeIsNotNull()
	{
		return this.referraltype != null;
	}
	public ims.clinical.vo.lookups.ClinicalReferralType getReferralType()
	{
		return this.referraltype;
	}
	public void setReferralType(ims.clinical.vo.lookups.ClinicalReferralType value)
	{
		this.isValidated = false;
		this.referraltype = value;
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.currentreferralstatus == null)
			listOfErrors.add("CurrentReferralStatus is mandatory");
		if(this.datedecisiontorefer == null)
			listOfErrors.add("DateDecisionToRefer is mandatory");
		if(this.referringhcp == null)
			listOfErrors.add("ReferringHCP is mandatory");
		if(this.refertoservice == null)
			listOfErrors.add("ReferToService is mandatory");
		if(this.referraltype == null)
			listOfErrors.add("ReferralType is mandatory");
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
	
		ClinicalReferralForOutpatientBookingWorklistVo clone = new ClinicalReferralForOutpatientBookingWorklistVo(this.id, this.version);
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientForOutpatientBookingWorklistVo)this.patient.clone();
		if(this.currentreferralstatus == null)
			clone.currentreferralstatus = null;
		else
			clone.currentreferralstatus = (ims.clinical.vo.InternalReferralStatusForBookingWorklistVo)this.currentreferralstatus.clone();
		if(this.refertohcp == null)
			clone.refertohcp = null;
		else
			clone.refertohcp = (ims.core.vo.HcpLiteVo)this.refertohcp.clone();
		clone.urgentreferral = this.urgentreferral;
		if(this.datedecisiontorefer == null)
			clone.datedecisiontorefer = null;
		else
			clone.datedecisiontorefer = (ims.framework.utils.Date)this.datedecisiontorefer.clone();
		if(this.referringhcp == null)
			clone.referringhcp = null;
		else
			clone.referringhcp = (ims.core.vo.HcpLiteVo)this.referringhcp.clone();
		if(this.refertoservice == null)
			clone.refertoservice = null;
		else
			clone.refertoservice = (ims.clinical.vo.ServiceConfigIntReferralBookingListVo)this.refertoservice.clone();
		if(this.referraltype == null)
			clone.referraltype = null;
		else
			clone.referraltype = (ims.clinical.vo.lookups.ClinicalReferralType)this.referraltype.clone();
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
		if (!(ClinicalReferralForOutpatientBookingWorklistVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicalReferralForOutpatientBookingWorklistVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ClinicalReferralForOutpatientBookingWorklistVo compareObj = (ClinicalReferralForOutpatientBookingWorklistVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getUrgentReferral() == null && compareObj.getUrgentReferral() != null)
				return -1;
			if(this.getUrgentReferral() != null && compareObj.getUrgentReferral() == null)
				return 1;
			if(this.getUrgentReferral() != null && compareObj.getUrgentReferral() != null)
				retVal = this.getUrgentReferral().compareTo(compareObj.getUrgentReferral());
		}
		if (retVal == 0)
		{
			if(this.getDateDecisionToRefer() == null && compareObj.getDateDecisionToRefer() != null)
				return -1;
			if(this.getDateDecisionToRefer() != null && compareObj.getDateDecisionToRefer() == null)
				return 1;
			if(this.getDateDecisionToRefer() != null && compareObj.getDateDecisionToRefer() != null)
				retVal = this.getDateDecisionToRefer().compareTo(compareObj.getDateDecisionToRefer());
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
		if(this.patient != null)
			count++;
		if(this.currentreferralstatus != null)
			count++;
		if(this.refertohcp != null)
			count++;
		if(this.urgentreferral != null)
			count++;
		if(this.datedecisiontorefer != null)
			count++;
		if(this.referringhcp != null)
			count++;
		if(this.refertoservice != null)
			count++;
		if(this.referraltype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.vo.PatientForOutpatientBookingWorklistVo patient;
	protected ims.clinical.vo.InternalReferralStatusForBookingWorklistVo currentreferralstatus;
	protected ims.core.vo.HcpLiteVo refertohcp;
	protected Boolean urgentreferral;
	protected ims.framework.utils.Date datedecisiontorefer;
	protected ims.core.vo.HcpLiteVo referringhcp;
	protected ims.clinical.vo.ServiceConfigIntReferralBookingListVo refertoservice;
	protected ims.clinical.vo.lookups.ClinicalReferralType referraltype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}