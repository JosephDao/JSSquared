package com.revature.beans;

import java.sql.Date;

public class Cases {
	private int caseid;
	private String firstname;
	private String lastname;
	private Date birthdate;
	private int rating;
	private int socialworkerid;
	private int placementid;
	
	public Cases() {
		super();
	}

	public Cases(int caseid, String firstname, String lastname, Date birthdate, int rating, int socialworkerid,
			int placementid) {
		super();
		this.caseid = caseid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.rating = rating;
		this.socialworkerid = socialworkerid;
		this.placementid = placementid;
	}

	public int getCaseid() {
		return caseid;
	}

	public void setCaseid(int caseid) {
		this.caseid = caseid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getSocialworkerid() {
		return socialworkerid;
	}

	public void setSocialworkerid(int socialworkerid) {
		this.socialworkerid = socialworkerid;
	}

	public int getPlacementid() {
		return placementid;
	}

	public void setPlacementid(int placementid) {
		this.placementid = placementid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + caseid;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + placementid;
		result = prime * result + rating;
		result = prime * result + socialworkerid;
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
		Cases other = (Cases) obj;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (caseid != other.caseid)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (placementid != other.placementid)
			return false;
		if (rating != other.rating)
			return false;
		if (socialworkerid != other.socialworkerid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cases [caseid=" + caseid + ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate="
				+ birthdate + ", rating=" + rating + ", socialworkerid=" + socialworkerid + ", placementid="
				+ placementid + "]";
	}
	
}
