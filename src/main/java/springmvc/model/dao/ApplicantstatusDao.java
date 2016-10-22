package springmvc.model.dao;

import springmvc.model.Applicantstatus;

public interface ApplicantstatusDao 

{
	
   Applicantstatus getApplicantstatus(Integer appstatus);

   Applicantstatus saveApplicantstatus(Applicantstatus applicantstatus);
   
	
	
}
