package Solutions;

/**
 * Created by IntelliJ IDEA.
 * File Name: Custom003_SudokuVerifier.java
 * User: Ratchapong T.
 * Date: 29-Mar-2016
 * Time: 6:41 PM
 */
public class Custom003_SudokuVerifier {
    public int sudokuVerifier(String input) {
        boolean[][] r = new boolean[9][9];
        boolean[][] c = new boolean[9][9];
        boolean[][] b = new boolean[9][9];
        for (int i = 0; i < input.length(); i++) {
            int n = input.charAt(i) - '0';
            if (n < 0 || n > 9) return 0;
            int row = i / 9;
            int col = i % 9;
            int box = (row / 3 * 3) + (col / 3);
            if (r[row][n - 1] || c[col][n - 1] || b[box][n - 1]) return 0;
            r[row][n - 1] = true;
            c[col][n - 1] = true;
            b[box][n - 1] = true;
        }
        return 1;
    }
}
