import java.util.*;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {

        if(matrix == null || matrix.length == 0) {
            return Collections.emptyList();
        }

        List<Integer> output = new ArrayList<>();

        int rEnd = matrix.length - 1, cEnd = matrix[0].length - 1;
        int rStart = 0, cStart = 0;
//        rStart - starting row index
//        rEnd - ending row index
//        cStart - starting column index
//        cEnd - ending column index


        while(rStart <= rEnd && cStart <= cEnd) {
            int i;
            // Add the first row
            for(i = cStart; i <= cEnd; i++) {
                output.add(matrix[rStart][i]);
            }
            rStart++;

            // Add the last column
            for(i = rStart; i <= rEnd; i++) {
                output.add(matrix[i][cEnd]);
            }
            cEnd--;

            for(i = cEnd; i >= cStart && rStart <= rEnd; i--) {
                output.add(matrix[rEnd][i]);
            }
            rEnd--;

            for(i = rEnd; i >= rStart && cStart <= cEnd; i--) {
                output.add(matrix[i][cStart]);
            }
            cStart++;
        }
        return output;
    }


    public static void main(String[] args) {

        int[][] input = {{1,2,3} , {4,5,6}, {7,8,9}};

        System.out.println(spiralOrder(input));
    }
}
