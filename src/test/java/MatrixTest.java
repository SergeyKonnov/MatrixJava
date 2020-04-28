import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @Test
    public void canAddNumberToMatrix() {
        double[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int number = 5;
        double[][] ans = Matrix.add(array, number);
        double[][] expectAns = {{6, 7, 8}, {9, 10, 11}, {12, 13, 14}};
        assertArrayEquals(ans, expectAns);
    }
    public void canSubtractNumberToMatrix() {
        double[][] array = {{6, 7, 8}, {9, 10, 11}, {12, 13, 14}};
        int number = 5;
        double[][] ans = Matrix.add(array, number);
        double[][] expectAns = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertArrayEquals(ans, expectAns);
    }

    public void canAddMatricesWithEqualSize() throws Exception {
        double[][] array1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] array2 = {{6, 7, 8}, {9, 10, 11}, {12, 13, 14}};
        double[][] ans = Matrix.add(array1, array2);
        double[][] expectAns = {{7, 9, 11}, {13, 15, 17}, {19, 21, 23}};
        assertArrayEquals(ans, expectAns);
    }
}