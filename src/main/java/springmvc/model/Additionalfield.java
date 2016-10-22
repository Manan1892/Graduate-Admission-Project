package springmvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Add_Field")
public class Additionalfield 


{

	@Id
	@GeneratedValue
	int addfld;
	
	@Column(name="nameoffield")
	private String nameoffield;
	
	@Column(name="typeoffield")
	private String typeoffield;
	
	@Column(name="requiredfield")
	private String requiredfield;
	
	@Column(name="optionalfield")
	private String optionalfield;
	
	
    @OneToOne
    private Application application;
	
	@ManyToOne
	private Department department;
	
	public String getNameoffield() {
		return nameoffield;
	}
	public void setNameoffield(String nameoffield) {
		this.nameoffield = nameoffield;
	}
	public String getTypeoffield() {
		return typeoffield;
	}
	public void setTypeoffield(String typeoffield) {
		this.typeoffield = typeoffield;
	}
	public String getRequiredfield() {
		return requiredfield;
	}
	public void setRequiredfield(String requiredfield) {
		this.requiredfield = requiredfield;
	}
	public String getOptionalfield() {
		return optionalfield;
	}
	public void setOptionalfield(String optionalfield) {
		this.optionalfield = optionalfield;
	}
	public int getAddfld() {
		return addfld;
	}
	public void setAddfld(int addfld) {
		this.addfld = addfld;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}

	
	
	
}
