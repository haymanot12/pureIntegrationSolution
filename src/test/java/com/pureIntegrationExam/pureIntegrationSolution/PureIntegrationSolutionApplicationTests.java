package com.pureIntegrationExam.pureIntegrationSolution;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pureIntegrationExam.pureIntegrationSolution.service.DogDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class PureIntegrationSolutionApplicationTests {

	@Autowired
	DogDataService dogDataService;


	@Test
	void contextLoads() {
	}
	@Test
	public void testGetAll() {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, List<String>> expected = new HashMap<>();
		try {
			expected = objectMapper.readValue(new File("jsonData.json"), new TypeReference<Map<String, List<String>>>() {
			});

		}catch(IOException i){

		}
		Assertions.assertEquals(expected.get("terrier").toString(),dogDataService.getDogData().getMessage().get("terrier").toString());
	}

	@Test
	public void testDogNotNull() {

		Assertions.assertNotNull(dogDataService.getDogData().getMessage().get("terrier").toString());
			}

}
