/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Percolation {
    private boolean grid[][];

    // tworzy siatkę n na n, z wszystkimi miejscami na początku zablokowanymi
    public Percolation(int n) {
        grid = new boolean[n][n];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = false;
            }
        }


    }

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
    }

    // otwiera miejsce (wiersz, kolumna), jeśli nie jest już otwarte
    // public void open(int row, int col)

    // czy miejsce (wiersz, kolumna) jest otwarte?
    // public boolean isOpen(int row, int col)

    // czy miejsce (wiersz, kolumna) jest pełne?
    // public boolean isFull(int row, int col)

    // zwraca liczbę otwartych miejsc
    // public int numberOfOpenSites()

    // czy system przepuszcza?
    // public boolean percolates(){}

    // testowy klient (opcjonalny)
    public static void main(String[] args) {

        Percolation p1 = new Percolation(20);
        p1.print(p1.grid);

    }

}
