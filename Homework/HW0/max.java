public class max {
    /** Returns the maximum value from m using a for loop. */
    public static int forMax(int[] m) {
        int max_num = m[0];
        for (int i = 1; i < m.length; i++){
            if (max_num < m[i]){
                max_num = m[i];
            }
        }
        System.out.println(max_num);
        return max_num;
        
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};  
       forMax(numbers);
    }
}