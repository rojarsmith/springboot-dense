/*
 * Copyright (C)
 *
 * @author Rojar Smith
 * @date 2023-10-02
 */
package com.dev.dense.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.dense.backend.domain.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

	public Permission findByName(String name);

}
