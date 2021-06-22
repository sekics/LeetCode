public class addBinary{
    public String dispose(String ans,String str,int now,int jinwei ){
        if( jinwei == 0 ){
            while( now >= 0 ){
                ans = str.charAat( now -- ) + ans ;
            }
        }
        else{
            while( now >= 0 ){
                if( jinwei == 1 && str.charAt(now) == '1'){
                    ans = "0" + ans ;
                    jinwei = 1 ;
                }
                else if( jinwei == 1 && str.charAt(now) == '0' ){
                    ans = "1" + ans ;
                }
                else{
                    ans = str.charAt(now) + ans ;
                }
            }
        }
        return ans ;
    }
    public String addBinary(String a,String b){
        int nA = a.length() - 1 , nB = b.length() - 1 ;
        String ans = "" ;
        int jinwei = 0 ;
        while( nA >= 0 && nB >= 0 ){
            if( ( a.charAt(nA) & b.charAt(nB) ) == 1 ){
                ans = jinwei == 1 ? "0" + ans : "1" + ans ;
            }
            else{
                if( a.charAt(nA) == '0' ){
                    ans = jinwei == 1 ? "1" + ans : "0" + ans ;
                    jinwei = 0 ;
                }
                else{
                    ans = jinwei == 1 ? "1" + ans : "0" + ans ;
                    jinwei = 1 ;
                }
            }
            nA -- ;
            nB -- ;
        }
        if( nA == 0 ){
            dispose(ans,b,nB,jinwei) ;
        }
        else{
            dispose(ans,a,nA,jinwei) ;
        }
        return ans ;
    }
}