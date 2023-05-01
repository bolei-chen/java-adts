package sets;
public class Main {
    public static void main(String[] args) {
        FineTreeSet s1 = new FineTreeSet<Integer>();
        int limit = 100;
        MultiThreadSetRunner[] tr1 = new MultiThreadSetRunner[limit];
        for(int i = 0; i < limit; i++) {
            tr1[i] = new MultiThreadSetRunner(s1);
            tr1[i].start();
        }
        
        for(int i = 0; i < limit; i++){
            try{
                tr1[i].join();
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
    }
}