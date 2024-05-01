package com.eduardohenrick.estudo.listadetarefas.tarefa;

import com.eduardohenrick.estudo.listadetarefas.pessoa.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class TarefasPessoa {

    private Pessoa pessoa;
    private List<Tarefa> tarefas;

    public TarefasPessoa() {

    }

    public TarefasPessoa(Pessoa pessoa, List<Tarefa> tarefas) {
        this.pessoa = pessoa;
        this.tarefas = tarefas;
    }

    public void adicionarTarefa(Tarefa tarefa) {
        boolean tarefaJaAdicionada = false;

        for (Tarefa t : tarefas) {
            if(tarefa.getCodigo().equals(t.getCodigo())){
                tarefaJaAdicionada = true;
            }
        }

        if (!tarefaJaAdicionada){
            tarefas.add(tarefa);
            System.out.print("main.Tarefa adicionada: ");
            System.out.println(tarefa.getDescricao());
        } else {
            System.out.print("main.Tarefa já adicionada: ");
            System.out.println(tarefa.getDescricao());
        }
    }

    public void removerTarefa(Tarefa tarefa) {
        tarefas.remove(tarefa);
    }

    public List<Tarefa> getTarefas() {
        List<Tarefa> listaDeTarefasCopia = new ArrayList<Tarefa>();
        for (Tarefa t : tarefas) {

            Tarefa tarefaCopia = new Tarefa(t.getCodigo(), t.getDescricao());

            listaDeTarefasCopia.add(tarefaCopia);
        }

        return listaDeTarefasCopia ;
    }

}
