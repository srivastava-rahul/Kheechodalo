package com.click.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "KD_USER_PROFILE")

public class ProfileSetting {
	
	private static final long serialVersionUID = -6598843564851420989L;

	@Id
	@Column(name = "ID")
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@GeneratedValue(generator = "idGen")
	private String id;

	@Column(name = "USER_NAME_SURNAME", length = 100)
	private String name_surname;
	
	@Column(name = "USER_DOB")
	private Date dob;
	
	@Column(name = "USER_EMAIL_ID")
	private String  email_id;
	
	@Column(name = "USER_PHONE")
	private long  phone;
	
	@Column(name = "USER_PHONE_FLAGE")
	private boolean phone_flage=false;
	
	@Column(name = "USER_GENDER")
	private String  gender;
	
	@Column(name = "USER_DAILY_STATUS")
	private String  daily_status;

	@Column(name = "USER_NATIVE_PLACE")
	private String native_place;
	
	@Column(name = "USER_LIVE_IN")
	private String live_in;
	
	@Column(name = "USER_COUNTRY")
	private String  country;
	
	@Column(name = "USER_RELATIONSHIP")
	private String  relationship;

	@Column(name = "USER_POST_GRADURATION")
	private String  post_graduration;
	
	@Column(name = "USER_GRADURATION")
	private String graduration;
	
	@Column(name = "USER_SECONDARY_SCHOOL")
	private String  secondary_school;
	
	@Column(name = "USER_HIGH_SCHOOL")
	private String high_school;

	@Column(name = "USER_WORK_PLACE")
	private String  work_place;
	
	@Column(name = "USER_WORK_EXPERIENCE")
	private String  work_experience;
	
	@Column(name = "USER_SKILL")
	private String skill;

	@Column(name = "USER_BIRTH_PLACE")
	private String birth_place;
	
	@Column(name = "USER_RELIGIOUS_VIEW")
	private String religious_view;
	
	@Column(name = "USER_PAYTM")
	private String paytm;
	
	@Column(name = "USER_PAYTM_FLAGE")
	private boolean paytm_flage=false;

	@Column(name = "USER_ADDRESS")
	private String address;
	
	@Column(name = "USER_ADDRESS_FLAGE")
	private boolean address_flage =false;
	
	@Column(name = "USER_HOBBIES")
	private String hobbies;
	
	@Column(name = "USER_FAVOURITE_FOOD")
	private String  favourite_food;
	
	@Column(name = "USER_FAVOURITE_SINGER")
	private String favourite_singer;
	
	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	@Column(name = "USER_FAVOURITE_MOVIES")
	private String favourite_movies;
	
	@Column(name = "USER_FAVOURITE_DAILY_SOAP")
	private String favourite_daily_soap;
	
	@Column(name = "USER_FAVOURITE_AUTHOR")
	private String favourite_author;
	
	@Lob
	@Column(name = "FILE_DATA")
	private byte[] fileData;


	public ProfileSetting(){}

	public ProfileSetting(String name_surname, Date dob, String email_id, long phone, boolean phone_flage,
			String gender, String daily_status, String native_place, String live_in, String country, String relationship,
			String post_graduration, String graduration, String secondary_school, String high_school, String work_place,
			String work_experience, String skill, String birth_place, String religious_view, String paytm,
			boolean paytm_flage, String address, boolean address_flage, String hobbies, String favourite_food,
			String favourite_singer, String favourite_movies, String favourite_daily_soap, String favourite_author) {
		super();
		this.name_surname = name_surname;
		this.dob = dob;
		this.email_id = email_id;
		this.phone = phone;
		this.phone_flage = phone_flage;
		this.gender = gender;
		this.daily_status = daily_status;
		this.native_place = native_place;
		this.live_in = live_in;
		this.country = country;
		this.relationship = relationship;
		this.post_graduration = post_graduration;
		this.graduration = graduration;
		this.secondary_school = secondary_school;
		this.high_school = high_school;
		this.work_place = work_place;
		this.work_experience = work_experience;
		this.skill = skill;
		this.birth_place = birth_place;
		this.religious_view = religious_view;
		this.paytm = paytm;
		this.paytm_flage = paytm_flage;
		this.address = address;
		this.address_flage = address_flage;
		this.hobbies = hobbies;
		this.favourite_food = favourite_food;
		this.favourite_singer = favourite_singer;
		this.favourite_movies = favourite_movies;
		this.favourite_daily_soap = favourite_daily_soap;
		this.favourite_author = favourite_author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName_surname() {
		return name_surname;
	}

	public void setName_surname(String name_surname) {
		this.name_surname = name_surname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public boolean isPhone_flage() {
		return phone_flage;
	}

	public void setPhone_flage(boolean phone_flage) {
		this.phone_flage = phone_flage;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDaily_status() {
		return daily_status;
	}

	public void setDaily_status(String daily_status) {
		this.daily_status = daily_status;
	}

	public String getNative_place() {
		return native_place;
	}

	public void setNative_place(String native_place) {
		this.native_place = native_place;
	}

	public String getLive_in() {
		return live_in;
	}

	public void setLive_in(String live_in) {
		this.live_in = live_in;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getPost_graduration() {
		return post_graduration;
	}

	public void setPost_graduration(String post_graduration) {
		this.post_graduration = post_graduration;
	}

	public String getGraduration() {
		return graduration;
	}

	public void setGraduration(String graduration) {
		this.graduration = graduration;
	}

	public String getSecondary_school() {
		return secondary_school;
	}

	public void setSecondary_school(String secondary_school) {
		this.secondary_school = secondary_school;
	}

	public String getHigh_school() {
		return high_school;
	}

	public void setHigh_school(String high_school) {
		this.high_school = high_school;
	}

	public String getWork_place() {
		return work_place;
	}

	public void setWork_place(String work_place) {
		this.work_place = work_place;
	}

	public String getWork_experience() {
		return work_experience;
	}

	public void setWork_experience(String work_experience) {
		this.work_experience = work_experience;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getBirth_place() {
		return birth_place;
	}

	public void setBirth_place(String birth_place) {
		this.birth_place = birth_place;
	}

	public String getReligious_view() {
		return religious_view;
	}

	public void setReligious_view(String religious_view) {
		this.religious_view = religious_view;
	}

	public String getPaytm() {
		return paytm;
	}

	public void setPaytm(String paytm) {
		this.paytm = paytm;
	}

	public boolean isPaytm_flage() {
		return paytm_flage;
	}

	public void setPaytm_flage(boolean paytm_flage) {
		this.paytm_flage = paytm_flage;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isAddress_flage() {
		return address_flage;
	}

	public void setAddress_flage(boolean address_flage) {
		this.address_flage = address_flage;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getFavourite_food() {
		return favourite_food;
	}

	public void setFavourite_food(String favourite_food) {
		this.favourite_food = favourite_food;
	}

	public String getFavourite_singer() {
		return favourite_singer;
	}

	public void setFavourite_singer(String favourite_singer) {
		this.favourite_singer = favourite_singer;
	}

	public String getFavourite_movies() {
		return favourite_movies;
	}

	public void setFavourite_movies(String favourite_movies) {
		this.favourite_movies = favourite_movies;
	}

	public String getFavourite_daily_soap() {
		return favourite_daily_soap;
	}

	public void setFavourite_daily_soap(String favourite_daily_soap) {
		this.favourite_daily_soap = favourite_daily_soap;
	}

	public String getFavourite_author() {
		return favourite_author;
	}

	public void setFavourite_author(String favourite_author) {
		this.favourite_author = favourite_author;
	}

	public String toLogString() {
		return "UserProfileSetting [id=" + id + ", name_surname=" + name_surname + ", dob=" + dob + ", email_id="
				+ email_id + ", phone=" + phone + ", phone_flage=" + phone_flage + ", gender=" + gender
				+ ", daily_status=" + daily_status + ", native_place=" + native_place + ", live_in=" + live_in
				+ ", country=" + country + ", relationship=" + relationship + ", post_graduration=" + post_graduration
				+ ", graduration=" + graduration + ", secondary_school=" + secondary_school + ", high_school="
				+ high_school + ", work_place=" + work_place + ", work_experience=" + work_experience + ", skill="
				+ skill + ", birth_place=" + birth_place + ", religious_view=" + religious_view + ", paytm=" + paytm
				+ ", paytm_flage=" + paytm_flage + ", address=" + address + ", address_flage=" + address_flage
				+ ", hobbies=" + hobbies + ", favourite_food=" + favourite_food + ", favourite_singer="
				+ favourite_singer + ", favourite_movies=" + favourite_movies + ", favourite_daily_soap="
				+ favourite_daily_soap + ", favourite_author=" + favourite_author + "]";
	}
	
	
}
