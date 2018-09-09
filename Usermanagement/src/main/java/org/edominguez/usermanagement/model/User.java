package org.edominguez.usermanagement.model;


import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="User Model for CRUD Operations")
@Entity
public class User extends ResourceSupport{
	
	

	@ApiModelProperty(position = 0, required = true, value = "Primary Key")
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ApiModelProperty(position = 1, required = true, value = "User First Name")
	@Column(name="first_name")
	@NotBlank
    @Size(min = 1, max = 20)
	private String firstName;
	
	@ApiModelProperty(position = 2, required = true, value = "User Last Name")
	@Column(name="last_name")
	@NotBlank
    @Size(min = 1, max = 20)
	private String lastName;
	

	public Long getid() {
		return id;
	}

	public void setid(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	

}
