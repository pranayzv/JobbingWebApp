package model;

public class Employee {

	private String username;
	private String password;
	private String qualification;
	private int experience;
	private String gender;
	private long mob;
	
	public Employee(String fullname, String username, String password, String qualification, int experience,
			String gender, long mob) {
		super();
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.qualification = qualification;
		this.experience = experience;
		this.gender = gender;
		this.mob = mob;
	}
	
	private String fullname;
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getMob() {
		return mob;
	}
	public void setMob(long mob) {
		this.mob = mob;
	}

}
