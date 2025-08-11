package com.manoelcampos.impostorenda;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author Rauner Lucas
 */
@Data
@SuperBuilder(builderMethodName = "hiddenBuilder")
public class PessoaJuridica extends Pessoa {
    private double lucro;
    private double valorProdutosAdquiridos;
    private static final double ALIQUOTA_IRPJ = 0.15; // 15%
    private static final double ALIQUOTA_ADICIONAL = 0.10; // 10%
    private static final double LIMITE_COBRANCA_IR = 20000.0;
    private static final double ALIQUOTA_CSLL = 0.09; // 9%
    private static final double ALIQUOTA_ICMS = 0.05; // 5%

    // Builder personalizado para campos obrigatórios
    public static PessoaJuridicaBuilder builder(String nome, double lucro) {
        return hiddenBuilder()
                .nome(nome)
                .lucro(lucro);
    }

    @Override
    protected double calcularImpostoRenda() {
        double irParcial = lucro * ALIQUOTA_IRPJ;
        double irExcedente = Math.max(0, irParcial - LIMITE_COBRANCA_IR);
        double adicional = irExcedente > 0 ? irExcedente * ALIQUOTA_ADICIONAL : 0;
        return irParcial + adicional;
    }

    @Override
    protected double calcularOutrosImpostos() {
        return calcularCSLL() + calcularICMS();
    }

    private double calcularCSLL() {
        return lucro * ALIQUOTA_CSLL;
    }

    private double calcularICMS() {
        return valorProdutosAdquiridos * ALIQUOTA_ICMS;
    }
}