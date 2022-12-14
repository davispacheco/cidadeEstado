package com.lista14.cidadeEstado.service;

import com.lista14.cidadeEstado.model.CidadeModel;
import com.lista14.cidadeEstado.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public List<CidadeModel> buscarTodas() {
        return cidadeRepository.findAll();
    }

    public Optional<CidadeModel> buscarPorId(Long codigo) {
        return cidadeRepository.findById(codigo);
    }

    public CidadeModel cadastrar(CidadeModel cidadeModel) {
        return cidadeRepository.save(cidadeModel);
    }

    public CidadeModel alterar(CidadeModel cidadeModel, Long codigo) {
        return cidadeRepository.save(cidadeModel);
    }

    public void deletar(Long codigo) {
        cidadeRepository.deleteById(codigo);
    }
}
