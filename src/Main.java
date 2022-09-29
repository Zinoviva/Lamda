import jdk.jshell.spi.SPIResolutionException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Mariam", "Gorlovanova", 17));
        people.add(new Person("Oleg", "Zvonkovenko", 32));
        people.add(new Person("Vova", "Novikov", 16));

        MyInterface myInterface = (o1, o2) -> {
            int len1 = o1.getSurname().split(" ").length;  //берем фамилию разбиваем на слова получаем массив из частей
            int len2 = o2.getSurname().split(" ").length;  //и берем у него только длину
            if (len1 != len2) {  //если лен 1 и лен 2 не равны
                return Integer.compare(len1, len2);
            }
            return Integer.compare(o1.getAge(), o2.getAge());
        };

        Collections.sort(people, myInterface);
        //создать предикат с фильтром на возраст 18 лет, если да удалить его из списка
        people.removeIf(person -> person.getAge() < 18 );



        System.out.println(people);//после сортировки покажет нам список в нужном порядке
    }
}