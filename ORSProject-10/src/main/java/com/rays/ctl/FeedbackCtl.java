package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.FeedbackDTO;
import com.rays.form.FeedbackForm;
import com.rays.service.FeedbackServiceInt;

@RestController
@RequestMapping(value="Feedback")
public class FeedbackCtl extends BaseCtl<FeedbackForm, FeedbackDTO, FeedbackServiceInt> {

}
