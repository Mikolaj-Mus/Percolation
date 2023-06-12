/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Percolation {
    private boolean grid[][];
    private boolean[][] visited;

    // tworzy siatkę n na n, z wszystkimi miejscami na początku zablokowanymi
    public Percolation(int n) {
        grid = new boolean[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = false;
            }
        }
    }


    // otwiera miejsce (wiersz, kolumna), jeśli nie jest już otwarte
    public void open(int row, int col) {
        if (!grid[row][col]) {
            grid[row][col] = true;
        }
    }

    // czy miejsce (wiersz, kolumna) jest otwarte?
    public boolean isOpen(int row, int col) {
        return grid[row][col];
    }

    // czy miejsce (wiersz, kolumna) jest pełne?
    public boolean isFull(int row, int col) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                visited[i][j] = grid[i][j];
            }
        }
        // Sprawdzamy warunki brzegowe
        if (!isValidIndex(row, col) || !isOpen(row, col) || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;  // oznaczamy pole jako odwiedzone

        // Sprawdzamy, czy bieżące pole jest w pierwszym rzędzie
        if (row == 0) {
            return true;
        }

        // Rekurencyjnie sprawdzamy połączenia dla sąsiednich pól
        return isFull(row - 1, col)  // góra
                || isFull(row + 1, col)  // dół
                || isFull(row, col - 1)  // lewo
                || isFull(row, col + 1);  // prawo
    }


    // zwraca liczbę otwartych miejsc
    // public int numberOfOpenSites()

    // czy system przepuszcza?
    // public boolean percolates(){}

    // testowy klient (opcjonalny)

    public boolean isValidIndex(int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid.length;
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
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {

        Percolation p1 = new Percolation(20);

        p1.open(2, 8);
        p1.open(1, 8);
        p1.open(0, 8);
        p1.print(p1.grid);
        System.out.println(p1.isFull(2, 8));
    }

}
