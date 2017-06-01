package com.model.db;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Doctor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "YYGH_DOCTOR_INFO", schema = "dbo")
public class Doctor extends
		org.springframework.orm.hibernate3.support.HibernateDaoSupport
		implements java.io.Serializable, Comparable<Doctor> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String ksdm;
	private String ksmc;
	private String ysdm;
	private String ygxm;
	private Integer ygxb;
	private String gzmc;

	// Constructors

	/** default constructor */
	public Doctor() {
	}

	/** minimal constructor */
	public Doctor(String ksdm, String ysdm) {
		this.ksdm = ksdm;
		this.ysdm = ysdm;
	}

	/** full constructor */
	public Doctor(String ksdm, String ksmc, String ysdm, String ygxm,
			Integer ygxb, String gzmc) {
		this.ksdm = ksdm;
		this.ksmc = ksmc;
		this.ysdm = ysdm;
		this.ygxm = ygxm;
		this.ygxb = ygxb;
		this.gzmc = gzmc;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "ksdm", nullable = false, length = 6)
	public String getKsdm() {
		return this.ksdm;
	}

	public void setKsdm(String ksdm) {
		this.ksdm = ksdm;
	}

	@Column(name = "ksmc", length = 40)
	public String getKsmc() {
		return this.ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	@Column(name = "ysdm", nullable = false, length = 50)
	public String getYsdm() {
		return this.ysdm;
	}

	public void setYsdm(String ysdm) {
		this.ysdm = ysdm;
	}

	@Column(name = "ygxm", length = 8)
	public String getYgxm() {
		return this.ygxm;
	}

	public void setYgxm(String ygxm) {
		this.ygxm = ygxm;
	}

	@Column(name = "ygxb")
	public Integer getYgxb() {
		return this.ygxb;
	}

	public void setYgxb(Integer ygxb) {
		this.ygxb = ygxb;
	}

	@Column(name = "gzmc", length = 40)
	public String getGzmc() {
		return this.gzmc;
	}

	public void setGzmc(String gzmc) {
		this.gzmc = gzmc;
	}

	public int compareTo(Doctor o) {
		if (!this.ysdm.equals(o.ysdm)) {
			return this.ysdm.compareTo(o.ysdm);
		} else if (!this.ksdm.equals(o.ksdm)) {
			return this.ksdm.compareTo(o.ksdm);
		} else {
			return this.ygxm.compareTo(o.ygxm);
		}
	}

}