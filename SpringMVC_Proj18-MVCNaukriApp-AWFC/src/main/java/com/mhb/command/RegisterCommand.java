package com.mhb.command;

public class RegisterCommand {
private String name;
private String addrs;
private int age;
private int exp;
private String skillDomain;
private String location;
private int expSalary;

public int getExpSalary() {
	return expSalary;
}
public void setExpSalary(int expSalary) {
	this.expSalary = expSalary;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddrs() {
	return addrs;
}
public void setAddrs(String addrs) {
	this.addrs = addrs;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getExp() {
	return exp;
}
public void setExp(int exp) {
	this.exp = exp;
}
public String getSkillDomain() {
	return skillDomain;
}
public void setSkillDomain(String skillDomain) {
	this.skillDomain = skillDomain;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
@Override
public String toString() {
	return "RegisterCommand [name=" + name + ", addrs=" + addrs + ", age=" + age + ", exp=" + exp + ", skillDomain="
			+ skillDomain + ", location=" + location + ", expSalary=" + expSalary + "]";
}


}
