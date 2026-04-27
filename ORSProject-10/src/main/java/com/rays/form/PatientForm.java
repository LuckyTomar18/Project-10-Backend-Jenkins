package com.rays.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.PatientDTO;

public class PatientForm extends BaseForm {

	@NotEmpty(message="Patient Code is required")
	private String patientCode;

	@NotEmpty(message="Patient Name is required")
	private String patientName;

	@NotEmpty(message="Phone is required")
	private String phone;

	private String diseaseName = null;

	@NotNull(message = "DiseaseId is required")
	@Min(1)
	private Long diseaseId;

	@NotEmpty(message="Condition Code is required")
	private String condition;

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
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public BaseDTO getDto() {

		PatientDTO dto = initDTO(new PatientDTO());
		
		dto.setPatientCode(patientCode);
		dto.setPatientName(patientName);
		dto.setPhone(phone);
		dto.setDiseaseName(diseaseName);
		dto.setDiseaseName(diseaseName);
		dto.setCondition(condition);
		return dto;
	}
}
