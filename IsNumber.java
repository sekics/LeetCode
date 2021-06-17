public class IsNumber{

    public boolean isNumber(String s){
        boolean isE = false;
        boolean frontPoint = false , backPoint = false ;
        int frontSign = 0 , backSign = 0 ;
        int n = s.size() ;
        int i = 0 ;
        if( ( s.charAt(i) >= '0' && s.charAt(i) <= '9' ) ){
            frontSign = 1 ;
        }
        else if( s.charAt(i) == '.'){
            frontSign = 1 ;
            frontPoint = true ;
            i ++ ;
        }
        else if( s.charAt(i) == '-' ){
            frontSign = -1 ;
            i ++ ;
        }
        else{
            return false ;
        }
        for( i ; i < n ; i ++ ){
            char ch = s.charAt(i) ;
            if( ch >= '0' && ch <= '9'){
                continue ;
            }
            else if( ch == 'e' || ch == 'E' ){
                if( isE == true ){
                    return false ;
                }
                else if( isE == false ){
                    isE = true ;
                }
            }
            else if( ch == '-' || ch == '+' ){
                if( isE ){
                    if( backSign != 0 ){
                        return false ;
                    }
                    else{
                        backSign = 1 ;
                    }
                }
                else{
                    return false ;
                }
            }
            else if( ch == '.' ){
                if( isE == false ){
                    if( frontPoint ){
                        return false ;
                    }
                    else{
                        frontPoint = true ;
                    }
                }
                else{
                    if( backPoint ){
                        return false ;
                    }
                    else{
                        backPoint = true ;
                    }
                }
            }
        }
        return true ;
    }

    public boolean isNumber(String s){
        if( s.length() == 1 ){
            if( s.charAt(0) >= '0' && s.charAt(0) <= '9' ){
                return true ;
            }
            else{
                return false ;
            }
        }
        boolean isE = false , frontPoint = false , frontSign = false , backSign = false ;
        boolean frontNum = false , backNum = false ;
        int n = s.length() , i = 0 ;
        char last ;
        if( ( s.charAt(i) >= '0' && s.charAt(i) <= '9' ) ){
            frontSign = true ;
        }
        else if( s.charAt(i) == '.'){
            frontSign = true ;
            if( i + 1 < s.length() ){
                last = s.charAt( i + 1 ) ;
                if( last == 'e' || last == 'E' ){
                    return false ;
                }
            }
            frontPoint = true ;
            i ++ ;
        }
        else if( s.charAt(i) == '-' || s.charAt(i) == '+'){
            frontSign = true ;
            i ++ ;
        }
        else{
            return false ;
        }
        for( ; i < n ; i ++ ){
            char ch = s.charAt(i) ;
            if( i > 0 ){
                last = s.charAt( i - 1 ) ;
            }
            if( ch >= '0' && ch <= '9' ){
                if(isE){
                    backNum = true ;
                }
                else{
                    frontNum = true ;
                }
            }
            else if( ch == 'e' || ch == 'E' ){
                if(isE || !frontNum ){
                    return false ;
                }
                else{
                    isE = true ;
                    if( i + 1 < s.length() ){
                        ch = s.charAt( i + 1 ) ;
                        if( ch == '+' || ch == '-'){
                            i = i + 1 ;
                        }
                    }
                }
            }
            else if( ch == '-' || ch == '+' ){
                // if(isE){
                //     if( backSign ){
                //         return false ;
                //     }
                //     else{
                //         backSign = true ;
                //     }
                // }
                // else{
                //     return false ;
                // }
                return false ;
            }
            else if( ch == '.' ){
                if( isE == true ){
                    return false ;
                }
                else{
                    if( frontPoint){
                        return false ;
                    }
                    else{
                        frontPoint = true ;
                    }
                }
                if( i == s.length() - 1 ){
                    if( !frontNum ){
                        return false ;
                    }
                }
            }
            else{
                return false ;
            }
        }
        if( isE ){
            if( !backNum ){
                return false ;
            }
            char ch = s.charAt( i - 1 ) ;
            if( ch >= '0' && ch <= '9' )
            return true ;
            else
            return false ;
        }
        return true ;
    }
}