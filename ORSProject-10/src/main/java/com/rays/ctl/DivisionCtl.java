package com.rays.ctl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.DivisionDTO;
import com.rays.dto.RoleDTO;
import com.rays.form.DivisionForm;
import com.rays.service.DivisionServiceInt;

@RestController
@RequestMapping(value="Division")
public class DivisionCtl extends BaseCtl<DivisionForm, DivisionDTO, DivisionServiceInt>{

	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		DivisionDTO dto = new DivisionDTO();
		List<DropdownList> list = baseService.search(dto, userContext);
		res.addResult("divisionList", list);
		return res;
	}
}
