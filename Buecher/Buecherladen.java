package Buecher;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Scanner;

import java.util.ArrayList;

public class Buecherladen {

        public static boolean isBook = false;
        public static boolean isNewspaper = false;

        public static int ItemsInStock = 0;
        public static int BooksInStock = 0;
        public static int NewspapersInStock = 0;
        public static int q;
        public static int ParameterB = 9;
        public static int ParameterZ = 7;

        public static String DateTime = getDateTime();

        public static Scanner s = new Scanner(System.in);

        public static int streetChoice = 0;
        public static int addItemsChoice = 0;
        public static int emptyBooklistChoice = 0;
        public static int emptyNewspaperlistChoice = 0;
        public static int newspaperListChoice = 0;
        public static int itemlistChoice = 0;
        public static int bookMainMenuChoice = 0;
        public static int newspaperMainMenuChoice = 0;
        public static int bookInformationChoice = 0;
        public static int newspaperInformationChoice = 0;
        public static int bookKaufenMenuChoice = 0;
        public static int newspaperKaufenMenuChoice = 0;
        public static int bookKaufenConfirmChoice = 0;
        public static int newspaperKaufenConfirmChoice = 0;

        public static int tempQuantity = 1;
        public static int booksBought = 0;
        public static int newspapersBought = 0;
        public static int newBooks = 0;
        public static int newNewspapers = 0;
        public static int bookCapacity = 100;
        public static int newspaperCapacity = 100;

        public static ArrayList<String> datalist = new ArrayList<String>(
                        2 + bookCapacity * ParameterB + newspaperCapacity);

        public static Buch[] buecher;
        public static Zeitung[] zeitungen;

        public static void main(String[] args) {

                buecher = new Buch[bookCapacity];
                zeitungen = new Zeitung[newspaperCapacity];

                datalist = getSafeFile();

                if (ParameterB == 0 && ParameterZ == 0)
                        ItemsInStock = ItemsInStock + Integer.parseInt(datalist.get(0)
                                        + datalist.get(Integer.parseInt(datalist.get(0)) * ParameterB + 1));

                goStreet();
        }

        private static void goStreet() {

                ItemsInStock = 0;
                BooksInStock = 0;
                NewspapersInStock = 0;

                streetChoice = 0;
                addItemsChoice = 0;
                emptyBooklistChoice = 0;
                newspaperListChoice = 0;
                itemlistChoice = 0;
                bookMainMenuChoice = 0;
                newspaperMainMenuChoice = 0;
                bookInformationChoice = 0;
                newspaperInformationChoice = 0;
                bookKaufenMenuChoice = 0;
                newspaperKaufenMenuChoice = 0;
                bookKaufenConfirmChoice = 0;
                newspaperKaufenConfirmChoice = 0;

                tempQuantity = 1;
                booksBought = 0;
                newspapersBought = 0;
                newBooks = 0;
                newNewspapers = 0;

                datalist = getSafeFile();

                if (ParameterB == 0 && ParameterZ == 0)
                        ItemsInStock = ItemsInStock + Integer.parseInt(datalist.get(0)
                                        + datalist.get(Integer.parseInt(datalist.get(0)) * ParameterB + 1));

                System.out.println("\n\n\n\n" + String.format("%45s",
                                "Du bist auf der Straße. Gegenüber von dir, befindet sich ein Buchladen.") + "\n\n\n\n"
                                + String.format("%95s", DateTime) + "\n\n\n\n\n\n"
                                + String.format("%1s %7s", "1)", ">Buchladen betreten") + "\n"
                                + String.format("%1s %7s", "2)", ">Spiel verlassen") + "\n");
                streetChoice = s.nextInt();
                switch (streetChoice) {
                        case 1:
                                System.out.println("\n\nDu betrittst den Buchladen.\t" + DateTime + "\n\n");
                                addSafedItems();
                                doBookList();
                                break;
                        case 2:
                                System.out.println("\n\n\n\n\nDu entscheidest dich, das Spiel zu verlassen.\n\n");
                                break;
                        default:
                                System.out.println("\nUngültige Eingabe");
                                goStreet();
                                break;
                }
        }

        private static void doBookList() {

                System.out.println("\n\n\n");
                System.out.println(String.format("%-1s %1s %10s %3s %10s %3s %5s %3s %5s %3s %5s", "Num", "|", "Titel",
                                "|", "Autor", "|", "Seitenzahl", "|", "Preis", "|", "Vorrat")
                                + "\n"
                                + String.format("%s",
                                                "-----------------------------------------------------------------------------------------------------------------------------")
                                + "\n");
                for (int i = 0; i < BooksInStock; i++) {
                        System.out.println(String.format("%-1s %1s %10s %3s %10s %3s %5s %3s %5s %3s %5s", i + 1, "|",
                                        buecher[i].getTitel(), "|", buecher[i].getAutor(), "|",
                                        buecher[i].getSeitenzahl() + " Seiten", "|", buecher[i].getPreis() + "€", "|",
                                        buecher[i].getVorrat()) + "\n");
                }
                System.out.println(String.format("%2s %2s %15s", BooksInStock + 1, "|", ">Zeitungen ansehen"));
                System.out.println(String.format("%2s %2s %15s", BooksInStock + 2, "|", ">Items hinzufügen"));
                System.out.println(String.format("%2s %2s %15s", BooksInStock + 3, "|", ">Buchladen verlassen"));
                if (BooksInStock == 0) {
                        System.out.println("\n\n\nEs sind keine Bücher vorhanden. Bitte wählen:\n"
                        // + String.format("%2s %7s", "1)", ">Bücher hinzufügen") + "\n"
                        // + String.format("%2s %7s", "2)", ">Verlassen")
                        );
                        emptyBooklistChoice = s.nextInt();
                        doEmptyBookListMenu();
                } else {
                        System.out.println("Wähle ein Buch [1 - " + BooksInStock + "] oder [" + (BooksInStock + 1)
                                        + " - " + (BooksInStock + 3) + "]\n");
                        itemlistChoice = s.nextInt();
                        doBookMainMenu();
                }
        }

        private static void doNewspaperList() {
                System.out.println("\n\n\n");
                System.out.println(String.format("%-1s %1s %10s %3s %10s %3s %5s %3s %5s", "Num", "|", "Herausgeber",
                                "|", "Auflage", "|", "Preis", "|", "Vorrat")
                                + "\n"
                                + String.format("%s",
                                                "-----------------------------------------------------------------------------------------------------------------------------")
                                + "\n");
                for (int i = 0; i < NewspapersInStock; i++) {
                        System.out.println(String.format("%-1s %1s %10s %3s %10s %3s %5s %3s %5s", i + 1, "|",
                                        zeitungen[i].getHerausgeber(), "|", zeitungen[i].getAuflage(), "|",
                                        zeitungen[i].getPreis() + "€", "|", zeitungen[i].getVorrat()) + "\n");
                }
                System.out.println(String.format("%2s %2s %15s", NewspapersInStock + 1, "|", ">Bücher ansehen"));
                System.out.println(String.format("%2s %2s %15s", NewspapersInStock + 2, "|", ">Items hinzufügen"));
                System.out.println(String.format("%2s %2s %15s", NewspapersInStock + 3, "|", ">Buchladen verlassen"));
                if (NewspapersInStock == 0) {
                        System.out.println("\n\n\nEs sind keine Zeitugen vorhanden. Bitte wählen:\n");
                        emptyNewspaperlistChoice = s.nextInt();
                        doEmptyNewspaperListMenu();
                } else {
                        System.out.println("Wähle eine Zeitung [1 - " + NewspapersInStock + "] oder ["
                                        + (NewspapersInStock + 1) + " - " + (NewspapersInStock + 3) + "]\n");
                        newspaperListChoice = s.nextInt();
                        doNewspaperMainMenu();
                }
        }

        private static void doEmptyBookListMenu() {

                switch (emptyBooklistChoice) {
                        case 1:
                                doNewspaperList();
                                break;
                        case 2:
                                addItems();
                                break;
                        case 3:
                                System.out.println("\n\n\n\n\n"
                                                + String.format("%15s %25s", "_______________",
                                                                "Danke für deinen Besuch!")
                                                + "\n" + String.format("%20s %25s", "____________________",
                                                                "Komme jeder Zeit wieder.")
                                                + "\n");
                                goStreet();
                                break;
                        default:
                                System.out.println("\nUngültige Eingabe");
                                doEmptyBookListMenu();
                                break;
                }
        }

        private static void doEmptyNewspaperListMenu() {

                switch (emptyNewspaperlistChoice) {
                        case 1:
                                doBookList();
                                break;
                        case 2:
                                addItems();
                                break;
                        case 3:
                                System.out.println("\n\n\n\n\n"
                                                + String.format("%15s %25s", "_______________",
                                                                "Danke für deinen Besuch!")
                                                + "\n" + String.format("%20s %25s", "____________________",
                                                                "Komme jeder Zeit wieder.")
                                                + "\n");
                                goStreet();
                                break;
                        default:
                                System.out.println("\nUngültige Eingabe");
                                doEmptyNewspaperListMenu();
                                break;
                }
        }

        private static void doBookMainMenu() {

                isBook = true;

                if (itemlistChoice < BooksInStock + 1) {
                        System.out.println(
                                        "\n\n\n" + String.format("%5s", buecher[itemlistChoice - 1].getTitel() + ":"));
                        System.out.println(String.format("%s",
                                        "------------------------------------------------------------\n")
                                        + String.format("%1s %7s", "1)", ">Informationen") + "\n"
                                        + String.format("%1s %7s", "2)", ">Buch kaufen") + "\n"
                                        + String.format("%1s %7s", "3)", ">zurück zur Auswahl") + "\n");
                        bookMainMenuChoice = s.nextInt();

                        switch (bookMainMenuChoice) {
                                case 1:
                                        doBookInformation();
                                        break;
                                case 2:
                                        doBookKaufenMenu();
                                        break;
                                case 3:
                                        isBook = false;
                                        doBookList();
                                        break;
                                default:
                                        System.out.println("\nUngültige Eingabe");
                                        doBookMainMenu();
                                        break;
                        }
                } else if (itemlistChoice == BooksInStock + 1) {
                        doNewspaperList();
                } else if (itemlistChoice == BooksInStock + 2) {
                        addItems();
                } else {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                                        + String.format("%5s |%-1s %-10s", "_____", "Danke für deinen Besuch!",
                                                        "__________")
                                        + "\n" + String.format("%10s |%-1s %-10s", "__________",
                                                        "Komme jeder Zeit wieder.", "__________")
                                        + "\n\n");
                        goStreet();
                }
        }

        private static void doNewspaperMainMenu() {

                isNewspaper = true;

                if (newspaperListChoice < NewspapersInStock + 1) {
                        System.out.println(
                                        "\n\n\n" + String.format("%5s", zeitungen[newspaperListChoice - 1].getHerausgeber()
                                                        + "\t" + zeitungen[newspaperListChoice - 1].getAuflage() + ":"));
                        System.out.println(String.format("%s",
                                        "------------------------------------------------------------\n")
                                        + String.format("%1s %7s", "1)", ">Informationen") + "\n"
                                        + String.format("%1s %7s", "2)", ">Zeitung kaufen") + "\n"
                                        + String.format("%1s %7s", "3)", ">zurück zur Auswahl") + "\n");
                        newspaperMainMenuChoice = s.nextInt();

                        switch (newspaperMainMenuChoice) {
                                case 1:
                                        doNewspaperInformation();
                                        break;
                                case 2:
                                        doNewspaperKaufenMenu();
                                        break;
                                case 3:
                                        isNewspaper = false;
                                        doBookList();
                                        break;
                                default:
                                        System.out.println("\nUngültige Eingabe");
                                        doNewspaperMainMenu();
                                        break;
                        }
                } else if (newspaperListChoice == NewspapersInStock) {
                        addItems();
                } else {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                                        + String.format("%5s |%-1s %-10s", "_____", "Danke für deinen Besuch!",
                                                        "__________")
                                        + "\n" + String.format("%10s |%-1s %-10s", "__________",
                                                        "Komme jeder Zeit wieder.", "__________")
                                        + "\n\n");
                        goStreet();
                }
        }

        private static void doBookInformation() {

                System.out.println("\n\n" + String.format("%10s %3s %10s %3s %10s %3s %5s %3s %5s %3s %5s",
                                buecher[itemlistChoice - 1].getTitel(), "|", buecher[itemlistChoice - 1].getAutor(),
                                "|", buecher[itemlistChoice - 1].getVerlag(), "|",
                                buecher[itemlistChoice - 1].getPreis() + "€", "|",
                                buecher[itemlistChoice - 1].getSeitenzahl() + " Seiten", "|",
                                buecher[itemlistChoice - 1].getVorrat() + "\n")
                                + String.format("%1s", "Bitte gebe von [1 - 3] ein:") + "\n"
                                + String.format("%1s %7s", "1)", ">Buch hinzufügen (Bitte gebe '1) >Anzahl<' ein)")
                                + "\n" + String.format("%1s %7s", "2)", ">zurück zur Auswahl (2)") + "\n"
                                + String.format("%1s %7s", "3)", ">Buch kaufen (3)") + "\n");
                bookInformationChoice = s.nextInt();

                switch (bookInformationChoice) {
                        case 1:
                                doQuantityUp();
                                doBookInformation();
                                break;
                        case 2:
                                doBookMainMenu();
                                break;
                        case 3:
                                doBookKaufenMenu();
                                break;
                        default:
                                System.out.println("\nUngültige Eingabe");
                                doBookInformation();
                                break;
                }
        }

        private static void doNewspaperInformation() {

                System.out.println("\n\n"
                                + String.format("%10s %3s %10s %3s %5s %3s %5s",
                                                zeitungen[newspaperListChoice - 1].getHerausgeber(), "|",
                                                zeitungen[newspaperListChoice - 1].getAuflage(), "|",
                                                zeitungen[newspaperListChoice - 1].getPreis() + "€", "|",
                                                zeitungen[newspaperListChoice - 1].getVorrat() + "\n")
                                + String.format("%1s", "Bitte gebe von [1 - 3] ein:") + "\n"
                                + String.format("%1s %7s", "1)", ">Zeitung hinzufügen (Bitte gebe '1) >Anzahl<' ein)")
                                + "\n" + String.format("%1s %7s", "2)", ">zurück zur Auswahl (2)") + "\n"
                                + String.format("%1s %7s", "3)", ">Zeitung kaufen (3)") + "\n");
                newspaperInformationChoice = s.nextInt();

                switch (newspaperInformationChoice) {
                        case 1:    
                                doQuantityUp();
                                doNewspaperInformation();
                                break;
                        case 2:
                                doNewspaperMainMenu();
                                break;
                        case 3:
                                doNewspaperKaufenMenu();
                                break;
                        default:
                                System.out.println("\nUngültige Eingabe");
                                doNewspaperInformation();
                                break;
                }
        }

        private static void doQuantityUp() {

                if (isNewspaper == true) {
                        q = s.nextInt();
                        if (q > 0) {
                                System.out.println("\n"
                                + String.format("%27s %15s", "",
                                                "V o r r a t   u m   " + q + "   e r h ö h t .")
                                + "\n" + String.format("%77s %17s", "", zeitungen[newspaperListChoice - 1].getVorrat())
                                + "\n" + String.format("%77s %18s", "", q) + "\n"
                                + String.format("%77s %19s", "", q + zeitungen[newspaperListChoice - 1].getVorrat())
                                + "\n");
                        } else if(q < 0) {
                                System.out.println("\n"
                                + String.format("%27s %15s", "",
                                                "V o r r a t   u m   " + -q + "   v e r r i n g e r t .")
                                + "\n" + String.format("%77s %17s", "", zeitungen[newspaperListChoice - 1].getVorrat())
                                + "\n" + String.format("%77s %18s", "", q) + "\n"
                                + String.format("%77s %19s", "", q + zeitungen[newspaperListChoice - 1].getVorrat())
                                + "\n");  
                        }

                        zeitungen[newspaperListChoice - 1].setVorrat(q);

                } else if (isBook == true) {
                        q = s.nextInt();
                        if (q > 0) {
                                System.out.println("\n"
                                + String.format("%27s %15s", "",
                                                "V o r r a t   u m   " + q + "   e r h ö h t .")
                                + "\n"
                                + String.format("%77s %17s", "", buecher[itemlistChoice - 1].getVorrat())
                                + "\n" + String.format("%77s %18s", "", q) + "\n"
                                + String.format("%77s %19s", "", q + buecher[itemlistChoice - 1].getVorrat())
                                + "\n");
                        } else if (q < 0) {
                                System.out.println("\n"
                                + String.format("%27s %15s", "",
                                                "V o r r a t   u m   " + -q + "   v e r r i n g e r t .")
                                + "\n"
                                + String.format("%77s %17s", "", buecher[itemlistChoice - 1].getVorrat())
                                + "\n" + String.format("%77s %18s", "", q) + "\n"
                                + String.format("%77s %19s", "", q + buecher[itemlistChoice - 1].getVorrat())
                                + "\n");
                        }

                        buecher[itemlistChoice - 1].setVorrat(q);

                }
        }

        private static void doQuantityDown() {

                System.out. println(isBook + " " + isNewspaper);
                if (isBook == true) {
                        q = -1 * booksBought;
                        System.out.println("\n"
                                        + String.format("%27s %15s", "",
                                                        "V o r r a t   u m   " + booksBought
                                                                        + "   v e r r i n g e r t .")
                                        + "\n" + String.format("%77s %17s", "", buecher[itemlistChoice - 1].getVorrat())
                                        + "\n" + String.format("%77s %18s", "", q) + "\n"
                                        + String.format("%77s %19s", "", q + buecher[itemlistChoice - 1].getVorrat())
                                        + "\n");

                        buecher[itemlistChoice - 1].setVorrat(q);
                } else if (isNewspaper == true) {
                        q = -1 * newspapersBought;
                        System.out.println("\n"
                                        + String.format("%27s %15s", "",
                                                        "V o r r a t   u m   " + newspapersBought
                                                                        + "   v e r r i n g e r t .")
                                        + "\n"
                                        + String.format("%77s %17s", "", zeitungen[newspaperListChoice - 1].getVorrat())
                                        + "\n" + String.format("%77s %18s", "", q) + "\n"
                                        + String.format("%77s %19s", "", q + zeitungen[newspaperListChoice - 1].getVorrat())
                                        + "\n");

                        zeitungen[newspaperListChoice - 1].setVorrat(q);
                }

        }

        private static void doBookKaufenMenu() {

                System.out.println("\n\t\t" + tempQuantity + " mal " + buecher[itemlistChoice - 1].getTitel());
                System.out.println("\n" + String.format("%1s %7s", "1)", ">kaufen") + "\n"
                                + String.format("%1s %7s", "2)", ">Anzahl bestimmen") + "\n"
                                + String.format("%1s %7s", "3)", ">zurück zur Auswahl") + "\n");
                bookKaufenMenuChoice = s.nextInt();

                switch (bookKaufenMenuChoice) {
                        case 1:
                                doBookKaufenConfirm();
                                break;
                        case 2:
                                System.out.println("\n\nAnzahl eingeben:\n");
                                tempQuantity = s.nextInt();
                                doBookKaufenMenu();
                                break;
                        case 3:
                                doBookMainMenu();
                                break;
                }
        }

        private static void doNewspaperKaufenMenu() {

                System.out.println("\n\t\t" + tempQuantity + " mal " + zeitungen[newspaperListChoice - 1].getHerausgeber());
                System.out.println("\n" + String.format("%1s %7s", "1)", ">kaufen") + "\n"
                                + String.format("%1s %7s", "2)", ">Anzahl bestimmen") + "\n"
                                + String.format("%1s %7s", "3)", ">zurück zur Auswahl") + "\n");
                newspaperKaufenMenuChoice = s.nextInt();

                switch (newspaperKaufenMenuChoice) {
                        case 1:
                                doNewspaperKaufenConfirm();
                                break;
                        case 2:
                                System.out.println("\n\nAnzahl eingeben:\n");
                                tempQuantity = s.nextInt();
                                doNewspaperKaufenMenu();
                                break;
                        case 3:
                                doNewspaperMainMenu();
                                break;
                }
        }

        private static void doBookKaufenConfirm() {

                System.out.println("\n\t\t" + tempQuantity + " mal " + buecher[itemlistChoice - 1].getTitel() + " von "
                                + buecher[itemlistChoice - 1].getAutor() + " kaufen?\n"
                                + String.format("%1s %4s", "1)", ">Ja") + "\n" + String.format("%1s %4s", "2)", ">Nein")
                                + "\n");
                bookKaufenConfirmChoice = s.nextInt();

                switch (bookKaufenConfirmChoice) {
                        case 1:
                                booksBought = tempQuantity;
                                tempQuantity = 1;
                                System.out.println("\n\n\nKauf abgeschlossen\n\n");
                                doQuantityDown();
                                safeToFile();
                                break;
                        case 2:
                                tempQuantity = 1;
                                doBookKaufenMenu();
                                break;
                        default:
                                System.out.println("\nUngültige Eingabe");
                                doBookKaufenConfirm();
                                break;
                }
        }

        private static void doNewspaperKaufenConfirm() {

                System.out.println("\n\t\t" + tempQuantity + " mal " + zeitungen[newspaperListChoice - 1].getHerausgeber() + ", "
                                + zeitungen[newspaperListChoice - 1].getAuflage() + " kaufen?\n"
                                + String.format("%1s %4s", "1)", ">Ja") + "\n" + String.format("%1s %4s", "2)", ">Nein")
                                + "\n");
                newspaperKaufenConfirmChoice = s.nextInt();

                switch (newspaperKaufenConfirmChoice) {
                        case 1:
                                newspapersBought = tempQuantity;
                                tempQuantity = 1;
                                System.out.println("\n\n\nKauf abgeschlossen\n\n");

                                doQuantityDown();

                                safeToFile();
                                break;
                        case 2:
                                tempQuantity = 1;
                                doBookKaufenMenu();
                                break;
                        default:
                                System.out.println("\nUngültige Eingabe");
                                doBookKaufenConfirm();
                                break;
                }
        }

        private static void addSafedItems() {

                System.out.println("\n\n\n\n\n");

                BooksInStock = BooksInStock + Integer.parseInt(datalist.get(0));

                for (int i = 0; i < (BooksInStock); i++) {

                        buecher[i] = new Buch();
                        System.out.println(String.format("%55s",
                                        "Buch " + (i + 1) + " von " + (BooksInStock) + " geladen."));
                        buecher[i].setType(datalist.get(1 + i * ParameterB));
                        buecher[i].setTitel(datalist.get(2 + i * ParameterB));
                        buecher[i].setAutor(datalist.get(3 + i * ParameterB));
                        buecher[i].setVerlag(datalist.get(4 + i * ParameterB));
                        buecher[i].setPreis(Double.parseDouble(datalist.get(5 + i * ParameterB)));
                        buecher[i].setSeitenzahl(Integer.parseInt(datalist.get(6 + i * ParameterB)));
                        buecher[i].setVorrat(Integer.parseInt(datalist.get(7 + i * ParameterB)));
                        buecher[i].setDateTime(datalist.get(8 + i * ParameterB));
                        buecher[i].setParameter(Integer.parseInt(datalist.get(9 + i * ParameterB)));
                }
                System.out.println("\n");

                NewspapersInStock = NewspapersInStock
                                + Integer.parseInt(datalist.get(Integer.parseInt(datalist.get(0)) * ParameterB + 1));

                for (int i = 0; i < (NewspapersInStock); i++) {

                        zeitungen[i] = new Zeitung();
                        System.out.println(String.format("%55s",
                                        "Zeitung " + (i + 1) + " von " + (NewspapersInStock) + " geladen."));
                        zeitungen[i].setType((datalist.get(Integer.parseInt(datalist.get(0)) * ParameterB + 2 + 0 + (i * ParameterZ))));
                        zeitungen[i].setHerausgeber((datalist.get(Integer.parseInt(datalist.get(0)) * ParameterB + 2 + 1 + (i * ParameterZ))));
                        zeitungen[i].setAuflage((datalist.get(Integer.parseInt(datalist.get(0)) * ParameterB + 2 + 2 + (i * ParameterZ))));
                        zeitungen[i].setPreis(Double.parseDouble(datalist.get(Integer.parseInt(datalist.get(0)) * ParameterB + 2 + 3 + (i * ParameterZ))));
                        zeitungen[i].setVorrat(Integer.parseInt(datalist.get(Integer.parseInt(datalist.get(0)) * ParameterB + 2 + 4 + (i * ParameterZ))));
                        zeitungen[i].setDateTime((datalist.get(Integer.parseInt(datalist.get(0)) * ParameterB + 2 + 5 + (i * ParameterZ))));
                        zeitungen[i].setParameter(Integer.parseInt(datalist.get(Integer.parseInt(datalist.get(0)) * ParameterB + 2 + 6 + (i * ParameterZ))));

                        ItemsInStock = BooksInStock + NewspapersInStock;
                }
        }

        public static void addItems() {

                System.out.println("\n\n\nWas willst du hinzufügen?\n\n" + String.format("%1s %7s", "1)", ">Bücher")
                                + "\n" + String.format("%1s %7s", "2)", ">Zeitungen") + "\n");
                addItemsChoice = s.nextInt();

                switch (addItemsChoice) {
                        case 1:
                                addBooks();
                                break;
                        case 2:
                                addNewspapers();
                                break;
                        default:
                                System.out.println("\nUngültige Eingabe");
                                addItems();
                                break;
                }

        }

        private static void addBooks() {

                newBooks = newBooks();

                for (int i = ItemsInStock; i < (ItemsInStock + newBooks); i++) {

                        buecher[i] = new Buch();

                        System.out.println("\n\n\n" + String.format("%10s", "Buch " + (i - ItemsInStock + 1) + " von "
                                        + (ItemsInStock + newBooks) + " hinzufügen."));

                        System.out.println(
                                        "\nBitte gebe die Daten wie folgt ein:\n\tTitel -> Enter; Autor -> Enter; Verlag --> Enter; Preis --> Enter; Seitenzahl --> Enter; Anzahl --> Enter");
                        s.nextLine();
                        buecher[i].setTitel(s.nextLine());
                        buecher[i].setAutor(s.nextLine());
                        buecher[i].setVerlag(s.nextLine());
                        buecher[i].setPreis(s.nextDouble());
                        buecher[i].setSeitenzahl(s.nextInt());
                        buecher[i].setVorrat(s.nextInt());
                }

                BooksInStock = BooksInStock + newBooks;
                ItemsInStock = ItemsInStock + newBooks;

                safeToFile();

        }

        private static void addNewspapers() {
                newNewspapers = newNewspapers();

                for (int i = ItemsInStock; i < (NewspapersInStock + newNewspapers); i++) {

                        zeitungen[i] = new Zeitung();

                        System.out.println("\n\n\n" + String.format("%10s", "Zeitung " + (i - NewspapersInStock + 1)
                                        + " von " + (NewspapersInStock + newNewspapers) + " hinzufügen."));

                        System.out.println(
                                        "\nBitte gebe die Daten wie folgt ein:\n\tHerausgeber -> Enter; Auflage -> Enter; Preis --> Enter; Anzahl --> Enter");
                        s.nextLine();
                        zeitungen[i].setHerausgeber(s.nextLine());
                        zeitungen[i].setAuflage(s.nextLine());
                        zeitungen[i].setPreis(s.nextDouble());
                        zeitungen[i].setVorrat(s.nextInt());
                }

                NewspapersInStock = NewspapersInStock + newNewspapers;
                ItemsInStock = ItemsInStock + newNewspapers;

                safeToFile();
        }

        private static int newBooks() {

                System.out.println("\nBitte gebe ein, wie viele neue Bücher du hinzufügen möchtest:");
                newBooks = s.nextInt();

                return newBooks;
        }

        private static int newNewspapers() {

                System.out.println("\nBitte gebe ein, wie viele neue Zeitungen du hinzufügen möchtest:");
                newNewspapers = s.nextInt();

                return newNewspapers;
        }

        private static void safeToFile() {

                try {
                        File FileItemlist = new File("C:\\StoreItemlist.txt");
                        Scanner FileReader = new Scanner(FileItemlist);
                /*        if (Files.readAllLines(Paths.get("StoreItemlist.txt")).get(0).equals("0") || Files
                                        .readAllLines(Paths.get("StoreItemlist.txt"))
                                        .get(Integer.parseInt(datalist
                                                        .get(Integer.parseInt(datalist.get(0)) * ParameterB + 1)))
                                        .equals("0")) {*/
                        if (BooksInStock == 0 && NewspapersInStock == 0) {
                                FileWriter myWriter = new FileWriter("C:\\StoreItemlist.txt", false);

                                myWriter.write(Integer.toString(BooksInStock) + "\n");
                                for (int i = 0; i < BooksInStock; i++) {
                                        /* 1 */ myWriter.write(buecher[i].getType() + "\n");
                                        /* 2 */ myWriter.write(buecher[i].getTitel() + "\n");
                                        /* 3 */ myWriter.write(buecher[i].getAutor() + "\n");
                                        /* 4 */ myWriter.write(buecher[i].getVerlag() + "\n");
                                        /* 5 */ myWriter.write(Double.toString(buecher[i].getPreis()) + "\n");
                                        /* 6 */ myWriter.write(Integer.toString(buecher[i].getSeitenzahl()) + "\n");
                                        /* 7 */ myWriter.write(Integer.toString(buecher[i].getVorrat()) + "\n");
                                        /* 8 */ myWriter.write(buecher[i].getDTF().format(buecher[i].getNOW()) + "\n");
                                        /* 9 */ myWriter.write(Integer.toString(buecher[i].getParameter()) + "\n");
                                }
                                myWriter.write(Integer.toString(NewspapersInStock) + "\n");
                                for (int i = 0; i < NewspapersInStock; i++) {
                                        /* 1 */ myWriter.write(zeitungen[i].getType() + "\n");
                                        /* 2 */ myWriter.write(zeitungen[i].getHerausgeber() + "\n");
                                        /* 3 */ myWriter.write(zeitungen[i].getAuflage() + "\n");
                                        /* 4 */ myWriter.write(Double.toString(zeitungen[i].getPreis()) + "\n");
                                        /* 5 */ myWriter.write(Integer.toString(zeitungen[i].getVorrat()) + "\n");
                                        /* 6 */ myWriter.write(
                                                        zeitungen[i].getDTF().format(zeitungen[i].getNOW()) + "\n");
                                        /* 7 */ myWriter.write(Integer.toString(zeitungen[i].getParameter()) + "\n");
                                }
                                myWriter.close();
                        } else {
                                FileWriter myWriter = new FileWriter("C:\\StoreItemlist.txt", true);

                                myWriter.write(Integer.toString(BooksInStock) + "\n");
                                for (int i = 0; i < BooksInStock; i++) {
                                        /* 1 */ myWriter.write(buecher[i].getType() + "\n");
                                        /* 2 */ myWriter.write(buecher[i].getTitel() + "\n");
                                        /* 3 */ myWriter.write(buecher[i].getAutor() + "\n");
                                        /* 4 */ myWriter.write(buecher[i].getVerlag() + "\n");
                                        /* 5 */ myWriter.write(Double.toString(buecher[i].getPreis()) + "\n");
                                        /* 6 */ myWriter.write(Integer.toString(buecher[i].getSeitenzahl()) + "\n");
                                        /* 7 */ myWriter.write(Integer.toString(buecher[i].getVorrat()) + "\n");
                                        /* 8 */ myWriter.write(buecher[i].getDTF().format(buecher[i].getNOW()) + "\n");
                                        /* 9 */ myWriter.write(Integer.toString(buecher[i].getParameter()) + "\n");
                                }
                                myWriter.write(Integer.toString(NewspapersInStock) + "\n");
                                for (int i = 0; i < NewspapersInStock; i++) {
                                        /* 1 */ myWriter.write(zeitungen[i].getType() + "\n");
                                        /* 2 */ myWriter.write(zeitungen[i].getHerausgeber() + "\n");
                                        /* 3 */ myWriter.write(zeitungen[i].getAuflage() + "\n");
                                        /* 4 */ myWriter.write(Double.toString(zeitungen[i].getPreis()) + "\n");
                                        /* 5 */ myWriter.write(Integer.toString(zeitungen[i].getVorrat()) + "\n");
                                        /* 6 */ myWriter.write(
                                                        zeitungen[i].getDTF().format(zeitungen[i].getNOW()) + "\n");
                                        /* 7 */ myWriter.write(Integer.toString(zeitungen[i].getParameter()) + "\n");
                                }
                                myWriter.close();
                        }
                        FileReader.close();
                } catch (IOException e) {
                        System.out.println("Es ist ein Fehler aufgetreten.");
                        e.printStackTrace();
                }
                itemlistChoice = 0;
                datalist = getSafeFile();
                isBook = false;
                isNewspaper = false;
                doBookList();

        }

        private static ArrayList<String> getSafeFile() {

                try {
                        File FileItemlist = new File("C:\\StoreItemlist.txt");

                        /*
                         * try { FileWriter myWriter = new FileWriter( "C:\\StoreItemlist.txt" );
                         * 
                         * myWriter.write("0\n"); myWriter.write("0"); myWriter.close(); } catch
                         * (IOException e) { System.out.println("Es ist ein Fehler aufgetreten."); }
                         */
                        Scanner FileReader = new Scanner(FileItemlist);

                        while (FileReader.hasNextLine()) {
                                String data = FileReader.nextLine();
                                datalist.add(data);
                        }
                        FileReader.close();
                } catch (FileNotFoundException e) {
                        System.out.println("Es ist ein Fehler aufgetreten.");
                        e.printStackTrace();
                }
                return datalist;
        }

        public static String getDateTime() {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                // System.out.println(dtf.format(now));
                String DateTime = dtf.format(now);
                return DateTime;
        }
}