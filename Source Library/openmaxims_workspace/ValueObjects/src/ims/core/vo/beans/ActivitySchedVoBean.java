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

package ims.core.vo.beans;

public class ActivitySchedVoBean extends ims.vo.ValueObjectBean
{
	public ActivitySchedVoBean()
	{
	}
	public ActivitySchedVoBean(ims.core.vo.ActivitySchedVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.tmreq = vo.getTmReq();
		this.isactive = vo.getIsActive();
		this.activitytype = vo.getActivityType() == null ? null : (ims.vo.LookupInstanceBean)vo.getActivityType().getBean();
		this.isworkqueue = vo.getIsWorkQueue();
		this.description = vo.getDescription();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.codemappings = vo.getCodeMappings() == null ? null : vo.getCodeMappings().getBeanCollection();
		this.firstappointment = vo.getFirstAppointment();
		this.diagnostic = vo.getDiagnostic();
		this.intreq = vo.getIntReq();
		this.ispatreq = vo.getIsPatReq();
		this.isscheduled = vo.getIsScheduled();
		this.reason = vo.getReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getReason().getBean();
		this.activityimage = vo.getActivityImage() == null ? null : (ims.admin.vo.beans.AppImageVoBean)vo.getActivityImage().getBean();
		this.specialrequirements = vo.getSpecialRequirements() == null ? null : vo.getSpecialRequirements().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ActivitySchedVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.tmreq = vo.getTmReq();
		this.isactive = vo.getIsActive();
		this.activitytype = vo.getActivityType() == null ? null : (ims.vo.LookupInstanceBean)vo.getActivityType().getBean();
		this.isworkqueue = vo.getIsWorkQueue();
		this.description = vo.getDescription();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.codemappings = vo.getCodeMappings() == null ? null : vo.getCodeMappings().getBeanCollection();
		this.firstappointment = vo.getFirstAppointment();
		this.diagnostic = vo.getDiagnostic();
		this.intreq = vo.getIntReq();
		this.ispatreq = vo.getIsPatReq();
		this.isscheduled = vo.getIsScheduled();
		this.reason = vo.getReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getReason().getBean();
		this.activityimage = vo.getActivityImage() == null ? null : (ims.admin.vo.beans.AppImageVoBean)vo.getActivityImage().getBean(map);
		this.specialrequirements = vo.getSpecialRequirements() == null ? null : vo.getSpecialRequirements().getBeanCollection();
	}

	public ims.core.vo.ActivitySchedVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ActivitySchedVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ActivitySchedVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ActivitySchedVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ActivitySchedVo();
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
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public Integer getTmReq()
	{
		return this.tmreq;
	}
	public void setTmReq(Integer value)
	{
		this.tmreq = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.vo.LookupInstanceBean getActivityType()
	{
		return this.activitytype;
	}
	public void setActivityType(ims.vo.LookupInstanceBean value)
	{
		this.activitytype = value;
	}
	public Boolean getIsWorkQueue()
	{
		return this.isworkqueue;
	}
	public void setIsWorkQueue(Boolean value)
	{
		this.isworkqueue = value;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String value)
	{
		this.description = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.core.vo.beans.TaxonomyMapBean[] getCodeMappings()
	{
		return this.codemappings;
	}
	public void setCodeMappings(ims.core.vo.beans.TaxonomyMapBean[] value)
	{
		this.codemappings = value;
	}
	public Boolean getFirstAppointment()
	{
		return this.firstappointment;
	}
	public void setFirstAppointment(Boolean value)
	{
		this.firstappointment = value;
	}
	public Boolean getDiagnostic()
	{
		return this.diagnostic;
	}
	public void setDiagnostic(Boolean value)
	{
		this.diagnostic = value;
	}
	public Integer getIntReq()
	{
		return this.intreq;
	}
	public void setIntReq(Integer value)
	{
		this.intreq = value;
	}
	public Boolean getIsPatReq()
	{
		return this.ispatreq;
	}
	public void setIsPatReq(Boolean value)
	{
		this.ispatreq = value;
	}
	public Boolean getIsScheduled()
	{
		return this.isscheduled;
	}
	public void setIsScheduled(Boolean value)
	{
		this.isscheduled = value;
	}
	public ims.vo.LookupInstanceBean getReason()
	{
		return this.reason;
	}
	public void setReason(ims.vo.LookupInstanceBean value)
	{
		this.reason = value;
	}
	public ims.admin.vo.beans.AppImageVoBean getActivityImage()
	{
		return this.activityimage;
	}
	public void setActivityImage(ims.admin.vo.beans.AppImageVoBean value)
	{
		this.activityimage = value;
	}
	public java.util.Collection getSpecialRequirements()
	{
		return this.specialrequirements;
	}
	public void setSpecialRequirements(java.util.Collection value)
	{
		this.specialrequirements = value;
	}
	public void addSpecialRequirements(java.util.Collection value)
	{
		if(this.specialrequirements == null)
			this.specialrequirements = new java.util.ArrayList();
		this.specialrequirements.add(value);
	}

	private Integer id;
	private int version;
	private String name;
	private Integer tmreq;
	private Boolean isactive;
	private ims.vo.LookupInstanceBean activitytype;
	private Boolean isworkqueue;
	private String description;
	private ims.vo.LookupInstanceBean status;
	private ims.core.vo.beans.TaxonomyMapBean[] codemappings;
	private Boolean firstappointment;
	private Boolean diagnostic;
	private Integer intreq;
	private Boolean ispatreq;
	private Boolean isscheduled;
	private ims.vo.LookupInstanceBean reason;
	private ims.admin.vo.beans.AppImageVoBean activityimage;
	private java.util.Collection specialrequirements;
}