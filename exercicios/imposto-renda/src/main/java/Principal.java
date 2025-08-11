import com.manoelcampos.impostorenda.PessoaFisica;
import com.manoelcampos.impostorenda.PessoaJuridica;

public class Principal {
    public static void main(String[] args) {
        // Exemplo com Pessoa Física usando Builder
        PessoaFisica pf = PessoaFisica.builder("João Silva", 5000)
                .numeroDependentes(2)
                .gastosSaude(500)
                .gastosEducacao(300)
                .build();

        System.out.println("Imposto total PF: R$ " + pf.calcularImpostoTotal());

        // Exemplo com Pessoa Jurídica usando Builder
        PessoaJuridica pj = PessoaJuridica.builder("Empresa XYZ Ltda", 200000)
                .valorProdutosAdquiridos(50000)
                .build();

        System.out.println("Imposto total PJ: R$ " + pj.calcularImpostoTotal());
    }
}
