package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.FeedbackDAOInt;
import com.rays.dto.FeedbackDTO;

@Service
public class FeedbackServiceImpl extends BaseServiceImpl<FeedbackDTO, FeedbackDAOInt> implements FeedbackServiceInt {

}
