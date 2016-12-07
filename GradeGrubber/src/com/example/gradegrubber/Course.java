package com.example.gradegrubber;

public class Course {

	private String cname;

	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * @param cname
	 */
	public Course(String cname) {
		super();
		this.cname = cname;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Course [cname=" + cname + "]";
	}
	
}
