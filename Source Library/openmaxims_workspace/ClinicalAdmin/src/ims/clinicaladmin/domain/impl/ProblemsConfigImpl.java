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
// This code was generated by Dara Hickey using IMS Development Environment (version 1.44 build 2245.22719)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.clinicaladmin.domain.impl;
import java.util.ArrayList;
import java.util.List;
import ims.clinical.configuration.domain.objects.ClinicalProblem;
import ims.clinical.configuration.vo.ClinicalProblemRefVo;
import ims.clinical.vo.ClinicalProblemShortVoCollection;
import ims.clinical.vo.ProblemConfigVo;
import ims.clinical.vo.domain.ClinicalProblemShortVoAssembler;
import ims.clinical.vo.domain.ProblemConfigVoAssembler;
import ims.clinicaladmin.domain.base.impl.BaseProblemsConfigImpl;
import ims.admin.helper.Keywords;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;

public class ProblemsConfigImpl extends BaseProblemsConfigImpl
{
	private static final long serialVersionUID = 1L;

	public ims.clinical.vo.ProblemConfigVo getProblemConfigVo(ClinicalProblemRefVo voProblemConfig)
	{
		DomainFactory factory = getDomainFactory();
		ClinicalProblem problem = (ClinicalProblem) factory.getDomainObject(ClinicalProblem.class, voProblemConfig.getID_ClinicalProblem());
		return (ProblemConfigVoAssembler.create(problem));
	}

	public ProblemConfigVo saveProblemConfig(ProblemConfigVo voProblemConfig) throws StaleObjectException, UniqueKeyViolationException
	{
		if (!voProblemConfig.isValidated())
		{
			throw new DomainRuntimeException("This ProblemConfigVo has not be validated.");
		}
		
		DomainFactory factory = getDomainFactory();			
		ClinicalProblem domProblem = ProblemConfigVoAssembler.extractClinicalProblem(factory, voProblemConfig);
		
		domProblem.setKeywords(Keywords.setupKeyWords(domProblem.getKeywords(), domProblem.getPCName()));
		try
		{
			factory.save(domProblem);
		}
		catch(UnqViolationUncheckedException e)
		{
			//check which constraint was violated (name/taxononmy map)

			//name
			ClinicalProblem prob = ClinicalProblem.getClinicalProblemFromPCName(factory, voProblemConfig.getPCName());
			if (prob != null && prob.getId() != null && !(prob.getId().equals(voProblemConfig.getID_ClinicalProblem())))
			{
				throw new UniqueKeyViolationException("Problem record called \"" + voProblemConfig.getPCName() + "\" already exists. Duplicates not allowed.", e);					
			}
			
			//taxonomy map
			String dupMessage = Keywords.checkDuplicateTaxonomy(factory, domProblem, voProblemConfig.getTaxonomyMap(), "getPCName");
			if(dupMessage != null)
				throw new UniqueKeyViolationException(dupMessage);
			
			throw (e);
		}
		return ProblemConfigVoAssembler.create(domProblem);
	}

	private List listDomConfiguredProblems(String filter, boolean activeOnly) throws DomainInterfaceException
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" from ClinicalProblem p join p.keywords as kw "); 
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		if (activeOnly)
		{
			hql.append(" where p.isActive = :isActive");
			names.add("isActive");
			values.add(Boolean.TRUE);	
		}
		return Keywords.searchByKeywords(factory, filter, hql.toString(), names, values);				
	}	

	private ClinicalProblemShortVoCollection listConfiguredProblems(String filter, boolean activeOnly) throws DomainInterfaceException
	{
		return ClinicalProblemShortVoAssembler.createClinicalProblemShortVoCollectionFromClinicalProblem(listDomConfiguredProblems(filter, activeOnly)).sort();
	}
	
	public ClinicalProblemShortVoCollection listAllProblems(String pcName) throws DomainInterfaceException
	{
		return listConfiguredProblems(pcName, false);
	}

	public ClinicalProblemShortVoCollection listActiveProblems(String pcName) throws DomainInterfaceException
	{
		return listConfiguredProblems(pcName, true);
	}
}