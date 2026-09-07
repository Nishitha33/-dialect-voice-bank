package com.nishitha.dialectvoicebank.controller;

import com.nishitha.dialectvoicebank.model.VoiceRecording;
import com.nishitha.dialectvoicebank.service.VoiceRecordingService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/recordings")
public class VoiceRecordingController {

    private final VoiceRecordingService voiceRecordingService;

    public VoiceRecordingController(VoiceRecordingService voiceRecordingService) {
        this.voiceRecordingService = voiceRecordingService;
    }

    @PostMapping
    public VoiceRecording createRecording(@RequestBody VoiceRecording recording) {
        return voiceRecordingService.saveRecording(recording);
    }

    @GetMapping
    public List<VoiceRecording> getAllRecordings() {
        return voiceRecordingService.getAllRecordings();
    }

    @PostMapping("/upload")
    public VoiceRecording uploadRecording(
            @RequestParam("file") MultipartFile file,
            @RequestParam("dialect") String dialect) throws IOException {

        return voiceRecordingService.uploadRecording(file, dialect);
    }
}