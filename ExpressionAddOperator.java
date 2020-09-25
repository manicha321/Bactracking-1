
//Time Complexity-O(3^n)
//Space Complexity-O(n)
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String>output=new ArrayList();
        backTrack(output,num,0,target,"",0,0);
        return output;

    }
    void backTrack(List<String>output,String num,int index,int target,String exp,long prevSum,long prevAddition)
    {
        if(index==num.length())
            {
                if(target==prevSum)
                {
                    output.add(exp);
                }
            }

        for(int i=index;i<num.length();i++)
        {
            long cur=Long.parseLong(num.substring(index,i+1));
            if(num.charAt(index)=='0'&& i!=index)
            {
                continue;
            }
            if(index==0)
            {
                backTrack(output,num,i+1,target,exp+cur,cur,cur);
            }
            else{
                //+
                backTrack(output,num,i+1,target,exp +'+'+cur,prevSum+cur,cur);
                //-
                backTrack(output,num,i+1,target,exp+'-'+cur,prevSum-cur,-cur);
                //*
                backTrack(output,num,i+1,target,exp+'*'+cur,(prevSum-                 prevAddition)+prevAddition*cur,prevAddition*cur);


            }

        }
    }
}