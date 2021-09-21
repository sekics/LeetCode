package main.leetcode;

public class SplitListToParts {

    public ListNode[] splitListToParts(ListNode head, int k){
        int cnt = 0 ;
        ListNode tmp = head ;
        while( tmp != null ){
            cnt ++ ;
            tmp = tmp.next ;
        }
        int avg = cnt / k ;
        int remain = cnt % k ;
        tmp = head ;
        ListNode[] ans = new ListNode[k] ;
        for( int i = 0 ; i < k ; i ++ ){
            int num = i >= remain ? avg : avg + 1 ;
            ListNode newHead = null;
            ListNode newTmp = null ;
            while( num > 0 ){
                if( newHead == null ){
                    newHead = new ListNode() ;
                    newTmp = newHead ;
                }
                else{
                    newTmp.next = new ListNode() ;
                    newTmp = newTmp.next ;
                }
                newTmp.val = tmp.val ;
                tmp = tmp.next ;
                num -- ;
            }
            ans[i] = newHead ;
        }
        return ans ;
    }
}
