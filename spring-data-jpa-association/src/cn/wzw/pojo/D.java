package cn.wzw.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "d")
public class D {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "d_name")
	private String dname;
	
	//配置映射关系，多对多所有使用set集合
	@ManyToMany(mappedBy = "d")
	private Set<C> c = new HashSet<C>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Set<C> getC() {
		return c;
	}

	public void setC(Set<C> c) {
		this.c = c;
	}
	
	
}
