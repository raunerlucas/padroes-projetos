import com.manoelcampos.impostorenda.*;

public class Principal {
    public static void main(String[] args) {
        // Exemplo com Pessoa Física
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("João Silva");
        pf.setSalarioBruto(5000);
        pf.setNumeroDependentes(2);
        pf.setGastosSaude(500);
        pf.setGastosEducacao(300);

        System.out.println("Imposto total PF: R$ " + pf.calcularImpostoTotal());

        // Exemplo com Pessoa Jurídica
        PessoaJuridica pj = new PessoaJuridica();
        pj.setNome("Empresa XYZ Ltda");
        pj.setLucro(200000);
        pj.setValorProdutosAdquiridos(50000);

        System.out.println("Imposto total PJ: R$ " + pj.calcularImpostoTotal());
    }
}
