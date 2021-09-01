package main.leetcode.string;

public class CompareVersion {

    public int compareVersion( String version1 , String version2 ){


        String[] splits1 = version1.split("\\.") ;
        String[] splits2 = version2.split("\\.") ;
        int l1 = splits1.length ;
        int l2 = splits2.length ;

        int i = 0 , j = 0 ;

        while( i < l1 && j < l2 ){

            int num1 = Integer.parseInt( splits1[ i ++ ] ) ;
            int num2 = Integer.parseInt( splits2[ j ++ ] ) ;
            if( num1 > num2 ){
                return 1 ;
            }
            else if( num1 < num2 ){
                return -1 ;
            }
            else{
                continue ;
            }
        }

        while( i < l1 ){
            int num = Integer.parseInt( splits1[ i ++ ] ) ;
            if( num > 0 ){
                return 1 ;
            }
        }

        while( j < l2 ){
            int num = Integer.parseInt( splits2[ j ++ ] ) ;
            if( num > 0 ){
                return -1 ;
            }
        }
        return 0 ;
    }

}
