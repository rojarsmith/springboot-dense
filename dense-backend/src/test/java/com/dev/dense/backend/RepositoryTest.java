/*
 * Copyright (C)
 *
 * @author Rojar Smith
 * @date 2023-10-03
 */
package com.dev.dense.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dev.dense.backend.domain.Permission;
import com.dev.dense.backend.repository.PermissionRepository;

@SpringBootTest
public class RepositoryTest {

	@Autowired
	PermissionRepository permissionRepository;

	@Test
	void testPermissionRepository() {
		Permission p1 = new Permission();
		p1.setId(1L);
		p1.setName("permission1");
		p1.setDescription("Permission 1");
		p1.setUri("/test1");
		p1.setMethod("read");
		permissionRepository.save(p1);

		Optional<Permission> p = permissionRepository.findByNameNative("permission1");
		assertEquals(p.get(), p1);
	}

}
