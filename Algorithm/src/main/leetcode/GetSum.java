package main.leetcode;

public class GetSum {

    public int[] convertToBinary( int num ){
        int[] ans = new int[ 11 ] ;
        ans[10] = num >= 0 ? 0 : 1 ;
        for( int i = 0 ; i < 10 ; i ++ ){
            ans[i] = num & 1 ;
            num = num >>> 1 ;
        }
        //当作无符号数位移了，高位补零了所以变成正数了
        // ans[10] = num >= 0 ? 0 : 1 ;
        return ans ;
    }

    public int converToNum( int[] binary ){
        int ans = 0 ;
        if( binary[10] == 1 ){
            int i = 0 ;
            while( binary[i] == 0 ){
                binary[i] = 1 ;
                i ++ ;
            }
            binary[i] = 0 ;
            for(  i = 0 ; i < 10 ; i ++ ){
                binary[i] = binary[i] == 1 ? 0 : 1 ;
            }
        }
        // System.out.println( Arrays.toString(binary) ) ;
        int[] table = new int[10] ;
        table[0] = 1 ;
        for( int i = 1 ; i <= 9 ; i ++ ){
            table[i] = table[ i - 1 ] << 1 ;
        }
        // System.out.println( Arrays.toString(table) ) ;
        // System.out.println( Arrays.toString(binary) ) ;
        for( int i = 0 ; i <= 9 ; i ++ ){
            if( binary[i] == 1 ){
                ans = ans ^ table[i] ;
            }
        }
        return binary[10] == 1 ? -ans : ans ;
    }
    public int getSum(int a, int b) {
        int[] binaryA = convertToBinary(a) ;
        int[] binaryB = convertToBinary(b) ;
        int jinwei = 0 ;
        for( int i = 0 ; i < 11 ; i ++ ){
            if( ( jinwei & binaryA[i] & binaryB[i] ) == 1 ){
                binaryA[i] = 1 ;
                jinwei = 1 ;
            }
            else if( ( (jinwei & binaryA[i])== 1 ) || ( (jinwei & binaryB[i]) == 1 ) || ( (binaryA[i] & binaryB[i]) == 1 )){
                jinwei = 1 ;
                binaryA[i] = 0 ;
            }
            else if( ( jinwei | binaryA[i] | binaryB[i] ) == 1 ){
                jinwei = 0 ;
                binaryA[i] = 1 ;
            }
            else{
                binaryA[i] = 0 ;
            }
        }
        int ans = converToNum(binaryA) ;
        return ans ;
    }

    public int getSumI( int a , int b ){
        int sum = 0 , carry = 0 ;
        sum = a ^ b ;
        carry = ( a & b ) << 1 ;
        if( carry != 0 ){
            return getSumI( sum , carry) ;
        }
        return sum ;
    }
}
