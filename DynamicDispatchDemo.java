class Parent{
    void show(){
        System.out.println("Parent show method");
    }
}
class Child extends Parent{
    @Override
    void show(){
        System.out.println("Child's show method");
    }
}
public class DynamicDispatchDemo{
    public static void main(String[] args){
Parent obj = new Child();
obj.show();
    }
}