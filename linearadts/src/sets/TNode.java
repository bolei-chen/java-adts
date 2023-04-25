package sets;

import java.util.concurrent.locks.ReentrantLock;

public class TNode<T>  {
    public TNode<T> left; 
    public TNode<T> right; 
    public T item; 
    ReentrantLock lock = new  ReentrantLock();
     
    public TNode(T item, TNode<T> left, TNode<T> right) {
       this.item = item;
       this.left = left; 
       this.right = right; 
    }
    public TNode(T item){
        this(item, null, null);
    } 
         
}
