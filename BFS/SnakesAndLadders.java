public class SnakesAndLadders{
    
    public int[] getIndex(int i,int c,int flag){
        int[] rs = new int[2] ;
        rs[0] = c - i / c - 1 ;
        if( flag == 0 ){
            rs[1] = i % c ;
        }
        else{
            rs[1] = c - ( i % c ) - 1 ;
        }
        return rs ;
    }

    public int[] getIndex(int i ,int c){
        int[] rs = new int[2] ;
        rs[0] = c - i/c - 1 ;
        if( c % 2 == 1 ){
            rs[1] = rs[0] % 2 == 1 ? i % c : c - ( i % c ) - 1 ;
        }
        else{
            rs[1] = rs[0] % 2 == 0 ? i % c : c - ( i % c ) - 1 ;
        }
        return rs ;
    }
    public int snakesAndLadders(int[][] board){
        int n = board.length ;
        int N = n * n ;
        int[] dp = new int[ N ] ;
        dp[0] = 0 ;
        int row , col ;
        for( int i = 0 ; i < N ; i ++ ){
            int[] indexes = getIndex(i,n) ;
            row = indexes[0] ;
            col = indexes[1] ;

            if( board[row][col] != -1 ){
                dp[board[row][col]] = Math.min(dp[board[row][col]],dp[i]) ;
            }
            else{
                for( int j = i + 1 ; j <= j + 6 && j < N ; j ++ ){
                    dp[j] = Math.min( dp[j] ,dp[i] + 1 ) ;
                }
            }
        }
        return dp[ N - 1 ] ;
    }

    public int snakesAndLaddersBFS(int[][] board){
        int n = board.length ;
        int N = n * n ;
        Set<Integer> seen = new HashSet<Integer>() ;
        Queue<Integer> nextLayer = new LinkedList<Integer>() ;
        int level = -1 ;
        nextLayer.offer(1) ;
        seen.add(1) ;
        while( !nextLayer.isEmpty() ){
            int size = nextLayer.size() ;
            level ++ ;
            for( int i = 0 ; i < size ; i ++ ){
                int now = nextLayer.poll() ;
                int[] nowI = getIndex(now -1 ,n) ;
                int item0 = board[nowI[0]][nowI[1]] ;
                // if( item0 != -1 && !seen.contains(item0)){
                //     nextLayer.offer(item0) ;
                //     seen.add(item0) ;
                //     continue ;
                // }
                for( int j = now + 1 ; j <= now + 6 && j <= N ; j ++ ){
                    int[] indexes = getIndex(j - 1 , n) ;
                    int item = board[indexes[0]][indexes[1]] ;
                    // System.out.println(j) ;
                    // System.out.println(Arrays.toString(indexes)) ;
                    // System.out.println(j) ;
                    // System.out.println(item) ;
                    if( item == -1 && !seen.contains(j) ){
                        nextLayer.offer(j) ;
                        seen.add(j) ;
                    }
                    else if( item != -1  ){
                        seen.add(j) ;
                        if( !seen.contains(item) ){
                            seen.add(item) ;
                            nextLayer.offer(item) ;
                        }
                    }
                }
                if( now == N ){
                    return level ;
                }
            }
            // System.out.println(nextLayer.toString()) ;
        }
        return -1 ;
    }
}