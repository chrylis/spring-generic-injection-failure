package com.chrylis.spring_examples.spring_generic_injection_failure.service;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.chrylis.spring_examples.spring_generic_injection_failure.service.JobStatus.Status;

@Service
public class InMemoryJobStatusService implements JobStatusService<InMemoryJobStatus> {

	private final Map<String, InMemoryJobStatus> repository = new HashMap<>();

	public InMemoryJobStatus startingJob(String jobId, Date started) {
		InMemoryJobStatus job = new InMemoryJobStatus(jobId, started);
		repository.put(jobId, job);
		return job;
	}

	public void updateJobStatus(InMemoryJobStatus targetJob, Status newStatus) {
		targetJob.setStatus(newStatus);
	}

	public void finishJob(InMemoryJobStatus targetJob) {
		targetJob.setStatus(Status.FINISHED);
	}

	public InMemoryJobStatus findJob(String jobId) {
		return repository.get(jobId);
	}
	
	public Collection<InMemoryJobStatus> findJobs() {
		return repository.values();
	}
}
