// tegemata: case 2 (ülesande tehtuks märkimine) või on see üleliigne, sest tegelikult saavutab sama asja ka
// ülesande nimekirjast eemaldamisega?
// case 1: erindi võiks ka sinna lisada valet sisendit püüdma
// listiPrint vaja kohandada eri prioriteediga ülesannete jaoks, olema peaks vist uus meetod sorteeri
// probleem: failist lugemisel ei ole teada, kas ülesanne on elulise tähtsusega või mitte

import java.io.File;
import java.util.Scanner;

public class Peaklass {

    public static void main(String[] args) {
        File fail = new File("todolist.txt");
        ToDoList toDoList = new ToDoList();
        if (fail.exists()) {
            toDoList.lae(fail);
        } else {
            try {
                fail.createNewFile();
            } catch (Exception e) {
                System.out.println("Tekkis viga faili loomisel");
            }
        }
        System.out.println("Tere! Oled kasutamas to-do list'i ehk täitmist vajavate ülesannete nimekirja.");
        System.out.println("Sisesta 1, et lisada uus ülesanne");
        System.out.println("Sisesta 2, et märkida mingi ülesanne tehtuks");
        System.out.println("Sisesta 3, et eemaldada mingi ülesanne nimekirjast");
        System.out.println("Sisesta 4, et lasta fortuunal otsustada järgmine tegevus");
        System.out.println("Sisesta 5, et kuvada kõik hetkel nimekirjas olevad ülesanded");
        System.out.println("Sisesta 6, et salvestada praegune to-do list");
        System.out.println("Sisesta 7, et programmist väljuda");

        boolean loop = true; // selle jaoks, et programm töötaks peale ühe käsu täitmist.
        boolean salvestatud = true; // kontrollimaks, kas muudatused on salvestatud

        while (loop) {
            int valik = 0;

            try {
                Scanner kasutajaSisend = new Scanner(System.in);
                System.out.println("Mida soovid järgmiseks teha? ");
                valik = Integer.parseInt(kasutajaSisend.nextLine());
                System.out.println();
            } catch (Exception e) {
                System.out.println("Vigane sisend, sisesta vaid number.");
                System.out.println();
            }

            switch (valik) {
                case 1:
                    toDoList.lisaUusKirje();
                    toDoList.eraldaja();
                    salvestatud = false;
                    break;

                case 2:
                    System.out.println("null"); // ei tee midagi
                    toDoList.eraldaja();
                    salvestatud = false;
                    break;

                case 3:
                    toDoList.eemaldaÜlesanne();
                    toDoList.eraldaja();
                    salvestatud = false;
                    break;

                case 4:
                    toDoList.loosiÜlesanne();
                    toDoList.eraldaja();
                    break;

                case 5:
                    toDoList.väljastaLisatudKirjed();
                    toDoList.eraldaja();
                    break;

                case 6:
                    toDoList.salvesta(fail);
                    toDoList.eraldaja();
                    salvestatud = true;
                    break;

                case 7:
                    if (!salvestatud) {
                        System.out.println("Praegune list on salvestamata!");
                        break;
                    } else {
                        System.out.println("Oled programmist väljunud. Hüvasti!");
                        loop = false;
                    }
            }
        }
    }
}
