package in.ashokit.Entity;


import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Councellor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer councellorId;
	private String name;
	private String email;
	private String pwd;
	private Long phno;
	
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	@OneToMany(mappedBy = "councellor" ,cascade = CascadeType.ALL)
	private List<Enquiry> enquires;

	public Integer getCouncellorId() {
		return councellorId;
	}

	public void setCouncellorId(Integer councellorId) {
		this.councellorId = councellorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<Enquiry> getEnquires() {
		return enquires;
	}

	public void setEnquires(List<Enquiry> enquires) {
		this.enquires = enquires;
	}
	
	

}
