package springmvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Academic_rec")

public class Acadamicrecord 

{

	@Id
	@GeneratedValue
	int acarec;
	
	

	@Column(name="gpa")
	private double gpa;
	

	@Column(name="transcript")
	private String transcript;
	
	@OneToOne
	private Application application;
	
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getTranscript() {
		return transcript;
	}
	public void setTranscript(String transcript) {
		this.transcript = transcript;
	}
	public int getAcarec() {
		return acarec;
	}
	public void setAcarec(int acarec) {
		this.acarec = acarec;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
		
}
