/*
 * Copyright (C)
 *
 * @author Rojar Smith
 * @date 2023-10-02
 */
package com.dev.dense.backend.domain;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
@DynamicUpdate
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 40)
	private String name;

	private String description;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( //
			name = "role_permission", //
			joinColumns = @JoinColumn(name = "role_id"), //
			inverseJoinColumns = @JoinColumn(name = "permission_id") //
	)
	private Set<Permission> permissions = new HashSet<>();

	@Override
	public String toString() {
		return this.name;
	}

}
