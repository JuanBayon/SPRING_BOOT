package com.juanbayon.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.Type;

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
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Lob
    @Column(name="image", nullable=false)
	@Type(type = "org.hibernate.type.BinaryType")
    private byte[] image;

}
