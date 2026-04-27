package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_disease")
public class DiseaseDTO extends BaseDTO {

	@Column(name = "disease")
	private String disease;

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	@Override
	public String getValue() {
		return disease;
	}

	@Override
	public String getUniqueKey() {
		return "disease";
	}

	@Override
	public String getUniqueValue() {
		return disease;
	}

	@Override
	public String getLabel() {
		return "Disease";
	}

	@Override
	public String getTableName() {
		return "Disease";
	}

}
