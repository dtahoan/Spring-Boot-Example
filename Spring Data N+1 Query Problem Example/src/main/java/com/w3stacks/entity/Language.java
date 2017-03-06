package com.w3stacks.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "languages")
public class Language implements Serializable {

	private static final long serialVersionUID = -6871880136807445659L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;
	
//	@OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
//	private List<Framework> frameworks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Framework> getFrameworks() {
//		return frameworks;
//	}
//
//	public void setFrameworks(List<Framework> frameworks) {
//		this.frameworks = frameworks;
//	}
	
	
}
