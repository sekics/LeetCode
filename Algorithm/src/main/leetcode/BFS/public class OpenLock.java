public class OpenLock{

    public char numIncrease(char x){
        return x == '9' ? '0' : (char)( x + 1 ) ;
    }
    public char numDecrease(char x){
        return x == '0' ? '9' : (char)( x - 1 ) ;
    }
    public List<String> generate(String nowStr){
        List<String> com = new ArrayList<String>() ;
        char[] chars = new char[4] ;
        for( int i = 0 ; i < 4 ; i ++ ){
            chars[i] = nowStr.charAt(i) ;
        }
        for( int i = 0 ; i < 4 ; i ++ ){
            char ch = chars[i] ;
            chars[i] = numIncrease(ch) ;
            com.add(new String(chars)) ;
            chars[i] = numDecrease(ch);
            com.add(new String(chars)) ;
            chars[i] = ch ;
        }
        return com ;
    }
    public int openLock(String[] deadends,String target){
        if( "0000".equals(target) ){
            return 0 ;
        }
        Queue<String> nextLayer = new LinkedList<String>() ;
        Set<String> disposed = new HashSet<String>() ;
        Set<String> deadEnds = new HashSet<String>() ;
        for(String str:deadends ){
            deadEnds.add(str) ;
        }
        if( deadEnds.contains("0000") ){
            return -1 ;
        }
        disposed.add("0000") ;
        nextLayer.offer("0000") ;
        int level = 0 ;
        while( !nextLayer.isEmpty() ){
            level ++ ;
            int n = nextLayer.size() ;
            for( int i = 0 ; i < n ; i ++ ){
                String nowStr = nextLayer.poll() ;
                for(String str:generate(nowStr)){
                    if( !deadEnds.contains(str) && !disposed.contains(str)){
                        if( str.equals(target)){
                            return level ;
                        }
                        nextLayer.offer(str) ;
                        disposed.add(str) ;
                    }
                }
            }
        }
        return -1 ;
    }
}