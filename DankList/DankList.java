import java.util.*;

public class DankList implements Comparable<Dank> , Iterable<Dank> {

    private LinkedList<Dank> list = new LinkedList<>();
    private int count;
    
    public DankList() { /* Default Constructor is all we need */ }
    
    public void add(Dank d) { list.add(d); }
    
    public Dank get(int i) { return list.get(i); }

    public void testDank(int n) {
        Random rand = new Random();
        for (int i = 0; i < n; ++i) add(new Dank("test"+i, rand.nextInt(10000)));
        System.out.println("\nSorted DankList:");
        Collections.sort(list);
        for (Dank d : list) { System.out.println(d); }
    }
    
    @Override
    public Iterator<Dank> iterator() { return list.iterator(); }
    
    @Override
    public int compareTo(Dank other) {
        return list.get(count++).compareTo(other);
    }

}
