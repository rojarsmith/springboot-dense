/*
 * Copyright (C)
 *
 * @author Rojar Smith
 * @date 2023-10-02
 */
package com.dev.dense.backend.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CascadeType;
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
@SuppressWarnings("unused")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String password;

	private Boolean enabled = true;

	private Boolean accountNonExpired = true;

	private Boolean credentialsNonExpired = true;

	private Boolean accountNonLocked = true;

	private String email;

	private String name;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( //
			name = "member_role", //
			joinColumns = @JoinColumn(name = "member_id"), //
			inverseJoinColumns = @JoinColumn(name = "role_id") //
	)
	private Set<Role> roles = new HashSet<>();

	@Column(name = "password_changed_time")
	private Date passwordChangedTime;

	@Column(name = "failed_attempt")
	private int failedAttempt;

	@Column(name = "lock_time")
	private Date lockTime;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable( //
			name = "member_history", //
			joinColumns = @JoinColumn(name = "member_id"), //
			inverseJoinColumns = @JoinColumn(name = "history_id") //
	)
	private Set<PasswordHistory> historys = new HashSet<>();

}
