package com.juanbayon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juanbayon.entites.Milestone;

public interface MilestoneRepository extends JpaRepository<Milestone, Integer> {

}
