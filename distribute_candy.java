public class Solution {
    public int candy(ArrayList<Integer> A) {
        int[] arr = new int[A.size()];
        Arrays.fill(arr,1);
        for(int i=1;i<A.size();i++)
	{
            if(A.get(i)>A.get(i-1))
	    {
		arr[i]=arr[i-1]+1;
	    }
	}
	for(int i=A.size()-2;i>=0;i--)
	{
	    if(A.get(i)>A.get(i+1))
	    {
		arr[i]=Math.max(arr[i],arr[i+1]+1);
	    }
	}
	int sum=0;
	for(int i=0;i<A.size();i++)
	{
	    sum+=arr[i];
	}
	return sum;
    }        
}
