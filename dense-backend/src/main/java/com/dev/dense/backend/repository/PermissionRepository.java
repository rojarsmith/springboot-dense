/*
 * Copyright (C)
 *
 * @author Rojar Smith
 * @date 2023-10-02
 */
package com.dev.dense.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.dense.backend.domain.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

	public Optional<Permission> findByName(String name);

	@Query(nativeQuery = true, value = "SELECT * FROM Permission as e WHERE e.name IN (:name)")
	public Optional<Permission> findByNameNative(@Param("name") String name);

}
