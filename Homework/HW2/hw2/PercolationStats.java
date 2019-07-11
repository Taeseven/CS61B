package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {

    private double[] result;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException("Parameters must larger than 0!");
        }
        result = new double[T];
        for (int i = 0; i < T; i++) {
            Percolation map = pf.make(N);
            while (!map.percolates()) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                map.open(row, col);
            }
            result[i] = (double) map.numberOfOpenSites() / (N * N);
        }
    }

    public double mean() {
        return StdStats.mean(result);
    }

    public double stddev() {
        return StdStats.stddev(result);
    }

    public double confidenceLow() {
        return mean() - 1.96 * Math.sqrt(stddev()) / Math.sqrt(result.length);
    }

    public double confidenceHigh() {
        return mean() + 1.96 * Math.sqrt(stddev()) / Math.sqrt(result.length);
    }

    public static void main(String[] args) {
        PercolationFactory pf = new PercolationFactory();
        PercolationStats test = new PercolationStats(20, 10, pf);
        System.out.println(test.mean());
        System.out.println(test.stddev());
    }
}
