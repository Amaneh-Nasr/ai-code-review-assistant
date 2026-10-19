package com.amaneh.ai_code_review_assistant.controller;

import com.amaneh.ai_code_review_assistant.service.CodeReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/review")
public class CodeReviewController {
    private final CodeReviewService codeReviewService;

    public CodeReviewController(CodeReviewService codeReviewService) {
        this.codeReviewService = codeReviewService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, AI Code Review Assistant!";
    }

    @PostMapping
    public String reviewCode(@RequestBody String code) {
        return codeReviewService.reviewCode(code);
    }
}