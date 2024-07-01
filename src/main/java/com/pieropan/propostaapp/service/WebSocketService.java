package com.pieropan.propostaapp.service;

import com.pieropan.propostaapp.DTO.PropostaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate template;

    public void notificar(PropostaResponseDTO proposta) {
        template.convertAndSend("/propostas", proposta);
    }
}