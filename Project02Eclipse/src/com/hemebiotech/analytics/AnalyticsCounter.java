package com.hemebiotech.analytics;

import java.util.*;

public class AnalyticsCounter {

	public ReadSymptomDataFromFile reader;

	public WriteSymptomDataToFile writer;


	public AnalyticsCounter(ReadSymptomDataFromFile reader, WriteSymptomDataToFile writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms(){
		return reader.GetSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> countedSymptoms = new HashMap<>();
		for (String symptom : symptoms) {
			countedSymptoms.computeIfPresent(symptom, (k, v) -> ++v);
			countedSymptoms.computeIfAbsent(symptom, k -> 1);
		}
		return countedSymptoms;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}


}

