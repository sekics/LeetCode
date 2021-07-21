package main.leetcode;

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        int cntA = 0 , cntB = 0 ;
        ListNode tmp = headA ;
        while( tmp != null ){
            cntA ++ ;
            tmp = tmp.next ;
        }
        tmp = headB ;
        while( tmp != null ){
            cntB ++ ;
            tmp = tmp.next ;
        }
        ListNode tmpA = headA ;
        ListNode tmpB = headB ;
        if( cntA > cntB ){
            while( cntA > cntB ){
                cntA -- ;
                tmpA = tmpA.next ;
            }
        }
        else if( cntA < cntB ){
            while( cntB > cntA ){
                cntB -- ;
                tmpB = tmpB.next ;
            }
        }
        while( tmpA != null && tmpB != null ){
            if( tmpA == tmpB ){
                return tmpA ;
            }
            tmpA = tmpA.next ;
            tmpB = tmpB.next ;
        }
        return null ;
    }

    public ListNode getIntersectionNodeOptim( ListNode headA,ListNode headB ){
        int[] cnt = new int[2] ;
        ListNode[] tmpNodes = new ListNode[2] ;
        tmpNodes[0] = headA ;
        tmpNodes[1] = headB ;
        ListNode tmpNode ;
        for( int i = 0 ; i < 2 ; i ++ ){
            tmpNode = tmpNodes[i] ;
            while( tmpNode != null ) {
                tmpNode = tmpNode.next;
                cnt[i] ++ ;
            }
        }
        int larger = cnt[0] > cnt[1] ? 0 : 1 ;
        tmpNode = tmpNodes[larger] ;
        while( cnt[larger] > cnt[ larger ^ 1 ] ){
            tmpNode = tmpNode.next ;
            cnt[larger] -- ;
        }
        tmpNodes[larger] = tmpNode ;
        while( tmpNodes[0] != null && tmpNodes[1] != null ){
            if( tmpNodes[0] == tmpNodes[1] ){
                return tmpNodes[0] ;
            }
            tmpNodes[0] = tmpNodes[0].next ;
            tmpNodes[1] = tmpNodes[1].next ;
        }
        return null ;
    }
}
