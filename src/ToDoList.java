import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    ArrayList<Ülesanne> toDoList = new ArrayList<>();

    //case 1
    public void lisaUusKirje() {
        Scanner sisend = new Scanner(System.in);
        System.out.println("Kas see ülesanne on elulise tähtsusega? (jah/ei) ");
        if (sisend.nextLine().equals("jah")) {
            System.out.println("Mida soovid lisada? ");
            Ülesanne lisatudÜlesanne = new Ülesanne(sisend.nextLine(), true);
            toDoList.add(lisatudÜlesanne);
            System.out.println("Uus kirje lisatud!");

        } else if (sisend.nextLine().equals("ei")) {
            System.out.println("Mida soovid lisada? ");
            Ülesanne lisatudÜlesanne = new Ülesanne(sisend.nextLine(), false);
            toDoList.add(lisatudÜlesanne);
            System.out.println("Uus kirje lisatud!");
        }
    }

    //case 3
    public String eemaldaÜlesanne() {
        if (toDoList.isEmpty()) {
            System.out.println("See list on juba tühi.");
            return null; //kohmakas lahendus, aga tagastustüüp void ei sobinud rekursiooniga, teisiti ei osanud
        } else {
            listiPrint();
            Scanner eemaldatav = new Scanner(System.in);
            System.out.println("Sisesta ülesande number, mida soovid eemaldada: ");
            try {
                int number = Integer.parseInt(eemaldatav.nextLine());
                toDoList.remove(number - 1);
                System.out.println("Ülesanne number " + number + " edukalt eemaldatud.");
                return null;
            } catch (Exception e) {
                System.out.println("Vigane sisend, sisesta vaid number.");
                return eemaldaÜlesanne();
            }
        }
    }

    //case 4
    public void loosiÜlesanne() {
        if (toDoList.isEmpty()) {
            System.out.println("List on tühi. Sul ei ole midagi teha.");
        } else {
            int max = toDoList.size();
            int juhuslikArv = (int) (Math.random() * max);
            System.out.print("Fortuuna valis: ");
            System.out.println(toDoList.get(juhuslikArv));
        }
    }

    //case 5
    public void väljastaLisatudKirjed() {
        if (toDoList.isEmpty()) {
            System.out.println("List on tühi.");
        } else {
            listiPrint();
        }
    }

    //case 6
    public void salvesta(File fail) {
        try (java.io.PrintWriter pw = new java.io.PrintWriter(fail, "UTF-8")) {
            for (int i = 0; i < toDoList.size(); i++) {
                pw.println(toDoList.get(i));
            }
            System.out.println("Ülesannete nimekiri salvestatud.");
        } catch (Exception e) {
            System.out.println("Tekkis viga faili salvestamisel.");
        }
    }

    private void listiPrint() {
        System.out.println("Listis on " + toDoList.size() + " kirje(t): ");
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println(i + 1 + ". " + toDoList.get(i));
        }
    }

    public void lae(File fail) {
        try (java.util.Scanner sc = new java.util.Scanner(fail, "UTF-8")) {
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                Ülesanne ülesanneFailist = new Ülesanne(rida);
                toDoList.add(ülesanneFailist);
            }
        } catch (Exception e) {
            System.out.println("Tekkis viga faili lugemisel.");
        }
    }

    //loetavuse parandamiseks
    public void eraldaja() {
        String s = "*";
        int n = 64;
        System.out.println();
        StringBuilder sb = new StringBuilder(s.length() * n);
        for (int i = 0; i < n; i++)
            sb.append(s);
        System.out.println(sb.toString());
        System.out.println();
    }
}
