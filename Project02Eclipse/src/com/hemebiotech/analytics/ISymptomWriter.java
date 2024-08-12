package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data
 */
public interface ISymptomWriter {

    /**
     * Writes the list of symptoms and their frequency.
     * @param symptoms  A Map where the key represents the name of the symptom
     *                  and the value represents its frequency of occurrence.
     */
    void writeSymptoms(Map<String, Integer> symptoms) ;
}
