package group.lin.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class GroupDAO implements Serializable {
	protected String userId;
	protected int groupId;
	protected String foundId;
	protected String groupName;
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getFoundId() {
		return foundId;
	}
	public void setFoundId(String foundId) {
		this.foundId = foundId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
