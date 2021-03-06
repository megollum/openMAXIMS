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

package ims.RefMan.vo.beans;

public class ReferralERODForBookAppointmentVoBean extends ims.vo.ValueObjectBean
{
	public ReferralERODForBookAppointmentVoBean()
	{
	}
	public ReferralERODForBookAppointmentVoBean(ims.RefMan.vo.ReferralERODForBookAppointmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.eroddate1 = vo.getERODDate1() == null ? null : (ims.framework.utils.beans.DateBean)vo.getERODDate1().getBean();
		this.eroddate2 = vo.getERODDate2() == null ? null : (ims.framework.utils.beans.DateBean)vo.getERODDate2().getBean();
		this.patavailfromdate = vo.getPatAvailFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getPatAvailFromDate().getBean();
		this.reasonableoffer = vo.getReasonableOffer();
		this.erodtype = vo.getERODType() == null ? null : (ims.vo.LookupInstanceBean)vo.getERODType().getBean();
		this.appointment = vo.getAppointment() == null ? null : (ims.scheduling.vo.beans.Booking_AppointmentVoBean)vo.getAppointment().getBean();
		this.sequence = vo.getSequence();
		this.isactive = vo.getIsActive();
		this.pathwayclock = vo.getPathWayClock() == null ? null : new ims.vo.RefVoBean(vo.getPathWayClock().getBoId(), vo.getPathWayClock().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.ReferralERODForBookAppointmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.eroddate1 = vo.getERODDate1() == null ? null : (ims.framework.utils.beans.DateBean)vo.getERODDate1().getBean();
		this.eroddate2 = vo.getERODDate2() == null ? null : (ims.framework.utils.beans.DateBean)vo.getERODDate2().getBean();
		this.patavailfromdate = vo.getPatAvailFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getPatAvailFromDate().getBean();
		this.reasonableoffer = vo.getReasonableOffer();
		this.erodtype = vo.getERODType() == null ? null : (ims.vo.LookupInstanceBean)vo.getERODType().getBean();
		this.appointment = vo.getAppointment() == null ? null : (ims.scheduling.vo.beans.Booking_AppointmentVoBean)vo.getAppointment().getBean(map);
		this.sequence = vo.getSequence();
		this.isactive = vo.getIsActive();
		this.pathwayclock = vo.getPathWayClock() == null ? null : new ims.vo.RefVoBean(vo.getPathWayClock().getBoId(), vo.getPathWayClock().getBoVersion());
	}

	public ims.RefMan.vo.ReferralERODForBookAppointmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.ReferralERODForBookAppointmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.ReferralERODForBookAppointmentVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.ReferralERODForBookAppointmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.ReferralERODForBookAppointmentVo();
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
	public ims.framework.utils.beans.DateBean getERODDate1()
	{
		return this.eroddate1;
	}
	public void setERODDate1(ims.framework.utils.beans.DateBean value)
	{
		this.eroddate1 = value;
	}
	public ims.framework.utils.beans.DateBean getERODDate2()
	{
		return this.eroddate2;
	}
	public void setERODDate2(ims.framework.utils.beans.DateBean value)
	{
		this.eroddate2 = value;
	}
	public ims.framework.utils.beans.DateBean getPatAvailFromDate()
	{
		return this.patavailfromdate;
	}
	public void setPatAvailFromDate(ims.framework.utils.beans.DateBean value)
	{
		this.patavailfromdate = value;
	}
	public Boolean getReasonableOffer()
	{
		return this.reasonableoffer;
	}
	public void setReasonableOffer(Boolean value)
	{
		this.reasonableoffer = value;
	}
	public ims.vo.LookupInstanceBean getERODType()
	{
		return this.erodtype;
	}
	public void setERODType(ims.vo.LookupInstanceBean value)
	{
		this.erodtype = value;
	}
	public ims.scheduling.vo.beans.Booking_AppointmentVoBean getAppointment()
	{
		return this.appointment;
	}
	public void setAppointment(ims.scheduling.vo.beans.Booking_AppointmentVoBean value)
	{
		this.appointment = value;
	}
	public Integer getSequence()
	{
		return this.sequence;
	}
	public void setSequence(Integer value)
	{
		this.sequence = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.vo.RefVoBean getPathWayClock()
	{
		return this.pathwayclock;
	}
	public void setPathWayClock(ims.vo.RefVoBean value)
	{
		this.pathwayclock = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean eroddate1;
	private ims.framework.utils.beans.DateBean eroddate2;
	private ims.framework.utils.beans.DateBean patavailfromdate;
	private Boolean reasonableoffer;
	private ims.vo.LookupInstanceBean erodtype;
	private ims.scheduling.vo.beans.Booking_AppointmentVoBean appointment;
	private Integer sequence;
	private Boolean isactive;
	private ims.vo.RefVoBean pathwayclock;
}
