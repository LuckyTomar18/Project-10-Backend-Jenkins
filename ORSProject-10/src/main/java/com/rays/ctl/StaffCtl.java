package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.DivisionDTO;
import com.rays.dto.StaffDTO;
import com.rays.form.StaffForm;
import com.rays.service.DivisionServiceInt;
import com.rays.service.StaffServiceInt;

@RestController
@RequestMapping(value ="Staff")
public class StaffCtl extends BaseCtl<StaffForm, StaffDTO, StaffServiceInt> {

	@Autowired
	DivisionServiceInt divisionService = null;
	
	
	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		DivisionDTO dto = new DivisionDTO();
		List<DropdownList> list = divisionService.search(dto, userContext);
		res.addResult("divisionList", list);
		return res;
	}
}
