package com.model.db;

// default package

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DoctorScheduleId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class DoctorScheduleId extends
		org.springframework.orm.hibernate3.support.HibernateDaoSupport
		implements java.io.Serializable, Comparable<DoctorScheduleId> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timestamp gzrq;
	private String ksdm;
	private String ysdm;
	private Short zblb;

	// Constructors

	/** default constructor */
	public DoctorScheduleId() {
	}

	/** full constructor */
	public DoctorScheduleId(Timestamp gzrq, String ksdm, String ysdm, Short zblb) {
		this.gzrq = gzrq;
		this.ksdm = ksdm;
		this.ysdm = ysdm;
		this.zblb = zblb;
	}

	// Property accessors

	@Column(name = "GZRQ", nullable = false, length = 23)
	public Timestamp getGzrq() {
		return this.gzrq;
	}

	public void setGzrq(Timestamp gzrq) {
		this.gzrq = gzrq;
	}

	@Column(name = "KSDM", nullable = false, length = 6)
	public String getKsdm() {
		return this.ksdm;
	}

	public void setKsdm(String ksdm) {
		this.ksdm = ksdm;
	}

	@Column(name = "YSDM", nullable = false, length = 10)
	public String getYsdm() {
		return this.ysdm;
	}

	public void setYsdm(String ysdm) {
		this.ysdm = ysdm;
	}

	@Column(name = "ZBLB", nullable = false, precision = 4, scale = 0)
	public Short getZblb() {
		return this.zblb;
	}

	public void setZblb(Short zblb) {
		this.zblb = zblb;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DoctorScheduleId))
			return false;
		DoctorScheduleId castOther = (DoctorScheduleId) other;

		return ((this.getGzrq() == castOther.getGzrq()) || (this.getGzrq() != null
				&& castOther.getGzrq() != null && this.getGzrq().equals(
				castOther.getGzrq())))
				&& ((this.getKsdm() == castOther.getKsdm()) || (this.getKsdm() != null
						&& castOther.getKsdm() != null && this.getKsdm()
						.equals(castOther.getKsdm())))
				&& ((this.getYsdm() == castOther.getYsdm()) || (this.getYsdm() != null
						&& castOther.getYsdm() != null && this.getYsdm()
						.equals(castOther.getYsdm())))
				&& ((this.getZblb() == castOther.getZblb()) || (this.getZblb() != null
						&& castOther.getZblb() != null && this.getZblb()
						.equals(castOther.getZblb())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGzrq() == null ? 0 : this.getGzrq().hashCode());
		result = 37 * result
				+ (getKsdm() == null ? 0 : this.getKsdm().hashCode());
		result = 37 * result
				+ (getYsdm() == null ? 0 : this.getYsdm().hashCode());
		result = 37 * result
				+ (getZblb() == null ? 0 : this.getZblb().hashCode());
		return result;
	}

	public int compareTo(DoctorScheduleId o) {
		if (!this.ysdm.equals(o.getYsdm())) {
			return this.ysdm.compareTo(o.getYsdm());
		} else {
			return this.ksdm.compareTo(o.getKsdm());
		}
	}

}