import java.util.ArrayList;
import java.util.List;

class Solution {
	//Approach: 1. So here we place a queen at the first row and then try placing the other queens at other rows, if we are not able to we can backtrack and move the queens.
	//2. We have an isSafe function, which helps in concluding whether there is a queen in the same column, or in diagonal up right direction or in diagonal up left direction.
	//3. We are checking only these places because we are processing from top to bottom and have not placed any queens at the bottom level.
	
	
    List<List<String>> result;int m;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        m =n;
        board = new int[n][n];
        backtrack(0);
        return result;
    }
    private void backtrack(int row)
    {
     //adding board to result   
        if(row == m)
        {
            List<String> list = new ArrayList<>();
            for(int i=0;i<m;i++)
            {
                StringBuilder str = new StringBuilder();
                for(int j=0;j<m;j++)
                {
                    if(board[i][j] == 1)
                        str.append('Q');
                    else
                        str.append('.');
                }
                list.add(str.toString());
            }
            result.add(list);
            return;
        }
        //finding where to place the queeen
        for(int j=0;j<m;j++)
        {
            if(isSafe(row, j))
            {
                //action
                board[row][j] = 1;
                //recurse
                backtrack(row+1);
                //backtrack
                board[row][j] = 0;
            }
        }
    }
    private boolean isSafe(int row, int column)
    {
        //check column
        for(int i=0;i<row;i++)
        {
            if(board[i][column] == 1)return false;
        }
        //diagonal right
        int i = row-1; int j = column +1;
        while(i >=0 && j < m)
        {
            if(board[i][j] == 1)return false;
            i--;j++;
        }
        //diagonal up left
        i = row - 1; j = column - 1;
        while(i >= 0 && j >= 0)
        {
            if(board[i][j] == 1)return false;
            i--;j--;
        }
        return true;
    }
}

//Time Complexity : O(n!), at each row there are n choices, the series goes like n-2, n-4 forming a 

//Space Complexity : O(n^2)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :