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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5360.17707)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.base.impl.BaseServiceConfigurationImpl;
import ims.admin.vo.lookups.Diagnostic;
import ims.admin.vo.lookups.DiagnosticCollection;
import ims.RefMan.domain.objects.ReferralService;
import ims.configuration.gen.ConfigFlag;
import ims.core.clinical.domain.objects.Service;
import ims.core.clinical.vo.ServiceRefVo;
import ims.core.resource.domain.objects.ServiceActivity;
import ims.core.resource.domain.objects.ServiceDiagnostics;
import ims.core.resource.domain.objects.ServiceTriageAction;
import ims.core.vo.ActivityLiteVoCollection;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.ServiceActivityForServiceConfigurationVo;
import ims.core.vo.ServiceActivityForServiceConfigurationVoCollection;
import ims.core.vo.ServiceDiagnosticsVo;
import ims.core.vo.ServiceFunctionForServiceConfigurationVo;
import ims.core.vo.ServiceFunctionForServiceConfigurationVoCollection;
import ims.core.vo.ServiceLiteVo;
import ims.core.vo.ServiceLiteVoCollection;
import ims.core.vo.ServiceTriageActionVo;
import ims.core.vo.ServiceVo;
import ims.core.vo.domain.ActivityLiteVoAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.ServiceActivityForServiceConfigurationVoAssembler;
import ims.core.vo.domain.ServiceDiagnosticsVoAssembler;
import ims.core.vo.domain.ServiceFunctionForServiceConfigurationVoAssembler;
import ims.core.vo.domain.ServiceLiteVoAssembler;
import ims.core.vo.domain.ServiceTriageActionVoAssembler;
import ims.core.vo.domain.ServiceVoAssembler;
import ims.core.vo.lookups.ActivityType;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.ServiceFunction;
import ims.core.vo.lookups.ServiceFunctionCollection;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.domain.lookups.Lookup;
import ims.domain.lookups.LookupInstance;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServiceConfigurationImpl extends BaseServiceConfigurationImpl
{
	private static final long serialVersionUID = 1L;

	public ims.core.vo.ServiceLiteVoCollection listServices(String name, ims.core.vo.lookups.ServiceCategory category, ims.core.vo.lookups.Specialty specialty, Boolean activeOnly)
	{
		DomainFactory factory = getDomainFactory();
		
		StringBuilder hqlJoins = new StringBuilder("select s from Service s ");
		StringBuffer hql = new StringBuffer(" ");
		
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if (name != null)
		{
			hql.append(andStr + " s.upperName like :ServiceName ");
			markers.add("ServiceName");
			values.add(name.toUpperCase() + "%");
			andStr = " and ";
		}
		if (Boolean.TRUE.equals(activeOnly))
		{
			hql.append(andStr + " s.isActive = :IsActive");
			markers.add("IsActive");
			values.add(Boolean.TRUE.equals(activeOnly));
			andStr = " and ";
		}
		
		if (category != null)
		{
			hqlJoins.append(" left join s.serviceCategory as cat ");
			hql.append(andStr + " cat.id = :CatId");
			markers.add("CatId");
			values.add(category.getID());
			andStr = " and ";
		}
		
		if (specialty != null)
		{
			hqlJoins.append(" left join s.specialty as spec ");
			hql.append(andStr + " spec.id = :SpecId");
			markers.add("SpecId");
			values.add(specialty.getID());
			andStr = " and ";
		}

		if (markers.size() > 0)
			hql.insert(0, " where ");
		
		hql.append( " order by s.upperName asc" );
		
		int configAmount = ConfigFlag.DOM.CLINICAL_ADMIN_SEARCH_MAX_SIZE.getValue();
		List services = factory.find(hqlJoins.append(hql.toString()).toString(), markers, values, configAmount);
		ServiceLiteVoCollection servicesVo = ServiceLiteVoAssembler.createServiceLiteVoCollectionFromService(services);
		
		ReferralService referralService = null;
		StringBuffer hqlSec = new StringBuffer("select rs from ReferralService as rs");
		List list = factory.find(hqlSec.toString());
		
		if (list.size() > 0 && list != null)
		{
			referralService = (ReferralService) list.get(0);
		}

		if(referralService != null && referralService.getReferralServices() != null)
		{
			for(ServiceLiteVo s : servicesVo)
			{
				if(s == null)
					continue;
				
				if(isReferraService(s.getID_Service(), referralService))
					s.setCanReferIntoTheService(true);
			}
		}
		
		return servicesVo;
	}

	private boolean isReferraService(Integer serviceId, ReferralService referralService)
	{
		if(serviceId == null || referralService == null || referralService.getReferralServices() == null)
			return false;
		
		Iterator it = referralService.getReferralServices().iterator();
		
		while(it.hasNext())
		{
			Object service = it.next();
			
			if(service instanceof Service)
			{
				if(((Service) service).getId() == serviceId)
					return true;
			}
		}
		
		return false;
	}

	public ServiceVo getService(ServiceRefVo service)
	{
		if(service == null || service.getID_Service() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		ServiceVo serviceVo = ServiceVoAssembler.create((Service) factory.getDomainObject(Service.class, service.getID_Service()));
		
		String hql = "select count(s.id) from ReferralService as rs left join rs.referralServices as s where s.id = :ServiceId";
		Object[] count = factory.find(hql, new String[] {"ServiceId"}, new Object[] {serviceVo.getID_Service()}).toArray();
		
		if(count != null && count.length > 0 && ((Long) count[0]).intValue() > 0)
			serviceVo.setCanReferIntoTheService(true);
		else
			serviceVo.setCanReferIntoTheService(false);
		
		return serviceVo;
	}

	public ServiceFunctionCollection listServiceFunctionsLookups(String searchText)
	{
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		
		DomainFactory factory = getDomainFactory();
		String hql = "select li from LookupInstance as li left join li.type as lt where lt.id = :LookupId ";
		markers.add("LookupId");
		values.add(ServiceFunction.TYPE_ID);
		
		if(searchText != null)
		{
			hql += " and UPPER(li.text) like :LookupText";
			markers.add("LookupText");
			values.add(searchText.toUpperCase() + "%");
		}
		
		hql += " order by UPPER(li.text) asc";
		
		List serviceFunctions = factory.find(hql, markers, values);
		
		if(serviceFunctions == null)
			return null;
		
		ServiceFunctionCollection coll = new ServiceFunctionCollection();
		
		for(int i=0; i<serviceFunctions.size(); i++)
		{
			if(serviceFunctions.get(i) instanceof LookupInstance)
			{
				LookupInstance instance = (LookupInstance) serviceFunctions.get(i);
				coll.add(createServiceFunctionLookupInstance(instance));
			}
		}
		
		return coll.size() > 0 ? coll : null;
	}
	
	private ServiceFunction createServiceFunctionLookupInstance(LookupInstance instance)
	{
		if(instance == null)
			return null;
	
		ims.framework.utils.ImagePath img = null;
		ims.framework.utils.Color color = null;		
		img = null;
		
		if (instance.getImage() != null) 
		{
			img = new ims.framework.utils.ImagePath(instance.getImage().getImageId(), instance.getImage().getImagePath());
		}
		
		color = instance.getColor();
		if (color != null) 
			color.getValue();

		ims.core.vo.lookups.ServiceFunction serviceFunction = new ims.core.vo.lookups.ServiceFunction(instance.getId(),instance.getText(), instance.isActive(), null, img, color);
		ims.core.vo.lookups.ServiceFunction parentServiceFunction = serviceFunction;
		ims.domain.lookups.LookupInstance parentServiceFunctionDo = instance.getParent();
		
		while (parentServiceFunctionDo != null)
		{
			if (parentServiceFunctionDo.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(parentServiceFunctionDo.getImage().getImageId(), parentServiceFunctionDo.getImage().getImagePath() );
			}
			else 
			{
				img = null;
			}
			
			color = parentServiceFunctionDo.getColor();
			
			if (color != null)
			{
				color.getValue();
			}
			
			parentServiceFunction.setParent(new ims.core.vo.lookups.ServiceFunction(parentServiceFunctionDo.getId(),parentServiceFunctionDo.getText(), parentServiceFunctionDo.isActive(), null, img, color));
			parentServiceFunction = parentServiceFunction.getParent();
			parentServiceFunctionDo = parentServiceFunctionDo.getParent();
		}
		
		return serviceFunction;
	}

	public ServiceFunctionForServiceConfigurationVoCollection listServiceFunctionByService(ServiceRefVo service, Boolean activeOnly)
	{
		if(service == null || service.getID_Service() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		String hql = "select servfunc from ServiceFunction servfunc where servfunc.service.id = :serviceid ";
		
		if(Boolean.TRUE.equals(activeOnly))
		{
			hql += " and servfunc.isActive = 1 ";
		}
		
		hql += " order by UPPER(servfunc.function.text) asc";
		List servFuncList = factory.find(hql, new String[]{"serviceid"}, new Object[]{service.getID_Service()});
		return ServiceFunctionForServiceConfigurationVoAssembler.createServiceFunctionForServiceConfigurationVoCollectionFromServiceFunction(servFuncList);
	}

	public ServiceActivityForServiceConfigurationVoCollection listServiceActivitiesByService(ServiceRefVo service)
	{
		if(service == null || service.getID_Service() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		List servActList = factory.find("select servAct from ServiceActivity servAct where servAct.service.id = :serviceid order by UPPER(servAct.activity.name) asc", new String[]{"serviceid"}, new Object[]{service.getID_Service()});
		return ServiceActivityForServiceConfigurationVoAssembler.createServiceActivityForServiceConfigurationVoCollectionFromServiceActivity(servActList);
	}

	public ActivityLiteVoCollection listActivities(String searchText)
	{
		DomainFactory factory = getDomainFactory();
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		
		String hql = "select act from Activity as act left join act.activityType as actType where actType.id = :AppointmentType and act.isActive = 1 ";
		markers.add("AppointmentType");
		values.add(ActivityType.APPOINTMENTTYPES.getID());
		
		if(searchText != null)
		{
			hql += " and UPPER(act.name) like :ActivityName ";
			markers.add("ActivityName");
			values.add(searchText.toUpperCase() + "%");
		}
		
		hql += " order by UPPER(act.name) asc";
		
		List<?> list = factory.find(hql, markers, values);
		
		return ActivityLiteVoAssembler.createActivityLiteVoCollectionFromActivity(list);
	}

	public void saveActivitiesAndFunctions(ServiceFunctionForServiceConfigurationVoCollection functions, ServiceActivityForServiceConfigurationVoCollection activities, ServiceFunctionForServiceConfigurationVoCollection serviceFunctionsForDelete, ServiceActivityForServiceConfigurationVoCollection serviceActivitiesForDelete) throws StaleObjectException, ForeignKeyViolationException, UniqueKeyViolationException
	{
		DomainFactory factory = getDomainFactory();
		
		if(functions != null)
		{
			for(ServiceFunctionForServiceConfigurationVo fuction : functions)
			{
				if(fuction == null)
					continue;
				
				if(!fuction.isValidated())
					throw new CodingRuntimeException("ServiceFunctionForServiceConfigurationVo is not validated.");
				
				ims.core.clinical.domain.objects.ServiceFunction doFunction = ServiceFunctionForServiceConfigurationVoAssembler.extractServiceFunction(factory, fuction);
				
				if(fuction.getID_ServiceFunction() == null)
				{
					if(wasFunctionAlreadySaved(fuction))
						throw new StaleObjectException(doFunction);
				}
				
				try
				{
					factory.save(doFunction);
				}
				catch (UnqViolationUncheckedException e)
				{
					throw new UniqueKeyViolationException("A Service Function with the same code mapping exists.");
				}
			}
		}
		
		if(activities != null)
		{
			for(ServiceActivityForServiceConfigurationVo activity : activities)
			{
				if(activity == null)
					continue;
				
				if(!activity.isValidated())
					throw new CodingRuntimeException("ServiceActivityForServiceConfigurationVo is not validated.");
				
				ServiceActivity doActivity = ServiceActivityForServiceConfigurationVoAssembler.extractServiceActivity(factory, activity);
				
				if(activity.getID_ServiceActivity() == null)
				{
					if(wasActivityAlreadySaved(activity))
						throw new StaleObjectException(doActivity);
				}
				
				factory.save(doActivity);
			}
		}
		
		if (serviceFunctionsForDelete != null)
		{

			for (int i = 0; i < serviceFunctionsForDelete.size(); i++)
			{
				ims.core.clinical.domain.objects.ServiceFunction doServiceFunction = ServiceFunctionForServiceConfigurationVoAssembler.extractServiceFunction(factory, serviceFunctionsForDelete.get(i));
				try
				{
					factory.delete(doServiceFunction);
				}
				catch (DomainRuntimeException e)
				{
					throw new ForeignKeyViolationException(serviceFunctionsForDelete.get(i).getFunction().getText());
				}
			}

		}
		
		if (serviceActivitiesForDelete != null)
		{

			for (int i = 0; i < serviceActivitiesForDelete.size(); i++)
			{
				ServiceActivity doServiceActivity = ServiceActivityForServiceConfigurationVoAssembler.extractServiceActivity(factory, serviceActivitiesForDelete.get(i));
				try
				{
					factory.delete(doServiceActivity);
				}
				catch (DomainRuntimeException e)
				{
					throw new ForeignKeyViolationException(serviceActivitiesForDelete.get(i).getActivity().getName());
				}
			}

		}
	}

	private boolean wasActivityAlreadySaved(ServiceActivityForServiceConfigurationVo activity)
	{
		if(activity == null || activity.getService() == null || activity.getActivity() == null)
			return false;
		
		DomainFactory factory = getDomainFactory();
		String hql = "select servAct from ServiceActivity servAct left join servAct.service as s left join servAct.activity as a where s.id = :Service and a.id = :Activity";
		
		List servActList = factory.find(hql, new String[]{"Service", "Activity"}, new Object[]{activity.getService().getID_Service(), activity.getActivity().getID_Activity()});
		
		if(servActList != null && servActList.size() > 0)
			return true;
		
		return false;
	}

	private boolean wasFunctionAlreadySaved(ServiceFunctionForServiceConfigurationVo serviceFunction)
	{
		if(serviceFunction == null || serviceFunction.getService() == null || serviceFunction.getFunction() == null)
			return false;
		
		DomainFactory factory = getDomainFactory();
		String hql = "select servfunc from ServiceFunction servfunc left join servfunc.service as s left join servfunc.function as f where s.id = :Service and f.id = :Function";
		
		List servFuncList = factory.find(hql, new String[]{"Service", "Function"}, new Object[]{serviceFunction.getService().getID_Service(), serviceFunction.getFunction().getID()});
		
		if(servFuncList != null && servFuncList.size() > 0)
			return true;
		
		return false;
	}

	public HcpLiteVoCollection listHCP(String surname, String forename, HcpDisType hcpType, Boolean isActive)
	{
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		DomainFactory factory = getDomainFactory();
		
		StringBuilder hqlJoins = new StringBuilder("select h from Hcp as h left join h.mos as m left join h.hcpType as hcpType ");
		StringBuffer hql = new StringBuffer(" ");
		String andStr = " ";
		
		if(surname != null)
		{
			hql.append(andStr + " m.name.upperSurname like :Surname ");
			markers.add("Surname");
			values.add(surname.toUpperCase() + "%");
			andStr = " and ";
		}
		if(forename != null)
		{
			hql.append(andStr + " m.name.upperForename like :Forename ");
			markers.add("Forename");
			values.add(forename.toUpperCase() + "%");
			andStr = " and ";
		}
		if(hcpType != null)
		{
			hql.append(andStr + " hcpType.id = :HcpType ");
			markers.add("HcpType");
			values.add(hcpType.getID());
			andStr = " and ";
		}
		if (Boolean.TRUE.equals(isActive)) //WDEV-21035
		{
			hql.append(andStr + " h.isActive = :Active ");
			markers.add("Active");
			values.add(isActive);
			andStr = " and ";
		}
		if (markers.size() > 0)
			hql.insert(0, " where ");
		
		hql.append("  order by m.name.upperForename asc, m.name.upperSurname asc"); 
		List<?> listHcp = factory.find(hqlJoins.append(hql.toString()).toString(), markers, values);
		
		return HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(listHcp);
	}

	public ServiceVo saveService(ServiceVo service) throws StaleObjectException, UniqueKeyViolationException
	{
		if(service == null)
			throw new CodingRuntimeException("Cannot save a null ServiceVo.");
		
		if(!service.isValidated())
			throw new CodingRuntimeException("ServiceVo is not validated.");
		
		DomainFactory factory = getDomainFactory();
		Service doService = ServiceVoAssembler.extractService(factory, service);
		doService.setUpperName(doService.getServiceName().substring(0, Math.min(20, doService.getServiceName().length())).toUpperCase());
		
		try
		{
			factory.save(doService);
		}
		catch (UnqViolationUncheckedException e)
		{
			ServiceLiteVoCollection voCollSer = listServices(service.getServiceName(), null, null, null);
			if (voCollSer != null && voCollSer.size() > 0 && !voCollSer.get(0).getID_Service().equals(service.getID_Service()))
				throw new UniqueKeyViolationException("Record called \"" + service.getServiceName() + "\" already exists. Duplicates not allowed.", e);

//			String dupMessage = Keywords.checkDuplicateTaxonomy(factory, doService, "taxonomyMap", service.getTaxonomyMap(), "getServiceName");
//			if (dupMessage != null)
//				throw new UniqueKeyViolationException(dupMessage);
		}
		
		
		ReferralService referralService = null;
		StringBuffer hql = new StringBuffer("select rs from ReferralService as rs");
		List list = factory.find(hql.toString());
		
		if (list.size() > 0 && list != null)
		{
			referralService = (ReferralService) list.get(0);
		}
		
		boolean saveReferralService = false;
		
		if(Boolean.TRUE.equals(service.getCanReferIntoTheService()))
		{
			if(referralService == null)
				referralService = new ReferralService();
			
			if(referralService.getReferralServices() == null)
				referralService.setReferralServices(new java.util.HashSet());
			
			if(!referralService.getReferralServices().contains(doService))
			{
				referralService.getReferralServices().add(doService);
				saveReferralService = true;
			}
		}
		else
		{
			if(referralService != null && referralService.getReferralServices() != null)
			{
				if(referralService.getReferralServices().contains(doService))
				{
					referralService.getReferralServices().remove(doService);
					saveReferralService = true;
				}
			}
		}
		
		if(referralService != null && saveReferralService)
		{
			factory.save(referralService);
		}
		
		return ServiceVoAssembler.create(doService);
	}

	public ServiceTriageActionVo getServiceTriageAction(ServiceRefVo service)
	{
		if(service == null || service.getID_Service() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		String hql = "select sta from ServiceTriageAction as sta left join sta.service as s where s.id = :ServiceId";
		
		List serviceList = factory.find(hql, new String[] {"ServiceId"}, new Object[] {service.getID_Service()});
		if(serviceList == null || serviceList.size() == 0)
			return null;
		
		if(serviceList.get(0) instanceof ServiceTriageAction)
		{
			return ServiceTriageActionVoAssembler.create((ServiceTriageAction) serviceList.get(0));
		}
		
		return null;
	}

	public ServiceTriageActionVo saveServiceTriageAction(ServiceTriageActionVo traigeAction) throws StaleObjectException, UniqueKeyViolationException
	{
		if(traigeAction == null)
			throw new CodingRuntimeException("Canot save a null ServiceTriageActionVo.");
		
		if(!traigeAction.isValidated())
			throw new CodingRuntimeException("ServiceTriageActionVo is not validated.");
		
		DomainFactory factory = getDomainFactory();
		ServiceTriageAction doServiceTriageAction = ServiceTriageActionVoAssembler.extractServiceTriageAction(factory, traigeAction);
		
		try
		{
			factory.save(doServiceTriageAction);
		}
		catch (UnqViolationUncheckedException e)
		{
			throw new UniqueKeyViolationException("A Service Triage Action record is already saved for this Service.");
		}
		
		return ServiceTriageActionVoAssembler.create(doServiceTriageAction);
	}

	public ServiceDiagnosticsVo getServiceDiagnostics(ServiceRefVo service)
	{
		if(service == null || service.getID_Service() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		String hql = "select sd from ServiceDiagnostics as sd left join sd.service as s where s.id = :ServiceId";
		
		List serviceList = factory.find(hql, new String[] {"ServiceId"}, new Object[] {service.getID_Service()});
		if(serviceList == null || serviceList.size() == 0)
			return null;
		
		if(serviceList.get(0) instanceof ServiceDiagnostics)
		{
			return ServiceDiagnosticsVoAssembler.create((ServiceDiagnostics) serviceList.get(0));
		}
		
		return null;
	}

	public ServiceDiagnosticsVo saveServiceDiagnostics(ServiceDiagnosticsVo serviceDiagnostics) throws StaleObjectException, UniqueKeyViolationException
	{
		if(serviceDiagnostics == null)
			throw new CodingRuntimeException("Canot save a null ServiceTriageActionVo.");
		
		if(!serviceDiagnostics.isValidated())
			throw new CodingRuntimeException("ServiceTriageActionVo is not validated.");
		
		DomainFactory factory = getDomainFactory();
		ServiceDiagnostics doServiceTriageAction = ServiceDiagnosticsVoAssembler.extractServiceDiagnostics(factory, serviceDiagnostics);
		
		try
		{
			factory.save(doServiceTriageAction);
		}
		catch (UnqViolationUncheckedException e)
		{
			throw new UniqueKeyViolationException("A Service Diagnostics record is already saved for this Service.");
		}
		
		return ServiceDiagnosticsVoAssembler.create(doServiceTriageAction);
	}

	public DiagnosticCollection listDiagnostics()
	{
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		
		DomainFactory factory = getDomainFactory();
		
		String hql = "select li from LookupInstance as li left join li.type as lt where lt.id = :LookupId ";		

		markers.add("LookupId");		
		values.add(Diagnostic.TYPE_ID);		
		
		hql += " order by UPPER(li.text) asc";
		
		List diagnostics = factory.find(hql, markers, values);
		
		if(diagnostics == null)
			return null;
		
		DiagnosticCollection coll = new DiagnosticCollection();
		
		for(int i=0; i<diagnostics.size(); i++)
		{
			if(diagnostics.get(i) instanceof LookupInstance)
			{
				LookupInstance instance = (LookupInstance) diagnostics.get(i);
				coll.add(createDiagnosticLookupInstance(instance));
			}
		}
		
		return coll.size() > 0 ? coll : null;
	}

	private Diagnostic createDiagnosticLookupInstance(LookupInstance instance)
	{
		if(instance == null)
			return null;
	
		ims.framework.utils.ImagePath img = null;
		ims.framework.utils.Color color = null;		
		img = null;
		
		if (instance.getImage() != null) 
		{
			img = new ims.framework.utils.ImagePath(instance.getImage().getImageId(), instance.getImage().getImagePath());
		}
		
		color = instance.getColor();
		if (color != null) 
			color.getValue();

		Diagnostic diagnosticInstance = new Diagnostic(instance.getId(),instance.getText(), instance.isActive(), null, img, color);
		Diagnostic parentDiagnostic = diagnosticInstance;
		ims.domain.lookups.LookupInstance parentDiagnosticDo = instance.getParent();
		
		while (parentDiagnosticDo != null)
		{
			if (parentDiagnosticDo.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(parentDiagnosticDo.getImage().getImageId(), parentDiagnosticDo.getImage().getImagePath() );
			}
			else 
			{
				img = null;
			}
			
			color = parentDiagnosticDo.getColor();
			
			if (color != null)
			{
				color.getValue();
			}
			
			parentDiagnostic.setParent(new Diagnostic(parentDiagnosticDo.getId(),parentDiagnosticDo.getText(), parentDiagnosticDo.isActive(), null, img, color));
			parentDiagnostic = parentDiagnostic.getParent();
			parentDiagnosticDo = parentDiagnosticDo.getParent();
		}
		
		return diagnosticInstance;
	}

	public ServiceFunction saveServiceFunctionInstance(String serviceFunctionText) throws StaleObjectException
	{
		DomainFactory factory = getDomainFactory();
		
		java.util.List lst = factory.find("from LookupInstance l where l.id = (select max(l1.id) from LookupInstance l1)");
		int nextVal = ((LookupInstance) lst.get(0)).getId();
		if (nextVal < 0)
			nextVal = 0;
		
		Lookup type = factory.getLookup(ServiceFunction.TYPE_ID);
		LookupInstance doServiceFunction = new LookupInstance(nextVal + 1, type, true, serviceFunctionText);
		doServiceFunction.setText(serviceFunctionText);
		
		factory.save(doServiceFunction);
		
		return createServiceFunctionLookupInstance(doServiceFunction);
	}

	public ServiceFunction getServiceFunctionInstance(String serviceFunctionText)
	{
		if(serviceFunctionText == null || serviceFunctionText.length() == 0)
			return null;
		
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		
		DomainFactory factory = getDomainFactory();
		String hql = "select li from LookupInstance as li left join li.type as lt where lt.id = :LookupId and UPPER(li.text) = :ServiceFunctionText ";
		markers.add("LookupId");
		values.add(ServiceFunction.TYPE_ID);
		
		markers.add("ServiceFunctionText");
		values.add(serviceFunctionText.toUpperCase());
		
		List serviceFunstions = factory.find(hql, markers, values);
		
		if(serviceFunstions == null || serviceFunstions.size() == 0)
			return null;
		
		if(serviceFunstions.get(0) instanceof LookupInstance)
			return createServiceFunctionLookupInstance((LookupInstance) serviceFunstions.get(0));
				
		return null;
	}
	
	//WDEV-22945
	public Boolean isServiceLinkedToReferralContract(ServiceRefVo serviceRef)
	{
		if (serviceRef == null || serviceRef.getID_Service() == null)
			return false;
		
		String hqlCount = "select count(serv.id) from ContractConfig as contract left join contract.serviceLocations as cService left join cService.service as serv left join contract.status as stat where stat.id = :Active and serv.isActive = :ActiveService and serv.id = :ServiceId";
		
		long count = getDomainFactory().countWithHQL(hqlCount, new String[]{"Active","ActiveService", "ServiceId"}, new Object[]{PreActiveActiveInactiveStatus.ACTIVE.getID(), Boolean.TRUE, serviceRef.getID_Service()});  
		
		return count > 0;
	}
}