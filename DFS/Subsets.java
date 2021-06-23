public class Subsets{

    List<Integer> tmp = new ArrayList<Integer>() ;
    List<List<Integer>> ans = new ArrayList<List<Integer>>() ;

    public List<List<Integer>> subsets(int[] nums){
        dfs(0,nums) ;
    }

    public void dfs(int i,int[] nums){
        if( i == nums.length - 1 ){
            ans.add( new ArrayList(tmp)) ;
            retutn ;
        }
        //选当前元素
        tmp.add(nums[i]) ;
        dfs( i + 1 , nums) ;
        //不选当前元素 
        tmp.remove( nums.length - 1 ) ;
        dfs( i + 1 , nums) ;
    }
    //此写法超时
    // Set<Set<Integer>> lists = new HashSet<Set<Integer>>() ; 
    // List<List<Integer>> ans = new ArrayList<List<Integer>>() ;

    // public void DFS(Set<Integer> hs,Set<Integer> set,int[] nums){
    //     if( !lists.contains(hs) ){
    //         lists.add(new HashSet(hs)) ;
    //         ans.add(new ArrayList(hs)) ;
    //     }
    //     for( int i = 0 ; i < nums.length && hs.size() < nums.length ; i ++ ){
    //         int item = nums[i] ;
    //         if( !set.contains(item) ){
    //             hs.add(item) ;
    //             set.add(item) ;
    //             DFS(hs,set,nums) ;
    //             hs.remove(item) ;
    //             set.remove(item) ;
    //         }
    //     }
    // }

    // public List<List<Integer>> subsets(int[] nums) {
    //     Set<Integer> set = new HashSet<Integer>() ;
    //     ans.add(new ArrayList<Integer>()) ;
    //     for(int item : nums ){
    //         HashSet<Integer> hs = new HashSet<Integer>() ;
    //         hs.add(item) ;
    //         set.add(item) ;
    //         DFS(hs,set,nums) ;
    //         hs.remove(item) ;
    //         set.remove(item) ;
    //     }
    //     // System.out.println(ans.size()) ;
    //     return ans ;
    // }
}