package main.leetcode;

public class MaximumTime {

    public String getMaxHour(String hour){
        StringBuilder sb = new StringBuilder() ;
        char first = hour.charAt(0) ;
        char sec = hour.charAt(1) ;
        String str ;
        if( first == '?' && sec == '?' ){
            str = sb.append("23").toString() ;
        }
        else if( sec == '?' ){
            sb.append(first) ;
            str = first - '0' <= 1 ? sb.append('9').toString() : sb.append('3').toString() ;
        }
        else if( first == '?' ){
            if( sec - '0' <= 3 ){
                sb.append('2') ;
            }
            else{
                sb.append('1') ;
            }
            str = sb.append(sec).toString() ;
        }
        else{
            sb.append(first) ;
            str = sb.append(sec).toString() ;
        }
        return str ;
    }

    public String getMaxMinute(String minute){
        StringBuilder sb = new StringBuilder() ;
        char first = minute.charAt(0) ;
        char sec = minute.charAt(1) ;
        String str ;
        if( first == '?' && sec == '?' ){
            str = sb.append("59").toString() ;
        }
        else if( sec == '?' ){
            sb.append(first) ;
            str = sb.append('9').toString() ;
        }
        else if( first == '?' ){
            sb.append('5') ;
            str = sb.append(sec).toString() ;
        }
        else{
            sb.append(first) ;
            str = sb.append(sec).toString() ;
        }
        return str ;
    }
    public String maximumTime( String time ){
        StringBuilder sb = new StringBuilder() ;
        sb.append(getMaxHour(time.substring(0,2))) ;
        sb.append(":") ;
        sb.append(getMaxMinute(time.substring(3,5))) ;
        return sb.toString() ;
    }
}
