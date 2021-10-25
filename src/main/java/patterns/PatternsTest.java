package patterns;

import patterns.adapter.MyCustomList;
import patterns.adapter.MyList;
import patterns.builder.Person;
import patterns.builder.User;
import patterns.fabric.ButtonFabric;
import patterns.fabric.WinButtonFabric;
import patterns.proxy.Calculator;
import patterns.proxy.Summator;
import patterns.proxy.SummatorWithLogProxy;
import patterns.singleton.Network;

public class PatternsTest {
    public static void main(String[] args) {
        Network network = Network.getInstance();
        ButtonFabric winFabric = new WinButtonFabric();
        winFabric.createButton();

        Person person = Person.builder()
                .setAge(15)
                .setName("Ivan")
                .setSurname("Ivanov")
                .build();

        User user = User.builder()
                .age(12)
                .name("Ivan")
                .surname("Ivanov")
                .build();

        MyList list = new MyCustomList();
        list.add(12);

        Calculator calculator = new Summator();
        Calculator proxy = new SummatorWithLogProxy();

        calculator.calculate();
        proxy.calculate();

        Runnable r1 = () -> System.out.println("Hello");
        Runnable r2 = () -> System.out.println(" World!");
    }
}
