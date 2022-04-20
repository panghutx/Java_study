import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: panghu
 * Date: 2022-04-20
 * Time: 15:37
 */
public class Demo3 {
    public static boolean isValidSudoku(char[][] board) {
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                for(int col1=col+1;col1<9;col1++){
                    //比较一行上是否有一样的元素
                    if(board[row][col]==(board[row][col1])){
                        return false;
                    }
                }

            }
        }

        for(int col=0;col<9;col++){
            for(int row=0;row<9;row++){
                for(int row1=row+1;row1<9;row1++){
                    //比较一列上是否有一样的元素
                    if(board[row][col]==(board[row1][col])){
                        return false;
                    }
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        //新建一个二维数组

        //System.out.println(isValidSudoku(board));
    }
}