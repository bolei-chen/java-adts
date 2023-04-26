package sets;
public class TreeSetRunner extends Thread {
    private TreeSet<Integer> set;
    public TreeSetRunner(TreeSet<Integer> set) {
        this.set = set;
    }
    public void run(){
        for (int i = 0; i < 100; i++) {
            this.set.add(i);
        }
        for (int i = 0; i <= 100; i++) {
            if (i == 100){
                 System.out.println(!this.set.contains(i));
            } else {
                System.out.println(this.getName() + ":This set contains: " + i + this.set.contains(i));
            }
        }
    }
}