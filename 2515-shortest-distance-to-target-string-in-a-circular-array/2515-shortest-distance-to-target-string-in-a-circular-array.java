class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n=words.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(words[i].equals(target)){
                int rd=(i-startIndex+n)%n;
                int ld=(startIndex-i+n)%n;
                min=Math.min(min,Math.min(rd,ld));
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}