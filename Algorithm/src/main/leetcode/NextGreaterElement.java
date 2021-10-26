package main.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        int n = nums2.length, m = nums1.length ;
        int[] bigger = new int[n] ;
        Stack<Integer> stack = new Stack<>() ;
        Map<Integer,Integer> num_to_index = new HashMap<>() ;
        num_to_index.put(nums2[0],0) ;
        stack.push(0) ;
        int top = nums2[0] ;
        int index = 0 ;
        for( int i = 1 ; i < n ; i ++ ){
            num_to_index.put(nums2[i] , i) ;
            index = stack.peek() ;
            top = nums2[index] ;
            if( nums2[i] > top ){
                while( !stack.isEmpty() && top < nums2[i] ){
                    bigger[index] = i ;
                    stack.pop() ;
                    if( !stack.isEmpty() ){
                        index = stack.peek() ;
                        top = nums2[index] ;
                    }
                }
            }
            stack.push(i) ;
        }
        while( !stack.isEmpty() ){
            index = stack.pop() ;
            bigger[index] = -1 ;
        }
        int[] ans = new int[m] ;
        for( int i = 0 ; i < m ; i ++ ){
            index = num_to_index.get(nums1[i]) ;
            ans[i] = bigger[index] == -1 ? -1 : nums2[bigger[index]] ;
        }
        return ans ;
    }
}
