
package springmvc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department 


{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int department_id;

	@Column(name = "departmentname")
	private String name;


	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="department")
	private List<Programs> program;


	public int getDepartment_id() {
		return department_id;
	}


	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Programs> getProgram() {
		return program;
	}


	public void setProgram(List<Programs> program) {
		this.program = program;
	}



	
}
