package com.mhb.command;

public class UserCommand {
private int UserId;
private String userName;
private String addrs;
public int getUserId() {
	return UserId;
}
public void setUserId(int userId) {
	UserId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getAddrs() {
	return addrs;
}
public void setAddrs(String addrs) {
	this.addrs = addrs;
}
@Override
public String toString() {
	return "UserCommand [UserId=" + UserId + ", userName=" + userName + ", addrs=" + addrs + "]";
}

}
