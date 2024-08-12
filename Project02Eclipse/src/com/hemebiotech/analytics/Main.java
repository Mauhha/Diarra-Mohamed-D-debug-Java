package com.hemebiotech.analytics;

public class Main {

    public static void main(String[] args) {

        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");

        WriteSymptomDataToFile writer = new WriteSymptomDataToFile("result.out");

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        analyticsCounter.writeSymptoms(analyticsCounter.sortSymptoms(analyticsCounter.countSymptoms(analyticsCounter.getSymptoms())));
    }
}
