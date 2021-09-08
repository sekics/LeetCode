package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IPO {

    int[][] combination ;
    List<Integer> heap = new ArrayList<>() ;
    int idx = 0 ;
    int n ;
    public boolean canFinish( int nowCapital ){
        return combination[idx][1] <= nowCapital ;
    }
    public void swap( int a , int b ){
        int tmp = heap.get( a ) ;
        heap.set( a , heap.get(b) ) ;
        heap.set( b , tmp ) ;
    }
    public void Adjust( int index ){
        int parent = index / 2 ;
        while( index > 0 && heap.get( index ) > heap.get( parent ) ){
            swap( index , parent ) ;
            index = parent ;
            // parent = ( index ) / 2 ; 注意在子节点找父节点的时候Index减1
            parent = ( index - 1 ) / 2 ;
        }
    }
    public void addToHeap( int nowCaptal ){
        //根据combination后对capital排序将满足条件的项目都加入到堆中
        while( idx < n && combination[ idx ][1] <= nowCaptal ){
            heap.add( combination[idx][0] ) ;
            //将值加入到最后一个位置并调整
            Adjust( heap.size() - 1 ) ;
            idx ++ ;
        }
    }

    //调整堆，当堆的最大元素出堆后，要进行调整
    public void adjustTop( int index ){
        //当前的index小于堆的大小才进行
        if( index < heap.size() ){
            int left = index * 2 + 1 , right = index * 2 + 2 ;
            int max = heap.get( index ) ;
            int maxIndex = index ;
            //判断index的子节点是否比当前的节点大，此处的子节点可以直接是index * 2 + ( 1 || 2 ) , 找父节点时要先减1
            if( left < heap.size() && heap.get( left ) > max ){
                max = heap.get( left ) ;
                maxIndex = left ;
            }
            if( right < heap.size() && heap.get( right ) > max ){
                maxIndex = right ;
            }
            // 如果最大元素下标改变了，说明有更大的，更改
            if( maxIndex != index ){
                swap( index , maxIndex ) ;
                adjustTop( maxIndex );
            }
        }
    }
    public int popHeap(){
        int ans = heap.get(0) ;
        int size = heap.size() ;
//        System.out.println( heap.toString() );
        heap.set( 0 , heap.get( size - 1 ) ) ;
        heap.remove( size - 1 ) ;
        adjustTop(0) ;
//        System.out.println( heap.toString() );
        return ans ;
    }
    public int findMaximizedCapital( int k , int w , int[] profits , int[] capital ){
        n = profits.length ;
        combination = new int[n][2] ;
        for( int i = 0 ; i < n ; i ++ ){
            combination[i][0] = profits[i] ;
            combination[i][1] = capital[i] ;
        }
        //先将组合对capital进行排序
        Arrays.sort( combination , ( int[] a , int[]b ) -> {
            if( a[1] != b[1] ){
                return a[1] - b[1] ;
            }
            else{
                return b[0] - a[0] ;
            }
        });
        //当前的资本
        int nowCapital = w ;
        //计数
        int cnt = 0 ;
        //判断当前状况是否可以进行完成项目:当前已完成的项目小于规定可以完成的项目且目前还有项目可以做并且  现在的资本可以接项目或者还有可以接的项目
        //heap.size()>0 表明以当前的资本还有可以接的项目
        //canFinish( nowCapital) 当heap里面没有项目了进入这个判断，判断当前的资本是否可以接到新的项目
        while( cnt < k && cnt < n && ( heap.size() > 0 || canFinish( nowCapital ) ) ){
            // 把当前资本可以接到的项目都加入到最大堆中，并每次挑选堆中利润最大的项目来完成
            addToHeap( nowCapital  ) ;
            // 更新当前的资本
            nowCapital = nowCapital + popHeap( ) ;
            cnt ++ ;
        }
        return nowCapital ;
    }
}
