package cn.wzw.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "num")
	private int num;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "grend")
	private Integer grend;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getGrend() {
		return grend;
	}
	public void setGrend(Integer grend) {
		this.grend = grend;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", num=" + num + ", name=" + name + ", address=" + address + ", sex=" + sex
				+ ", grend=" + grend + "]";
	}
	
	
	
}
