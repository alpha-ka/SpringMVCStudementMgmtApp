package com.alpha.sm.dto;

public class StudentDTO {
	private Integer id;
	private String name;
	private Long mobile;
	private String country;

	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDTO(Integer id, String name, Long mobile, String country) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", name=" + name + ", mobile=" + mobile + ", country=" + country + "]";
	}

}
