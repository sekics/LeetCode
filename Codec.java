import java.util.Queue;

class TreeNode{
    int val ;
    TreeNode left ;
    TreeNode rigth ;
    TreeNode(int x){
        this.val = x ;
    }
}
public class Codec{
    
    public String serialize(TreeNode root){
        if(root==null){
            return "";
        }
        TreeNode tmp = root ;
        Queue<TreeNode> nodes = new LinkedList<TreeNode>() ;
        Set<TreeNode> seen = new HashSet<TreeNode>() ;
        nodes.add(tmp) ;
        // seen.add(tmp) ;
        StringBuilder sb = new StringBuilder() ;
        while( !nodes.isEmpty() ){
            int size = nodes.size() ;
            for( int i = 0 ; i < size ; i ++ ){
                TreeNode now = nodes.poll() ;
                if( seen.contains(now) ){
                    sb.append('+') ;
                }
                else{
                    sb.append(String.valueOf(now.val)) ;
                    sb.append('.') ;
                    seen.add(now) ;
                    if( now.left != null ){
                        nodes.add( now.left ) ;
                    }
                    else{
                        nodes.add( now ) ;
                    }
                    if( now.right != null ){
                        nodes.add( now.right ) ;
                        // seen.add( now.right ) ;
                    }
                    else{
                        nodes.add(now) ;
                    }
                }
            }
        }
        return sb.toString() ;
    }

    public TreeNode[] getNodes(String data){
        TreeNode[] nodes = new TreeNode[2] ;
        for( int t = 0 ; t < 2 ; t ++ ){
            int j = s ;
            if( s < data.length() && data.charAt(s) == '+' ){
                nodes[t] = null ;
                s ++ ;
            }
            else if( s < data.length() ){
                while( j < data.length() && data.charAt(j) != '.' ){
                    j ++ ;
                }
                // System.out.println(s + " " +j) ;
                nodes[t] = new TreeNode(Integer.valueOf(data.substring(s, j))) ;
                j ++ ;
                s = j ;
            }
            else{
                nodes[t] = null ;
            }
        }
        return nodes ;
    }

    int s = 0 ;
    public TreeNode deserialize(String data){
        if(data.equals("")){
            return null ;
        }
        int n = data.length() ;
        int i = n - 1 ;
        while( data.charAt(i) == '+' ){
            i -- ;
        }
        data = data.substring(0,  i + 1 ) ;
        n = data.length() ;
        s = 0 ;
        while( data.charAt(s) != '.' ){
            s ++ ;
        }
        int val = Integer.valueOf(data.substring(0, s)) ;
        s ++ ;
        TreeNode root = new TreeNode(val) ;
        Queue<TreeNode> nodes = new LinkedList<TreeNode>() ;
        nodes.add(root) ;
        while( s < n ){
            TreeNode now = nodes.poll() ;
            TreeNode[] lr = getNodes(data) ;
            now.left = lr[0] ;
            now.right = lr[1] ;
            if( lr[0] != null ){
                nodes.add(lr[0]) ;
            }
            if( lr[1] != null ){
                nodes.add(lr[1] ) ;
            }
        }
        return root ;
    }
}