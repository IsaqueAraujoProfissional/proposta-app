package com.pieropan.propostaapp.controller;

import com.pieropan.propostaapp.DTO.PropostaRequestDTO;
import com.pieropan.propostaapp.DTO.PropostaResponseDTO;
import com.pieropan.propostaapp.service.PropostaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/proposta")
public class PropostaController {

    private PropostaService propostaService;

    @PostMapping
    public ResponseEntity<PropostaResponseDTO> criar(@RequestBody PropostaRequestDTO requestDto) {
        PropostaResponseDTO response = propostaService.criar(requestDto);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(response.getId())
                        .toUri())
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<PropostaResponseDTO>> obterProposta() {
        return ResponseEntity.ok(propostaService.obterProposta());
    }
}