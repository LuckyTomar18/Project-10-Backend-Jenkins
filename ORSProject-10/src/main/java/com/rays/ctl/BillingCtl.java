package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.BillingDTO;
import com.rays.form.BillingForm;
import com.rays.service.BillingServiceInt;

@RestController
@RequestMapping(value="Billing")
public class BillingCtl extends BaseCtl<BillingForm, BillingDTO, BillingServiceInt> {

}
