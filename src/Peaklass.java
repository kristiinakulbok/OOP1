import java.io.File;
import java.util.Scanner;

public class Peaklass {

    public static void main(String[] args) {
        File fail = new File("todolist.txt");
        ToDoList toDoList = new ToDoList();
        if (fail.exists()){
            toDoList.lae(fail);
        }
        else{
            try {
                fail.createNewFile();
            }
            catch (Exception e){
                System.out.println("Tekkis viga faili loomisel");
            }
        }
        System.out.println("Tere! Oled kasutamas to-do list'i ehk täitmist vajavate ülesannete nimekirja.");
        boolean loop = true; // selle jaoks, et programm töötaks peale ühe käsu täitmist.
        boolean salvestatud = true; // see praegu ei tee midagi, aga tulevikus kontrollib kas on salvestatud või mitte
                                    // enne, kui programmist väljutakse.
        while (loop) {
            int valik = 0;

            System.out.println("Sisesta 1, et lisada uus ülesanne");
            System.out.println("Sisesta 2, et märkida mingi ülesanne tehtuks");
            System.out.println("Sisesta 3, et eemaldada mingi ülesanne nimekirjast");
            System.out.println("Sisesta 4, et lasta fortuunal otsustada järgmine tegevus");
            System.out.println("Sisesta 5, et kuvada kõik hetkel nimekirjas olevad ülesanded");
            System.out.println("Sisesta 6, et salvestada praegune to-do list");
            System.out.println("Sisesta 7, et programmist väljuda");

            try {
                Scanner kasutajaSisend = new Scanner(System.in);
                System.out.println("Mida soovid järgmiseks teha? ");
                valik = Integer.parseInt(kasutajaSisend.nextLine());
            }
            catch(Exception e){
                System.out.println("Vigane sisend, sisesta vaid number.");
            }

            //Tegin selle osa korda for loopiga, nüüd programm jääb käima
            //

            switch (valik) {
                case 1:
                    toDoList.lisaUusKirje();
                    salvestatud = false;
                    break;

                case 2:
                    System.out.println("null"); // ei tee midagi
                    salvestatud = false;
                    break;

                case 3:
                    toDoList.eemaldaÜlesanne();
                    salvestatud = false;
                    break;

                case 4:
                    toDoList.loosiÜlesanne();
                    break;

                case 5:
                    toDoList.väljastaLisatudKirjed();
                    break;

                case 6:
                    toDoList.salvesta(fail);
                    salvestatud = true;
                    break;

                case 7:
                    if (!salvestatud){
                        System.out.println("Praegune list on salvestamata!");
                        break;
                    }
                    else {
                        loop = false;
                    }
            }
        }
    }
}
