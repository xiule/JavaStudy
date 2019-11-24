public class ForS {
    public static void main(String[] args) {
        /**
         * 老板不认识员工
         * 员工都认识老板
         * 员工可能认识员工
         *
         * 求找出老板是谁
         */
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 8};//8是老板

        int i = whoBoss(arr);
        System.out.println(i);
    }

    private static boolean isKnow(int n1, int n2) {
     //
        return false;
    }

    private static int whoBoss(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j >= 0; j--) {
                int count = 0;
                if (isKnow(arr[i], arr[j])) {
                    count++;
                    if (count == arr.length-1) {
                        break;
                    }
                } else {
                    count--;
                }
            }
           return i;
        }

        return Integer.parseInt(null);
    }
}
