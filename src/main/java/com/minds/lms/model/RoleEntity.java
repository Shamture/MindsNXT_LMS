package com.minds.lms.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class RoleEntity implements Serializable{
	
	@NotNull
    @Size(max = 20)
    private long roleId;

    @NotNull
    @Size(max = 20)
    private long subRoleId;
    
    public RoleEntity() {
	
	}
    
    public RoleEntity(long roleId, long subRoleId) {
		this.roleId = roleId;
		this.subRoleId = subRoleId;
	}
    
    public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getSubRoleId() {
		return subRoleId;
	}

	public void setSubRoleId(long subRoleId) {
		this.subRoleId = subRoleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (roleId ^ (roleId >>> 32));
		result = prime * result + (int) (subRoleId ^ (subRoleId >>> 32));
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
		RoleEntity other = (RoleEntity) obj;
		if (roleId != other.roleId)
			return false;
		if (subRoleId != other.subRoleId)
			return false;
		return true;
	}

	


}
