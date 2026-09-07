package com.nishitha.dialectvoicebank.repository;

import com.nishitha.dialectvoicebank.model.VoiceRecording;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoiceRecordingRepository extends JpaRepository<VoiceRecording, Long> {
}