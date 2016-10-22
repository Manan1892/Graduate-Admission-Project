package springmvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import javax.persistence.CascadeType;
@Entity
@Table(name = "usertype")
public class Usertype

{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int type_id;

	@Column(name = "type")
	private String type;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "typeuser")
	private List<Users> users ;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

}
