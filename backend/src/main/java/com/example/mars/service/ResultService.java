package com.example.mars.service;


import com.example.mars.entity.Operation;
import com.example.mars.entity.Result;
import com.example.mars.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
    @Autowired
    ResultRepository resultRepository;

    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    public Result addResult(Result result) {
        return resultRepository.save(result);
    }
}
