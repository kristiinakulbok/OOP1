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
                System.out.println("Tekkis viga faili loomisel!");
            }
        }
        System.out.println("Tere! Oled kasutamas to-do list'i ehk täitmist vajavate ülesannete nimekirja.");
        toDoList.kuvaValikud();

        boolean loop = true; // selle jaoks, et programm töötaks peale ühe käsu täitmist.
        boolean salvestatud = true; // kontrollimaks, kas muudatused on salvestatud

        while (loop) {
            int valik = 0;

            try {
                Scanner kasutajaSisend = new Scanner(System.in);
                System.out.println("Mida soovid järgmiseks teha? Sisesta 7, et uuesti näha kõiki valikuid.");
                valik = Integer.parseInt(kasutajaSisend.nextLine());
                //System.out.println();
            } catch (Exception e) {
                System.out.println("Vigane sisend, sisesta vaid number.");
                //System.out.println();
            }

            switch (valik) {
                case 1:
                    toDoList.lisaUusKirje();
                    toDoList.eraldaja();
                    salvestatud = false;
                    break;

                case 2:
                    toDoList.eemaldaÜlesanne();
                    toDoList.eraldaja();
                    salvestatud = false;
                    break;

                case 3:
                    toDoList.loosiÜlesanne();
                    toDoList.eraldaja();
                    break;

                case 4:
                    toDoList.sorteeri();
                    toDoList.väljastaLisatudKirjed();
                    toDoList.eraldaja();
                    break;

                case 5:
                    toDoList.sorteeri();
                    toDoList.salvesta(fail);
                    toDoList.eraldaja();
                    salvestatud = true;
                    break;

                case 6:
                    if (!salvestatud) {
                        System.out.println("Praegune list on salvestamata! 1 - Salvesta ja välju.");
                        System.out.println("                               2 - Välju salvestamata.");
                        System.out.println("                               3 - Tühista.");
                        try{
                            Scanner kasutajaSisend = new Scanner(System.in);
                            valik = Integer.parseInt(kasutajaSisend.nextLine());
                            switch (valik){
                                case 1:
                                    toDoList.salvesta(fail);
                                    loop = false;
                                    System.out.println("Oled programmist väljunud. Hüvasti!");
                                    break;

                                case 2:
                                    loop = false;
                                    System.out.println("Oled programmist väljunud. Hüvasti!");
                                    break;

                                case 3:
                                    break;
                            }
                        } catch (Exception e){
                            System.out.println("Vigane sisend!");
                        }
                        break;
                    } else {
                        System.out.println("Oled programmist väljunud. Hüvasti!");
                        loop = false;
                        break;
                    }

                case 7:
                    toDoList.kuvaValikud();
                    break;
            }
        }
    }
}
