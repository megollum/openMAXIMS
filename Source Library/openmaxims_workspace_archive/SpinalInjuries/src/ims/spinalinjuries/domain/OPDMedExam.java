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

package ims.spinalinjuries.domain;

// Generated from form domain impl
public interface OPDMedExam extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Save the MedExamGeneralVo
	*/
	public void saveMedExamGeneralVo(ims.generalmedical.vo.MedExamGeneralVo voMedExamGeneral) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* Save the VitalsVo
	*/
	public ims.core.vo.VitalSignsVo saveVitalsVo(ims.core.vo.VitalSignsVo voVitals) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* retrieve a MedExamGeneralVo record by care context
	*/
	public ims.generalmedical.vo.MedExamGeneralVo getMedExamGeneralVoByCareContext(ims.core.vo.CareContextLiteVo voCareContext);

	// Generated from form domain interface definition
	/**
	* Retrieve a vitals sign record by care context
	*/
	public ims.core.vo.VitalSignsVo getVitalsVoByCareContext(ims.core.vo.CareContextLiteVo voCareContext);

	// Generated from form domain interface definition
	public ims.core.vo.CareContextShortVoCollection listOPDMedExamByCareContextShort(ims.core.vo.EpisodeofCareLiteVo voEpisodeOfCareLite);

	// Generated from form domain interface definition
	public ims.core.vo.VSMetricsCollection listMetricsData(ims.core.patient.vo.PatientRefVo voPatientShort);

	// Generated from form domain interface definition
	/**
	* listHcpLiteByName
	*/
	public ims.core.vo.HcpLiteVoCollection listHcpLiteByName(String hcpName);
}