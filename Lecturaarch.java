import java.io.*;

public class Lecturaarch {

    public static void main(String[] args) {
        try {
            double[][] mA = readMatrixFromFile("src/a.mat");
            double[][] mB = readMatrixFromFile("src/b.mat");
            double[][] res = multiplyMatrices(mA, mB);
            writeMatrixToFile("3.mat", res);

            System.out.println("Matrix A:");
            printMatrix(mA);
            System.out.println("Matrix B:");
            printMatrix(mB);

            double[][] matrixC = readMatrixFromFile("3.mat");
            System.out.println("Matrix C:");
            printMatrix(matrixC);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static double[][] readMatrixFromFile(String file) throws IOException {
        try (DataInputStream dataStream = new DataInputStream(new FileInputStream(file))) {
            int rows = dataStream.read();
            int cols = dataStream.read();
            double[][] mat= new double[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    mat[i][j] = dataStream.readDouble();
                }
            }
            return mat;
        }
    }
    private static void writeMatrixToFile(String filename, double[][] matrix) throws IOException {
        try (DataOutputStream dataStream = new DataOutputStream(new FileOutputStream(filename))) {
            dataStream.write(matrix.length);
            dataStream.write(matrix[0].length);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    dataStream.writeDouble(matrix[i][j]);
                }
            }
        }
    }
    private static double[][] multiplyMatrices(double[][] a, double[][] b) {
        int filA = a.length;
        int colA = a[0].length;
        int colB = b[0].length;
        double[][] result = new double[filA][colB];

        for (int i = 0; i < filA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int k = 0; k < colA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
    private static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
