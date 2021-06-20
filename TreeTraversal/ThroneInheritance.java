class TreeNode{
    public String thisName ;
    public String parentName ;
    public boolean isDead = false ;
    public List<TreeNode> children ;
    public TreeNode(String parentName ,String thisName){
        this.parentName = parentName ;
        this.thisName = thisName ;
        this.children = new ArrayList<TreeNode>() ;
    }
}
class ThroneInheritance {

    private TreeNode king ;
    private Map<String,TreeNode> nameToNode = new HashMap<String,TreeNode>() ;
    // private List<String> childrenOfKing = new ArrayList<String>() ;
    // private Set<String> died = new HashSet<String>() ;
    
    public ThroneInheritance(String kingName) {
        this.king = new TreeNode(kingName,kingName) ;
        nameToNode.put(kingName,this.king);
    }
    
    public void birth(String parentName, String childName) {
        TreeNode parent = nameToNode.get(parentName) ;
        TreeNode child = new TreeNode(parentName,childName) ;
        parent.children.add(child) ;
        this.nameToNode.put(childName,child) ;
    }
    
    public void death(String name) {
        TreeNode dead = nameToNode.get(name) ;
        dead.isDead = true ;
    }

    public void preOrder(TreeNode root,List<String> rs){
        if( root == null ){
            return ;
        }
        else{
            if( !root.isDead ){
                rs.add(root.thisName) ;
            }
            for(TreeNode child:root.children){
                preOrder(child,rs) ;
            }
        }
    }
    public List<String> getInheritanceOrder() {
        List<String> rs = new ArrayList<String>() ;
        preOrder(this.king,rs) ;
        return rs ;
    }
}