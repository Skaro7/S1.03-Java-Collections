import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
package Excercise1;

class Month {
    private String name;

    public Month(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Month> monthList = new ArrayList<>();

        monthList.add(new Month("January"));
        monthList.add(new Month("February"));
        monthList.add(new Month("March"));
        monthList.add(new Month("April"));
        monthList.add(new Month("May"));
        monthList.add(new Month("June"));
        monthList.add(new Month("July"));
        monthList.add(new Month("September"));
        monthList.add(new Month("October"));
        monthList.add(new Month("November"));
        monthList.add(new Month("December"));

        Month august = new Month("August");
        monthList.add(7, august);

        System.out.println("ArrayList months in order:");
        for (Month month : monthList) {
            System.out.println(month.getName());
        }
        System.out.println();
        
        Set<Month> months = new HashSet<>(monthList);

        monthList.add(new Month("January"));
        monthList.add(new Month("February"));

        System.out.println("HashSet months (no duplicates):");
        for (Month month : months) {
            System.out.println(month.getName());
        }
        System.out.println();


        System.out.println("Iterator output:");
        Iterator<Month> iterator = months.iterator();
        for (Month month : months) {
            System.out.println(iterator.next().getName());
        }

    }
}