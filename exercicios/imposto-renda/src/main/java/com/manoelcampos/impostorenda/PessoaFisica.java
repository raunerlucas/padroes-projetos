package com.manoelcampos.impostorenda;


import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author Manoel Campos da Silva Filho
 */
@Data
@SuperBuilder(builderMethodName = "hiddenBuilder")
public class PessoaFisica extends Pessoa {
    private double salarioBruto;
    private int numeroDependentes;
    private double gastosSaude;
    private double gastosEducacao;
    private static final double ALIQUOTA_IRPF = 0.11; // 11%
    private static final double ALIQUOTA_INSS = 0.11; // 11%
    private static final double DEDUCAO_POR_DEPENDENTE = 189.59; // valor fictício

    // Builder personalizado para campos obrigatórios
    public static PessoaFisicaBuilder builder(String nome, double salarioBruto) {
        return hiddenBuilder()
                .nome(nome)
                .salarioBruto(salarioBruto);
    }

    @Override
    protected double calcularImpostoRenda() {
        double inss = calcularINSS();
        double deducaoDependentes = DEDUCAO_POR_DEPENDENTE * numeroDependentes;
        double irParcial = (salarioBruto - deducaoDependentes - inss) * ALIQUOTA_IRPF;
        return Math.max(0, irParcial - gastosSaude - gastosEducacao);
    }

    @Override
    protected double calcularOutrosImpostos() {
        return calcularINSS(); // PF paga apenas INSS como outro imposto
    }

    private double calcularINSS() {
        return salarioBruto * ALIQUOTA_INSS;
    }
}