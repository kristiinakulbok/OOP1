import java.io.File;
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
        }
        else {
            listiPrint();
        }
    }

    private void listiPrint() { // eemaldasin duplikaat koodi, selle eest kaotab punkte vist
        System.out.println("Listis on " + toDoList.size() + " kirjet: ");
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println(i + 1 + ". " + toDoList.get(i));
        }
    }

    public String loosiÜlesanne() {
        if (toDoList.isEmpty()) {
            return "List on tühi. Sul ei ole midagi teha.";
        }
        else {
            int max = toDoList.size();
            int juhuslikArv = (int) (Math.random() * max);
            System.out.print("Fortuuna valis: ");
            return toDoList.get(juhuslikArv);
        }
    }

    public String eemaldaÜlesanne() {
        if (toDoList.isEmpty()) {
            return "See list on juba tühi.";
        }
        else {
            listiPrint();
            Scanner eemaldatav = new Scanner(System.in);
            System.out.println("Sisesta ülesande number, mida soovid eemaldada: ");
            try {
                int number = Integer.parseInt(eemaldatav.nextLine());
                toDoList.remove(number - 1);
                return "Ülesanne number " + number + " edukalt eemaldatud.";
            }
            catch(Exception e){
                System.out.println("Vigane sisend, sisesta vaid number.");
                return eemaldaÜlesanne();
            }
        }
    }
        // uued meetodid, salvestavad ja laadivad failist to-do listi.
    public void salvesta(File fail) {
        try (java.io.PrintWriter pw = new java.io.PrintWriter(fail, "UTF-8")) {
            for (int i = 0; i < toDoList.size(); i++) {
                pw.println(toDoList.get(i));
            }
        }
        catch (Exception e){
            System.out.println("Tekkis viga faili salvestamisel.");
        }
    }

    public void lae(File fail){
        try(java.util.Scanner sc = new java.util.Scanner(fail, "UTF-8")){
            while (sc.hasNextLine()){
                String rida = sc.nextLine();
                toDoList.add(rida);
            }
        }
        catch (Exception e){
            System.out.println("Tekkis viga faili lugemisel.");
        }
    }
}