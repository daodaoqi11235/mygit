package com.hibernate.beans;

// Generated 2016-9-7 19:03:09 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Expertqa generated by hbm2java
 */
public class Expertqa implements java.io.Serializable {

	private Integer questionId;
	private Integer id;
	private String qdescription;
	private Date qtime;
	private String field;
	private Integer expertId;
	private Date atime;
	private String adescription;
	private Integer state;
	private String fee;
	private Boolean isPayed;
	private Date payTime;
	private Integer roleId;

	public Expertqa() {
	}

	public Expertqa(Integer id, String qdescription, Date qtime, String field,
			Integer expertId, Date atime, String adescription, Integer state,
			String fee, Boolean isPayed, Date payTime, Integer roleId) {
		this.id = id;
		this.qdescription = qdescription;
		this.qtime = qtime;
		this.field = field;
		this.expertId = expertId;
		this.atime = atime;
		this.adescription = adescription;
		this.state = state;
		this.fee = fee;
		this.isPayed = isPayed;
		this.payTime = payTime;
		this.roleId = roleId;
	}

	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQdescription() {
		return this.qdescription;
	}

	public void setQdescription(String qdescription) {
		this.qdescription = qdescription;
	}

	public Date getQtime() {
		return this.qtime;
	}

	public void setQtime(Date qtime) {
		this.qtime = qtime;
	}

	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Integer getExpertId() {
		return this.expertId;
	}

	public void setExpertId(Integer expertId) {
		this.expertId = expertId;
	}

	public Date getAtime() {
		return this.atime;
	}

	public void setAtime(Date atime) {
		this.atime = atime;
	}

	public String getAdescription() {
		return this.adescription;
	}

	public void setAdescription(String adescription) {
		this.adescription = adescription;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getFee() {
		return this.fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public Boolean getIsPayed() {
		return this.isPayed;
	}

	public void setIsPayed(Boolean isPayed) {
		this.isPayed = isPayed;
	}

	public Date getPayTime() {
		return this.payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
