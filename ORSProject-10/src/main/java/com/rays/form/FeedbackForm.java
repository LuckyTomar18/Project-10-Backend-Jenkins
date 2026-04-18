package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.FeedbackDTO;

public class FeedbackForm extends BaseForm {

	@NotEmpty (message = "Feedback FormId  is required")
	private String feedbackFormId;
	
	@NotEmpty (message = "Participant Name   is required")
	private String participantName;
	
	@NotNull  (message = "Rating is required")
	private Integer rating;
	
	@NotNull (message = "comments is required")
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
	public BaseDTO getDto() {

		FeedbackDTO dto = initDTO(new FeedbackDTO());
		dto.setFeedbackFormId(feedbackFormId);
		dto.setParticipantName(participantName);
		dto.setRating(rating);
		dto.setComments(comments);

		return dto;
	}
}
