package com.example.report;

import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

public class ReportBundleFacade {
    private final JsonWriter jsonWriter;
    private final Zipper zipper;
    private final AuditLog auditLog;

    public ReportBundleFacade() {
        this.jsonWriter = new JsonWriter();
        this.zipper = new Zipper();
        this.auditLog = new AuditLog();
    }

    public Path export(Map<String, Object> data, Path outDir, String baseName) {
        Objects.requireNonNull(data, "data");
        Objects.requireNonNull(outDir, "outDir");
        Objects.requireNonNull(baseName, "baseName");

        try {
            // Step 1: Write JSON
            Path jsonPath = jsonWriter.write(data, outDir, baseName);
            
            // Step 2: Zip the JSON file
            Path zipPath = outDir.resolve(baseName + ".zip");
            Path finalZip = zipper.zip(jsonPath, zipPath);
            
            // Step 3: Log the success
            auditLog.log("exported " + finalZip);
            
            return finalZip;
        } catch (Exception e) {
            if (e instanceof UncheckedIOException) {
                throw (UncheckedIOException) e;
            }
            throw new UncheckedIOException(new java.io.IOException("Export failed", e));
        }
    }
}
