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

package ims.icp.domain;

// Generated from form domain impl
public interface PatientICPPresentationComponent extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.icp.vo.PatientICP_PresentationVo getPatientICP(ims.icps.instantiation.vo.PatientICPRefVo patientICP);

	// Generated from form domain interface definition
	public ims.icp.vo.PatientICPAction_PresentationVo setActionStatus(ims.icps.instantiation.vo.PatientICPRefVo patientICP, ims.icps.instantiation.vo.PatientICPActionRefVo action, ims.icp.vo.lookups.ICPActionStatus status, Boolean canCounterSign, ims.core.vo.MemberOfStaffLiteVo mos) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void removeStageFromScope(ims.icp.vo.PatientICP_PresentationVo patientICP, ims.icps.instantiation.vo.PatientICPStageRefVo stage, ims.core.vo.MemberOfStaffLiteVo mos) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void removePhaseFromScope(ims.icp.vo.PatientICP_PresentationVo patientICP, ims.icps.instantiation.vo.PatientICPPhaseRefVo phase, ims.core.vo.MemberOfStaffLiteVo mos) throws ims.domain.exceptions.StaleObjectException;
}