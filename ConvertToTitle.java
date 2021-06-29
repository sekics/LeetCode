public class ConvertToTitle{
    
    public String convertToTitle(int columnNumber){
        char[] chs = new char[26] ;
        chs[0] = 'A' ;
        for( int i = 1 ; i < 26 ; i ++ ){
            chs[i] = (char) ( chs[ i - 1 ] + 1 );
        }
        StringBuffer sb = new StringBuffer() ;
        char ch ;
        while( columnNumber > 0 ){
            columnNumber -- ;
            ch = chs[ columnNumber % 26 ] ;
            sb.ap ;
            columnNumber /= 26 ;
        }
        sb.reverse() ;
        return sb.toString() ;
    } 
}