import java.util.List;

public class RestoreIpAdress{

    public boolean checkOk(String str){
        if( str.length() == 1 ){
            return true ;
        }
        else if( str.length() > 1 && str.charAt(0) =='0' ){
            return false ;
        }
        else{
            int ip = Integer.parseInt(str) ;
            if( ip > 255 ){
                return false ;
            }
            return true ;
        }
    }

    public String generateIp(List<String> ip){
        StringBuilder ans = new StringBuilder() ;
        for( int i = 0 ; i < ip.size() ; i ++ ){
            ans.append(ip.get(i)) ;
            if( i < 3 ){
                ans.append('.') ;
            }
        }
        return ans.toString() ;
    }
    
    public void DFS(Set<String> set,String s,int nowIndex,List<String> ip){
        if( ip.size() == 4 ){
            int length = 0 ;
            for(String str : ip){
                length += str.length() ;
            }
            if( length == s.length() ){
                String Ip = generateIp(ip) ;
                set.add(Ip) ;
            }
        }
        else if( ip.size() < 4 && nowIndex < s.length() ){
            for( int i = 1 ; i < 4 ; i ++ ){
                String str = nowIndex + i < s.length() ? s.substring(nowIndex,nowIndex + i) : s.substring(nowIndex,s.length()) ;
                // System.out.println(nowIndex + "----" + i + "----" + str) ;
                // System.out.println(nowIndex + "----" + i + "----" + str + "---" + ip.size()) ;
                // System.out.println(ip.toString()) ;
                if( checkOk(str) ){
                    ip.add(str) ;
                    DFS(set,s,nowIndex + i ,ip) ;
                    ip.remove( ip.size() - 1 ) ;
                }
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        Set<String> set = new HashSet<String>() ;
        List<String> ip = new ArrayList<String>() ;
        DFS(set,s,0,ip) ;
        return new ArrayList(set) ;
    }

    public List<String> restoreIpAdress( String s ){
        Set<String> set = new HashSet<String>() ;
        List<String> ip = new ArrayList<String>() ;
        DFS(set,s,0,ip) ;
        return new ArrayList(set) ;
    }
}