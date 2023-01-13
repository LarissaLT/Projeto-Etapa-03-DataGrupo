package com.promocao.cadastro;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CadastroMapper {

    public CadastroDto toDto(CadastroEntity entity) {
        CadastroDto dto = new CadastroDto(
                entity.getId(),
                entity.getNomeCompleto(),
                entity.getEmail(),
                entity.getCpf(),
                entity.getEndereco());
        return dto;
    }

    public CadastroEntity toEntity(CadastroDto dto) {
        CadastroEntity entity = new CadastroEntity();
        entity.setId(dto.id());
        entity.setNomeCompleto(dto.nomeCompleto());
        entity.setEmail(dto.email());
        entity.setCpf(dto.cpf());
        entity.setEndereco(dto.endereco());
        return entity;
    }

    public List<CadastroDto> toDto(List<CadastroEntity> entities) {
        List<CadastroDto> result = entities.stream().map(e -> toDto(e)).collect(Collectors.toList());
        return result;
    }

    public List<CadastroEntity> toEntity(List<CadastroDto> dtos) {
        List<CadastroEntity> result = dtos.stream().map(e -> toEntity(e)).collect(Collectors.toList());
        return result;
    }
}
