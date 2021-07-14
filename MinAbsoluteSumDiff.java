class MinAbsoluteSumDiff{

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length ;
        int maxN = (int) 1e5 ;
        int mod = (int)1e9 + 7 ; 
        int[] diff = new int[n] ;
        int[] sorted = new int[n] ;
        sorted = nums1.clone() ;
        Map<Integer,List<Integer>> map = new HashMap<>() ;
        for( int i = 0 ; i < n ; i ++ ){
            int re = (int) Math.abs( nums1[i] - nums2[i]) ;
            diff[i] = re ;
            List<Integer> list = map.get(re) == null ? new ArrayList<>() : map.get(re) ;
            list.add(i) ;
            map.put(re,list) ;
        }
        Arrays.sort(diff) ;
        Arrays.sort( sorted ) ;
        System.out.println(Arrays.toString(diff)) ;
        System.out.println(Arrays.toString(sorted)) ;
        int max = 0 ;
        int maxIndex = -1 ;
        int min = mod ;
        for( int i = n - 1 ; i >= 0 ; i -- ){
            List<Integer> list = map.get(diff[i]) ;
            for( int j = 0 ; j < list.size() ; j ++ ){
                int index = list.get(j) ;
                // System.out.println( diff[i] + " " + index) ;
                if( max > diff[i] || diff[i] == 0 ){
                    continue ;
                }
                int nearIndex = binarySearch(sorted,nums2,index) ;
                // System.out.println( nums2[index] + "--" + nearIndex + "--" + sorted[nearIndex] ) ;
                int gain = Math.abs( nums1[index] - nums2[index] ) - Math.abs( nums2[index] - sorted[nearIndex] ) ;
                // System.out.println(gain) ;
                if( gain > max ){
                    // System.out.println("change maxIndex:" + index) ;
                    maxIndex = index ;
                    max = gain ;
                    min = Math.abs( nums2[index] - sorted[nearIndex] ) ;
                }
            }
        }
        int rs = 0 ;
        for( int i = 0 ; i < n ; i ++ ){
            if( i == maxIndex ){
                rs = ( rs + min ) % mod ;
            }
            else{
                rs = ( rs + Math.abs( nums2[i] - nums1[i] ) ) % mod ;
            }
        }
        return rs ;
    }

    public int binarySearch(int[] nums1,int[] nums2,int index){
        if( nums1.length == 1 ){
            return 0 ;
        }
        int target = nums2[index] ;
        int left = 0 ;
        int right = nums1.length - 1 ;
        int mid ;
        while( left <= right ){
            mid = ( left + right ) / 2 ;
            if( nums1[mid] == target ){
                return mid ;
            }
            else if( nums1[mid] > target ){
                right = mid - 1 ;
            }
            else{
                left = mid + 1 ;
            }
        }
        if( left == 0 ){
            return left ;
        }
        else if( left == nums1.length ){
            return right ;
        }
        else{
            return Math.abs( target - nums1[left] ) < Math.abs(target - nums1[right]) ? left : right ;
        }
    }
}