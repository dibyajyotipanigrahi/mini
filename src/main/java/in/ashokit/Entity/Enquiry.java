package in.ashokit.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enquiry {
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enqID;
	private String stuName;
	private Long stuPhno;
	private String mode;
	private String course;
	private String status;

	@Column(updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;

	@Column(insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;

	@ManyToOne
	@JoinColumn(name = "councellor_id")
	private Councellor councellor;

	public Integer getEnqID() {
		return enqID;
	}

	public void setEnqID(Integer enqID) {
		this.enqID = enqID;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Long getStuPhno() {
		return stuPhno;
	}

	public void setStuPhno(Long stuPhno) {
		this.stuPhno = stuPhno;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Councellor getCouncellor() {
		return councellor;
	}

	public void setCouncellor(Councellor councellor) {
		this.councellor = councellor;
	}

}
