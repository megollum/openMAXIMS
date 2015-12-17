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

package ims.pathways.vo.beans;

public class PatientPathwaysAwaitingValidationWorklistVoBean extends ims.vo.ValueObjectBean
{
	public PatientPathwaysAwaitingValidationWorklistVoBean()
	{
	}
	public PatientPathwaysAwaitingValidationWorklistVoBean(ims.pathways.vo.PatientPathwaysAwaitingValidationWorklistVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientForPathwayAwaitingValidationWorklistVoBean)vo.getPatient().getBean();
		this.pathway = vo.getPathway() == null ? null : (ims.pathways.vo.beans.PathwayForPatientPathwaysAwaitingValidationWorklistVoBean)vo.getPathway().getBean();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.pathways.vo.beans.PatientJourneyStatusVoBean)vo.getCurrentStatus().getBean();
		this.responsibleconsultant = vo.getResponsibleConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleConsultant().getBean();
		this.nextvalidationdate = vo.getNextValidationDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getNextValidationDate().getBean();
		this.currentclock = vo.getCurrentClock() == null ? null : (ims.pathways.vo.beans.PathwayClockForRTTCurrentStatusVoBean)vo.getCurrentClock().getBean();
		this.validationcompleteddt = vo.getValidationCompletedDT() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getValidationCompletedDT().getBean();
		this.validationcompletedby = vo.getValidationCompletedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffVoBean)vo.getValidationCompletedBy().getBean();
		this.lastvalidationdate = vo.getLastValidationDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getLastValidationDate().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceShortVoBean)vo.getService().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.PatientPathwaysAwaitingValidationWorklistVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientForPathwayAwaitingValidationWorklistVoBean)vo.getPatient().getBean(map);
		this.pathway = vo.getPathway() == null ? null : (ims.pathways.vo.beans.PathwayForPatientPathwaysAwaitingValidationWorklistVoBean)vo.getPathway().getBean(map);
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.pathways.vo.beans.PatientJourneyStatusVoBean)vo.getCurrentStatus().getBean(map);
		this.responsibleconsultant = vo.getResponsibleConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleConsultant().getBean(map);
		this.nextvalidationdate = vo.getNextValidationDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getNextValidationDate().getBean();
		this.currentclock = vo.getCurrentClock() == null ? null : (ims.pathways.vo.beans.PathwayClockForRTTCurrentStatusVoBean)vo.getCurrentClock().getBean(map);
		this.validationcompleteddt = vo.getValidationCompletedDT() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getValidationCompletedDT().getBean();
		this.validationcompletedby = vo.getValidationCompletedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffVoBean)vo.getValidationCompletedBy().getBean(map);
		this.lastvalidationdate = vo.getLastValidationDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getLastValidationDate().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceShortVoBean)vo.getService().getBean(map);
	}

	public ims.pathways.vo.PatientPathwaysAwaitingValidationWorklistVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.pathways.vo.PatientPathwaysAwaitingValidationWorklistVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.PatientPathwaysAwaitingValidationWorklistVo vo = null;
		if(map != null)
			vo = (ims.pathways.vo.PatientPathwaysAwaitingValidationWorklistVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.pathways.vo.PatientPathwaysAwaitingValidationWorklistVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.core.vo.beans.PatientForPathwayAwaitingValidationWorklistVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientForPathwayAwaitingValidationWorklistVoBean value)
	{
		this.patient = value;
	}
	public ims.pathways.vo.beans.PathwayForPatientPathwaysAwaitingValidationWorklistVoBean getPathway()
	{
		return this.pathway;
	}
	public void setPathway(ims.pathways.vo.beans.PathwayForPatientPathwaysAwaitingValidationWorklistVoBean value)
	{
		this.pathway = value;
	}
	public ims.framework.utils.beans.DateBean getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.startdate = value;
	}
	public ims.pathways.vo.beans.PatientJourneyStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.pathways.vo.beans.PatientJourneyStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getResponsibleConsultant()
	{
		return this.responsibleconsultant;
	}
	public void setResponsibleConsultant(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.responsibleconsultant = value;
	}
	public ims.framework.utils.beans.DateBean getNextValidationDate()
	{
		return this.nextvalidationdate;
	}
	public void setNextValidationDate(ims.framework.utils.beans.DateBean value)
	{
		this.nextvalidationdate = value;
	}
	public ims.pathways.vo.beans.PathwayClockForRTTCurrentStatusVoBean getCurrentClock()
	{
		return this.currentclock;
	}
	public void setCurrentClock(ims.pathways.vo.beans.PathwayClockForRTTCurrentStatusVoBean value)
	{
		this.currentclock = value;
	}
	public ims.framework.utils.beans.DateTimeBean getValidationCompletedDT()
	{
		return this.validationcompleteddt;
	}
	public void setValidationCompletedDT(ims.framework.utils.beans.DateTimeBean value)
	{
		this.validationcompleteddt = value;
	}
	public ims.core.vo.beans.MemberOfStaffVoBean getValidationCompletedBy()
	{
		return this.validationcompletedby;
	}
	public void setValidationCompletedBy(ims.core.vo.beans.MemberOfStaffVoBean value)
	{
		this.validationcompletedby = value;
	}
	public ims.framework.utils.beans.DateBean getLastValidationDate()
	{
		return this.lastvalidationdate;
	}
	public void setLastValidationDate(ims.framework.utils.beans.DateBean value)
	{
		this.lastvalidationdate = value;
	}
	public ims.core.vo.beans.ServiceShortVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceShortVoBean value)
	{
		this.service = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PatientForPathwayAwaitingValidationWorklistVoBean patient;
	private ims.pathways.vo.beans.PathwayForPatientPathwaysAwaitingValidationWorklistVoBean pathway;
	private ims.framework.utils.beans.DateBean startdate;
	private ims.pathways.vo.beans.PatientJourneyStatusVoBean currentstatus;
	private ims.core.vo.beans.HcpLiteVoBean responsibleconsultant;
	private ims.framework.utils.beans.DateBean nextvalidationdate;
	private ims.pathways.vo.beans.PathwayClockForRTTCurrentStatusVoBean currentclock;
	private ims.framework.utils.beans.DateTimeBean validationcompleteddt;
	private ims.core.vo.beans.MemberOfStaffVoBean validationcompletedby;
	private ims.framework.utils.beans.DateBean lastvalidationdate;
	private ims.core.vo.beans.ServiceShortVoBean service;
}