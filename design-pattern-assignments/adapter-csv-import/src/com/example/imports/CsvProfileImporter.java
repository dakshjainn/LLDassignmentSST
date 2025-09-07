package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader csvReader;
    private final ProfileService profileService;

    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = Objects.requireNonNull(csvReader, "csvReader");
        this.profileService = Objects.requireNonNull(profileService, "profileService");
    }

    @Override
    public int importFrom(Path csvFile) {
        Objects.requireNonNull(csvFile, "csvFile");
        
        List<String[]> rows = csvReader.read(csvFile);
        int successCount = 0;
        
        for (String[] row : rows) {
            if (isValidRow(row)) {
                try {
                    String id = row[0].trim();
                    String email = row[1].trim();
                    String displayName = row.length > 2 ? row[2].trim() : "";
                    
                    profileService.createProfile(id, email, displayName);
                    successCount++;
                } catch (Exception e) {
                    System.out.println("Skipping invalid row: " + String.join(",", row) + " - " + e.getMessage());
                }
            } else {
                System.out.println("Skipping invalid row: " + String.join(",", row) + " - missing id or email");
            }
        }
        
        return successCount;
    }
    
    private boolean isValidRow(String[] row) {
        return row != null && row.length >= 2 && 
               row[0] != null && !row[0].trim().isEmpty() &&
               row[1] != null && !row[1].trim().isEmpty();
    }
}
