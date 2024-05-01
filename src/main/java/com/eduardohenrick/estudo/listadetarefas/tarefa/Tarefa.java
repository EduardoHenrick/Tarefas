package com.eduardohenrick.estudo.listadetarefas.tarefa;

import com.eduardohenrick.estudo.listadetarefas.exception.AlterarStatusTarefaException;

import static com.eduardohenrick.estudo.listadetarefas.tarefa.Status.CANCELADA;
import static com.eduardohenrick.estudo.listadetarefas.tarefa.Status.CONCLUIDA;
import static com.eduardohenrick.estudo.listadetarefas.tarefa.Status.EM_ANDAMENTO;
import static com.eduardohenrick.estudo.listadetarefas.tarefa.Status.PENDENTE;

public class Tarefa {

    private Integer codigo;
    private String descricao;
    private Status status;

    public Tarefa(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.status = PENDENTE;
    }

    public Tarefa(Integer codigo, String descricao, Status status) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.status = status;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void iniciarTarefa() throws AlterarStatusTarefaException {
        switch (status) {

            case PENDENTE:
                System.out.println("A tarefa pode ser iniciada ");
                status = EM_ANDAMENTO;
                break;

            case EM_ANDAMENTO:
                System.out.println("A tarefa ja esta EM_ANDAMENTO ");
                throw new AlterarStatusTarefaException("O status não pode ser alterado pois ja esta em andamento");


            case CONCLUIDA:
                System.out.println("A tarefa não pode ser iniciada pois esta CONCLUIDA ");
                throw new AlterarStatusTarefaException("O status não pode sera alterado pois ja esta concluida");
        }

    }

    public void concluirTarefa() throws AlterarStatusTarefaException {
        switch (status) {

            case EM_ANDAMENTO:
                System.out.println("A tarefa pode ser concluida");
                status = CONCLUIDA;
                break;

            case PENDENTE:
                System.out.println("A tarefa não pode ser concluida pois ainda esta PENDENTE");
                throw new AlterarStatusTarefaException("O status não pode sera alterado pois esta PENDENTE");

            case CONCLUIDA:
                System.out.println("A tarefa não pode ser concluida pois ja esta CONCLUIDA");
                throw new AlterarStatusTarefaException("O status não pode ser alterado pois ja esta CONCLUIDA");
        }

    }

    public void cancelarTarefa() throws AlterarStatusTarefaException {
        switch (status) {

            case PENDENTE, EM_ANDAMENTO:
                System.out.println("A tarefa pode ser cancelada");
                status = CANCELADA;
                break;

            case CONCLUIDA:
                System.out.println("A tarefa não pode ser cancelada pois ja esta CONCLUIDA");
                throw new AlterarStatusTarefaException("O status não pode ser alterado pois ja esta CONCLUIDA");

            case CANCELADA:
                System.out.println("A tarefa nã pode ser cancelada pois ja esta CANCELADA");
                throw new AlterarStatusTarefaException("O status não pode ser alterado pois ja esta CANCELADA");

        }

    }

}
