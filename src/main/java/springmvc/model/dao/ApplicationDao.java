package springmvc.model.dao;

import java.util.List;

import springmvc.model.Application;

public interface ApplicationDao 

{

	Application getApp(Integer applicant_id);
	
	List<Application> getApp();
	
	Application saveApplication(Application application);
	
	
	
	
	
}
