package com.chrylis.spring_examples.spring_generic_injection_failure.service;

import java.util.Date;

/**
 * Simple non-persistent implementation class.
 * 
 * @author Christopher Smith
 *
 */
public class InMemoryJobStatus implements JobStatus {

	InMemoryJobStatus(String id, Date started) {
		this.id = id;
		this.started = started;
	}

	private final String id;

	public String getId() {
		return id;
	}

	private final Date started;

	public Date getStarted() {
		return started;
	}

	private Status status;

	public Status getStatus() {
		return status;
	}
	
	void setStatus(Status newStatus) {
		this.status = newStatus;
	}
}
