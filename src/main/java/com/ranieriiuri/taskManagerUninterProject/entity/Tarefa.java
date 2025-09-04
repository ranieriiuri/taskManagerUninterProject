package com.ranieriiuri.taskManagerUninterProject.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="TAREFA")
public class Tarefa extends AbstractEntity<Long> {

    @NotBlank(message = "O nome da tarefa é obrigatório.")
    @Size(min = 2, max = 60, message = "O nome deve ter no mínimo {min} caracteres.")
    @Column(name = "nome", nullable = false, unique = true, length = 60)
    private String nome;

    @NotNull(message = "O campo de data é obrigatório")
    @Column(name = "data_entrega", nullable = false, columnDefinition = "DATE")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDate dataEntrega;

    @Column(name = "responsavel", nullable = false, length = 60)
    private String responsavel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

}
