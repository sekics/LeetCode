class Solution {

    public void DFS(int[] nums,int nowIndex,int cnt,int nowCNT,int sum,List<Integer> ans){
        if( nowCNT == cnt ){
            ans.add(sum) ;
            return ;
        }
        else if( nowCNT > cnt ){
            return ;
        }
        else{
            for( int i = nowIndex + 1; i < nums.length ; i ++ ){
                DFS(nums,i,cnt,nowCNT+1,sum+nums[i],ans) ;
            }
        }
    }

    public List<Integer> getCombination(int[] nums,int cnt){
        List<Integer> ans = new ArrayList<Integer>() ;
        if( cnt == 0 ){
            ans.add(0) ;
        }
        for( int i = 0 ; i < nums.length ; i ++ ){
            DFS(nums,i,cnt,1,nums[i],ans) ;
        }
        // DFS(nums,0,cnt,0,0,ans) ;
        return ans ;
    }

    public String generateDate(int hour,int minute){
        String str = "" ;
        str = str + String.valueOf(hour) + ":" ;
        str = minute < 10 ? str + "0" + String.valueOf(minute) : str + String.valueOf(minute) ;
        return str ;
    }
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>() ;
        int[] hours = new int[4] ;
        int[] minutes = new int[6] ;
        for( int i = 0 ; i < 4 ; i ++ ){
            hours[i] = (int)Math.pow(2,i) ;
        }
        for( int i = 0 ; i < 6 ; i ++ ){
            minutes[i] = (int)Math.pow(2,i) ;
        }
        for( int i = 0 ; i <= turnedOn && i <= 3 ; i ++ ){
            if( turnedOn - i > 5 ){
                continue ;
            }
            else{
                int hourOn = i , minuteOn = turnedOn - i ;
                List<Integer> pHours = getCombination(hours,hourOn) ;
                List<Integer> pMinutes = getCombination(minutes,minuteOn) ;
                // Collections.sort(pHours) ;
                // Collections.sort(pMinutes) ;
                for( int h = 0 ; h < pHours.size() ; h ++ ){
                    int hour = pHours.get(h) ;
                    if( hour > 11 ){
                        continue ;
                    }
                    else{
                        for( int m = 0 ; m < pMinutes.size() ; m ++ ){
                            int minute = pMinutes.get(m) ;
                            if( minute < 60 ){
                                String str = generateDate(hour,minute) ;
                                ans.add(str) ;
                            }
                        }
                    }
                }
            }
        }
        return ans ;
    }
}