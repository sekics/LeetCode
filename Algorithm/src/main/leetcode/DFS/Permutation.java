public class Permutation{

    String[] ans ;
    Set<String> tmp = new HashSet<String>() ;

    public String generateStr(LinkedList<Character> ll){
        String str = "" ;
        for(Character ch : ll){
            str += ch ;
        }
        return str ;
    }

    public void DFS(char[] chars,LinkedList<Character> ll,int now,Set<Integer> flag){
        if( ll.size() < chars.length ){
            flag.add(now) ;
            ll.add(chars[now]) ;
            if( ll.size() == chars.length ){
                tmp.add(generateStr(ll)) ;
                flag.remove(now) ;
                ll.removeLast() ;
                return ;
            }
            for( int i = 0 ; i < chars.length ; i ++ ){
                if( !flag.contains(i) ){
                    DFS(chars,ll,i,flag) ;
                }
            }
            flag.remove(now) ;
            ll.removeLast() ;
        }
    }

    public String[] permutaion(String s){
        char[] chars = new char[s.length()] ;
        Set<Integer> flag = new HashSet<Integer>() ;
        for( int i = 0 ; i < s.length() ; i ++ ){
            chars[i] = s.charAt(i) ;
        }
        for( int i = 0 ; i < s.length() ; i ++ ){
            LinkedList<Character> ll = new LinkedList<Character>() ;
            DFS(chars,ll,i,flag) ;
            
        }
        ans = new String[tmp.size()] ;
        int i = 0 ;
        for(String str:tmp){
            ans[i++] = str;
        }
        return ans ;
    }
    
}