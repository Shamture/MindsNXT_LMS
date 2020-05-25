package com.minds.lms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentAssignmentPK implements Serializable{
	
	@Column(name = "user_id")
    private Long user_id;

    @Column(name = "assignment_id")
    private Long assignment_id;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getAssignment_id() {
		return assignment_id;
	}

	public void setAssignment_id(Long assignment_id) {
		this.assignment_id = assignment_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignment_id == null) ? 0 : assignment_id.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentAssignmentPK other = (StudentAssignmentPK) obj;
		if (assignment_id == null) {
			if (other.assignment_id != null)
				return false;
		} else if (!assignment_id.equals(other.assignment_id))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

}
