package main.leetcode.string;

public class NumberToWords {

    String[] digitToString = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen"
    ,"Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"} ;
    String[] shiwei = {"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"} ;
    String[] scale = {"Billion","Million","Thousand",""} ;
    public String hundredToWords(int num){
        if( num == 0 ){
            return "";
        }
        else if( num < 20 ){
            return digitToString[num] ;
        }
        StringBuilder sb = new StringBuilder() ;
        if( num >= 100 ){
            sb.append( digitToString[ num / 100 ] ) ;
            sb.append(" Hundred") ;
            num = num % 100 ;
        }
        if( num > 0 && num < 20 ){
            sb.append(" " ) ;
            sb.append(digitToString[num]) ;
            return sb.toString() ;
        }
        else if( num > 0 ){
            if( sb.length() != 0 ){
                sb.append(" ") ;
            }
            sb.append( shiwei[ (num / 10 ) - 2]) ;
            num = num % 10 ;
        }
        if( num > 0 ){
            sb.append(" ") ;
            sb.append( digitToString[num] ) ;
        }
        return sb.toString() ;
    }

    public String numberToWords(int num){
        if( num == 0 ){
            return "Zero" ;
        }
        int start = 1000000000 ;
        StringBuilder ans = new StringBuilder() ;
        for( int i = 0 ; i < 4 ; i ++ ){
            int digit = num / start ;
            String str = hundredToWords(digit) ;
            if( ( ans.length() > 0 && ans.toString().charAt(ans.length() - 1 ) != ' ') && str.length() > 0 ){
                ans.append(" ") ;
            }
            ans.append( hundredToWords(digit) ) ;
            if( str.length() > 0 && i < 3 ){
                ans.append(" ") ;
                ans.append(scale[i]) ;
            }
            num = num % start ;
            start = start / 1000 ;
        }
        return ans.toString() ;
    }
}
