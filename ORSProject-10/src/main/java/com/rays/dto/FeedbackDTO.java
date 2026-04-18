package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;
@Entity
@Table(name="st_feedback")
public class FeedbackDTO extends BaseDTO{

	@Column(name="feedbackFormId")
	private String feedbackFormId;
	
	@Column(name="participantName")
	private String participantName;

	@Column(name="rating")
	private Integer rating;
	
	@Column(name="comments")
	private String comments;
	
	
	public String getFeedbackFormId() {
		return feedbackFormId;
	}

	public void setFeedbackFormId(String feedbackFormId) {
		this.feedbackFormId = feedbackFormId;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String getValue() {
		return feedbackFormId;
	}

	@Override
	public String getUniqueKey() {
		return "feedbackFormId";
	}

	@Override
	public String getUniqueValue() {
		return feedbackFormId;
	}

	@Override
	public String getLabel() {
		return "feedbackFormId";
	}

	@Override
	public String getTableName() {
		return "feedback";
	}

}
