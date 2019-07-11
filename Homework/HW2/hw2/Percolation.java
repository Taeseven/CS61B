package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] status;

    private int numOfOpen;
    private int top;
    private int bottom;

    private WeightedQuickUnionUF sets;
    private WeightedQuickUnionUF isFullsets;

    public Percolation(int N) {
        if (N <= 0) {
            throw new java.lang.IllegalArgumentException(N + "must be larger than 0!");
        }

        status = new boolean[N][N];
        numOfOpen = 0;
        sets = new WeightedQuickUnionUF(N * N + 2);
        isFullsets = new WeightedQuickUnionUF(N * N + 1);

        top = N * N;
        bottom = top + 1;

    }

    private void indexCheck(int row, int col) {
        int N = status.length;
        if (row < 0 || row >= N || col < 0 || col >= N) {
            throw new java.lang.IndexOutOfBoundsException("Position is out of boundary!");
        }

    }

    private int to1D(int row, int col) {
        int N = status.length;
        return row * N + col;
    }

    public void open(int row, int col) {
        indexCheck(row, col);

        if (!isOpen(row, col)) {
            status[row][col] = true;
            numOfOpen += 1;
            connect(row, col);
        }

    }

    private void connect(int row, int col) {
        int index = to1D(row, col);
        int N = status.length;
        if (row == 0) {
            sets.union(top, index);
            isFullsets.union(top, index);
        }
        if (row == N - 1) {
            sets.union(bottom, index);
        }

        if (row != 0 && isOpen(row - 1, col)) {
            sets.union(index - N, index);
            isFullsets.union(index - N, index);
        }
        if (row != N - 1 && isOpen(row + 1, col)) {
            sets.union(index + N, index);
            isFullsets.union(index + N, index);
        }
        if (col != 0 && isOpen(row, col - 1)) {
            sets.union(index - 1, index);
            isFullsets.union(index - 1, index);
        }
        if (col != N - 1 && isOpen(row, col + 1)) {
            sets.union(index, index + 1);
            isFullsets.union(index, index + 1);
        }

    }

    public boolean isOpen(int row, int col) {
        indexCheck(row, col);
        return status[row][col];
    }

    public boolean isFull(int row, int col) {
        indexCheck(row, col);
        return isFullsets.connected(top, to1D(row, col));
    }

    public int numberOfOpenSites() {
        return numOfOpen;
    }

    public boolean percolates() {
        return sets.connected(top, bottom);
    }

    public static void main(String[] args) {

    }

}
