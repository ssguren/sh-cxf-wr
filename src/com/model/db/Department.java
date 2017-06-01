package com.model.db;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Department entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ms_ghks"
    ,schema="dbo"
)

public class Department extends org.springframework.orm.hibernate3.support.HibernateDaoSupport implements java.io.Serializable,Comparable<Department> {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ksdm;
     private String ksmc;
     private Short ghlb;
     private String pydm;
     private String wbdm;
     private String jxdm;
     private String qtdm;
     private Double ghf;
     private Double zlf;
     private Boolean zjmz;
     private Short ghxe;
     private Short ygrs;
     private Short yyrs;
     private String ghrq;
     private Short mzks;
     private Boolean tjpb;
     private Double tjf;
     private Byte mzlb;
     private Short jzxh;


    // Constructors

    /** default constructor */
    public Department() {
    }

	/** minimal constructor */
    public Department(Double ghf, Double zlf, Boolean zjmz, Short ghxe, Short ygrs, Short yyrs, Boolean tjpb, Double tjf, Byte mzlb) {
        this.ghf = ghf;
        this.zlf = zlf;
        this.zjmz = zjmz;
        this.ghxe = ghxe;
        this.ygrs = ygrs;
        this.yyrs = yyrs;
        this.tjpb = tjpb;
        this.tjf = tjf;
        this.mzlb = mzlb;
    }
    
    /** full constructor */
    public Department(String ksmc, Short ghlb, String pydm, String wbdm, String jxdm, String qtdm, Double ghf, Double zlf, Boolean zjmz, Short ghxe, Short ygrs, Short yyrs, String ghrq, Short mzks, Boolean tjpb, Double tjf, Byte mzlb, Short jzxh) {
        this.ksmc = ksmc;
        this.ghlb = ghlb;
        this.pydm = pydm;
        this.wbdm = wbdm;
        this.jxdm = jxdm;
        this.qtdm = qtdm;
        this.ghf = ghf;
        this.zlf = zlf;
        this.zjmz = zjmz;
        this.ghxe = ghxe;
        this.ygrs = ygrs;
        this.yyrs = yyrs;
        this.ghrq = ghrq;
        this.mzks = mzks;
        this.tjpb = tjpb;
        this.tjf = tjf;
        this.mzlb = mzlb;
        this.jzxh = jzxh;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="KSDM", unique=true, nullable=false, length=6)

    public String getKsdm() {
        return this.ksdm;
    }
    
    public void setKsdm(String ksdm) {
        this.ksdm = ksdm;
    }
    
    @Column(name="KSMC", length=40)

    public String getKsmc() {
        return this.ksmc;
    }
    
    public void setKsmc(String ksmc) {
        this.ksmc = ksmc;
    }
    
    @Column(name="GHLB", precision=4, scale=0)

    public Short getGhlb() {
        return this.ghlb;
    }
    
    public void setGhlb(Short ghlb) {
        this.ghlb = ghlb;
    }
    
    @Column(name="PYDM", length=6)

    public String getPydm() {
        return this.pydm;
    }
    
    public void setPydm(String pydm) {
        this.pydm = pydm;
    }
    
    @Column(name="WBDM", length=6)

    public String getWbdm() {
        return this.wbdm;
    }
    
    public void setWbdm(String wbdm) {
        this.wbdm = wbdm;
    }
    
    @Column(name="JXDM", length=6)

    public String getJxdm() {
        return this.jxdm;
    }
    
    public void setJxdm(String jxdm) {
        this.jxdm = jxdm;
    }
    
    @Column(name="QTDM", length=6)

    public String getQtdm() {
        return this.qtdm;
    }
    
    public void setQtdm(String qtdm) {
        this.qtdm = qtdm;
    }
    
    @Column(name="GHF", nullable=false, precision=8)

    public Double getGhf() {
        return this.ghf;
    }
    
    public void setGhf(Double ghf) {
        this.ghf = ghf;
    }
    
    @Column(name="ZLF", nullable=false, precision=8)

    public Double getZlf() {
        return this.zlf;
    }
    
    public void setZlf(Double zlf) {
        this.zlf = zlf;
    }
    
    @Column(name="ZJMZ", nullable=false, precision=1, scale=0)

    public Boolean getZjmz() {
        return this.zjmz;
    }
    
    public void setZjmz(Boolean zjmz) {
        this.zjmz = zjmz;
    }
    
    @Column(name="GHXE", nullable=false, precision=4, scale=0)

    public Short getGhxe() {
        return this.ghxe;
    }
    
    public void setGhxe(Short ghxe) {
        this.ghxe = ghxe;
    }
    
    @Column(name="YGRS", nullable=false, precision=4, scale=0)

    public Short getYgrs() {
        return this.ygrs;
    }
    
    public void setYgrs(Short ygrs) {
        this.ygrs = ygrs;
    }
    
    @Column(name="YYRS", nullable=false, precision=4, scale=0)

    public Short getYyrs() {
        return this.yyrs;
    }
    
    public void setYyrs(Short yyrs) {
        this.yyrs = yyrs;
    }
    
    @Column(name="GHRQ")

    public String getGhrq() {
        return this.ghrq;
    }
    
    public void setGhrq(String ghrq) {
        this.ghrq = ghrq;
    }
    
    @Column(name="MZKS", precision=4, scale=0)

    public Short getMzks() {
        return this.mzks;
    }
    
    public void setMzks(Short mzks) {
        this.mzks = mzks;
    }
    
    @Column(name="TJPB", nullable=false, precision=1, scale=0)

    public Boolean getTjpb() {
        return this.tjpb;
    }
    
    public void setTjpb(Boolean tjpb) {
        this.tjpb = tjpb;
    }
    
    @Column(name="TJF", nullable=false, precision=8)

    public Double getTjf() {
        return this.tjf;
    }
    
    public void setTjf(Double tjf) {
        this.tjf = tjf;
    }
    
    @Column(name="MZLB", nullable=false, precision=2, scale=0)

    public Byte getMzlb() {
        return this.mzlb;
    }
    
    public void setMzlb(Byte mzlb) {
        this.mzlb = mzlb;
    }
    
    @Column(name="JZXH", precision=4, scale=0)

    public Short getJzxh() {
        return this.jzxh;
    }
    
    public void setJzxh(Short jzxh) {
        this.jzxh = jzxh;
    }

	public int compareTo(Department o) {
		if(!this.ksdm.equals(o.ksdm)){
			return this.ksdm.compareTo(o.ksdm);
		}else{
			return this.ksmc.compareTo(o.ksmc);
		}
	}
   








}