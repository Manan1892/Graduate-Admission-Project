package springmvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Applicantstatus")
public class Applicantstatus 

{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int applicant_status;
	
	@Column(name = "status")
	private String status;
	
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "date")
	private String date;
	
	@OneToOne
	private Application application;
	
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public int getApplicant_status() {
		return applicant_status;
	}
	public void setApplicant_status(int applicant_status) {
		this.applicant_status = applicant_status;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
}
