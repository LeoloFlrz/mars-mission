package com.example.mars.service;

import com.example.mars.entity.Operation;
import com.example.mars.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {
    @Autowired
    private OperationRepository operationRepository;

    public double add(double op1, double op2) {
        return op1 + op2;
    }

    public double deduct(double op1, double op2) {
        return op1 - op2;
    }

    public double multiply(double op1, double op2) {
        return op1 * op2;
    }

    public double divide(double op1, double op2) {
        if (op2 != 0) {
            return op1 / op2;
        } else {
            throw new IllegalArgumentException("You cannot divide between 0");
        }
    }

    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
    }
}
