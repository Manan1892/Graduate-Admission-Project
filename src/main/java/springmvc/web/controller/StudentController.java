package springmvc.web.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import springmvc.model.Acadamicrecord;
import springmvc.model.Additionalfield;
import springmvc.model.Applicantstatus;
import springmvc.model.Application;
import springmvc.model.Degree;
import springmvc.model.Department;
import springmvc.model.Programs;
import springmvc.model.dao.AcadamicrecordDao;
import springmvc.model.dao.AdditionalFieldDao;
import springmvc.model.dao.ApplicantstatusDao;
import springmvc.model.dao.ApplicationDao;
import springmvc.model.dao.DegreeDao;
import springmvc.model.dao.DepartmentDao;
import springmvc.model.dao.ProgramDao;

@Controller
@SessionAttributes("app")
public class StudentController 

{
	
	@Autowired
	private AdditionalFieldDao addfielddao;
	
	@Autowired
	private DegreeDao degreedao;
	
	@Autowired
	private DepartmentDao departmentdao;
	
	@Autowired
	private ProgramDao progarmdao;
	
	@Autowired
	private ApplicationDao applicationdao;
	
	@Autowired
	private ApplicantstatusDao applicantstatusdao;
	
	@Autowired
	private AcadamicrecordDao acadamicdao;
	
	@RequestMapping(value="/student.html")
	public String application(ModelMap models)
	
	{	
		//Application application =applicationdao.getApp(applicant_id);
		List<Application> applications = applicationdao.getApp();
		System.out.print(applications.size());
		//models.put("programs",application.getPrograms());		
		 models.put("applications",applications);
		 return "student";
	//	return "redirect:/student.html";		
	}
	
	@RequestMapping(value="/appview.html")
	public String view(@RequestParam int applicant_id,ModelMap models)
	{
		Application application =applicationdao.getApp(applicant_id);	
		models.put("application",application);		
	    return "applicantdetail";
		
	}
	
	@RequestMapping(value="/create.html", method=RequestMethod.GET)
	public String create(ModelMap models)
	{
		List<Department> departments = departmentdao.getDept();
		//Iterator<Department> i =departments.iterator();
		List<Programs> programs =progarmdao.getProg();   // departmentdao.getCoursesByDepartmentId(i.next().getDepartment_id());
		models.put("departments",departments);
		models.put("programs",programs);
		return "create";
		
	}
		
	@Autowired
	private ServletContext context;	
	private  File  getFileDirectory()
	{
		String path=context.getRealPath("/WEB-INF/files");
		return new File(path);
		
	}
		
	@RequestMapping(value="/create.html",method=RequestMethod.POST)
	
public String upload(@RequestParam MultipartFile file,@RequestParam String firstname,@RequestParam String lastname,
		@RequestParam String cin,@RequestParam String phno,@RequestParam String emailid,@RequestParam String gender,@RequestParam String birthdate
		,@RequestParam String citizenship,@RequestParam String clgname,@RequestParam String degreename,@RequestParam String requiredfield,
		@RequestParam double gpa,@RequestParam Integer Departments,@RequestParam Integer program_id,@RequestParam String type,@RequestParam String degreeCount,@RequestParam String term)
		throws IllegalStateException, IOException
	{
		
		System.out.print("degrees is "+degreeCount);
		System.out.print("degreecount is"+degreeCount.length());
		String[] degrees = null;
		List<Degree>  degs = null;
		
		
		if(!degreeCount.equals("")) {
			
			System.out.print("degrees is "+degreeCount);
			System.out.print("degreecount is"+degreeCount.length());
			degrees = StringUtils.split(degreeCount, " ");
			degs = new ArrayList<Degree>();
		}
		
		Application app=new Application();
		app.setFirstname(firstname);
		app.setLastname(lastname);
		app.setCin(cin);
		app.setPhno(phno);
		app.setEmailid(emailid);
		app.setGender(gender);
		app.setBirthdate(birthdate);
		app.setCitizenship(citizenship);
		app.setTerm(term);
		
            String base=context.getRealPath("/WEB-INF/files/");				
		    File in = new File(base + "/" + file.getOriginalFilename());
		    if(!in.exists()) {
			
			file.transferTo(new File(getFileDirectory(),file.getOriginalFilename()));
			
			
		}   
		
		String file_name=file.getOriginalFilename();
		
		Acadamicrecord acarcd=new Acadamicrecord();
		acarcd.setGpa(gpa);
		acarcd.setTranscript(file_name);
		app.setRecord(acarcd);
				
		Additionalfield addfield= new Additionalfield();
		addfield.setRequiredfield(requiredfield);
		app.setAddfield(addfield);
	
		Date d = new Date();
		
		Applicantstatus appstatus=new Applicantstatus();
		appstatus.setDate(d.toString());		
		appstatus.setStatus(type);
		app.setApplicationstatus(appstatus);
		
		Department dpt =departmentdao.getDept(Departments);
		app.setDepartment(dpt);
		
		
		Programs pro = progarmdao.getProg(program_id);
		
       app.setPrograms(pro);
    	
    	       if(degrees != null) {
    		
    	    	System.out.println(degrees.length);
                for(String s : degrees) {
    			
    			Degree d1 = new Degree();
    			d1.setClgname(clgname);
    			d1.setDegreename(s);
    			d1.setApplication(app);
    			degs.add(d1);
    			   			
    		}         
    	}
    	      
    	//app.setDegrees(degs);
    	
    	//acarcd.setApplication(app);
    	//applicantstatusdao.saveApplicantstatus(appstatus);    	
		//applicationdao.saveApplication(app);
        	
	    applicationdao.saveApplication(app);		
		return "redirect:student.html";	
		
	}
		
	@RequestMapping(value="/download.html")
	public String download(HttpServletResponse response ,@RequestParam("path") String path ) throws IOException
	
	{
		response.setContentType("text/plain");
		response.setHeader("Content-Disposition", "attachment;filename="+path);
		String base=context.getRealPath("/WEB-INF/files/");		
		FileInputStream in = new FileInputStream(new File(base + "/" + path));
		OutputStream out= response.getOutputStream();
		byte buffer[] = new byte[2048];
		int bytesRead;
		while((bytesRead=in.read(buffer)) > 0)
		out.write(buffer,0,bytesRead);
		in.close();	
		return "redirect:/";
		
			
	}
		
	@RequestMapping(value="/editstu.html",method=RequestMethod.GET)
	public String editapplication(@RequestParam int applicant_id,ModelMap models)
	{
		
		Application apps= applicationdao.getApp(applicant_id);
		Department d= apps.getDepartment();
		
		List<Programs> programs = departmentdao.getCoursesByDepartmentId(d.getDepartment_id());
		
		models.put("departments",d);
		models.put("programs",programs);
		
		Application app= applicationdao.getApp(applicant_id);
		models.put("applicationid",app.getApplicant_id());
		models.put("app",app);
		return "studentedit";
		
	}
	
	@RequestMapping(value="/editstu.html",method=RequestMethod.POST)
	public String editapplication(@RequestParam Integer appId,SessionStatus status,@RequestParam MultipartFile file,@RequestParam String firstname,@RequestParam String lastname,
			@RequestParam String emailid,@RequestParam String gender,@RequestParam String birthdate,@RequestParam String term
			,@RequestParam Integer program_id,@RequestParam String type,@RequestParam String gre) throws IllegalStateException, IOException
	{
		//app=applicationdao.saveApplication(app);
		//status.setComplete();		
//		return "redirect:/applicantdetail.html";
		
		//System.out.print("degrees is "+degreeCount);
		//System.out.print("degreecount is"+degreeCount.length());
		//String[] degrees = StringUtils.split(degreeCount, " ");
		//List<Degree>  degs = new ArrayList<Degree>();
				
		Application app = applicationdao.getApp(appId);
		System.out.print(app.getApplicant_id());
		app.setFirstname(firstname);
		app.setLastname(lastname);
	    app.setTerm(term);
		app.setEmailid(emailid);
		app.setGender(gender);
		app.setBirthdate(birthdate);
		app.getAddfield().setRequiredfield(gre);
		//System.out.print("file is" + file.getName());
		String base=context.getRealPath("/WEB-INF/files/");		
		
		File in = new File(base + "/" + file.getOriginalFilename());
		if(!in.exists()) {
			
			file.transferTo(new File(getFileDirectory(),file.getOriginalFilename()));
			
			
		}
		
		if(file != null) {
			
			String file_name=file.getOriginalFilename();
			
		    app.getRecord().setTranscript(file_name);
			
		}
				
		app.getApplicationstatus().setStatus(type);
		
		Programs pro = progarmdao.getProg(program_id);
    	app.setPrograms(pro);       
    	app.getRecord().setApplication(app);
    	applicationdao.saveApplication(app);
		//applicationdao.saveApplication(app);		
		return "redirect:student.html";	
			
	}	
}
	
	
	
	
	
	
	

