package com.lista14.cidadeEstado.controller;

import com.lista14.cidadeEstado.model.EstadoModel;
import com.lista14.cidadeEstado.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    @GetMapping(path = "/estados")
    public ResponseEntity<List<EstadoModel>> buscarTodosEstados() {
        return ResponseEntity.ok(estadoService.buscarTodos());
    }

    @GetMapping(path = "/estados/{codigo}")
    public ResponseEntity<Optional<EstadoModel>> buscarEstadoPorId(@PathVariable Long codigo) {
        return ResponseEntity.ok(estadoService.buscarPorId(codigo));
    }

    @PostMapping(path = "/estados")
    public ResponseEntity<EstadoModel> cadastrarEstado(@RequestBody EstadoModel estadoModel) {
        return new ResponseEntity<>(estadoService.cadastrar(estadoModel), HttpStatus.CREATED);
    }

    @PutMapping(path = "/estados/{codigo}")
    public ResponseEntity<EstadoModel> alterarEstado(@RequestBody EstadoModel estadoModel, @PathVariable Long codigo) {
        return ResponseEntity.ok(estadoService.alterar(estadoModel, codigo));
    }

    @DeleteMapping(path = "/estados/{codigo}")
    public ResponseEntity<?> deletarEstado(@PathVariable Long codigo) {
        estadoService.deletar(codigo);
        return ResponseEntity.noContent().build();
    }
}
