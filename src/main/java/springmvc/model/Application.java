package springmvc.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Application")
public class Application 


{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int applicant_id;

	
	@Column(name = "term")
	private String term;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lasttname")
	private String lastname;
	
	@Column(name = "cin")
	private String cin;
	
	@Column(name = "phoneno")
	private String phno;
	
	@Column(name = "emailid")
	private String emailid;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "birthdate")
	private String birthdate;
	
	@Column(name = "citizenship")
	private String citizenship;
	
    
	@OneToMany(cascade = CascadeType.ALL,mappedBy="application")
	private List<Degree> degrees;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Additionalfield addfield;
	
	@ManyToOne
	private Department department;
	
    @ManyToMany
	@JoinTable(name="usertoapplicant",joinColumns=@JoinColumn(name="applicant_id"),inverseJoinColumns=@JoinColumn(name="user_id"))
    private List<Users> users;
	
    @ManyToOne
    private Programs programs;
    	
	@OneToOne(cascade = CascadeType.ALL)
	private Applicantstatus applicationstatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Acadamicrecord record;
    
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getCitizenship() {
		return citizenship;
	}
	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}
	public int getApplicant_id() {
		return applicant_id;
	}
	public void setApplicant_id(int applicant_id) {
		this.applicant_id = applicant_id;
	}
	public List<Users> getUsers() {
		return users;
	}
	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Applicantstatus getApplicationstatus() {
		return applicationstatus;
	}
	public void setApplicationstatus(Applicantstatus applicationstatus) {
		this.applicationstatus = applicationstatus;
	}
	public List<Degree> getDegrees() {
		return degrees;
	}
	public void setDegrees(List<Degree> degrees) {
		this.degrees = degrees;
	}
	public Acadamicrecord getRecord() {
		return record;
	}
	public void setRecord(Acadamicrecord record) {
		this.record = record;
	}
	public Programs getPrograms() {
		return programs;
	}
	public void setPrograms(Programs programs) {
		this.programs = programs;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Additionalfield getAddfield() {
		return addfield;
	}
	public void setAddfield(Additionalfield addfield) {
		this.addfield = addfield;
	}

	
	
	
	
	
}
