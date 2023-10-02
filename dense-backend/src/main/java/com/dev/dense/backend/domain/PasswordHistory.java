/*
 * Copyright (C)
 *
 * @author Rojar Smith
 * @date 2023-10-02
 */
package com.dev.dense.backend.domain;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@DynamicUpdate
public class PasswordHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String password;

	@Override
	public String toString() {
		return this.password;
	}

}
