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

package ims.ocrr.domain;

// Generated from form domain impl
public interface SpecimenCollectionClinicComponent extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* saveOrderSpecimen
	*/
	public ims.ocrr.vo.SpecimenWorkListItemListVo saveWorkListItem(ims.ocrr.vo.SpecimenWorkListItemListVo orderSpecimenVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Returns a MosList based on the search criteria in the passed in filter
	*/
	public ims.core.vo.MemberOfStaffShortVoCollection listMembersOfStaff(ims.core.vo.MemberOfStaffShortVo filter);

	// Generated from form domain interface definition
	/**
	* listWorkListItemsOutpatient
	*/
	public ims.ocrr.vo.SpecimenWorkListItemListVoCollection listWorkListItems(ims.core.admin.vo.CareContextRefVo careContextRefVo, ims.ocrr.vo.lookups.SpecimenCollectionMethod listType, ims.ocrr.vo.lookups.SpecimenCollectionStatus specimenCollectionStatus);

	// Generated from form domain interface definition
	public ims.core.vo.Patient getPatient(ims.core.vo.PatientShort voPatShort) throws ims.domain.exceptions.StaleObjectException;
}