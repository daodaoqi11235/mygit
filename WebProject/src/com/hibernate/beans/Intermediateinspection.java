package com.hibernate.beans;

// Generated 2016-9-3 16:59:19 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Intermediateinspection generated by hbm2java
 */
public class Intermediateinspection implements java.io.Serializable {

	private int coverOfIntermediateInspectionId;
	private String p1;
	private String p2;
	private String p3;
	private String p4;
	private Date p5;
	private Date p6;
	private Date p7;
	private String p8;
	private String p9;

	public Intermediateinspection() {
		this.p1="";
		this.p2="";
		this.p3="";
		this.p4="";

		this.p8="";
		this.p9="";
	}

	public Intermediateinspection(int coverOfIntermediateInspectionId) {
		this.coverOfIntermediateInspectionId = coverOfIntermediateInspectionId;
	}

	public Intermediateinspection(int coverOfIntermediateInspectionId,
			String p1, String p2, String p3, String p4, Date p5, Date p6,
			Date p7, String p8, String p9) {
		this.coverOfIntermediateInspectionId = coverOfIntermediateInspectionId;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.p5 = p5;
		this.p6 = p6;
		this.p7 = p7;
		this.p8 = p8;
		this.p9 = p9;
	}

	public int getCoverOfIntermediateInspectionId() {
		return this.coverOfIntermediateInspectionId;
	}

	public void setCoverOfIntermediateInspectionId(
			int coverOfIntermediateInspectionId) {
		this.coverOfIntermediateInspectionId = coverOfIntermediateInspectionId;
	}

	public String getP1() {
		return this.p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}

	public String getP2() {
		return this.p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}

	public String getP3() {
		return this.p3;
	}

	public void setP3(String p3) {
		this.p3 = p3;
	}

	public String getP4() {
		return this.p4;
	}

	public void setP4(String p4) {
		this.p4 = p4;
	}

	public Date getP5() {
		return this.p5;
	}

	public void setP5(Date p5) {
		this.p5 = p5;
	}

	public Date getP6() {
		return this.p6;
	}

	public void setP6(Date p6) {
		this.p6 = p6;
	}

	public Date getP7() {
		return this.p7;
	}

	public void setP7(Date p7) {
		this.p7 = p7;
	}

	public String getP8() {
		return this.p8;
	}

	public void setP8(String p8) {
		this.p8 = p8;
	}

	public String getP9() {
		return this.p9;
	}

	public void setP9(String p9) {
		this.p9 = p9;
	}

}