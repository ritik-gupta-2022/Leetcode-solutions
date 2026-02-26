class Solution {
    Map<Integer, Set<Integer>> row = new HashMap<>();
    Map<Integer, Set<Integer>> col = new HashMap<>();
    Map<Integer, Set<Integer>> box = new HashMap<>();

    public int getBox(int i, int j){
        int b=-1;
        if(i<=2 && j<=2) b=0;
        if(i<=2 && (j>2 && j<=5)) b=1;
        if(i<=2 && j>5) b=2;
        if((i>2 && i<=5) && j<=2) b=3;
        if((i>2 && i<=5) && (j>2 && j<=5)) b=4;
        if((i>2 && i<=5) && j>5) b=5;
        if(i>5 && j<=2) b=6;
        if(i>5 && (j>2 && j<=5)) b=7;
        if(i>5 && j>5) b=8;

        return b;
    }
    public boolean helper(char arr[][], int i, int j){
        int b = getBox(i,j);
        int ele = arr[i][j]-'0';
        
        Set<Integer> r = row.get(i);
        Set<Integer> c = col.get(j);
        Set<Integer> bx = box.get(b);

        if(!r.contains(ele) && !c.contains(ele) && !bx.contains(ele)){
            r.add(ele);
            c.add(ele);
            bx.add(ele);
            row.put(i,r);
            col.put(j,c);
            box.put(b,bx);
            return true;
        }
        return false;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            row.put(i,new HashSet<>());
            col.put(i,new HashSet<>());
            box.put(i,new HashSet<>());
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]=='.') continue;
                if(!helper(board,i,j)) return false;
            }
        }
        return true;
    }
}