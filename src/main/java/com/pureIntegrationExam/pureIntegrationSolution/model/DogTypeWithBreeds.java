package com.pureIntegrationExam.pureIntegrationSolution.model;

import lombok.Data;

import java.util.List;
import java.util.Map;



@Data
public class DogTypeWithBreeds {

    private Map<String, List<String>> message;
    private String status;
}
