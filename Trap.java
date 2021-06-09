import java.util.Arrays;

public class Trap{
    
    public static void main(String[] args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int rs = trap(height);
    }

    public static int findLeft(int[] height,int[] left,int k,int now){
        if( k  < 0 ){
            return -1 ;
        }
        else if( height[ k ] > now ){
            if( left[ k ] == -1 ){
                return k ;
            }
            else{
                return findLeft(height, left,left[k],height[k] );
            }
        }
        else{
            return findLeft(height,left, k - 1 ,now);
        }
    }

    public static int findRight(int[] height,int[] right,int k,int now){
        if( k >= n ){
            return n ;
        }
        else if( height[k] > now ){
            if( right[ k ] == n ){
                return k ;
            }
            else{
                return findRight(height,right,right[k],height[k]);
            }
        }
        else{
            return findLeft(heith,right, k + 1,now);
        }

    }
    public static int trap(int[] height){
        int n = height.length ;
        int[] left = new int[n] ;
        int[] right = new int[n] ;
        left[0] = -1;
        right[ n - 1 ] = n ;
        for( int i = 1 ; i < n ; i ++ ){
            left[i] = findLeft(height,left, i - 1 ,height[i] );
        }
        for( int i = n - 2 ; i >=0 ; i -- ){
            right[i] = findRight(height,right, i + 1 ,height[i]);
        }
        System.out.println(Arrays.toString(left));
        return 0 ;
    }
}