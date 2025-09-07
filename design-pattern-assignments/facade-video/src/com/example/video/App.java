package com.example.video;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        VideoPipelineFacade pipeline = new VideoPipelineFacade();
        
        // Process with grayscale, scaling, and sharpening
        Path out = pipeline.process(
            Path.of("in.mp4"), 
            Path.of("out.mp4"), 
            true,    // grayscale
            0.5,     // scale factor
            5        // sharpen strength
        );
        
        System.out.println("Wrote " + out);
        
        // Demonstrate processing without optional filters
        Path out2 = pipeline.process(
            Path.of("in2.mp4"), 
            Path.of("out2.mp4"), 
            false,   // no grayscale
            null,    // no scaling
            null     // no sharpening
        );
        
        System.out.println("Wrote " + out2);
    }
}
