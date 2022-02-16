package model;

public class Company {
	
	private String cname;
	private String password;
	private String postname;
	private String jobdesc;
	private int experience;
	private long salary;

	public Company(String cname, String password, String postname, String jobdesc, int experience, long salary) {
		super();
		this.cname = cname;
		this.password = password;
		this.postname = postname;
		this.jobdesc = jobdesc;
		this.experience = experience;
		this.salary = salary;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPostname() {
		return postname;
	}

	public void setPostname(String postname) {
		this.postname = postname;
	}

	public String getJobdesc() {
		return jobdesc;
	}

	public void setJobdesc(String jobdesc) {
		this.jobdesc = jobdesc;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	

}
