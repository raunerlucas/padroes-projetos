import java.util.Random;

public class JavaRandomAdapter implements RandomNumberGenerator {
    private Random random;

    public JavaRandomAdapter() {
        this.random = new Random();
    }

    @Override
    public void setSeed(long seed) {
        random.setSeed(seed);
    }

    @Override
    public double nextNumber() {
        return random.nextDouble();
    }

    @Override
    public double[] nextNumbers(int size) {
        double[] samples = new double[size];
        for (int i = 0; i < size; i++) {
            samples[i] = random.nextDouble();
        }
        return samples;
    }
}