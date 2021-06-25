class Point{
    private int x ;
    private int y ;
    public Point(int x,int y){
        this.x = x ;
        this.y = y ;
    }
    public int getX(){
        return this.x ;
    }
    public int getY(){
        return this.y ;
    }

}
class MaxPoints{

    public String getSlope(int[] xPoint,int[] yPoint){

        double slope = (double) ( xPoint[1] - yPoint[1] ) / ( xPoint[0] - yPoint[1] ) ;
        double b = double (yPoint[1] - slope * yPoint[0]) ;
        return String.valueOf(slope) + "+" + String.valueOf(b) ;
    }
    public int maxPoints(int[][] points){

        int n = points.length ;

        HashMap<String,List<Point>> slopes = new HashMap<String,List<Point>>() ;

        for( int i = 1 ; i < n ; i ++ ){
            for( int j = 0 ; j < i ; j ++ ){
                Point xPoint = new Point(points[j][0],points[j][1]) ;
                Point yPoint = new Point(points[i][0],points[i][1]) ;
                String slope = getSlope(points[i],points[j]) ;
                System.out.println(slope) ;
            }
        }
        
        return 0 ;
    }

}