import javax.imageio.ImageTranscoder;

public class leetcode11 {
    public static void main(String[] args) {
        int []height={1,8,6,2,5,4,8,3,7};
        int i,j;
        i=0;
        j=height.length-1;
        int ans=0;
        while(i!=j){
            int area = Math.min(height[i], height[j]) * (j - i);
            ans=Math.max(area,ans);
            if(height[i]<=height[j])i++;
            else j--;
        }

        System.out.println(ans);
    }
}
