package com.juanbayon.ln;

import org.springframework.beans.factory.annotation.Autowired;

import com.juanbayon.entites.Milestone;
import com.juanbayon.exceptions.MilestoneException;
import com.juanbayon.ln.interfaces.IMilestones;
import com.juanbayon.repository.MilestoneRepository;

public class Milestones implements IMilestones {
	
	@Autowired
	MilestoneRepository repository;
	
	@Override
	public Iterable<Milestone> getAll() throws MilestoneException {
		
		Iterable<Milestone> milestones;
		
		try {
			milestones = repository.findAll();
		} catch (Exception e) {
			throw new MilestoneException(e.getMessage());
		}
		
		return milestones;
	}
	
	@Override
	public Milestone getOne(Integer id) throws MilestoneException {
		
		Milestone milestone;
		
		try {
			milestone = repository.findById(id).get();
		} catch (Exception e) {
			throw new MilestoneException(e.getMessage());
		}
		
		return milestone;
	}

}
