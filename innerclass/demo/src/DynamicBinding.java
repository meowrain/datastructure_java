public class DynamicBinding {
    public static void main(String[] args) {
        Parent son = new Son();
        System.out.println(son.name);
        Son son2 = (Son) son;
        System.out.println(son2.name);
        System.out.println(son.getName());
    }
}

class Parent {
    String name = "Parent";

    public String getName() {
        return this.name;
    }
}

class Son extends Parent {
    String name = "Son";
    @Override
    public String getName() {
        return this.name;
    }
}
