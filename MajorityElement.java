public class MajorityElement{

    //两遍
    //第一遍投票
    //第二遍统计频率
    public int majorityElement(int[] nums){
        int n = nums.length ;
        int nowCnt = 1 ;
        int nowEle = nums[0] ;
        for( int i = 1 ; i < n ; i ++ ){
            if( nums[i] == nowEle ){
                nowCnt ++ ;
            }
            else if( nowCnt == 0 ){
                nowCnt = 1 ;
                nowEle = nums[i] ;
            }
            else{
                nowCnt -- ;
            }
        }
        int freq = 0 ;
        for( int item : nums ){
            if( item == nowEle){
                freq ++ ;
            }
        }
        return freq > n / 2 ? nowEle : -1 ;
    }

}