//Time Complexity-O(n^n)
//Space Complexity-O(n)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer>path=new ArrayList();
        backTrack(candidates,target,0,path);
        return output;
    }
    List<List<Integer>>output=new ArrayList();
    void backTrack(int[]candidates,int target,int index,List<Integer>path)
    {
        if(target<0)
        {
            return;
        }
        else if(target==0)
        {
            output.add(new ArrayList(path));
            return;
        }
        else if(index>=candidates.length)
        {
            return;
        }
        for(int i=index;i<candidates.length;i++)
        {
            path.add(candidates[i]);
            backTrack(candidates,target-candidates[i],i,path);
            path.remove(path.size()-1);
        }
    }
}