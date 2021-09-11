package com.pureIntegrationExam.pureIntegrationSolution.service;

import com.pureIntegrationExam.pureIntegrationSolution.model.DogTypeWithBreeds;

public interface DogDataService {
    DogTypeWithBreeds getDogData();
    DogTypeWithBreeds saveDog(DogTypeWithBreeds dog);
}
