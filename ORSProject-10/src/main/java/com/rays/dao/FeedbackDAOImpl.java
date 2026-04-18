package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.FeedbackDTO;

@Repository
public class FeedbackDAOImpl extends BaseDAOImpl<FeedbackDTO> implements FeedbackDAOInt {

	@Override
	public Class<FeedbackDTO> getDTOClass() {
		return FeedbackDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(FeedbackDTO dto, CriteriaBuilder builder, Root<FeedbackDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if (!isEmptyString(dto.getFeedbackFormId())) {

			whereCondition.add(builder.like(qRoot.get("feedbackFormId"), dto.getFeedbackFormId() + "%"));
		}

		if (!isEmptyString(dto.getParticipantName())) {

			whereCondition.add(builder.like(qRoot.get("participantName"), dto.getParticipantName() + "%"));
		}

		return whereCondition;
	}

}
