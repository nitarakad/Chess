import java.util.ArrayList;
import java.util.Collection;

public class MyTester {
    public static void main(String[] args) {
        SquareSet set1 = new SquareSet();
        System.out.println("adding a1: " + set1.add(new Square("a1")));
        System.out.println("Size of Set 1 before: " + set1.size());
        System.out.println("adding a2: " + set1.add(new Square("a2")));
        System.out.println("Size of Set 1 after: " + set1.size());

        Collection<Square> list = new ArrayList<Square>();
        list.add(new Square("a1"));
        list.add(new Square("a2"));
        list.add(new Square("a3"));

        Collection<Square> containList = new ArrayList<Square>();
        containList.add(new Square("a1"));
        containList.add(new Square("a2"));
        containList.add(new Square("a3"));

        SquareSet set2 = new SquareSet(list);
        System.out.println("size of set 2: " + set2.size());

        SquareSet set3 = new SquareSet();
        set3.add(new Square('a', '1'));
        set3.add(new Square('a', '1'));
        System.out.println("size of set 3: " + set3.size());

        System.out.println("true if set "
            + "1 contains a1: " + set1.contains(new Square("a1")));

        System.out.println("should be true for set 2: "
            + set2.containsAll(containList));
    }
}