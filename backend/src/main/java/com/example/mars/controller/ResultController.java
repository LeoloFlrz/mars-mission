package com.example.mars.controller;

import com.example.mars.entity.Operation;
import com.example.mars.entity.Result;
import com.example.mars.service.OperationService;
import com.example.mars.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
@CrossOrigin("*")
public class ResultController {

    @Autowired
    private ResultService resultService;
    @Autowired
    private OperationService operationService;

    @PostMapping
    public ResponseEntity<String> AddResult(@RequestBody Result result) {
        resultService.addResult(result);
        return ResponseEntity.ok("Result added correctly");
    }

    @GetMapping
    public ResponseEntity<List<Result>> getAllResults() {
        List<Result> results = resultService.getAllResults();
        return ResponseEntity.ok(results);
    }
}
