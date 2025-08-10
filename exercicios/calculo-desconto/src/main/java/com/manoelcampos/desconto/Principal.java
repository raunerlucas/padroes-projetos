package com.manoelcampos.desconto;

import java.time.LocalDate;

public class Principal {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1L, "João", LocalDate.now());
        Venda venda = new Venda(cliente, LocalDate.now(), 100.0);

        // Testa o desconto fixo
        venda.setEstrategiaDesconto(EstrategiasDesconto.descontoFixo(10.0));
        System.out.println("Desconto fixo (10%): " + venda.calcularDesconto());

        // Testa o desconto progressivo
        venda.setEstrategiaDesconto(EstrategiasDesconto.descontoProgressivo());
        System.out.println("Desconto progressivo: " + venda.calcularDesconto());

        // Testa o desconto de aniversário
        venda.setEstrategiaDesconto(EstrategiasDesconto.descontoAniversario());
        System.out.println("Desconto de aniversário: " + venda.calcularDesconto());

        // Também é possível criar estratégias personalizadas diretamente
        venda.setEstrategiaDesconto(v -> {
            // Desconto especial para compras acima de 500
            if (v.getValorTotal() > 500) {
                return v.getValorTotal() * 0.07;
            }
            return 0.0;
        });
        System.out.println("Desconto personalizado: " + venda.calcularDesconto());
    }
}