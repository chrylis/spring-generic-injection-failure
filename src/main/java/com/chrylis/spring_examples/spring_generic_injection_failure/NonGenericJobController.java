package com.chrylis.spring_examples.spring_generic_injection_failure;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chrylis.spring_examples.spring_generic_injection_failure.service.InMemoryJobStatus;

/**
 * Bad REST implementation, but it's a showcase for the autowiring problem.
 * 
 * @author Christopher Smith
 *
 */
@RestController
@RequestMapping("/job")
@Profile("nongeneric")
public class NonGenericJobController extends GenericJobController<InMemoryJobStatus> {
}
