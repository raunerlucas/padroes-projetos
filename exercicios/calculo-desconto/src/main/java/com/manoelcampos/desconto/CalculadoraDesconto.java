package com.manoelcampos.desconto;


/**
 * Interface funcional para calcular o desconto aplicável a uma {@link Venda}.
 * @author Rauner Lucas Amaral
 */
@FunctionalInterface
public interface CalculadoraDesconto {

    /**
     * Calcula o valor do desconto aplicável a uma venda.
     * @param venda Venda para a qual o desconto deve ser calculado.
     * @return Valor do desconto.
     */
    double calcularDesconto(Venda venda);
}
