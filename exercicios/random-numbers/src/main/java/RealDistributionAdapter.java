import org.apache.commons.math3.distribution.RealDistribution;

public class RealDistributionAdapter implements RandomNumberGenerator {
    private RealDistribution distribution;

    public RealDistributionAdapter(RealDistribution distribution) {
        this.distribution = distribution;
    }

    @Override
    public void setSeed(long seed) {
        distribution.reseedRandomGenerator(seed);
    }

    @Override
    public double nextNumber() {
        return distribution.sample();
    }

    @Override
    public double[] nextNumbers(int size) {
        return distribution.sample(size);
    }
}
