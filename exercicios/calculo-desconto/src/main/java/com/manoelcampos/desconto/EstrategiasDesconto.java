package com.manoelcampos.desconto;

import java.time.LocalDate;

public class EstrategiasDesconto {

    // Estratégia de desconto com percentual fixo
    public static CalculadoraDesconto descontoFixo(double percentual) {
        return venda -> venda.getValorTotal() * (percentual / 100.0);
    }

    // Estratégia de desconto progressivo (valor da compra/25, máximo, 20%)
    public static CalculadoraDesconto descontoProgressivo() {
        return venda -> {
            double percentual = venda.getValorTotal() / 25.0;
            percentual = Math.min(percentual, 20.0);
            return venda.getValorTotal() * (percentual / 100.0);
        };
    }

    // Estratégia de desconto de aniversário (15%)
    public static CalculadoraDesconto descontoAniversario() {
        return venda -> {
            LocalDate hoje = LocalDate.now();
            LocalDate aniversario = venda.getCliente().getDataNascimento();

            if (hoje.getMonthValue() == aniversario.getMonthValue() &&
                    hoje.getDayOfMonth() == aniversario.getDayOfMonth()) {
                return venda.getValorTotal() * 0.15;
            }

            return 0.0;
        };
    }
}