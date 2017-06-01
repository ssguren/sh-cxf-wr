package com.model.db;

// default package

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Patient entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MS_BRDA", schema = "dbo")
public class Patient extends
		org.springframework.orm.hibernate3.support.HibernateDaoSupport
		implements java.io.Serializable, Comparable<Patient> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long brid;
	private String mzhm;
	private String brxm;
	private String fyzh;
	private String sfzh;
	private Short brxz;
	private Short brxb;
	private Timestamp csny;
	private Short hyzk;
	private Short zydm;
	private Short mzdm;
	private Short xxdm;
	private Integer gmyw;
	private Short dwxh;
	private String dwmc;
	private String dwdh;
	private String dwyb;
	private String hkdz;
	private String jtdh;
	private String hkyb;
	private Short jzcs;
	private Timestamp jzrq;
	private Timestamp czrq;
	private String jzkh;
	private Short jzdw;
	private String tjdw;
	private String gmwp;
	private Integer ghfy;
	private Integer zcfy;
	private Integer blfy;
	private String khzt;
	private String brkh;
	private String bly;
	private Timestamp blsj;
	private String lxbs;
	private String bzxx;
	private Long glxz;
	private String lxr;
	private String zgxm;
	private Long zggx;
	private String xzzh;
	private Long shbz;
	private String hkdm;
	private Byte brhj;
	private Byte pohj;
	private Byte whcd;
	private Byte fyys;
	private Byte yqfy;
	private Byte gffy;
	private Byte ldhj;
	private String zz;

	// Constructors

	/** default constructor */
	public Patient() {
	}

	/** minimal constructor */
	public Patient(String mzhm) {
		this.mzhm = mzhm;
	}

	/** full constructor */
	public Patient(String mzhm, String brxm, String fyzh, String sfzh,
			Short brxz, Short brxb, Timestamp csny, Short hyzk, Short zydm,
			Short mzdm, Short xxdm, Integer gmyw, Short dwxh, String dwmc,
			String dwdh, String dwyb, String hkdz, String jtdh, String hkyb,
			Short jzcs, Timestamp jzrq, Timestamp czrq, String jzkh,
			Short jzdw, String tjdw, String gmwp, Integer ghfy, Integer zcfy,
			Integer blfy, String khzt, String brkh, String bly, Timestamp blsj,
			String lxbs, String bzxx, Long glxz, String lxr, String zgxm,
			Long zggx, String xzzh, Long shbz, String hkdm, Byte brhj,
			Byte pohj, Byte whcd, Byte fyys, Byte yqfy, Byte gffy, Byte ldhj,
			String zz) {
		this.mzhm = mzhm;
		this.brxm = brxm;
		this.fyzh = fyzh;
		this.sfzh = sfzh;
		this.brxz = brxz;
		this.brxb = brxb;
		this.csny = csny;
		this.hyzk = hyzk;
		this.zydm = zydm;
		this.mzdm = mzdm;
		this.xxdm = xxdm;
		this.gmyw = gmyw;
		this.dwxh = dwxh;
		this.dwmc = dwmc;
		this.dwdh = dwdh;
		this.dwyb = dwyb;
		this.hkdz = hkdz;
		this.jtdh = jtdh;
		this.hkyb = hkyb;
		this.jzcs = jzcs;
		this.jzrq = jzrq;
		this.czrq = czrq;
		this.jzkh = jzkh;
		this.jzdw = jzdw;
		this.tjdw = tjdw;
		this.gmwp = gmwp;
		this.ghfy = ghfy;
		this.zcfy = zcfy;
		this.blfy = blfy;
		this.khzt = khzt;
		this.brkh = brkh;
		this.bly = bly;
		this.blsj = blsj;
		this.lxbs = lxbs;
		this.bzxx = bzxx;
		this.glxz = glxz;
		this.lxr = lxr;
		this.zgxm = zgxm;
		this.zggx = zggx;
		this.xzzh = xzzh;
		this.shbz = shbz;
		this.hkdm = hkdm;
		this.brhj = brhj;
		this.pohj = pohj;
		this.whcd = whcd;
		this.fyys = fyys;
		this.yqfy = yqfy;
		this.gffy = gffy;
		this.ldhj = ldhj;
		this.zz = zz;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "BRID", unique = true, nullable = false, precision = 18, scale = 0)
	public Long getBrid() {
		return this.brid;
	}

	public void setBrid(Long brid) {
		this.brid = brid;
	}

	@Column(name = "MZHM", nullable = false, length = 12)
	public String getMzhm() {
		return this.mzhm;
	}

	public void setMzhm(String mzhm) {
		this.mzhm = mzhm;
	}

	@Column(name = "BRXM", length = 40)
	public String getBrxm() {
		return this.brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	@Column(name = "FYZH", length = 10)
	public String getFyzh() {
		return this.fyzh;
	}

	public void setFyzh(String fyzh) {
		this.fyzh = fyzh;
	}

	@Column(name = "SFZH", length = 20)
	public String getSfzh() {
		return this.sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	@Column(name = "BRXZ", precision = 4, scale = 0)
	public Short getBrxz() {
		return this.brxz;
	}

	public void setBrxz(Short brxz) {
		this.brxz = brxz;
	}

	@Column(name = "BRXB", precision = 4, scale = 0)
	public Short getBrxb() {
		return this.brxb;
	}

	public void setBrxb(Short brxb) {
		this.brxb = brxb;
	}

	@Column(name = "CSNY", length = 23)
	public Timestamp getCsny() {
		return this.csny;
	}

	public void setCsny(Timestamp csny) {
		this.csny = csny;
	}

	@Column(name = "HYZK", precision = 4, scale = 0)
	public Short getHyzk() {
		return this.hyzk;
	}

	public void setHyzk(Short hyzk) {
		this.hyzk = hyzk;
	}

	@Column(name = "ZYDM", precision = 4, scale = 0)
	public Short getZydm() {
		return this.zydm;
	}

	public void setZydm(Short zydm) {
		this.zydm = zydm;
	}

	@Column(name = "MZDM", precision = 4, scale = 0)
	public Short getMzdm() {
		return this.mzdm;
	}

	public void setMzdm(Short mzdm) {
		this.mzdm = mzdm;
	}

	@Column(name = "XXDM", precision = 4, scale = 0)
	public Short getXxdm() {
		return this.xxdm;
	}

	public void setXxdm(Short xxdm) {
		this.xxdm = xxdm;
	}

	@Column(name = "GMYW", precision = 6, scale = 0)
	public Integer getGmyw() {
		return this.gmyw;
	}

	public void setGmyw(Integer gmyw) {
		this.gmyw = gmyw;
	}

	@Column(name = "DWXH", precision = 4, scale = 0)
	public Short getDwxh() {
		return this.dwxh;
	}

	public void setDwxh(Short dwxh) {
		this.dwxh = dwxh;
	}

	@Column(name = "DWMC", length = 40)
	public String getDwmc() {
		return this.dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	@Column(name = "DWDH", length = 16)
	public String getDwdh() {
		return this.dwdh;
	}

	public void setDwdh(String dwdh) {
		this.dwdh = dwdh;
	}

	@Column(name = "DWYB", length = 6)
	public String getDwyb() {
		return this.dwyb;
	}

	public void setDwyb(String dwyb) {
		this.dwyb = dwyb;
	}

	@Column(name = "HKDZ", length = 40)
	public String getHkdz() {
		return this.hkdz;
	}

	public void setHkdz(String hkdz) {
		this.hkdz = hkdz;
	}

	@Column(name = "JTDH", length = 16)
	public String getJtdh() {
		return this.jtdh;
	}

	public void setJtdh(String jtdh) {
		this.jtdh = jtdh;
	}

	@Column(name = "HKYB", length = 6)
	public String getHkyb() {
		return this.hkyb;
	}

	public void setHkyb(String hkyb) {
		this.hkyb = hkyb;
	}

	@Column(name = "JZCS", precision = 4, scale = 0)
	public Short getJzcs() {
		return this.jzcs;
	}

	public void setJzcs(Short jzcs) {
		this.jzcs = jzcs;
	}

	@Column(name = "JZRQ", length = 23)
	public Timestamp getJzrq() {
		return this.jzrq;
	}

	public void setJzrq(Timestamp jzrq) {
		this.jzrq = jzrq;
	}

	@Column(name = "CZRQ", length = 23)
	public Timestamp getCzrq() {
		return this.czrq;
	}

	public void setCzrq(Timestamp czrq) {
		this.czrq = czrq;
	}

	@Column(name = "JZKH", length = 40)
	public String getJzkh() {
		return this.jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	@Column(name = "JZDW", precision = 4, scale = 0)
	public Short getJzdw() {
		return this.jzdw;
	}

	public void setJzdw(Short jzdw) {
		this.jzdw = jzdw;
	}

	@Column(name = "TJDW", length = 100)
	public String getTjdw() {
		return this.tjdw;
	}

	public void setTjdw(String tjdw) {
		this.tjdw = tjdw;
	}

	@Column(name = "GMWP", length = 100)
	public String getGmwp() {
		return this.gmwp;
	}

	public void setGmwp(String gmwp) {
		this.gmwp = gmwp;
	}

	@Column(name = "GHFY")
	public Integer getGhfy() {
		return this.ghfy;
	}

	public void setGhfy(Integer ghfy) {
		this.ghfy = ghfy;
	}

	@Column(name = "ZCFY")
	public Integer getZcfy() {
		return this.zcfy;
	}

	public void setZcfy(Integer zcfy) {
		this.zcfy = zcfy;
	}

	@Column(name = "BLFY")
	public Integer getBlfy() {
		return this.blfy;
	}

	public void setBlfy(Integer blfy) {
		this.blfy = blfy;
	}

	@Column(name = "KHZT", length = 1)
	public String getKhzt() {
		return this.khzt;
	}

	public void setKhzt(String khzt) {
		this.khzt = khzt;
	}

	@Column(name = "BRKH", length = 20)
	public String getBrkh() {
		return this.brkh;
	}

	public void setBrkh(String brkh) {
		this.brkh = brkh;
	}

	@Column(name = "BLY", length = 20)
	public String getBly() {
		return this.bly;
	}

	public void setBly(String bly) {
		this.bly = bly;
	}

	@Column(name = "BLSJ", length = 23)
	public Timestamp getBlsj() {
		return this.blsj;
	}

	public void setBlsj(Timestamp blsj) {
		this.blsj = blsj;
	}

	@Column(name = "LXBS", length = 100)
	public String getLxbs() {
		return this.lxbs;
	}

	public void setLxbs(String lxbs) {
		this.lxbs = lxbs;
	}

	@Column(name = "BZXX", length = 100)
	public String getBzxx() {
		return this.bzxx;
	}

	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
	}

	@Column(name = "GLXZ", precision = 10, scale = 0)
	public Long getGlxz() {
		return this.glxz;
	}

	public void setGlxz(Long glxz) {
		this.glxz = glxz;
	}

	@Column(name = "LXR", length = 40)
	public String getLxr() {
		return this.lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	@Column(name = "ZGXM", length = 40)
	public String getZgxm() {
		return this.zgxm;
	}

	public void setZgxm(String zgxm) {
		this.zgxm = zgxm;
	}

	@Column(name = "ZGGX", precision = 10, scale = 0)
	public Long getZggx() {
		return this.zggx;
	}

	public void setZggx(Long zggx) {
		this.zggx = zggx;
	}

	@Column(name = "XZZH", length = 20)
	public String getXzzh() {
		return this.xzzh;
	}

	public void setXzzh(String xzzh) {
		this.xzzh = xzzh;
	}

	@Column(name = "SHBZ", precision = 18, scale = 0)
	public Long getShbz() {
		return this.shbz;
	}

	public void setShbz(Long shbz) {
		this.shbz = shbz;
	}

	@Column(name = "HKDM", length = 10)
	public String getHkdm() {
		return this.hkdm;
	}

	public void setHkdm(String hkdm) {
		this.hkdm = hkdm;
	}

	@Column(name = "BRHJ", precision = 2, scale = 0)
	public Byte getBrhj() {
		return this.brhj;
	}

	public void setBrhj(Byte brhj) {
		this.brhj = brhj;
	}

	@Column(name = "POHJ", precision = 2, scale = 0)
	public Byte getPohj() {
		return this.pohj;
	}

	public void setPohj(Byte pohj) {
		this.pohj = pohj;
	}

	@Column(name = "WHCD", precision = 2, scale = 0)
	public Byte getWhcd() {
		return this.whcd;
	}

	public void setWhcd(Byte whcd) {
		this.whcd = whcd;
	}

	@Column(name = "FYYS", precision = 2, scale = 0)
	public Byte getFyys() {
		return this.fyys;
	}

	public void setFyys(Byte fyys) {
		this.fyys = fyys;
	}

	@Column(name = "YQFY", precision = 2, scale = 0)
	public Byte getYqfy() {
		return this.yqfy;
	}

	public void setYqfy(Byte yqfy) {
		this.yqfy = yqfy;
	}

	@Column(name = "GFFY", precision = 2, scale = 0)
	public Byte getGffy() {
		return this.gffy;
	}

	public void setGffy(Byte gffy) {
		this.gffy = gffy;
	}

	@Column(name = "LDHJ", precision = 2, scale = 0)
	public Byte getLdhj() {
		return this.ldhj;
	}

	public void setLdhj(Byte ldhj) {
		this.ldhj = ldhj;
	}

	@Column(name = "ZZ", length = 50)
	public String getZz() {
		return this.zz;
	}

	public void setZz(String zz) {
		this.zz = zz;
	}

	public int compareTo(Patient o) {
		if (!this.brid.equals(o.brid))
			return this.brid.compareTo(o.brid);
		return 0;
	}

}