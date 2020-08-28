package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/test"})
public class testController {

	@GetMapping(value="")
    public @ResponseBody Map<String, Object> getAll() {
		Map<String, Object> result = new HashMap<>();
		result.put("student","test");
        return result;
    }
}
