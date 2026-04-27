package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_patient")
public class PatientDTO extends BaseDTO{

	

	@Column(name="patient_code")
	private String patientCode;
	
	@Column(name="patient_name")
	private String patientName;
	
	@Column(name="phone")
	private String Phone;
	
	@Column(name="disease_name")
	private String diseaseName = null;
	
	@Column(name="disease_id")
	private Long diseaseId;
	
	@Column(name="patient_condition")
	private String Condition;
	
	
	public String getPatientCode() {
		return patientCode;
	}
	public void setPatientCode(String patientCode) {
		this.patientCode = patientCode;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public Long getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(Long diseaseId) {
		this.diseaseId = diseaseId;
	}
	public String getCondition() {
		return Condition;
	}
	public void setCondition(String condition) {
		Condition = condition;
	}
	@Override
	public String getValue() {
		return null;
	}
	@Override
	public String getUniqueKey() {
		return "patientCode";
	}
	@Override
	public String getUniqueValue() {
		return patientCode;
	}
	@Override
	public String getLabel() {
		return "patientCode";
	}
	@Override
	public String getTableName() {
		return "Patient";
	}
	
	
	
	
	
	
}
