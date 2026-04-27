package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.DiseaseDTO;

public class DiseaseForm extends BaseForm {

	public static final int DIABETES = 1;
	public static final int HYPERTENSION = 2;
	public static final int ASTHMA= 3;
	public static final int TYPHOID = 4;

	@NotEmpty(message = "Disease is required")
	private String disease;

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	@Override
	public BaseDTO getDto() {
		DiseaseDTO dto = initDTO(new DiseaseDTO());
		dto.setDisease(disease);
		return dto;
	}

}
