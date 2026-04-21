package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.AuditDTO;
import com.rays.form.AuditForm;
import com.rays.service.AuditServiceInt;

@RestController
@RequestMapping(value="Audit")
public class AuditCtl extends BaseCtl<AuditForm, AuditDTO, AuditServiceInt>{

}
