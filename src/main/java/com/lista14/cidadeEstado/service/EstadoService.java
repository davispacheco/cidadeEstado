package com.lista14.cidadeEstado.service;

import com.lista14.cidadeEstado.model.CidadeModel;
import com.lista14.cidadeEstado.model.EstadoModel;
import com.lista14.cidadeEstado.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    public List<EstadoModel> buscarTodos() {
        return estadoRepository.findAll();
    }

    public Optional<EstadoModel> buscarPorId(Long codigo) {
        return estadoRepository.findById(codigo);
    }

    public EstadoModel cadastrar(EstadoModel estadoModel) {
        return estadoRepository.save(estadoModel);
    }

    public EstadoModel alterar(EstadoModel estadoModel, Long codigo) {
        return estadoRepository.save(estadoModel);
    }

    public void deletar(Long codigo) {
        estadoRepository.deleteById(codigo);
    }
}
