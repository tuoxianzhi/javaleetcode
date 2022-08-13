import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode15 {
    public static void main(String[] args) {
        int []nums={-1,0,1,2,-1,-4};
        List<List<Integer>> ans=threeSum(nums);
        System.out.println(Arrays.toString(ans.toArray()));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int a=nums[first];
            int third=n-1;
            for(int second = first+1; second < n; second++) {
                if(second>first+1&&nums[second]==nums[second-1]){
                    continue;
                }
                int b=nums[second];
                int tar=-a-b;
                while(third>=second+1&&nums[third]>tar){
                    third--;
                }
                if(third==second){
                    break;
                }
                if(a+b+nums[third]==0) {
                    ArrayList<Integer> abc = new ArrayList<Integer>();
                    abc.add(nums[first]);
                    abc.add(nums[second]);
                    abc.add(nums[third]);
                    ans.add(abc);
                }
            }

        }
        return ans;
    }
}
