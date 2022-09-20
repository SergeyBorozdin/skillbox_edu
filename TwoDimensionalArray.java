public class TwoDimensionalArray {

    public static final char SYMBOL_X = 'X';
    public static final char SPACE_SYMBOL = ' ';


    public static void main(String[] args) {
        char[][] matr = getTwoDimensionalArray(7);
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                System.out.print(matr[i][j]);
            }
            System.out.println();
        }
    }

    public static char[][] getTwoDimensionalArray(int size) {
        char[][] matrix = new char[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 && j == 0 ||
                        i == 0 && j == matrix[i].length - 1 ||
                        i == j ||
                        j == matrix.length -1 - i ||
                        i == matrix.length - 1 && j == 0) {
                    matrix[i][j] = SYMBOL_X;
                } else {
                    matrix[i][j]  = SPACE_SYMBOL;
                }
            }
        }

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ SYMBOL по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        return matrix;
    }


}
