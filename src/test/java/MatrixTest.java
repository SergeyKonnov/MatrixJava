import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MatrixTest {
    @Test
    public void canAddNumberToMatrix() {
        double[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int number = 5;

        double[][] ans = Matrix.add(array, number);
        double[][] expectAns = {{6, 7, 8}, {9, 10, 11}, {12, 13, 14}};
        assertArrayEquals(ans, expectAns);
    }

    @Test
    public void canSubtractNumberToMatrix() {
        double[][] array = {{6, 7, 8}, {9, 10, 11}, {12, 13, 14}};
        int number = 5;
        double[][] ans = Matrix.subtract(array, number);
        double[][] expectAns = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertArrayEquals(ans, expectAns);
    }

    @Test
    public void canAddMatricesWithEqualSize() throws Exception {
        double[][] array1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] array2 = {{6, 7, 8}, {9, 10, 11}, {12, 13, 14}};
        double[][] ans = Matrix.add(array1, array2);
        double[][] expectAns = {{7, 9, 11}, {13, 15, 17}, {19, 21, 23}};
        assertArrayEquals(ans, expectAns);
    }

    @Test
    public void throwExceptionIfTryToAddMatricesWithNotEqualSize() throws Exception {
        double[][] array1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] array2 = {{6, 7}, {9, 10}, {12, 13}};
        assertThrows(Exception.class, ()->{Matrix.add(array1, array2);});
    }

    @Test
    public void throwExceptionIfTryToSubtractMatricesWithNotEqualSize() throws Exception {
        double[][] array1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] array2 = {{6, 7}, {9, 10}, {12, 13}};
        assertThrows(Exception.class, () -> {
            Matrix.subtract(array1, array2);
        });
    }

    @Test
    public void canMultiplyTwoMatrices() {
        double[][] array1 = {{1, 2, 3, 4}, {4, 5, 6, 7}, {7, 8, 9, 10}};
        double[][] array2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        double[][] ans = Matrix.multiply(array1, array2);
        double[][] ansExpect = {{70, 80, 90}, {136, 158, 180}, {202, 236, 270}};
        assertArrayEquals(ans, ansExpect);
    }
    @Test
    public void canMultiplyOneDimensionalMatrices() {
        double[][] array1 = {{1, 2, 3, 4, 5}};
        double[][] array2 = {{1}, {2}, {3}, {4}, {5}};
        double[][] ans = Matrix.multiply(array1, array2);
        double[][] expectAns = {{55}};
        assertArrayEquals(ans, expectAns);
    }

    @Test
    public void canReadCorrectFile() {
        double[][] array = Matrix.readFromFile(getClass().getResource("/test1.txt").getFile());
        double[][] expectAns = {{3,  4,  5,  6,    7},
                                {8,  9,  10, 11.3, 12},
                                {13, 14, 15, 16,   17},
                                {18, 19, 20, 21,   22}};
        assertNotNull(array);
        assertArrayEquals(array, expectAns);
    }

    @Test
    public void cantReadFileWithIncorrectPath() {
        assertNull(Matrix.readFromFile("something incorrect"));
    }

    @ParameterizedTest
    @ValueSource (strings = {"/incorrectTest1.txt", "/incorrectTest2.txt", "/incorrectTest3.txt"})
    void cantReadIncorrectFiles(String path) {
        double[][] array = Matrix.readFromFile(getClass().getResource(path).getFile());
        assertNull(array);
    }
}