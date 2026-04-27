package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.DiseaseDTO;
import com.rays.dto.DivisionDTO;
import com.rays.dto.PatientDTO;
import com.rays.form.PatientForm;
import com.rays.service.DiseaseServiceInt;
import com.rays.service.DivisionServiceInt;
import com.rays.service.PatientServiceInt;

@RestController
@RequestMapping(value="Patient")
public class PatientCtl extends BaseCtl<PatientForm, PatientDTO, PatientServiceInt> {

	@Autowired
	DiseaseServiceInt diseaseService = null;
	
	
	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		DiseaseDTO dto = new DiseaseDTO();
		List<DropdownList> list = diseaseService.search(dto, userContext);
		res.addResult("diseaseList", list);
		return res;
	}
}
