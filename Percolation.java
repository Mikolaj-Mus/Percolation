/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private static final int TOP = 0;
    private boolean grid[][];
    private final boolean[][] opened;
    private final int size;
    private final int bottom;
    private int openSites;
    private final WeightedQuickUnionUF qf;


    // tworzy siatkę n na n, z wszystkimi miejscami na początku zablokowanymi
    public Percolation(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        size = n;
        bottom = size * size + 1;
        // ostatni element tablicy oznaczajacy dol jeden wiekszy od ostatniego w tablicy
        qf = new WeightedQuickUnionUF(size * size + 2);
        // ilosc pol do przeszukania
        opened = new boolean[size][size];
        openSites = 0;
    }


    // otwiera miejsce (wiersz, kolumna), jeśli nie jest już otwarte
    public void open(int row, int col) {
        checkException(row, col);

        opened[row - 1][col - 1] = true; // otwarcie miejsca
        ++openSites;

        if (row == 1) {
            qf.union(getQuickFindIndex(row, col), TOP);
        }

        if (row == size) {
            qf.union(getQuickFindIndex(row, col), bottom);
        }

        if (row > 1 && isOpen(row - 1, col)) {
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row - 1, col));
        }

        if (row < size && isOpen(row + 1, col)) {
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row + 1, col));
        }

        if (col > 1 && isOpen(row, col - 1)) {
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row, col - 1));
        }

        if (col < size && isOpen(row, col + 1)) {
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row, col + 1));
        }
    }

    private void checkException(int row, int col) {
        if (row <= 0 || row > size || col <= 0 || col > size) {
            throw new IllegalArgumentException();
        }
    }

    // zwraca numer indexu jakby to byla jedna tablica jednowymiarowa
    private int getQuickFindIndex(int row, int col) {
        return size * (row - 1) + col;
    }

    // czy miejsce (wiersz, kolumna) jest otwarte?
    public boolean isOpen(int row, int col) {
        return grid[row][col];
    }

    // czy miejsce (wiersz, kolumna) jest pełne?
    // public boolean isFull(int row, int col) {
    //
    // }


    // zwraca liczbę otwartych miejsc
    // public int numberOfOpenSites()

    // czy system przepuszcza?
    // public boolean percolates(){}

    // testowy klient (opcjonalny)


    public void print(boolean[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            System.out.println();
            for (int j = 0; j < grid[i].length; j++) {
                if (!grid[i][j]) {
                    System.out.print("0 ");
                }
                else {
                    System.out.print("1 ");
                }
            }
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {

        Percolation p1 = new Percolation(20);

        p1.open(2, 8);
        p1.open(1, 8);
        p1.open(0, 8);
        p1.print(p1.grid);
        // System.out.println(p1.isFull(2, 8));
    }

}
