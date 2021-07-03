import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

import jdk.internal.jshell.tool.resources.l10n;

public class FrequencySort{

    public String frequencySort(String s){
        Map<Character,Integer> map = new HashMap<Character,Integer>() ;
        Set<Character> set = new HashSet<Character>() ;
        int n = s.length() ;
        for( int i = 0 ; i < n ; i ++ ){
            char ch = s.charAt(i) ;
            map.put(ch,map.getOrDefault(ch, 0) + 1 ) ;
            set.add(ch) ;
        }
        Character[] chs = new Character[set.size()] ;
        int i = 0 ;
        for( Character item : set ){
            chs[ i ++ ] = item ;
        }
        // Arrays.sort(chs,new Comparator<Character>(){
        //     public int compare(Character a,Character b){
        //         return map.get(b) - map.get(a) ;
        //     }
        // });
        Arrays.sort(chs,(first,second) -> map.get(second) - map.get(first)) ;
        StringBuilder sb = new StringBuilder() ;
        for( i = 0 ; i < chs.length ; i ++ ){
            char ch = chs[i] ;
            for( int j = 0 ; j < map.get(ch) ; j ++ ){
                sb.append(ch) ;
            }
        }
        return sb.toString() ;
    }
}