package com.promocao.cadastro;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class CadastroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Nome_Completo")
    @NotBlank
    private String nomeCompleto;

    @Column(name="Email")
    @NotBlank
    @Email
    private String email;

    @Column(name="CPF")
    @NotNull(message = "cpf não pode ser nulo")
    @NotEmpty(message = "cpf não pode ser vazio")
    @Pattern(regexp = "\\d{11}")
    private String cpf;

    @Column(name="Endereco")
    @NotBlank
    private String endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
