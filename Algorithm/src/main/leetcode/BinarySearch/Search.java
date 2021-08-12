class Search{
    public int search(int[] nums,int target){
        int n = nums.length ;
        int left = 0 , right = n - 1 ;
        int mid = 0 ;
        while( left <= right ){
            mid = ( left + right ) / 2 ;
            if( nums[mid] == target ){
                break ;
            }
            else if( nums[mid] < target ){
                left = mid + 1 ;
            }
            else{
                right = mid - 1 ;
            }
        }
        if( nums[mid] == target ){
            int cnt = 1 ;
            left = mid - 1 ;
            while( left >= 0 && nums[left] == target ){
                left -- ;
                cnt ++ ;
            }
            right = mid + 1 ;
            while( right < n && nums[right] == target ){
                cnt ++ ;
                right ++ ;
            }
            return cnt ;
        }
        else{
            return 0 ;
        }
    }
}