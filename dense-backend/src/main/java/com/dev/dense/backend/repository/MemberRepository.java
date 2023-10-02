/*
 * Copyright (C)
 *
 * @author Rojar Smith
 * @date 2023-10-02
 */
package com.dev.dense.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.dense.backend.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	public Member getByUsername(String username);

	public Member findByEmail(String email);

	public Member findByUsername(String username);

}
