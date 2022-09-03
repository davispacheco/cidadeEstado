package com.lista14.cidadeEstado.controller;

import com.lista14.cidadeEstado.model.EnderecoModel;
import com.lista14.cidadeEstado.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(path = "/enderecos")
    public ResponseEntity<List<EnderecoModel>> buscarTodosEnderecos() {
        return ResponseEntity.ok(enderecoService.buscarTodos());
    }

    @GetMapping(path = "/enderecos/{codigo}")
    public ResponseEntity<Optional<EnderecoModel>> buscarEnderecoPorId(@PathVariable Long codigo) {
        return ResponseEntity.ok(enderecoService.buscarPorId(codigo));
    }

    @PostMapping(path = "/enderecos")
    public ResponseEntity<EnderecoModel> cadastrarEndereco(@RequestBody EnderecoModel enderecoModel) {
        return new ResponseEntity<>(enderecoService.cadastrar(enderecoModel), HttpStatus.CREATED);
    }

    @PutMapping(path = "/enderecos/{codigo}")
    public ResponseEntity<EnderecoModel> alterarEndereco(@RequestBody EnderecoModel enderecoModel, @PathVariable Long codigo) {
        return ResponseEntity.ok(enderecoService.alterar(enderecoModel, codigo));
    }

    @DeleteMapping(path = "/enderecos/{codigo}")
    public ResponseEntity<?> deletarEndereco(@PathVariable Long codigo) {
        enderecoService.deletar(codigo);
        return ResponseEntity.noContent().build();
    }
}
