package main.leetcode.string;

public class MinTimeToType {

    public int minTimeToType(String word){
        int ans = 0 ;
        int nowCh = 'a' ;
        for( int i = 0 ; i < word.length() ; i ++ ){
            int ch = word.charAt(i) ;
            if( nowCh != ch ){
                int tmp = (int )'z' - 'a' + 1 ;
                int clock = nowCh > ch ? 'z' - nowCh + ch - 'a' + 1 : ch - nowCh ;
                int counterClock = nowCh > ch ? nowCh - ch : 'z' - ch + nowCh - 'a' + 1 ;
                ans = ans + Math.min( clock , counterClock ) + 1 ;
            }
        }
        return ans ;
    }
}
