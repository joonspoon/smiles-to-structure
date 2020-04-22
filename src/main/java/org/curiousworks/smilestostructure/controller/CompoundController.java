package org.curiousworks.smilestostructure.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.curiousworks.smilestostructure.model.Compound;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompoundController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/2D")
	public Compound greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Compound(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "hi";
	}
}
