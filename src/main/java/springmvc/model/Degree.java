package springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Degree")
public class Degree

{

	@Id
	@GeneratedValue
	int degree_id;

	@Column(name = "clgname")
	private String clgname;

	//@Column(name = "timeperiod")
	//private String timepeiod;

	@Column(name = "degreename")
	private String degreename;

	//@Column(name = "majordegree")
	//private String majordegree;

	@ManyToOne
	private Application application;



	public String getClgname() {
		return clgname;
	}

	public void setClgname(String clgname) {
		this.clgname = clgname;
	}

	//public String getTimepeiod() {
	//	return timepeiod;
	//}

	//public void setTimepeiod(String timepeiod) {
	//	this.timepeiod = timepeiod;
	//}

	public String getDegreename() {
		return degreename;
	}

	public void setDegreename(String degreename) {
		this.degreename = degreename;
	}

	//public String getMajordegree() {
	//	return majordegree;
	//}

	//public void setMajordegree(String majordegree) {
		//this.majordegree = majordegree;
	//}


	public int getDegree_id() {
		return degree_id;
	}

	public void setDegree_id(int degree_id) {
		this.degree_id = degree_id;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

}
