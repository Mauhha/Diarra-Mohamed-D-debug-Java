package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implementation of ISymptomWriter that will write in a file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter{
    /**
     * File to which the symptoms will be written.
     */
    private final String filepath;

    /**
     * Constructor of WriteSymptomDataToFile that specify the output file name.
     * @param filepath File to which the symptoms will be written.
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        if (filepath != null){

            try {
                FileWriter writer = new FileWriter(filepath);
                for (Map.Entry<String, Integer> entry : symptoms.entrySet()){
                    writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
                }
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
