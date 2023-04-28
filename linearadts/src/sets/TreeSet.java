package sets;

public class TreeSet<T extends Comparable<T>> implements Set<T> {
    
    private int size;
    private TNode<T> root; 
     
    public TreeSet() {
        this.root = new TNode(null); 
        size = 0; 
    }
     
	@Override
     
	public boolean remove(T item) {
        return true; 
	}

	@Override
	public boolean contains(T item) {
        TNode<T> parent = find(item);
        parent.lock.unlock(); 
        final int cond = parent.item.compareTo(item); 
        if (cond == 0) {
            return true;
        }
        if (cond > 0) {
            return null != parent.left;
        } else {
            return null != parent.right; 
        }

	}

	@Override
	public int size() {
        return size; 
	}

    @Override
    public boolean add(T item) {
        if (size == 0) {
            root.item = item; 
        }
        TNode<T> parent = find(item);
        int cond =  parent.item.compareTo(item);
        TNode<T> son = cond > 0 ? parent.left : parent.right;
        if (son != null) {
            parent.lock.unlock();
            return false;
        } else {
            //son is
            if(cond > 0) {
                //parent > inserted
                parent.left = new TNode<T>(item);
            } else {
                parent.right = new TNode<T>(item);
            }
            size += 1;
            parent.lock.unlock();
            return true;
        }

    }
     
    private TNode<T> find(T item) {
        TNode<T> curr = this.root;
        TNode<T> prev = null;
        curr.lock.lock();
        while (true) {
            prev = curr;
            int cond = curr.item.compareTo(item);             
            if(cond == 0) {
                // return a locked node 
                return prev;
            }
            curr = cond > 0 ? curr.left:curr.right;
            if  (curr == null) {
                return prev;
            } else {
                curr.lock.lock();
                prev.lock.unlock();
            }
        }
    }
    
} 