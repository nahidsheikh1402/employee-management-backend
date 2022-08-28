package com.poc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.ToString;

/**
 * @author Nahid Sheikh
 * @since 26-August-2022
 *
 */
@Data
@ToString
@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(columnDefinition = "CHAR(32)")
	private String id;

	private boolean active;

	private Long createdAt;

	private Long modifiedAt;

	private String createdBy;

	private String modifiedBy;

	private boolean deleted;

	public BaseEntity() {
		this.setActive(true);
		this.createdAt = new Date().getTime();
		this.modifiedAt = this.createdAt;
		this.setDeleted(false);
	}
}
