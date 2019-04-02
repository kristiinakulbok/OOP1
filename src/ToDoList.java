import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    ArrayList<String> toDoList = new ArrayList<String>();

    //case 1
    public void lisaUusKirje() {
        Scanner sisend = new Scanner(System.in);
        System.out.println("Mida soovid lisada? ");
        String ülesanne = sisend.nextLine();
        toDoList.add(ülesanne);
        System.out.println("Uus kirje lisatud!");
    }

    //case 3
    public String eemaldaÜlesanne() {
        if (toDoList.isEmpty()) {
            System.out.println("See list on juba tühi.");
            return null; //kohmakas lahendus, aga tagastustüüp void ei sobinud rekursiooniga
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

    private void listiPrint() { // eemaldasin duplikaat koodi, selle eest kaotab punkte vist
        System.out.println("Listis on " + toDoList.size() + " kirje(t): ");
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println(i + 1 + ". " + toDoList.get(i));
        }
    }

    public void lae(File fail) {
        try (java.util.Scanner sc = new java.util.Scanner(fail, "UTF-8")) {
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                toDoList.add(rida);
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
