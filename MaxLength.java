public class MaxLength{

    public static void main(String[] args){

    }

    public int maxLength(List<String> arr){
        List<Integer> masks = new ArrayList<Integer>() ;
        for( String s : arr){
            int n = s.length() ;
            int mask = 0 ;
            for( int i = 0 ; i < n ; i ++ ){
                int ch = s.charAt(i) - 'a' ;
                if( ( mask >> ch) & 1 != 0 ){
                    mask = 0 ;
                    break ;
                }
                mask | = 1 << ch ;
            }
            if( mask > 0 ){
                masks.add(mask) ;
            }
        }
        
    }
}