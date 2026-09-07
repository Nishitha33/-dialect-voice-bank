package com.nishitha.dialectvoicebank.service;

import com.nishitha.dialectvoicebank.model.VoiceRecording;
import com.nishitha.dialectvoicebank.repository.VoiceRecordingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VoiceRecordingService {

    private final VoiceRecordingRepository voiceRecordingRepository;

    public VoiceRecordingService(VoiceRecordingRepository voiceRecordingRepository) {
        this.voiceRecordingRepository = voiceRecordingRepository;
    }

    public VoiceRecording saveRecording(VoiceRecording recording) {
        recording.setUploadedAt(LocalDateTime.now());
        return voiceRecordingRepository.save(recording);
    }

    public List<VoiceRecording> getAllRecordings() {
        return voiceRecordingRepository.findAll();
    }

    public VoiceRecording uploadRecording(MultipartFile file, String dialect) throws IOException {

        Path uploadDirectory = Paths.get("uploads");

        if (!Files.exists(uploadDirectory)) {
            Files.createDirectories(uploadDirectory);
        }

        Path filePath = uploadDirectory.resolve(file.getOriginalFilename());
        Files.write(filePath, file.getBytes());

        VoiceRecording recording = new VoiceRecording();
        recording.setFileName(file.getOriginalFilename());
        recording.setDialect(dialect);
        recording.setUploadedAt(LocalDateTime.now());

        return voiceRecordingRepository.save(recording);
    }
}