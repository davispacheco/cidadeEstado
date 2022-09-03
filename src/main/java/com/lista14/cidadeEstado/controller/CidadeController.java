package com.lista14.cidadeEstado.controller;

import com.lista14.cidadeEstado.model.CidadeModel;
import com.lista14.cidadeEstado.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CidadeController {
    @Autowired
    private CidadeService cidadeService;

    @GetMapping(path = "/cidades")
    public ResponseEntity<List<CidadeModel>> buscarTodasCidades() {
        return ResponseEntity.ok(cidadeService.buscarTodas());
    }

    @GetMapping(path = "/cidades/{codigo}")
    public ResponseEntity<Optional<CidadeModel>> buscarCidadePorId(@PathVariable Long codigo) {
        return ResponseEntity.ok(cidadeService.buscarPorId(codigo));
    }

    @PostMapping(path = "/cidades")
    public ResponseEntity<CidadeModel> cadastrarCidade(@RequestBody CidadeModel cidadeModel) {
        return new ResponseEntity<>(cidadeService.cadastrar(cidadeModel), HttpStatus.CREATED);
    }

    @PutMapping(path = "/cidades/{codigo}")
    public ResponseEntity<CidadeModel> alterarCidade(@RequestBody CidadeModel cidadeModel, @PathVariable Long codigo) {
        return ResponseEntity.ok(cidadeService.alterar(cidadeModel, codigo));
    }

    @DeleteMapping(path = "/cidades/{codigo}")
    public ResponseEntity<?> deletarCidade(@PathVariable Long codigo) {
        cidadeService.deletar(codigo);
        return ResponseEntity.noContent().build();
    }
}
