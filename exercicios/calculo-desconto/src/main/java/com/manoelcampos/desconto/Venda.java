package com.manoelcampos.desconto;

import lombok.Data;

import java.time.LocalDate;

/**
 * Venda realizada para um {@link Cliente}.
 * @author Manoel Campos da Silva Filho
 */
@Data
public class Venda {
    private long id;
    private Cliente cliente;
    private LocalDate data;
    private double valorTotal;
    private CalculadoraDesconto estrategiaDesconto;

    public Venda() {/**/}

    public Venda(Cliente cliente, LocalDate data, double valorTotal) {
        this.cliente = cliente;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    /**
     * Calcula o valor do desconto aplicável a esta venda, de acordo com a
     * estratégia de desconto definida.
     * @return Valor do desconto. Se nenhuma estratégia de desconto foi definida,
     * retorna 0.0 (zero).
     */
    public double calcularDesconto() {
        if (estrategiaDesconto == null) {
            return 0.0;
        }
        return estrategiaDesconto.calcularDesconto(this);
    }
}
