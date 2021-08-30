package main.leetcode.string;

import java.util.Arrays;
import java.util.Comparator;

public class KthLargestNumber {

    public String kthLargestNumber(String[] nums , int k ){
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if( o1.length() != o2.length() ){
                    return o1.length() - o2.length() ;
                }
                else{
                    for( int i = 0 ; i < o1.length() ; i ++ ){
                        if( o1.charAt(i) != o2.charAt(i) ){
                            return o1.charAt(i) - o2.charAt(i) ;
                        }
                    }
                    return 0 ;
                }
            }
        }) ;

        return nums[ nums.length - k ] ;
    }
}
