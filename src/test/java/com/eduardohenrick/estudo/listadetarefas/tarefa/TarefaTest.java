package com.eduardohenrick.estudo.listadetarefas.tarefa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TarefaTest {

    @Test
    public void deveIniciarUmaTarefaPendente() throws Exception {
        Tarefa tarefa1 = buildTarefa(Status.PENDENTE);
        tarefa1.iniciarTarefa();
        Assertions.assertEquals(Status.EM_ANDAMENTO, tarefa1.getStatus());
    }
    @Test
    public void deveConcluirUmaTarefaEmAndamento() throws com.eduardohenrick.estudo.listadetarefas.exception.AlterarStatusTarefaException {
        Tarefa tarefa2 = buildTarefa(Status.EM_ANDAMENTO);
        tarefa2.concluirTarefa();
        Assertions.assertEquals(Status.CONCLUIDA, tarefa2.getStatus());
    }
    @Test
    public void deveCancelarUmaTarefaPendente() throws com.eduardohenrick.estudo.listadetarefas.exception.AlterarStatusTarefaException {
        Tarefa tarefa3 = buildTarefa(Status.PENDENTE);
        tarefa3.cancelarTarefa();
        Assertions.assertEquals(Status.CANCELADA, tarefa3.getStatus());
    }

    private static Tarefa buildTarefa(Status status) {
        return new Tarefa(1, "varrer casa", status);

    }

    @Test
    public void deveCancelarUmaTarefaEmAndamento() throws com.eduardohenrick.estudo.listadetarefas.exception.AlterarStatusTarefaException {
        Tarefa tarefa4 = buildTarefa(Status.PENDENTE);
        tarefa4.cancelarTarefa();
        Assertions.assertEquals(Status.CANCELADA, tarefa4.getStatus());
    }

    @Test
    public void deveLancarExcecaoQuandoTentarIniciarUmaTarefaEmAndamento() {
        Tarefa tarefaa = buildTarefa(Status.EM_ANDAMENTO);

        Assertions.assertThrows(com.eduardohenrick.estudo.listadetarefas.exception.AlterarStatusTarefaException.class, () -> tarefaa.iniciarTarefa());
    }

    @Test
    public void deveLancarExcecaoQuandoTentarIniciarUmaTarefaConcluida() {

        Tarefa tarefab = buildTarefa(Status.CONCLUIDA);

        Assertions.assertThrows(com.eduardohenrick.estudo.listadetarefas.exception.AlterarStatusTarefaException.class, () -> tarefab.iniciarTarefa());

    }

    @Test
    public void deveLancarExcecaoQuandoTentarConcluirUmaTarefaPendente() {

        Tarefa tarefac = buildTarefa(Status.PENDENTE);

        Assertions.assertThrows(com.eduardohenrick.estudo.listadetarefas.exception.AlterarStatusTarefaException.class, () -> tarefac.concluirTarefa());
    }

    @Test
    public void deveLancarExcecaoQuandoTentarConcluirUmaTarefaConcluida() {

        Tarefa tarefad= buildTarefa(Status.CONCLUIDA);

        Assertions.assertThrows(com.eduardohenrick.estudo.listadetarefas.exception.AlterarStatusTarefaException.class, () -> tarefad.concluirTarefa());
    }

    @Test
    public void deveLancarExcecaoQuandoTentarCancelarUmaTarefaConcluida() {

        Tarefa tarefae = buildTarefa(Status.CONCLUIDA);

        Assertions.assertThrows(com.eduardohenrick.estudo.listadetarefas.exception.AlterarStatusTarefaException.class, () -> tarefae.cancelarTarefa());
    }

    @Test
    public void deveLancarExcecaoQuandoTentarCancelarUmaTarefaCancelada() {

        Tarefa tarefaf = buildTarefa(Status.CANCELADA);

        Assertions.assertThrows(com.eduardohenrick.estudo.listadetarefas.exception.AlterarStatusTarefaException.class, () -> tarefaf.cancelarTarefa());
    }


}
