class NumMatrix {
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {

        int sum = 0;

        for (int col = col1; col <= col2; col++) {
            for (int row = row1; row <= row2; row++) {
                sum += matrix[row][col];
            }
        }

        return sum;
    }
}