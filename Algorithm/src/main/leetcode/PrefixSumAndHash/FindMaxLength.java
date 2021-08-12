import java.util.HashMap;

public class FindMaxLength{
    
    public static void main(String[] args){
        
    }

    public int findMaxLength(int[] nums){
        //超内存
        int n = nums.length ;
        int[][] dp0 = new int[n][n] , dp1 = new int[n][n] ;
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = i ; j < n  ; j ++ ){
                if( i == j ){
                    dp0[i][j] = nums[j] == 0 ? 1 : 0 ;
                    dp1[i][j] = nums[j] == 1 ? 1 : 0 ;
                }
                else{
                    dp0[i][j] = nums[j] == 0 ? dp0[i][ j - 1 ] + 1 : dp0[i][ j - 1 ];
                    dp1[i][j] = nums[j] == 1 ? dp1[i][ j - 1 ] + 1 : dp1[i][ j - 1 ];
                }
            }
        }
        int max = 0 ;
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = n - 1 ; j > i ; j -- ){
                if( dp0[i][j] == dp1[i][j] && ( j - i + 1 ) > max){
                    max = j - i + 1 ;
                }
            }
        }
        return 0 ;
    }

    public int findMaxLength2(int[] nums){
        int n = nums.length ;
        HashMap<Integer,Integer> hashTable = new HashMap<Integer,Integer>() ;
        int sum = 0 ;
        int ans = 0 ;
        hashTable.put(0,-1) ;
        for( int i = 0 ; i < n ; i ++ ){
            sum = nums[i] == 0 ? sum - 1 : sum + 1 ;
            if( hashTable.containsKey(sum) ){
                int preIndex = hashTable.get(sum) ;
                ans = Math.max(ans,i - preIndex) ;
            }
            else{
                hashTable.put(sum,i) ;
            }
        }
        return ans ;
    }
}