public class SmallestGoodBase{
    public String smallestGoodBase1(String n){
        Long num = Long.parseLong(n);
        int mMax = (int) Math.floor( Math.log(num) / Math.log(2) ) ;
        for( int m = mMax ; m >= 2 ; m -- ){
            int k = (int) Math.pow(num, 1.0 / m ) ;
            Long sum = 1l , mul = 1l ;
            for( int i = 0 ; i < m ; i ++ ){
                mul = mul * k ;
                sum += mul ;
            }
            System.out.println( k + " " + sum + " " + num) ;
            System.out.println( sum == num ) ;
            System.out.println( sum.equals(num) ) ;
            //此处在声明sum和num变量时使用了关键字Long，是java中的对象，不同与long，因此比较时要使用方法equals
            if( sum.equals(num) ){
                return Long.toString(k) ;
            }
        }
        return Long.toString( num - 1 ) ;
    }

    public String smallestGoodBase(String n) {
        long nVal = Long.parseLong(n);
        int mMax = (int) Math.floor(Math.log(nVal) / Math.log(2));
        for (int m = mMax; m > 1; m--) {
            int k = (int) Math.pow(nVal, 1.0 / m);
            long mul = 1, sum = 1;
            for (int i = 0; i < m; i++) {
                mul *= k;
                sum += mul;
            }
            //此处sum和nVal都是声明为long，可以直接进行比较
            if (sum == nVal) {
                return Integer.toString(k);
            }
        }
        return Long.toString(nVal - 1);
    }


}