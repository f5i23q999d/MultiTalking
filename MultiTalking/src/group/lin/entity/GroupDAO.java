package group.lin.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class GroupDAO implements Serializable {
	protected int groupId,foundId;
	protected String groupName;
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getFoundId() {
		return foundId;
	}
	public void setFoundId(int foundId) {
		this.foundId = foundId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
