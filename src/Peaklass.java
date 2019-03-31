import java.util.Scanner;

public class Peaklass {

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        int valik = 0;

        System.out.println("Tere! Oled kasutamas to-do list'i ehk täitmist vajavate ülesannete nimekirja.");
        System.out.println("Sisesta 1, et lisada uus ülesanne");
        System.out.println("Sisesta 2, et märkida mingi ülesanne tehtuks");
        System.out.println("Sisesta 3, et eemaldada mingi ülesanne nimekirjast");
        System.out.println("Sisesta 4, et lasta fortuunal otsustada järgmine tegevus");
        System.out.println("Sisesta 5, et kuvada kõik hetkel nimekirjas olevad ülesanded");
        System.out.println("Sisesta 6, et programmist väljuda");

        Scanner kasutajaSisend = new Scanner(System.in);
        System.out.println("Mida soovid järgmiseks teha? ");
        valik = Integer.parseInt(kasutajaSisend.nextLine());

        //see on vist vaja kuidagi tsüklisse panna, et ta peale igat tegevust tööd ei lõpetaks
        //üleüldse see asi siin hetkel ei tööta eriti nii, nagu ma ette kujutasin
        switch (valik) {
            case 1:
                toDoList.lisaUusKirje();
                break;
            case 3:
                toDoList.eemaldaÜlesanne();
           /*
            case 2:

            case 4:
          */
            case 5:
                toDoList.väljastaLisatudKirjed();

            case 6:
                break;

        }


    }
}
