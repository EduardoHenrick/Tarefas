package com.eduardohenrick.estudo.listadetarefas;

import com.eduardohenrick.estudo.listadetarefas.pessoa.Pessoa;
import com.eduardohenrick.estudo.listadetarefas.exception.AlterarStatusTarefaException;
import com.eduardohenrick.estudo.listadetarefas.tarefa.Status;
import com.eduardohenrick.estudo.listadetarefas.tarefa.Tarefa;
import com.eduardohenrick.estudo.listadetarefas.tarefa.TarefasPessoa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws AlterarStatusTarefaException {

        Tarefa tarefa4 = new Tarefa(6,"varrer casa", Status.PENDENTE);

        try {
            tarefa4.iniciarTarefa();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(tarefa4.getStatus());
        tarefa4.cancelarTarefa ();
        System.out.println(tarefa4.getStatus());

    }



    private static TarefasPessoa buildTarefasPessoa() {
        Pessoa pessoa1 = new Pessoa(2, "Eduardo");
        Tarefa tarefa1 = new Tarefa(5, "lavar louça");

        List<Tarefa> tarefas = new ArrayList<>();
        tarefas.add(tarefa1);

        return new TarefasPessoa(pessoa1, tarefas);
    }


}