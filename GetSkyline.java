import java.util.Arrays;

class GetSkyline{

    public static void main(String[] args){
        List<List<Integer>> buildingList = new ArrayList<List<Integer>>() ;
        int n = buildings.length ;
        for( int i = 0 ; i < n ; i ++ ){
            List<Integer> building = Arrays.asList(building[i]) ;
            buildingList.add(building) ;
        }
    }

    public void generate(int x,int height,List<List<Integer>> rs){
        List<Integer> t = new ArrayList<Integer>() ;
        t.add(x) ;
        t.add(height) ;
        rs.add(t) ;
    }
    public List<List<Integer>> getSkyline(int[][] buildings){
        int n = buildings.length ;
        //对数组按照第一个元素进行升序排序,使用sort进行排序其数据类型不能为int,long char基本类型
        //Arrays.sort(buildings,(int[] a , int[] b) -> a[0] - b[0] ) ;
        //对数组按照第一个元素进行降序排序
        //Arrays.sort(buildings,(int[]a , int[] b) -> b[0] - a[0] ) ;
        List<List<Integer>> keyPoints = new ArrayList<List<Integer>>() ;
        int[] pre ;
        // int nowHight = 0 ;
        // int nowLeft = 0 ;
        // int nowRight = 0 ;
        for( int i = 0 ; i < n ; i ++ ){
            int[] building = buildings[i] ;
            //第一个大楼
            if( i == 0 ){
                generate(building[0],building[2],keyPoints) ;
                pre = building ;
            }
            else{
                //如果和上个大楼有重叠
                if( building[0] < pre[1] ){
                    //如果高度相等
                    if( building[2] == pre[2] ){
                        //如果当前大楼的右端点比上个大楼右端点更大，更新
                        if( building[1] > pre[1] ){
                            pre = building ;
                        }
                    }
                    //如果高度不相等
                    else if( building[2] > pre[2] ){
                        //如果当前更高的建筑先结束
                        generate(building[0], building[2], keyPoints);
                        if( building[1] < pre[1] ){
                            generate(building[1], pre[2], keyPoints) ;
                        }
                        else{
                            pre = building ;
                        }
                    }
                    else if( building[2] < pre[2] ){
                        while( i + 1 < n && buildings[ i + 1 ][0] < pre[1] && buildings[ i + 1 ][1] > )
                        if( building[1] > pre[1] ){
                            generate(pre[1], building[2], keyPoints);
                            pre = building ;
                        }
                    }
                }
                //如果和上个大楼没有重叠
                else{
                    generate(building[0],building[2],keyPoints) ;
                    pre = building ;
                }
            }
        }
    }

    public List<List<Integer>> getSkyline1(int[][] buildings) {
        // x轴从小到大排序，如果x相等，则按照高度从低到高排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int[] building : buildings) {
            // 左端点和高度入队，高度为负值说明是左端点
            pq.offer(new int[] { building[0], -building[2] });
            // 右端点和高度入队
            pq.offer(new int[] { building[1], building[2] });
        }

        List<List<Integer>> res = new ArrayList<>();

        // 降序排列
        TreeMap<Integer, Integer> heights = new TreeMap<>((a, b) -> b - a);
        heights.put(0, 1);
        int left = 0, height = 0;
        
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            // 如果是左端点
            if (arr[1] < 0) {
                // 高度 --> 高度 + 1
                heights.put(-arr[1], heights.getOrDefault(-arr[1], 0) + 1);
            } 
            // 右端点
            else {
                // 高度 --> 高度 - 1
                heights.put(arr[1], heights.get(arr[1]) - 1);
                // 说明左右端点都已经遍历完
                if (heights.get(arr[1]) == 0) heights.remove(arr[1]);
            }
            // heights是以降序的方式排列的，所以以下会获得最大高度
            int maxHeight = heights.keySet().iterator().next();
            // 如果最大高度不变，则说明当前建筑高度在一个比它高的建筑下面，不做操作
            if (maxHeight != height) {
                left = arr[0];
                height = maxHeight;
                res.add(Arrays.asList(left, height));
            }
        }
        return res;
    }
}