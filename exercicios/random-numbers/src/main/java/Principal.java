import org.apache.commons.math3.distribution.LogNormalDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.Arrays;

/**
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        /**
         * Seed (semente) é o valor inicial a ser utilizado pelos geradores de números aleatórios.
        * Se for utilizada uma mesma seed ao executar a aplicação várias vezes, os
        * mesmos exatos valores serão gerados.
        * Alterando a seed a cada execução, a sequência de valores muda.
        */
        final long seed = 123;

        RandomNumberGenerator normalGenerator = new RealDistributionAdapter(new NormalDistribution());
        normalGenerator.setSeed(seed);

        RandomNumberGenerator logNormalGenerator = new RealDistributionAdapter(new LogNormalDistribution());
        logNormalGenerator.setSeed(seed);

        RandomNumberGenerator uniformGenerator = new JavaRandomAdapter();
        uniformGenerator.setSeed(seed);

        final int TOTAL_NUMEROS = 4;
        for (int i = 0; i < TOTAL_NUMEROS; i++) {
            System.out.println("Número aleatório seguindo distribuição Normal usando biblioteca Apache Commons Math: "
                    + Arrays.toString(normalGenerator.nextNumbers(12)));
            System.out.println("Número aleatório seguindo distribuição Log-Normal usando biblioteca Apache Commons Math: "
                    + logNormalGenerator.nextNumber());
            System.out.println("Número aleatório seguindo distribuição Uniforme usando classe Random: "
                    + uniformGenerator.nextNumber());
            System.out.println();
        }
    }
}