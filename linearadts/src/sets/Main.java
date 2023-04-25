package sets;
public class Main {
    public static void main(String[] args) {
        TreeSet s1 = new TreeSet<>();
        int limit = 100;
        TreeSetRunner[] tr1 = new TreeSetRunner[limit];
        for(int i = 0; i < limit; i++) {
            tr1[i] = new TreeSetRunner(s1);
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