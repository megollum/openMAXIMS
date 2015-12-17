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


public class OutPatientListSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OutPatientListSearchCriteriaVo()
	{
	}
	public OutPatientListSearchCriteriaVo(ims.core.vo.beans.OutPatientListSearchCriteriaVoBean bean)
	{
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo();
		this.clinic = bean.getClinic() == null ? null : bean.getClinic().buildVo();
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo();
		this.clinicdate = bean.getClinicDate() == null ? null : bean.getClinicDate().buildDate();
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.documentstatus = bean.getDocumentStatus() == null ? null : ims.core.vo.lookups.DocumentStatus.buildLookup(bean.getDocumentStatus());
		this.datefrom = bean.getDateFrom() == null ? null : bean.getDateFrom().buildDate();
		this.dateto = bean.getDateTo() == null ? null : bean.getDateTo().buildDate();
		this.dictatedby = bean.getDictatedBy() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getDictatedBy().getId()), bean.getDictatedBy().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.OutPatientListSearchCriteriaVoBean bean)
	{
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo(map);
		this.clinic = bean.getClinic() == null ? null : bean.getClinic().buildVo(map);
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo(map);
		this.clinicdate = bean.getClinicDate() == null ? null : bean.getClinicDate().buildDate();
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.documentstatus = bean.getDocumentStatus() == null ? null : ims.core.vo.lookups.DocumentStatus.buildLookup(bean.getDocumentStatus());
		this.datefrom = bean.getDateFrom() == null ? null : bean.getDateFrom().buildDate();
		this.dateto = bean.getDateTo() == null ? null : bean.getDateTo().buildDate();
		this.dictatedby = bean.getDictatedBy() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getDictatedBy().getId()), bean.getDictatedBy().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.OutPatientListSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.OutPatientListSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.OutPatientListSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getLocationIsNotNull()
	{
		return this.location != null;
	}
	public ims.core.vo.LocationLiteVo getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.location = value;
	}
	public boolean getClinicIsNotNull()
	{
		return this.clinic != null;
	}
	public ims.core.vo.ClinicLiteVo getClinic()
	{
		return this.clinic;
	}
	public void setClinic(ims.core.vo.ClinicLiteVo value)
	{
		this.isValidated = false;
		this.clinic = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.core.vo.MedicLiteVo getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.MedicLiteVo value)
	{
		this.isValidated = false;
		this.consultant = value;
	}
	public boolean getClinicDateIsNotNull()
	{
		return this.clinicdate != null;
	}
	public ims.framework.utils.Date getClinicDate()
	{
		return this.clinicdate;
	}
	public void setClinicDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.clinicdate = value;
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.lookups.Specialty getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.specialty = value;
	}
	public boolean getDocumentStatusIsNotNull()
	{
		return this.documentstatus != null;
	}
	public ims.core.vo.lookups.DocumentStatus getDocumentStatus()
	{
		return this.documentstatus;
	}
	public void setDocumentStatus(ims.core.vo.lookups.DocumentStatus value)
	{
		this.isValidated = false;
		this.documentstatus = value;
	}
	public boolean getDateFromIsNotNull()
	{
		return this.datefrom != null;
	}
	public ims.framework.utils.Date getDateFrom()
	{
		return this.datefrom;
	}
	public void setDateFrom(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datefrom = value;
	}
	public boolean getDateToIsNotNull()
	{
		return this.dateto != null;
	}
	public ims.framework.utils.Date getDateTo()
	{
		return this.dateto;
	}
	public void setDateTo(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateto = value;
	}
	public boolean getDictatedByIsNotNull()
	{
		return this.dictatedby != null;
	}
	public ims.core.resource.people.vo.MemberOfStaffRefVo getDictatedBy()
	{
		return this.dictatedby;
	}
	public void setDictatedBy(ims.core.resource.people.vo.MemberOfStaffRefVo value)
	{
		this.isValidated = false;
		this.dictatedby = value;
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
		if(this.location != null)
		{
			if(!this.location.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.clinic != null)
		{
			if(!this.clinic.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.consultant != null)
		{
			if(!this.consultant.isValidated())
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
		if(this.location != null)
		{
			String[] listOfOtherErrors = this.location.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.clinic != null)
		{
			String[] listOfOtherErrors = this.clinic.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.consultant != null)
		{
			String[] listOfOtherErrors = this.consultant.validate();
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		OutPatientListSearchCriteriaVo clone = new OutPatientListSearchCriteriaVo();
		
		if(this.location == null)
			clone.location = null;
		else
			clone.location = (ims.core.vo.LocationLiteVo)this.location.clone();
		if(this.clinic == null)
			clone.clinic = null;
		else
			clone.clinic = (ims.core.vo.ClinicLiteVo)this.clinic.clone();
		if(this.consultant == null)
			clone.consultant = null;
		else
			clone.consultant = (ims.core.vo.MedicLiteVo)this.consultant.clone();
		if(this.clinicdate == null)
			clone.clinicdate = null;
		else
			clone.clinicdate = (ims.framework.utils.Date)this.clinicdate.clone();
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		if(this.documentstatus == null)
			clone.documentstatus = null;
		else
			clone.documentstatus = (ims.core.vo.lookups.DocumentStatus)this.documentstatus.clone();
		if(this.datefrom == null)
			clone.datefrom = null;
		else
			clone.datefrom = (ims.framework.utils.Date)this.datefrom.clone();
		if(this.dateto == null)
			clone.dateto = null;
		else
			clone.dateto = (ims.framework.utils.Date)this.dateto.clone();
		clone.dictatedby = this.dictatedby;
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
		if (!(OutPatientListSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OutPatientListSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		OutPatientListSearchCriteriaVo compareObj = (OutPatientListSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getClinicDate() == null && compareObj.getClinicDate() != null)
				return -1;
			if(this.getClinicDate() != null && compareObj.getClinicDate() == null)
				return 1;
			if(this.getClinicDate() != null && compareObj.getClinicDate() != null)
				retVal = this.getClinicDate().compareTo(compareObj.getClinicDate());
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
		if(this.location != null)
			count++;
		if(this.clinic != null)
			count++;
		if(this.consultant != null)
			count++;
		if(this.clinicdate != null)
			count++;
		if(this.specialty != null)
			count++;
		if(this.documentstatus != null)
			count++;
		if(this.datefrom != null)
			count++;
		if(this.dateto != null)
			count++;
		if(this.dictatedby != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.core.vo.LocationLiteVo location;
	protected ims.core.vo.ClinicLiteVo clinic;
	protected ims.core.vo.MedicLiteVo consultant;
	protected ims.framework.utils.Date clinicdate;
	protected ims.core.vo.lookups.Specialty specialty;
	protected ims.core.vo.lookups.DocumentStatus documentstatus;
	protected ims.framework.utils.Date datefrom;
	protected ims.framework.utils.Date dateto;
	protected ims.core.resource.people.vo.MemberOfStaffRefVo dictatedby;
	private boolean isValidated = false;
	private boolean isBusy = false;
}