package sets;

public interface Set<T> {
    
    boolean add(T item);
    
    boolean remove(T item);
    
    boolean contains(T item);
     
    int size();     
         
}
