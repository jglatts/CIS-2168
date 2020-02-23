public class Dank implements Comparable<Dank>{
    private String name;
    private int rating;
    
    public Dank(String name, int rating) { 
        this.name = name; 
        this.rating = rating; 
    } 
    
    @Override
    public String toString() { 
        return String.format("%-11s  rating: %d", name+",", rating); 
    }
    
    @Override 
    public int compareTo(Dank other) {
        if (rating < other.rating) return 1;
        if (rating > other.rating) return -1;
        return 0;
    }

}
