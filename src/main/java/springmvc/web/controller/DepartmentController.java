package springmvc.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;




import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import springmvc.model.Additionalfield;
import springmvc.model.Department;
import springmvc.model.Programs;
import springmvc.model.dao.AdditionalFieldDao;
import springmvc.model.dao.DepartmentDao;
import springmvc.model.dao.ProgramDao;

@Controller
@SessionAttributes("department")
public class DepartmentController

{
	@Autowired
	private AdditionalFieldDao additionalfielddao;

	@Autowired
	private DepartmentDao departmentdao;

	@Autowired
	private ProgramDao programdao;

	@RequestMapping(value = "/admin.html")
	public String department(ModelMap models)
	{
		List<Department> departments = departmentdao.getDept();
		for (Department x : departments) {
			String department = x.getName();
			// System.out.println(department);
		}
		models.put("departments", departments);
		return "admin";

	}   
	
	@RequestMapping(value = "/view.html")
	public String view(@RequestParam int department_id, ModelMap models)
	{
		Department department = departmentdao.getDept(department_id);
		models.put("programs1", department.getProgram());
		//models.put("additionals", department.getAdditionalfield());
		models.put("department", department);
		return "view";
	}

	@RequestMapping(value = "/edit.html", method = RequestMethod.GET)
	public String edit(ModelMap models, @RequestParam int department_id)
	{
		Department department = departmentdao.getDept(department_id);
		models.put("departmentid", department.getDepartment_id());
		//models.put("programs", department.getProgram());
		models.put("department", department);
		return "edit";
	}

	@RequestMapping(value = "/edit.html", method = RequestMethod.POST)
	public String edit(@ModelAttribute Department department,
			SessionStatus status)
	{
		department = departmentdao.saveDepartment(department);
		status.setComplete();
		return "redirect:admin.html";
	}
	
	@RequestMapping(value = "/fetchCourses.html", method = RequestMethod.GET)
	@ResponseBody 
	public String fetchCourses(@RequestParam("departmentId") String departmentId)
	{
		
		List<Programs> cartList = departmentdao.getCoursesByDepartmentId(Integer.parseInt(departmentId));
		
		
		
	    String jsonCartList = JSONObject.valueToString((List<Object>)(Object)cartList);
	    //System.out.print(jsonCartList);
		 // print your generated json*/
	    
		System.out.print("id"+cartList.size());
		return jsonCartList;
		 		
	}

	@RequestMapping(value = "/Addprogram.html", method = RequestMethod.GET)
	public String add(@RequestParam int department_id, ModelMap models)
	{
		models.put("department_id", department_id);
		models.put("program", new Programs());
		return "Addprogram";
	}

	@RequestMapping(value = "/Addprogram.html", method = RequestMethod.POST)
	public String add(@ModelAttribute Programs program,
			@RequestParam Integer department_id)

	{
		Department department = departmentdao.getDept(department_id);
		program.setDepartment(department);
		programdao.saveProgram(program);
		return "redirect:admin.html";
	}

	@RequestMapping(value = "/AddAdditionalField.html", method = RequestMethod.GET)
	public String addadditional(@RequestParam int department_id, ModelMap models) 
	{
		models.put("department_id", department_id);
		models.put("Addfield", new Additionalfield());
		return "AddAdditionalField";
	}

	@RequestMapping(value = "/AddAdditionalField.html", method = RequestMethod.POST)
	public String addadditional(@ModelAttribute Additionalfield Addfield,
			@RequestParam Integer department_id)
	{
		Department department = departmentdao.getDept(department_id);
		Addfield.setDepartment(department);
		additionalfielddao.saveAddfield(Addfield);
		return "redirect:admin.html";
	}

	@RequestMapping(value = "/removeprogram.html", method = RequestMethod.GET)
	public String removeprogram(@RequestParam int program_id, ModelMap models)

	{
		Programs program = programdao.getProg(program_id);
		//if(program.getApplication() != null)
		{
			//program.getApplication().setPrograms(null);
			programdao.saveProgram(program);
		}
		Department department = program.getDepartment();
		programdao.removeProgram(program);
		return "redirect:edit.html?department_id="
				+ department.getDepartment_id();
	}

	@RequestMapping(value = "/removeAdditional.html", method = RequestMethod.GET)
	public String removeadditional(@RequestParam int program_id, ModelMap models) 	
	{		
		Additionalfield Addfield = additionalfielddao.getAdditionalfield(program_id);
			Department department=Addfield.getDepartment();			
			additionalfielddao.removeAddfield(Addfield);			
		return "redirect:edit.html?department_id=" + department.getDepartment_id();
	}

	@RequestMapping(value = "/removeAdditional.html", method = RequestMethod.POST)
	public String removeadditional(@ModelAttribute Additionalfield Addfield,
			@RequestParam Integer department_id)
	{
		Department department = departmentdao.getDept(department_id);
		// program.setDepartment(null);
		additionalfielddao.saveAddfield(Addfield);
		additionalfielddao.removeAddfield(Addfield);
		return "redirect:admin.html";
	}

	@RequestMapping(value = "/adddepartment.html", method = RequestMethod.GET)
	public String adddept(ModelMap models)
	{
		models.put("department", new Department());
		return "adddepartment";
	}

	@RequestMapping(value = "/adddepartment.html", method = RequestMethod.POST)
	public String adddept(@ModelAttribute Department department,
			@RequestParam String name)
	{
		department = departmentdao.saveDepartment(department);
		return "redirect:admin.html";
	}

}
