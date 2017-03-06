package com.w3stacks.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

@Entity
@NamedEntityGraph(
		
		name = "graph.FrameworkLanguage",
		
		attributeNodes = {
				@NamedAttributeNode(value = "language")
		})
@Table(name = "frameworks")
public class Framework implements Serializable {

	private static final long serialVersionUID = -3916323453835805659L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "classification")
	private String classification;
	
	@ManyToOne
	@JoinColumn(name = "language_id", nullable = false)
	private Language language;

	public Framework() {
		super();
	}
	
	public Framework(String name, String classification) {
		super();
		this.name = name;
		this.classification = classification;
	}
	
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

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	
}
