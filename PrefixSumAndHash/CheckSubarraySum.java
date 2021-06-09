public class CheckSubarraySum{
    public static void main(String[] args){

    }

    public boolean checkSubarraySum(int[] nums,int k){
        int n = nums.length ;
        int[] left = new int[n];
        left[0] = nums[0] ;
        for( int i = 1 ; i < n ; i ++ ){
            left[i] = left[ i - 1 ] + nums[i] ;
        }
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = i + 1 ; j < n ; j ++ ){
                int cnt = j - i + 1 ;
                int sum ;
                if( i == 0 ){
                    sum = left[j] ;
                }
                else{
                    sum = left[j] - left[ i - 1 ] ;
                }
                if( sum % k == 0 ){
                    return true ;
                }
            }
        }
        return false ;
    }

    public boolean checkSubarraySum1(int[] nums,int k){
        int n = nums.length ;
        HashMap<Integer,Interger> hashTable = new HashMap<>() ;
        int rem = 0 ;
        hashTable.put(0,-1) ;
        for( int i = 0 ; i < n ; i ++ ){
            rem = ( rem + nums[i] ) % k ;
            if( hashTable.get(rem) != null ){
                int preindex = hashTable.get(rem) ;
                if( i - preindex > 2 ){
                    return true ;
                }
            }
            else{
                hashTable.put(rem,i) ;
            }
        }
        return false ;
    }
}