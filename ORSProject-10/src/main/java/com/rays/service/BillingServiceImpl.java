package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.BillingDAOInt;
import com.rays.dto.BillingDTO;

@Service
@Transactional
public class BillingServiceImpl extends BaseServiceImpl<BillingDTO, BillingDAOInt> implements BillingServiceInt {

}
