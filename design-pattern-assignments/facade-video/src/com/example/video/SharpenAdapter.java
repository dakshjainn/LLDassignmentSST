package com.example.video;

import java.util.Objects;

public class SharpenAdapter {
    private final LegacySharpen legacySharpen;

    public SharpenAdapter(LegacySharpen legacySharpen) {
        this.legacySharpen = Objects.requireNonNull(legacySharpen, "legacySharpen");
    }

    public Frame[] sharpen(Frame[] frames, int strength) {
        Objects.requireNonNull(frames, "frames");
        
        // Convert frames to handle for legacy API
        String handle = framesToHandle(frames);
        
        // Apply sharpening using legacy API
        String sharpenedHandle = legacySharpen.applySharpen(handle, strength);
        
        // Convert back to frames (in real implementation, this would extract actual frame data)
        return handleToFrames(sharpenedHandle, frames.length);
    }

    private String framesToHandle(Frame[] frames) {
        // Simulate converting frames to a handle string
        return "FRAMES:" + frames.length + "x" + (frames.length > 0 ? frames[0].w + "x" + frames[0].h : "0x0");
    }

    private Frame[] handleToFrames(String handle, int originalLength) {
        // Simulate converting handle back to frames
        // In real implementation, this would reconstruct actual frame data
        Frame[] result = new Frame[originalLength];
        for (int i = 0; i < originalLength; i++) {
            result[i] = new Frame(1920, 1080); // Default dimensions for simulation
        }
        return result;
    }
}

