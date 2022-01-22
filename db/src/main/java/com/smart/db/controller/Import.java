package com.smart.db.controller;

import org.springframework.web.bind.annotation.*;

@RestController("/test")
public class Import {
	@RequestMapping("/start")
	public void start() {
		System.out.println("Run.");
	}
}
