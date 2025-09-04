package com.ranieriiuri.taskManagerUninterProject.service;

import com.ranieriiuri.taskManagerUninterProject.entity.Tarefa;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TarefaServiceTest {

    @Autowired
    private TarefaServiceImpl ts;

    @Test
    @Order(1)
    void insere() {
        Tarefa tarefa = new Tarefa();

        tarefa.setNome("Revisao");
        tarefa.setDataEntrega(LocalDate.of(2025, 12, 25));
        tarefa.setResponsavel("Ranieri");

        ts.salvar(tarefa);
    }

    @Test
    void buscaTodos() {
    }

    @Test
    @Order(2)
    public void pesquisaPeloId() {
        Tarefa tarefa = ts.buscarPorId(2L);
        System.out.println(tarefa);
    }

    @Test
    @Order(3)
    public void atualiza() {
        Tarefa tarefa = ts.buscarPorId(2L);
        tarefa.setNome("Review");
        ts.editar(tarefa);
    }
    @Test
    @Order(4)
    public void remove() {
        Tarefa tarefa = ts.buscarPorId(2L);

        ts.excluir(tarefa.getId());


    }
}