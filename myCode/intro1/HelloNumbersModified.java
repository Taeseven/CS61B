public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int temp = x;
        while (x < 10) {
            temp += x;
            System.out.println(temp);
            x = x + 1;
        }
        
    }
}