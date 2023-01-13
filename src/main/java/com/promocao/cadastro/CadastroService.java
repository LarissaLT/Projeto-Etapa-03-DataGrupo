package com.promocao.cadastro;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroService {

    public final CadastroRepository repository;
    public final CadastroMapper mapper;

    public CadastroService(CadastroRepository repository, CadastroMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public CadastroDto cadastrar(CadastroDto dados) {
        CadastroEntity cadastroEntity = mapper.toEntity(dados);
        repository.save(cadastroEntity);
        CadastroDto cadastroDto = mapper.toDto(cadastroEntity);
        return cadastroDto;
    }

    public List<CadastroDto> listar() {
        List<CadastroEntity> entities = repository.findAll();
        List<CadastroDto> dtos = mapper.toDto(entities);
        return dtos;
    }

    public CadastroDto buscar(Long id) {
        Optional<CadastroEntity> optionalEntity = repository.findById(id);
        CadastroEntity cadastroEntity = optionalEntity.orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND));
        CadastroDto dto = mapper.toDto(cadastroEntity);
        return dto;
    }

    @Transactional
    public CadastroDto atualizar(CadastroDto dados, Long id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        CadastroEntity cadastroEntity = mapper.toEntity(dados);
        cadastroEntity.setId(id);
        repository.save(cadastroEntity);
        CadastroDto dto = mapper.toDto(cadastroEntity);
        return dto;
    }

    public void deletar(Long id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
    }
}
