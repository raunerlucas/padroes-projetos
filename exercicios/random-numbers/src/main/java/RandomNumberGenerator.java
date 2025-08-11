public interface RandomNumberGenerator {
    void setSeed(long seed);

    double nextNumber();

    double[] nextNumbers(int size);
}