package com.hemebiotech.analytics;

import java.util.*;

public class AnalyticsCounter {

	/**
	 * The reader used to read symptom data.
	 */
	public ReadSymptomDataFromFile reader;

	/**
	 * The writer used to write symptom data.
	 */
	public WriteSymptomDataToFile writer;


	/**
	 * Constructs an AnalyticsCounter with the specified reader and writer.
	 * @param reader A ReadSymptomDataFromFile used to read symptom data.
	 * @param writer A WriteSymptomDataToFile used to write symptom data.
	 */
	public AnalyticsCounter(ReadSymptomDataFromFile reader, WriteSymptomDataToFile writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Retrieve the list of symptoms from the reader.
	 * @return A list of symptoms read from the source.
	 */
	public List<String> getSymptoms(){
		return reader.GetSymptoms();
	}

	/**
	 * Counts the occurrences of each symptom.
	 * @param symptoms 	A list of symptoms.
	 * @return 			A Map where the key is a symptom and the value
	 *               	is the count of occurrences of that symptom.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> countedSymptoms = new HashMap<>();
		for (String symptom : symptoms) {
			countedSymptoms.computeIfPresent(symptom, (k, v) -> ++v);
			countedSymptoms.computeIfAbsent(symptom, k -> 1);
		}
		return countedSymptoms;
	}

	/**
	 * Sorts the symptoms by their names.
	 * @param symptoms	A Map with symptoms and their occurrences.
	 * @return			A Map sorted by the symptom names.
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	/**
	 * Writes the symptom data using the writer.
	 * @param symptoms	A Map with symptoms and their occurrences.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}


}

