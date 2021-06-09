public class CanJump{
    
    public static void main(String[] args){
        
    }

    public boolean canJump(int[] nums){

        int now = 0 ;
        int n = nums.length ;
        while( now < n && nums[now] != 0 ){
            //System.out.println( now + " " + nums[now]);
            if( now + nums[now] >= n - 1 ){
                return true;
            }
            int max = 0 ;
            int next = now ;
            int j ;
            for( j = now + 1 ; j <= now + nums[now] ; j ++ ){
                if( j < n && j + nums[j] > max ){
                    max = j + nums[j] ;
                    next = j ;
                }
            }
            now = next ;
        }
        if( now < n - 1 ){
            return false ;
        }
        else{
            return true ;
        }
    }

    public boolean canJump2(int[] nums){
        int n = nums.length ;
        for( int i = 0 ; i < n ; i ++ ){
            if( nums[i] == 0 ){
                int j = i ;
                while( j >= 0 && i - j >= nums[i]){
                    j -- ;
                }
                if( j < 0 ){
                    return false ;
                }
            }
        }

        return true ;
    }
}