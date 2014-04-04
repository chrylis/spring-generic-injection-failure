package com.chrylis.spring_examples.spring_generic_injection_failure.service;

import java.util.Collection;
import java.util.Date;

import com.chrylis.spring_examples.spring_generic_injection_failure.service.JobStatus.Status;

public interface JobStatusService<JS extends JobStatus> {
	JS startingJob(String jobId, Date started);

	void updateJobStatus(JS targetJob, Status newStatus);

	void finishJob(JS targetJob);
	
	JS findJob(String jobId);
	
	Collection<JS> findJobs();
}
