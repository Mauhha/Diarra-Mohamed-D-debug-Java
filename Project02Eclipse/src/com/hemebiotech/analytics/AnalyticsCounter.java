package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int dialatedpupilCount = 0;
	
	public static void main(String[] args) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();


		while (line != null) {
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("dialated pupils")) {
				dialatedpupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// writer implementation test
		WriteSymptomDataToFile writeSymptomDataToFile = new WriteSymptomDataToFile("result.out");
		Map<String,Integer> map = new TreeMap<>();
		map.put("headache",headacheCount);
		map.put("rash",rashCount);
		map.put("dialated pupils",dialatedpupilCount);
		writeSymptomDataToFile.writeSymptoms(map);
	}
}
