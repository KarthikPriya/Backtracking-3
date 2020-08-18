class Solution {
	//Approach: 1. The word might be in either horizontal or vertical directions. So we do dfs with the 4 directions and see if a particular word exist in the board. 
	//2. if any of the characters is not there, we will return false orelse we will keep iterating and complete the word search. We do backtracking here by replacing the character when we come back from the recursion.
	
    int m, n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        m = board.length;
        n = board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(dfs(board, word, i , j , 0))return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int index)
    {
        //base case
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '#')
            return false;
        if(index == word.length()) return true;
        
        //logic
        int[][] directions = {{0,1}, {0, -1}, {1,0}, {-1, 0}};
        if(board[i][j] == word.charAt(index))
        {
            if(index == word.length() - 1) return true;
            
            char ch = board[i][j];
            board[i][j] = '#';
            
            for(int[] dir: directions)
            {
                int r = i + dir[0];
                int c = j + dir[1];
                if(dfs(board, word, r,c,index+1))return true;       
            }
            board[i][j] = ch;
        }
        return false;
    }
}

//Time Complexity : O(m*n (3 ^ l)), m and n are board length and width, and l is the length of the word.
//Space Complexity : O(m*n) , recursion stack space
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No