package com.model.db;

// default package

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * DoctorSchedule entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MS_YSPBB", schema = "dbo")
public class DoctorSchedule extends
		org.springframework.orm.hibernate3.support.HibernateDaoSupport
		implements java.io.Serializable, Comparable<DoctorSchedule> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DoctorScheduleId id;
	private Short ghxe;
	private Short ygrs;
	private Short yyrs;
	private Short jzxh;
	private Short yyxe;
	private Short tgbz;
	private Short week;
	private Short xszt;
	private Integer zjpb;
	private Integer zjdyc;
	private Timestamp kssj;
	private Timestamp jssj;
	private Integer pb114;

	// Constructors

	/** default constructor */
	public DoctorSchedule() {
	}

	/** minimal constructor */
	public DoctorSchedule(DoctorScheduleId id, Short ghxe, Short ygrs,
			Short yyrs, Short tgbz, Timestamp kssj, Timestamp jssj) {
		this.id = id;
		this.ghxe = ghxe;
		this.ygrs = ygrs;
		this.yyrs = yyrs;
		this.tgbz = tgbz;
		this.kssj = kssj;
		this.jssj = jssj;
	}

	/** full constructor */
	public DoctorSchedule(DoctorScheduleId id, Short ghxe, Short ygrs,
			Short yyrs, Short jzxh, Short yyxe, Short tgbz, Short week,
			Short xszt, Integer zjpb, Integer zjdyc, Timestamp kssj,
			Timestamp jssj, Integer pb114) {
		this.id = id;
		this.ghxe = ghxe;
		this.ygrs = ygrs;
		this.yyrs = yyrs;
		this.jzxh = jzxh;
		this.yyxe = yyxe;
		this.tgbz = tgbz;
		this.week = week;
		this.xszt = xszt;
		this.zjpb = zjpb;
		this.zjdyc = zjdyc;
		this.kssj = kssj;
		this.jssj = jssj;
		this.pb114 = pb114;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "gzrq", column = @Column(name = "GZRQ", nullable = false, length = 23)),
			@AttributeOverride(name = "ksdm", column = @Column(name = "KSDM", nullable = false, length = 6)),
			@AttributeOverride(name = "ysdm", column = @Column(name = "YSDM", nullable = false, length = 10)),
			@AttributeOverride(name = "zblb", column = @Column(name = "ZBLB", nullable = false, precision = 4, scale = 0)) })
	public DoctorScheduleId getId() {
		return this.id;
	}

	public void setId(DoctorScheduleId id) {
		this.id = id;
	}

	@Column(name = "GHXE", nullable = false, precision = 4, scale = 0)
	public Short getGhxe() {
		return this.ghxe;
	}

	public void setGhxe(Short ghxe) {
		this.ghxe = ghxe;
	}

	@Column(name = "YGRS", nullable = false, precision = 4, scale = 0)
	public Short getYgrs() {
		return this.ygrs;
	}

	public void setYgrs(Short ygrs) {
		this.ygrs = ygrs;
	}

	@Column(name = "YYRS", nullable = false, precision = 4, scale = 0)
	public Short getYyrs() {
		return this.yyrs;
	}

	public void setYyrs(Short yyrs) {
		this.yyrs = yyrs;
	}

	@Column(name = "JZXH", precision = 4, scale = 0)
	public Short getJzxh() {
		return this.jzxh;
	}

	public void setJzxh(Short jzxh) {
		this.jzxh = jzxh;
	}

	@Column(name = "YYXE", precision = 4, scale = 0)
	public Short getYyxe() {
		return this.yyxe;
	}

	public void setYyxe(Short yyxe) {
		this.yyxe = yyxe;
	}

	@Column(name = "TGBZ", nullable = false, precision = 1, scale = 0)
	public Short getTgbz() {
		return this.tgbz;
	}

	public void setTgbz(Short tgbz) {
		this.tgbz = tgbz;
	}

	@Column(name = "WEEK", precision = 1, scale = 0)
	public Short getWeek() {
		return this.week;
	}

	public void setWeek(Short week) {
		this.week = week;
	}

	@Column(name = "XSZT", precision = 1, scale = 0)
	public Short getXszt() {
		return this.xszt;
	}

	public void setXszt(Short xszt) {
		this.xszt = xszt;
	}

	@Column(name = "ZJPB")
	public Integer getZjpb() {
		return this.zjpb;
	}

	public void setZjpb(Integer zjpb) {
		this.zjpb = zjpb;
	}

	@Column(name = "ZJDYC")
	public Integer getZjdyc() {
		return this.zjdyc;
	}

	public void setZjdyc(Integer zjdyc) {
		this.zjdyc = zjdyc;
	}

	@Column(name = "KSSJ", nullable = false, length = 23)
	public Timestamp getKssj() {
		return this.kssj;
	}

	public void setKssj(Timestamp kssj) {
		this.kssj = kssj;
	}

	@Column(name = "JSSJ", nullable = false, length = 23)
	public Timestamp getJssj() {
		return this.jssj;
	}

	public void setJssj(Timestamp jssj) {
		this.jssj = jssj;
	}

	@Column(name = "pb114")
	public Integer getPb114() {
		return pb114;
	}

	public void setPb114(Integer pb114) {
		this.pb114 = pb114;
	}

	public int compareTo(DoctorSchedule o) {
		if (!this.id.equals(o.id))
			return this.id.compareTo(o.id);
		return 0;

	}

}