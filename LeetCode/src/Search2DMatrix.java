public class Search2DMatrix {

    /*
        O(nlogn) approach. Search row index and perform binary search
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) {
            return false;
        }
        int row = 0;
        int totalRows = matrix.length - 1;
        int totalCols = matrix[0].length - 1;
        while(row <= totalRows) {
            int mid = row + totalRows / 2;
            if(matrix[mid][0] <= target && matrix[mid][totalCols] >= target) {
                return searchRow(matrix, mid, target);
            }
            if(matrix[mid][0] > target) totalRows = mid - 1;
            if(matrix[mid][totalCols] < target) {
                row = mid + 1;
            }
        }
        return false;
    }

    public static boolean searchRow(int[][] matrix, int rowIdx, int target) {
        int left = 0;
        int right = matrix[rowIdx].length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[rowIdx][mid] < target) {
                left = mid + 1;
            } else if(matrix[rowIdx][mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }


    // O(N+M) approach
    public boolean searchMatrixOptmized(int[][] matrix, int target) {
        if(matrix.length == 0) {
            return false;
        }
        int i = matrix.length - 1;
        int j = 0;
        while(i >= 0 && j < matrix[0].length) {
            if(matrix[i][j] > target) {
                i--;
            } else if(matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }
}
