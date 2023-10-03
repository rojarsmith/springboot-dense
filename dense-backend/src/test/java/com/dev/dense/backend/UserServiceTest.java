/*
 * Copyright (C)
 *
 * @author Rojar Smith
 * @date 2023-10-02
 */
package com.dev.dense.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dev.dense.backend.domain.Permission;
import com.dev.dense.backend.service.UserService;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	UserService userService;

	@Test
	void testPermission() {
		List<Permission> ps = new ArrayList<>();

		Permission p1 = new Permission();
		p1.setId(1L);
		p1.setName("permission1");
		p1.setDescription("Permission 1");
		p1.setUri("/test1");
		p1.setMethod("read");
		ps.add(p1);

		Permission p2 = new Permission();
		p2.setId(2L);
		p2.setName("permission2");
		p2.setDescription("Permission 2");
		p2.setUri("/test2");
		p2.setMethod("read, write");
		ps.add(p2);

		boolean created = userService.createPermission(p2);
		assertEquals(created, true);

		boolean updated = userService.updatePermissions(ps);
		assertEquals(updated, true);

		p2.setName("permission2a");
		userService.updatePermission(p2);
		ps = userService.readPermissions();
		assertEquals(ps.size(), 2);

		userService.deletePermission(p2.getId());
		ps = userService.readPermissions();
		assertEquals(ps.size(), 1);
	}

}
