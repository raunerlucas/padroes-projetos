package com.manoelcampos.impostorenda;

import lombok.Data;

/**
 * @author Manoel Campos da Silva Filho
 */
@Data
public abstract class Pessoa {
    private long id;
    private String nome;

    /**
     * Metodo template que define o algoritmo para cálculo de todos os impostos
     * @return valor total de impostos a pagar
     */
    public final double calcularImpostoTotal() {
        double impostoRenda = calcularImpostoRenda();
        double outrosImpostos = calcularOutrosImpostos();
        return impostoRenda + outrosImpostos;
    }

    /**
     * Calcula o Imposto de Renda específico para cada tipo de pessoa
     *
     * @return valor do IR a pagar
     */
    protected abstract double calcularImpostoRenda();

    /**
     * Calcula outros impostos específicos para cada tipo de pessoa
     *
     * @return valor de outros impostos a pagar
     */
    protected abstract double calcularOutrosImpostos();
}