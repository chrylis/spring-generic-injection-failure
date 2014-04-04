package com.chrylis.spring_examples.spring_generic_injection_failure;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chrylis.spring_examples.spring_generic_injection_failure.service.InMemoryJobStatus;
import com.chrylis.spring_examples.spring_generic_injection_failure.service.InMemoryJobStatusService;
import com.chrylis.spring_examples.spring_generic_injection_failure.service.JobStatus;
import com.chrylis.spring_examples.spring_generic_injection_failure.service.JobStatus.Status;

/**
 * Bad REST implementation, but it's a showcase for the autowiring problem.
 * 
 * @author Christopher Smith
 *
 */
@RestController
@RequestMapping("/job")
@Profile("nongeneric")
public class NonGenericJobController {
	@Autowired
	private InMemoryJobStatusService jobService;
	
	@RequestMapping("/{id}")
	public JobStatus getJob(@PathVariable String id) {
		return jobService.findJob(id);
	}
	
	@RequestMapping("/new/{id}")
	public JobStatus startJob(@PathVariable String id) {
		InMemoryJobStatus newJob = jobService.startingJob(id, new Date());
		jobService.updateJobStatus(newJob, Status.STARTED);
		return newJob;
	}
	
	@RequestMapping("/{id}/{status}")
	public JobStatus updateJob(@PathVariable String id, @PathVariable Status status) {
		InMemoryJobStatus jobStatus = jobService.findJob(id);
		jobService.updateJobStatus(jobStatus, status);
		return jobStatus;
	}
	
	@RequestMapping("")
	public Collection<InMemoryJobStatus> listJobs() {
		return jobService.findJobs();
	}
}
