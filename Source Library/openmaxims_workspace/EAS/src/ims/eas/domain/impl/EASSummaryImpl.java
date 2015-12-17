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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4847.21738)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.eas.domain.impl;

import ims.core.resource.people.vo.HcpRefVo;
import ims.core.vo.lookups.MedicGrade;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.eas.domain.base.impl.BaseEASSummaryImpl;
import ims.eas.domain.objects.ElectronicActionSheet;
import ims.eas.vo.ElectronicActionSheetRefVo;
import ims.eas.vo.ElectronicActionSheetVo;
import ims.eas.vo.domain.ElectronicActionSheetVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class EASSummaryImpl extends BaseEASSummaryImpl
{
	private static final long serialVersionUID = 1L;

	public String[] getSystemReportAndTemplate(Integer imsId)
	{
		String[] result = null;		
		DomainFactory factory = getDomainFactory();
		
		List<?> lst = factory.find("select r.reportXml, t.templateXml from ReportBo as r left join r.templates as t where (r.imsId= :imsid) order by t.name", new String[] {"imsid"}, new Object[] {imsId});
		
		if(lst.iterator().hasNext())
		{
			Object[] obj = (Object[])lst.iterator().next();
			result = new String[] {(String)obj[0], (String)obj[1]};
		}
		
		return result;
	}

	public ElectronicActionSheetVo save(ElectronicActionSheetVo eas) throws StaleObjectException 
	{
		if(eas == null)
			throw new CodingRuntimeException("Cannot save a null ElectronicActionSheetVo.");
		
		if(!eas.isValidated())
			throw new CodingRuntimeException("ElectronicActionSheetVo is not validated.");
		
		DomainFactory factory = getDomainFactory();
		
		ElectronicActionSheet doEAS = ElectronicActionSheetVoAssembler.extractElectronicActionSheet(factory, eas);
		
		factory.save(doEAS);
		
		return ElectronicActionSheetVoAssembler.create(doEAS);
	}

	public ElectronicActionSheetVo get(ElectronicActionSheetRefVo easRef) 
	{
		if(easRef == null || easRef.getID_ElectronicActionSheet() == null)
			throw new CodingRuntimeException("Cannot get ElectronicActionSheetVo by a null Id.");
		
		return ElectronicActionSheetVoAssembler.create((ElectronicActionSheet) getDomainFactory().getDomainObject(ElectronicActionSheet.class, easRef.getID_ElectronicActionSheet()));
	}

	public Boolean isConsultant(HcpRefVo hcp) 
	{
		if(hcp == null || hcp.getID_Hcp() == null)
			return false;
		
		String query = "select m from Medic as m left join m.grade as g where m.id = :MedicId and g.id = :Grade";
		DomainFactory factory = getDomainFactory();
		
		List<?> list = factory.find(query, new String[] {"MedicId", "Grade"}, new Object[] {hcp.getID_Hcp(), MedicGrade.CONS.getID()});
		
		if(list != null && list.size() > 0)
			return true;
		
		return false;
	}
}