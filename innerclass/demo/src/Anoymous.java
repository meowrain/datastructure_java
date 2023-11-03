interface HumanFunc {
    public void sayHello();

    public void PlayGames();
}

class Human implements HumanFunc {
    String name;
    int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }

    @Override
    public void PlayGames() {
        System.out.println("Playing Games now");
    }

    public void outputInfo() {
        System.out.println("The human's name is " + name + "\n" + "The human's age is " + age);
    }

    public void eat() {
        System.out.println("Human " + name + " Eat\t" + this.getClass().getName());
    }

    public void drink() {
        System.out.println("Human" + name + " Drink\t"+ this.getClass().getName());
    }

}

public class Anoymous {
    public static void main(String[] args) {
        Human human = new Human("meowrain", 20);

        HumanFunc human2 = new HumanFunc() {
            @Override
            public void sayHello() {
                System.out.println("HelloWorld");
            }

            @Override
            public void PlayGames() {
                System.out.println("Games Play");
                System.out.println(this.getClass().getName());
            }
        };
        HumanFunc human3 = new HumanFunc() {
            @Override
            public void sayHello() {
                System.out.println("HelloWorld");
            }

            @Override
            public void PlayGames() {
                System.out.println("Games Play2");
                System.out.println(this.getClass().getName());
            }
        };

        Human human4 = new Human("meow", 33) {
            public void eat() {
                System.out.println("Human " + name + " Eat" + "in inner" + this.getClass());
            }

            public void drink() {
                System.out.println("Human" + name + " Drink" + "in inner" + this.getClass());
            }
        };

        human.PlayGames();
        human.sayHello();
        human.outputInfo();

        human2.PlayGames();
        human3.PlayGames();

        System.out.println("-----------------------------");
        human.eat();
        human.drink();
        System.out.println("-----------------------------");
        human4.eat();
        human4.drink();
        System.out.println("-----------------------------");
    }
}
