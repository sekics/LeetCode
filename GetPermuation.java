import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class GetPermuation{
    
    public String getPermutation1(int n,int k){
        int[] factorial = new int[ n + 1 ] ;
        factorial[0] = 1 ;
        List<Integer> queue = new ArrayList<Integer>() ;
        for( int i = 1 ; i <= n ; i ++ ){
            queue.add( n - i + 1 ) ;
            factorial[i] = factorial[ i - 1 ] * i ;
        }
        int cnt = n - 1 ;
        StringBuilder sb = new StringBuilder() ;
        while( !queue.isEmpty() && cnt >= 0 ){
            int order = (int) Math.ceil( n / factorial[cnt] ) ;
            sb.append( String.valueOf(queue.get( order - 1 ) ) ) ;
            queue.remove( order - 1 ) ;
            n = n % ( factorial[ cnt -- ] + 1 ) ;
        }
        return sb.toString() ;
    }

    public String getPermutation2(int n, int k) {
        int[] factorial = new int[ n + 1 ] ;
        factorial[0] = 1 ;
        List<Integer> queue = new ArrayList<Integer>() ;
        for( int i = 1 ; i <= n ; i ++ ){
            queue.add( i ) ;
            factorial[i] = factorial[ i - 1 ] * i ;
        }
        // factorial[1] = 2 ;
        int cnt = n - 1 ;
        StringBuilder sb = new StringBuilder() ;
        while( !queue.isEmpty() && cnt >= 0 ){
            System.out.println( k + " " + factorial[cnt] + " " + factorial[queue.size()] + " " + queue.size() ) ;
            // int order = (int) Math.ceil( k / factorial[cnt] ) ;
            // int order = k / Math.max(factorial[ cnt ],queue.size()) ;
            int order =  ( k  ) / ( factorial[ cnt ] + 1 );
            int num ;
            if( queue.size() == 1 ){
                num = queue.get(0) ;
                queue.remove(0) ;
            }
            else{
                num = queue.get(order) ;
                queue.remove(order) ;
            }
            System.out.println( order + " " + num ) ;
            sb.append( String.valueOf( num ) ) ;
            // k = k % ( factorial[ queue.size()]  ) ;
            // queue.remove( order ) ;
            // k = k % Math.max( ( factorial[ cnt -- ]  ) , factorial[queue.size()]) ;
            // k = k % ( factorial[ cnt -- ] ) ;
            k = k - ( num - 1 ) * factorial[ cnt -- ] ;
            System.out.println("--") ;
        }
        return sb.toString() ;
    }

    public String getPermutation3(int n, int k) {
        int[] factorial = new int[ n + 1 ] ;
        factorial[0] = 1 ;
        List<Integer> queue = new ArrayList<Integer>() ;
        for( int i = 1 ; i <= n ; i ++ ){
            queue.add( i ) ;
            factorial[i] = factorial[ i - 1 ] * i ;
        }
        // factorial[1] = 2 ;
        int cnt = n - 1 ;
        StringBuilder sb = new StringBuilder() ;
        while( !queue.isEmpty() && cnt >= 0 ){
            if( k == 0 ){
                while( !queue.isEmpty() ){
                    sb.append(String.valueOf(queue.get(queue.size() - 1 ))) ;
                    queue.remove( queue.size() - 1 ) ;
                }
            }
            else{
                // System.out.println( k + " " + factorial[cnt] ) ;
                int order =  ( k - 1 ) / ( factorial[ cnt ]  );
                int num = queue.get(order) ;
                queue.remove(order) ;
                sb.append( String.valueOf( num ) ) ;
                k = k % factorial[ cnt -- ] ;
            }

        }
        return sb.toString() ;
    }
}