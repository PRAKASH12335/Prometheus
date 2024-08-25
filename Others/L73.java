package Others;

// 73. Set Matrix Zeroes

public class L73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRow = false, firstCol = false;
        for(int i=0;i<m;i++){
            if(matrix[i][0] == 0)
                firstCol = true;
        }
        for(int i=0;i<n;i++){
            if(matrix[0][i] == 0)
                firstRow = true;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstCol == true){
            for(int i=0;i<m;i++){
                matrix[i][0] = 0;
            }
        }
        if(firstRow == true){
            for(int i=0;i<n;i++){
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        L73 obj = new L73();
        obj.setZeroes(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}


// Time Complexity - O(m*n)
// Space Complexity - O(1)