package com.model.db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AdvertInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_advert_info", catalog = "test")
public class AdvertInfo implements java.io.Serializable,
		Comparable<AdvertInfo>, Cloneable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String advertName;
	private Integer playTime;
	private String relUrl;
	private Short priority;
	private Short isEffective;
	private Date upShelfTime;
	private Date downShelfTime;
	private Date createTime;
	private Date lastUpdateTime;

	// Constructors

	/** default constructor */
	public AdvertInfo() {
	}

	/** minimal constructor */
	public AdvertInfo(String advertName, Short priority, Date createTime,
			Date lastUpdateTime) {
		this.advertName = advertName;
		this.priority = priority;
		this.createTime = createTime;
		this.lastUpdateTime = lastUpdateTime;
	}

	/** full constructor */
	public AdvertInfo(String advertName, Integer playTime, String relUrl,
			Short priority, Short isEffective, Date upShelfTime,
			Date downShelfTime, Date createTime, Date lastUpdateTime) {
		this.advertName = advertName;
		this.playTime = playTime;
		this.relUrl = relUrl;
		this.priority = priority;
		this.isEffective = isEffective;
		this.upShelfTime = upShelfTime;
		this.downShelfTime = downShelfTime;
		this.createTime = createTime;
		this.lastUpdateTime = lastUpdateTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "AdvertName", nullable = false, length = 50)
	public String getAdvertName() {
		return this.advertName;
	}

	public void setAdvertName(String advertName) {
		this.advertName = advertName;
	}

	@Column(name = "PlayTime")
	public Integer getPlayTime() {
		return this.playTime;
	}

	public void setPlayTime(Integer playTime) {
		this.playTime = playTime;
	}

	@Column(name = "RelUrl", length = 100)
	public String getRelUrl() {
		return this.relUrl;
	}

	public void setRelUrl(String relUrl) {
		this.relUrl = relUrl;
	}

	@Column(name = "Priority", nullable = false)
	public Short getPriority() {
		return this.priority;
	}

	public void setPriority(Short priority) {
		this.priority = priority;
	}

	@Column(name = "IsEffective")
	public Short getIsEffective() {
		return this.isEffective;
	}

	public void setIsEffective(Short isEffective) {
		this.isEffective = isEffective;
	}

	@Column(name = "UpShelfTime", length = 19)
	public Date getUpShelfTime() {
		return this.upShelfTime;
	}

	public void setUpShelfTime(Date upShelfTime) {
		this.upShelfTime = upShelfTime;
	}

	@Column(name = "DownShelfTime", length = 19)
	public Date getDownShelfTime() {
		return this.downShelfTime;
	}

	public void setDownShelfTime(Date downShelfTime) {
		this.downShelfTime = downShelfTime;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "LastUpdateTime", nullable = false, length = 19)
	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public int compareTo(AdvertInfo o) {
		return this.priority.compareTo(o.priority);
	}

	public AdvertInfo clone() {
		try {
			return (AdvertInfo) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}