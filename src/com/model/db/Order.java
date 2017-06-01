package com.model.db;

// default package

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ms_yyghb", schema = "dbo")
public class Order extends
		org.springframework.orm.hibernate3.support.HibernateDaoSupport
		implements java.io.Serializable, Comparable<Order> {

	
	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long yyxh;
	private Long brid;
	private String ksdm;
	private String ysdm;
	private Byte yylb;
	private Short zblb;
	private Timestamp yyrq;
	private Short yybh;
	private String czgh;
	private Timestamp djsj;
	private Integer zfpb;
	private Integer zjbz;
	private Integer qrbz;
	private String lxdh;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(Long brid, String ksdm, String ysdm, Byte yylb, Short zblb,
			Timestamp yyrq, Short yybh) {
		this.brid = brid;
		this.ksdm = ksdm;
		this.ysdm = ysdm;
		this.yylb = yylb;
		this.zblb = zblb;
		this.yyrq = yyrq;
		this.yybh = yybh;
	}

	/** full constructor */
	public Order(Long brid, String ksdm, String ysdm, Byte yylb, Short zblb,
			Timestamp yyrq, Short yybh, String czgh, Timestamp djsj, Integer zfpb,
			Integer zjbz, Integer qrbz, String lxdh) {
		this.brid = brid;
		this.ksdm = ksdm;
		this.ysdm = ysdm;
		this.yylb = yylb;
		this.zblb = zblb;
		this.yyrq = yyrq;
		this.yybh = yybh;
		this.czgh = czgh;
		this.djsj = djsj;
		this.zfpb = zfpb;
		this.zjbz = zjbz;
		this.qrbz = qrbz;
		this.lxdh = lxdh;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "YYXH", unique = true, nullable = false, precision = 18, scale = 0)
	public Long getYyxh() {
		return this.yyxh;
	}

	public void setYyxh(Long yyxh) {
		this.yyxh = yyxh;
	}

	@Column(name = "BRID", nullable = false, precision = 18, scale = 0)
	public Long getBrid() {
		return this.brid;
	}

	public void setBrid(Long brid) {
		this.brid = brid;
	}

	@Column(name = "KSDM", nullable = false, length = 6)
	public String getKsdm() {
		return this.ksdm;
	}

	public void setKsdm(String ksdm) {
		this.ksdm = ksdm;
	}

	@Column(name = "YSDM", nullable = false, length = 50)
	public String getYsdm() {
		return this.ysdm;
	}

	public void setYsdm(String ysdm) {
		this.ysdm = ysdm;
	}

	@Column(name = "YYLB", nullable = false, precision = 2, scale = 0)
	public Byte getYylb() {
		return this.yylb;
	}

	public void setYylb(Byte yylb) {
		this.yylb = yylb;
	}

	@Column(name = "ZBLB", nullable = false, precision = 4, scale = 0)
	public Short getZblb() {
		return this.zblb;
	}

	public void setZblb(Short zblb) {
		this.zblb = zblb;
	}

	@Column(name = "YYRQ", nullable = false)
	public Timestamp getYyrq() {
		return this.yyrq;
	}

	public void setYyrq(Timestamp yyrq) {
		this.yyrq = yyrq;
	}

	@Column(name = "YYBH", nullable = false, precision = 4, scale = 0)
	public Short getYybh() {
		return this.yybh;
	}

	public void setYybh(Short yybh) {
		this.yybh = yybh;
	}

	@Column(name = "CZGH", length = 50)
	public String getCzgh() {
		return this.czgh;
	}

	public void setCzgh(String czgh) {
		this.czgh = czgh;
	}

	@Column(name = "DJSJ")
	public Timestamp getDjsj() {
		return this.djsj;
	}

	public void setDjsj(Timestamp djsj) {
		this.djsj = djsj;
	}

	@Column(name = "ZFPB")
	public Integer getZfpb() {
		return this.zfpb;
	}

	public void setZfpb(Integer zfpb) {
		this.zfpb = zfpb;
	}

	@Column(name = "ZJBZ")
	public Integer getZjbz() {
		return this.zjbz;
	}

	public void setZjbz(Integer zjbz) {
		this.zjbz = zjbz;
	}

	@Column(name = "QRBZ")
	public Integer getQrbz() {
		return this.qrbz;
	}

	public void setQrbz(Integer qrbz) {
		this.qrbz = qrbz;
	}

	@Column(name = "LXDH", length = 16)
	public String getLxdh() {
		return this.lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public int compareTo(Order o) {
		if (!this.yybh.equals(o.yybh)) {
			return this.yybh.compareTo(o.yybh);
		} else if (!this.ksdm.equals(o.ksdm)) {
			return this.ksdm.compareTo(o.ksdm);
		} else {
			return this.yyrq.compareTo(o.yyrq);
		}
	}

}