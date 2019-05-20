package cn.wzw.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "c")
public class C {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "c_name")
	private String cname;
	
	//多对多的关系，需要配置关联表。只需要在一个实体中配置中间表就可以了
	//@JoinTable:name：表名称，joinColumns：@JoinColumn(name= "c_id")中间表外键关联名称，inverseJoinColumns = @JoinColumn(name="d_id")：关联另外一张表名称
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "c_d",joinColumns =@JoinColumn(name= "c_id"),inverseJoinColumns = @JoinColumn(name="d_id") )
	private Set<D> d = new HashSet<D>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set<D> getD() {
		return d;
	}

	public void setD(Set<D> d) {
		this.d = d;
	}
	
	
}
