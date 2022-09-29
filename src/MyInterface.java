import java.util.Comparator;

public interface MyInterface extends Comparator <Person> {
    @Override
    int compare(Person o1, Person o2);
}
