public class IntList{
    public int first;
    public IntList rest;

    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    public int size(){
        if (rest == null){
            return 1;
        } else {
            return 1 + this.rest.size();
        }
    }

    public int get(int n){
        if (n == 0){
            return first;
        } else {
            return this.rest.get(n - 1);
            // return rest.get(n - 1);
        }
    }

    public static IntList incrList(IntList L, int x){
        if (L == null){
            return null;
        } else {
            IntList I = new IntList(L.first + x, incrList(L.rest, x));
            return I;
        }
    }

    public static IntList dincrList(IntList L, int x){
        if (L == null){
            return null;
        } else {
            L.first += x;
            dincrList(L.rest, x);
            return L;
        }
    }



    public static void main(String[] args){
        IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);

        System.out.println(L.get(0));
        
        System.out.println(incrList(L, 1).get(2));
        System.out.println(dincrList(L, 1).get(2));
    }
}