package com.pureIntegrationExam.pureIntegrationSolution.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pureIntegrationExam.pureIntegrationSolution.model.DogTypeWithBreeds;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DogDataServiceImpl implements DogDataService {
    @Override
    public DogTypeWithBreeds getDogData() {
        Map<String, List<String>> map = new HashMap<>();
        DogTypeWithBreeds dogTypeWithBreeds = new DogTypeWithBreeds();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            map = objectMapper.readValue(new File("jsonData.json"), new TypeReference<Map<String, List<String>>>() {
            });
            dogTypeWithBreeds.setMessage(map);
            dogTypeWithBreeds.setStatus("success");
            return dogTypeWithBreeds;

        }catch(IOException i){

        }

        return null;
    }

    @Override
    public DogTypeWithBreeds saveDog(DogTypeWithBreeds dog) {
        return null;
    }
}
