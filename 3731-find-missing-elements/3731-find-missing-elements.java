class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer>ans=new ArrayList<>();
        boolean[]present= new boolean[101];

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int num:nums){
            min=Math.min(min,num);
            max=Math.max(max,num);
            present[num]=true;
        }
        for(int i=min;i<=max;i++){
            if(!present[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}