public class Test {
    public static void main(String[] args) {
        People man = new People("meowrain").createMan("meowrain", 20);
        man.outputInfo();
    }
}

class People {
    String name;

    public People(String name) {
        this.name = name;
    }

    public void outputInfo() {
        System.out.println("The man's name is " + name + "\n");
    }

    public People createMan(String name, int age) {
        class Man extends People {
            int age;

            public Man(String name, int age) {
                super(name);
                this.age = age;
            }

            public void outputInfo() {
                System.out.println("The man's name is " + name + "\n" + "age is :" + age);
            }
        }
        return new Man(name, age);

    }

}