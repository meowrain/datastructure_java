class Outer {
    private String info = "helloworld";
    public static void sayHelloStatic() {
        System.out.println("HelloWorld");
    }
    public void sayHello() {
        System.out.println("HelloWorld");
    }
    class Inner {
        public void print(){
            System.out.println(info);
        }
        public void invokeOuterClassFun(){
            sayHello();
            sayHelloStatic();
        }
    }

    public Inner CreateInnerClass() {
        return new Inner();
    }
}
class Demo {
    public static void main(String[] args) {
        new Outer().CreateInnerClass().print();

    }
}

