package com.juanbayon.ln.interfaces;

import com.juanbayon.entites.Milestone;
import com.juanbayon.exceptions.MilestoneException;

public interface IMilestones {

	Iterable<Milestone> getAll() throws MilestoneException;

	Milestone getOne(Integer id) throws MilestoneException;

}
