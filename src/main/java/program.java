public class program {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        double[][] matr = {{1, 2 ,3}, {1, 2 ,3}, {1, 2 ,3}};
        double[][] tmp = matrix.readFromFile("C:\\Users\\user\\IdeaProjects\\matrix_mult\\src\\main\\java\\test1.txt");
        if (tmp == null)
            matrix.print(matr);
        else
            matrix.print(tmp);
    }
}
