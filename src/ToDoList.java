import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    ArrayList<String> toDoList = new ArrayList<String>();

    public void lisaUusKirje() {
        Scanner sisend = new Scanner(System.in);
        System.out.println("Mida soovid lisada? ");
        String ülesanne = sisend.nextLine();
        toDoList.add(ülesanne);
    }

    public void väljastaLisatudKirjed() {
        if (toDoList.isEmpty()) {
            System.out.println("List on tühi.");
        } else {
            System.out.println("Listis on " + toDoList.size() + " kirjet: ");
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println(i + 1 + ". " + toDoList.get(i));
            }
        }
    }

    public String loosiÜlesanne() {
        if (toDoList.isEmpty()) {
            return "List on tühi. Sul ei ole midagi teha.";
        } else {
            int max = toDoList.size();
            int juhuslikArv = (int) (Math.random() * max + 1);
            return toDoList.get(juhuslikArv);
        }
    }

    public String eemaldaÜlesanne() {
        if (toDoList.isEmpty()) {
            return "See list on juba tühi.";
        } else {
            System.out.println("Listis on " + toDoList.size() + " kirjet: ");
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println(i + 1 + ". " + toDoList.get(i));
            }
            Scanner eemaldatav = new Scanner(System.in);
            System.out.println("Sisesta ülesande number, mida soovid eemaldada: ");
            int number = Integer.parseInt(eemaldatav.nextLine());
            toDoList.remove(number-1);
            return "Ülesanne number " + number + " edukalt eemaldatud.";
        }
    }
}