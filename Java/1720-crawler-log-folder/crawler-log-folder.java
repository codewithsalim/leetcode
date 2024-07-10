class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;
        for ( String log: logs ){
            if ( log.equals("../")){
                depth = depth-1>=0?depth-1:0;
            }else if( log.equals("./")){
                
            }else{
                depth++;
            }
        }
        return depth;
    }
}