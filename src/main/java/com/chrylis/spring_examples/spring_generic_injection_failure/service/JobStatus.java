package com.chrylis.spring_examples.spring_generic_injection_failure.service;

import java.util.Date;

/**
 * Interface for retrieving job status information. Might be implemented in-memory, as a JPA entity, as a MongoDB document...
 * 
 * @author Christopher Smith
 *
 */
public interface JobStatus {
	String getId();

	Date getStarted();

	Status getStatus();

	public enum Status {
		STARTED, FAILED, FINISHED;
	}
}
