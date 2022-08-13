class leetcode1417 {
    public static void main(String[] args) {
        String s="covid2019";
        int sumDigit = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sumDigit++;
            }
        }
        int sumAlpha = s.length() - sumDigit;
        if (Math.abs(sumDigit - sumAlpha) > 1) {
            System.out.println("");
            return;
        }
        boolean flag = sumDigit > sumAlpha;
        char[] arr = s.toCharArray();
        for (int i = 0, j = 1; i < s.length(); i += 2) {
            if (Character.isDigit(arr[i]) != flag) {
                while (Character.isDigit(arr[j]) != flag) {
                    j += 2;
                }
                swap(arr, i, j);

            }
        }
        System.out.println(new String(arr));

    }

    public static void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];

        arr[j] = c;

    }
}