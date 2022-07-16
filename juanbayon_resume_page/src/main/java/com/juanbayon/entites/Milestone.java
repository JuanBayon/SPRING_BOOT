package com.juanbayon.entites;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Milestone {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="startDate", nullable=false)
	private Date startDate;
	
	@Column(name="finishDate")
	private Date finishDate;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="institution", nullable=false)
	private String institution;

}
