import com.sun.nio.file.SensitivityWatchEventModifier;

public class SLList{

    private static class IntNode{
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    /**Initialize empty SLList. */
    public SLList(){
        sentinel = new IntNode(999, null);
        size = 0;
    }

    /**Normal initialization */
    public SLList(int x){
        sentinel = new IntNode(999, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /**Initialize with an array of integar. */
    public SLList(int[] x){
        sentinel = new IntNode(999, null);
        sentinel.next = new IntNode(x[0], null);
        IntNode p = sentinel.next;
        size = x.length;
        for(int i = 1; i < size; i++){
            p.next = new IntNode(x[i], null);
            p = p.next;
        }
    }

    /**Get the size of SLList. */
    public int size(){
        return size;
    }

    /**Add to item to the fornt of the SLList */
    public void addFisrst(int x){
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /**Add to item to the end of the SLList */
    public void addLast(int x){
        IntNode p = sentinel;
        size += 1;
        while(p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    /**Get the first item */
    public int getFirst(){
        return sentinel.next.item;
    }

    /**Delect the first item of SLList */
    public void delectFirst(){
        if (sentinel.next != null){
            sentinel.next = sentinel.next.next;
        }
    }

    /**Add a value at the end of the SLList, and square items already in the SLList
     * e.g
     * 1 => 2 to 1 => 1 => 2 => 4 => 5
     * add 7 to 1 => 1 => 1 => 1 => 2 => 4 => 4 => 16 => 5 => 25 => 7
    */
    public void squareInsert(int x){
        IntNode p = sentinel.next;
        while (p.next != null){
            p.next = new IntNode(p.item * p.item, p.next);
            p = p.next.next;
        }
        p.next = new IntNode(p.item * p.item, new IntNode(x, null));
        size = 2 * size + 1;
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        int[] x = new int[]{1,2,3};
        SLList L = new SLList(x);
        L.squareInsert(4);

        // L.addLast(20);
        // L.addFisrst(100);
        // L.delectFirst();
        // System.out.println(L.size());
        // System.out.println(L.getFirst());
        for(int i = 0; i < L.size(); i++){
            System.out.println(L.getFirst());
            L.delectFirst();
        }
    }


}