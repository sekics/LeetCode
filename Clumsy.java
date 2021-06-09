public class Clumsy{
    
    public static void main(String[] args){
        
    }

    public static int clumsy(int N){
        if(N == 1){
            return 1;
        }
        if(N == 2){
            return 2;
        }
        if(N == 3){
            return 6;
        }
        int rs = N * ( N - 1 ) / ( N - 2 ) + ( N - 3 );
        N = N - 4 ;
        int groups = N / 4 ;
        for( int i = 0 ; i < groups ; i ++ ){
            rs = rs - N * ( N - 1 ) / ( N - 2 ) + ( N - 3 ) ;
            N = N - 4 ;
        }
        if( N == 3 ){
            return rs - 6 ;
        }
        else if( N == 2 ){
            return rs - 2 ;
        }
        else{
            return rs - N ;
        }
    }
}