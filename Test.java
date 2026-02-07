public class Test {
    public static void main(String[] args){
        Test obj = new Test();
        obj = null;
        System.gc();
    }
    
}
