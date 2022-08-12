package offer12;

public class MySolution {
    public boolean exist(char[][] board, String word) {
        int h = board.length,w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board,visited,i,j,word,0);
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board,boolean[][] visited,int i,int j,String s,int k){
        if(board[i][j] != s.charAt(k)){
            return false;
        }else if (k == s.length() - 1){
            return true;
        }
        int[][] dics  = {{0,1},{0,-1},{1,0},{-1,0}};
        visited[i][j] = true;
        boolean result = false;
        for (int[] dic: dics) {
            int new_i = dic[0] + i, new_j = dic[1] + j;
            if (new_i >= 0 && new_i < board.length && new_j >= 0 && new_j < board[0].length){
                if(!visited[new_i][new_j]){
                    boolean flag = check(board,visited,new_i,new_j,s,k + 1);
                    if (flag){
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
