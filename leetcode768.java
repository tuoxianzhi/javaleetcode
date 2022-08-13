import java.lang.reflect.Array;
import java.util.*;

public class leetcode768 {
    public static void main(String[] args) {
        int []arr={1,1,0,0,1};
        int ans=maxChunksToSorted1(arr);
        System.out.println(ans);
        return;
    }
    public static int maxChunksToSorted1(int[] arr) {
        int n = arr.length;
        int []kat =new int[n];
        int [][][]art = new int[n][n][2];
        boolean [][]ans = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            art[i][i][0]=arr[i];
            art[i][i][1]=arr[i];
            kat[i]=arr[i];

        }
        Arrays.sort(kat);
        for (int i = 0; i < n; i++) {
            if (arr[i]==kat[i])ans[i][i]=true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                art[j][j+i][0]=Math.max(art[j][j+i-1][0],art[j+i][j+i][0]);
                art[j][j+i][1]=Math.min(art[j][j+i-1][1],art[j+i][j+i][1]);
                if(art[j][j+i][0]==kat[j+i]&&art[j][j+i][1]==kat[j]){
                    ans[j][j+i]=true;
                }
            }
        }
        int cnt=0,it=0;
        while(it<=n-1){
            for(int j = it; j <= n-1; j++) {
                if(ans[it][j]){
                    it=j+1;
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
    public static int maxChunksToSorted(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int res = 0;
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        Arrays.sort(sortedArr);
        for (int i = 0; i < sortedArr.length; i++) {
            int x = arr[i], y = sortedArr[i];
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 0) {
                cnt.remove(x);
            }
            cnt.put(y, cnt.getOrDefault(y, 0) - 1);
            if (cnt.get(y) == 0) {
                cnt.remove(y);
            }
            if (cnt.isEmpty()) {
                res++;
            }
        }
        return res;
    }
}
