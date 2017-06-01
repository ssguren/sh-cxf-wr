package com.model.db;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PatientCard entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "yb_mzbrda", schema = "dbo"
// ,catalog="mz_bsrun"
)
public class PatientCard extends
		org.springframework.orm.hibernate3.support.HibernateDaoSupport
		implements java.io.Serializable, Comparable<PatientCard> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer brid;
	private String mzhm;
	private Short brxz;
	private String bxh;
	private String ickh;
	private String rylb;
	private String gwylb;
	private Byte kz;
	private Boolean zfpb;
	private String lxr;
	private String xzlx;
	private String zmmz;
	private String sqbh;

	// Constructors

	/** default constructor */
	public PatientCard() {
	}

	/** minimal constructor */
	public PatientCard(String mzhm, Short brxz, String bxh, String ickh,
			String rylb, String gwylb, Byte kz, Boolean zfpb) {
		this.mzhm = mzhm;
		this.brxz = brxz;
		this.bxh = bxh;
		this.ickh = ickh;
		this.rylb = rylb;
		this.gwylb = gwylb;
		this.kz = kz;
		this.zfpb = zfpb;
	}

	/** full constructor */
	public PatientCard(String mzhm, Short brxz, String bxh, String ickh,
			String rylb, String gwylb, Byte kz, Boolean zfpb, String lxr,
			String xzlx, String zmmz, String sqbh) {
		this.mzhm = mzhm;
		this.brxz = brxz;
		this.bxh = bxh;
		this.ickh = ickh;
		this.rylb = rylb;
		this.gwylb = gwylb;
		this.kz = kz;
		this.zfpb = zfpb;
		this.lxr = lxr;
		this.xzlx = xzlx;
		this.zmmz = zmmz;
		this.sqbh = sqbh;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "BRID", unique = true, nullable = false, precision = 9, scale = 0)
	public Integer getBrid() {
		return this.brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	@Column(name = "MZHM", nullable = false, length = 12)
	public String getMzhm() {
		return this.mzhm;
	}

	public void setMzhm(String mzhm) {
		this.mzhm = mzhm;
	}

	@Column(name = "BRXZ", nullable = false, precision = 4, scale = 0)
	public Short getBrxz() {
		return this.brxz;
	}

	public void setBrxz(Short brxz) {
		this.brxz = brxz;
	}

	@Column(name = "BXH", nullable = false, length = 20)
	public String getBxh() {
		return this.bxh;
	}

	public void setBxh(String bxh) {
		this.bxh = bxh;
	}

	@Column(name = "ICKH", nullable = false, length = 20)
	public String getIckh() {
		return this.ickh;
	}

	public void setIckh(String ickh) {
		this.ickh = ickh;
	}

	@Column(name = "RYLB", nullable = false, length = 4)
	public String getRylb() {
		return this.rylb;
	}

	public void setRylb(String rylb) {
		this.rylb = rylb;
	}

	@Column(name = "GWYLB", nullable = false, length = 4)
	public String getGwylb() {
		return this.gwylb;
	}

	public void setGwylb(String gwylb) {
		this.gwylb = gwylb;
	}

	@Column(name = "KZ", nullable = false, precision = 2, scale = 0)
	public Byte getKz() {
		return this.kz;
	}

	public void setKz(Byte kz) {
		this.kz = kz;
	}

	@Column(name = "ZFPB", nullable = false, precision = 1, scale = 0)
	public Boolean getZfpb() {
		return this.zfpb;
	}

	public void setZfpb(Boolean zfpb) {
		this.zfpb = zfpb;
	}

	@Column(name = "LXR", length = 20)
	public String getLxr() {
		return this.lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	@Column(name = "XZLX", length = 10)
	public String getXzlx() {
		return this.xzlx;
	}

	public void setXzlx(String xzlx) {
		this.xzlx = xzlx;
	}

	@Column(name = "ZMMZ", length = 3)
	public String getZmmz() {
		return this.zmmz;
	}

	public void setZmmz(String zmmz) {
		this.zmmz = zmmz;
	}

	@Column(name = "SQBH", length = 20)
	public String getSqbh() {
		return this.sqbh;
	}

	public void setSqbh(String sqbh) {
		this.sqbh = sqbh;
	}

	public int compareTo(PatientCard o) {
		if (!this.brid.equals(o.brid)) {
			return this.brid.compareTo(o.brid);
		} else if (!this.ickh.equals(o.ickh)) {
			return this.ickh.compareTo(o.ickh);
		} else {
			return 0;
		}
	}

}