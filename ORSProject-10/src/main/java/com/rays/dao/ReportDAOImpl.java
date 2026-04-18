
package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ReportDTO;

@Repository
public class ReportDAOImpl extends BaseDAOImpl<ReportDTO> implements ReportDAOInt {

	@Override
	public Class<ReportDTO> getDTOClass() {
		return ReportDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(ReportDTO dto, CriteriaBuilder builder, Root<ReportDTO> qRoot) {
List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if (isNotNull(dto.getGeneratedDate())) {

			whereCondition.add(builder.equal(qRoot.get("generatedDate"), dto.getGeneratedDate()));
		}

		if (!isEmptyString(dto.getRemarks())) {

			whereCondition.add(builder.like(qRoot.get("remarks"), dto.getRemarks() + "%"));
		}
		
		if (!isEmptyString(dto.getReportType())) {

			whereCondition.add(builder.like(qRoot.get("reportType"), dto.getReportType() + "%"));
		}

		return whereCondition;
	}
	}

	

