public class DrawTranigle{
    public static void Draw(int N){
        int row = 1;
        while (row <= N){
            int col = 1;
            while (col <= row){
                if (col == row){
                    System.out.println('*');
                } else {
                    System.out.print('*');
                }
                col += 1;
            }
            row += 1;
        }
    }
    public static void main(String[] args){
        Draw(10);
    }
}