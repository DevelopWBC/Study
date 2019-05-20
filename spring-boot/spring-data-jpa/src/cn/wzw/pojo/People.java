package cn.wzw.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CRUDRepository接口
 * @author wangzhiwen
 *
 */
@Entity
@Table(name = "t_people")
public class People {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "countryName")
	private String countryName;
	@Column(name = "type")
	private String type;
	@Column(name = "ocupation")
	private String ocupation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOcupation() {
		return ocupation;
	}
	public void setOcupation(String ocupation) {
		this.ocupation = ocupation;
	}
	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", countryName=" + countryName + ", type=" + type
				+ ", ocupation=" + ocupation + "]";
	}
	
	
}
