package Buecher;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Scanner;

import java.util.ArrayList;

public class Buecherladen {

        public static int ItemsInStock = 0;
        public static int BooksInStock = 0;
        public static int NewspapersInStock = 0;
        public static int q;
        public static int ParameterB = 9;
        public static int ParameterZ = 7;

        public static String DateTime = getDateTime();

        public static void main(String[] args) {

                Scanner s = new Scanner(System.in);

                int streetChoice = 0;
                int addItemsChoice = 0;
                int emptyitemlistChoice = 0;
                int newspaperListChoice = 0;
                int itemlistChoice = 0;
                int bookMainMenuChoice = 0;
                int newspaperMainMenuChoice = 0;
                int bookInformationChoice = 0;
                int newspaperInformationChoice = 0;
                int bookKaufenMenuChoice = 0;
                int newspaperKaufenMenuChoice = 0;
                int bookKaufenConfirmChoice = 0;
                int newspaperKaufenConfirmChoice = 0;

                int tempQuantity = 1;
                int booksBought = 0;
                int newspapersBought = 0;
                int newBooks = 0;
                int newNewspapers = 0;
                int bookCapacity = 100;
                int newspaperCapacity = 100;

                ArrayList<String> datalist = new ArrayList<String>(2 + bookCapacity * ParameterB + newspaperCapacity);

                Buch[] buecher;
                Zeitung[] zeitungen;

                buecher = new Buch[bookCapacity];
                zeitungen = new Zeitung[newspaperCapacity];

                datalist = getSafeFile(datalist, s, bookKaufenConfirmChoice, bookKaufenMenuChoice, booksBought,
                                tempQuantity, newBooks, buecher, itemlistChoice, bookInformationChoice,
                                bookMainMenuChoice, emptyitemlistChoice);

                if (ParameterB == 0 && ParameterZ == 0)
                        ItemsInStock = ItemsInStock + Integer.parseInt(datalist.get(0)
                                        + datalist.get(Integer.parseInt(datalist.get(0)) * ParameterB + 1));

                goStreet(streetChoice, datalist, s, newBooks, buecher, bookMainMenuChoice, itemlistChoice,
                                bookInformationChoice, bookKaufenMenuChoice, bookKaufenConfirmChoice, tempQuantity,
                                booksBought, emptyitemlistChoice, q, DateTime, zeitungen, addItemsChoice, newNewspapers,
                                newspaperMainMenuChoice, newspaperInformationChoice, newspaperKaufenMenuChoice,
                                newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
        }

        private static void goStreet(int streetChoice, ArrayList<String> datalist, Scanner s, int newBooks,
                        Buch[] buecher, int bookMainMenuChoice, int itemlistChoice, int bookInformationChoice,
                        int bookKaufenMenuChoice, int bookKaufenConfirmChoice, int tempQuantity, int booksBought,
                        int emptyitemlistChoice, int q, String DateTime, Zeitung[] zeitungen, int addItemsChoice,
                        int newNewspapers, int newspaperMainMenuChoice, int newspaperInformationChoice,
                        int newspaperKaufenMenuChoice, int newspaperKaufenConfirmChoice, int newspapersBought,
                        int newspaperListChoice) {

                ItemsInStock = 0;
                BooksInStock = 0;
                NewspapersInStock = 0;

                streetChoice = 0;
                addItemsChoice = 0;
                emptyitemlistChoice = 0;
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

                datalist = getSafeFile(datalist, s, bookKaufenConfirmChoice, bookKaufenMenuChoice, booksBought,
                                tempQuantity, newBooks, buecher, itemlistChoice, bookInformationChoice,
                                bookMainMenuChoice, emptyitemlistChoice);

                if (ParameterB == 0 && ParameterZ == 0)
                        ItemsInStock = ItemsInStock + Integer.parseInt(datalist.get(0)
                                        + datalist.get(Integer.parseInt(datalist.get(0)) * ParameterB + 1));

                System.out.println("\n\n\n\n\n\n\n\n" + String.format("%45s",
                                "Du bist auf der Straße. Gegenüber von dir, befindet sich ein Buchladen.") + "\n\n\n\n"
                                + String.format("%95s", DateTime) + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                                + String.format("%1s %7s", "1)", ">Buchladen betreten") + "\n"
                                + String.format("%1s %7s", "2)", ">Spiel verlassen") + "\n");
                streetChoice = s.nextInt();
                switch (streetChoice) {
                        case 1:
                                System.out.println("\n\nDu betrittst den Buchladen.\t" + DateTime + "\n\n");
                                addSafedItems(datalist, s, bookKaufenConfirmChoice, bookKaufenMenuChoice, booksBought,
                                                tempQuantity, newBooks, buecher, itemlistChoice, bookInformationChoice,
                                                bookMainMenuChoice, emptyitemlistChoice, q, streetChoice, zeitungen,
                                                addItemsChoice, newNewspapers, newspaperMainMenuChoice,
                                                newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
                                doItemList(datalist, s, newBooks, buecher, bookMainMenuChoice, itemlistChoice,
                                                bookInformationChoice, bookKaufenMenuChoice, bookKaufenConfirmChoice,
                                                tempQuantity, booksBought, emptyitemlistChoice, q, streetChoice,
                                                zeitungen, addItemsChoice, newNewspapers, newspaperMainMenuChoice,
                                                newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
                                break;
                        case 2:
                                System.out.println("\n\n\n\n\nDu entscheidest dich, das Spiel zu verlassen.\n\n");
                                break;
                        default:
                                System.out.println("\nUngültige Eingabe");
                                goStreet(streetChoice, datalist, s, newBooks, buecher, bookMainMenuChoice,
                                                itemlistChoice, bookInformationChoice, bookKaufenMenuChoice,
                                                bookKaufenConfirmChoice, tempQuantity, booksBought, emptyitemlistChoice,
                                                q, DateTime, zeitungen, addItemsChoice, newNewspapers,
                                                newspaperMainMenuChoice, newspaperInformationChoice,
                                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice,
                                                newspapersBought, newspaperListChoice);
                                break;
                }
        }

        private static void doItemList(ArrayList<String> datalist, Scanner s, int newBooks, Buch[] buecher,
                        int bookMainMenuChoice, int itemlistChoice, int bookInformationChoice, int bookKaufenMenuChoice,
                        int bookKaufenConfirmChoice, int tempQuantity, int booksBought, int emptyitemlistChoice, int q,
                        int streetChoice, Zeitung[] zeitungen, int addItemsChoice, int newNewspapers,
                        int newspaperMainMenuChoice, int newspaperInformationChoice, int newspaperKaufenMenuChoice,
                        int newspaperKaufenConfirmChoice, int newspapersBought, int newspaperListChoice) {

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
                        emptyitemlistChoice = s.nextInt();
                        doEmptyBookListMenu(datalist, s, bookMainMenuChoice, itemlistChoice, bookInformationChoice,
                                        bookKaufenMenuChoice, bookKaufenConfirmChoice, buecher, tempQuantity,
                                        booksBought, newBooks, emptyitemlistChoice, q, streetChoice, addItemsChoice,
                                        zeitungen, newNewspapers, newspaperMainMenuChoice, newspaperInformationChoice,
                                        newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice, newspapersBought,
                                        newspaperListChoice);
                } else {
                        System.out.println("Wähle ein Buch [1 - " + BooksInStock + "] oder [" + (BooksInStock + 1)
                                        + " - " + (BooksInStock + 3) + "]\n");
                        itemlistChoice = s.nextInt();
                        doBookMainMenu(datalist, s, bookMainMenuChoice, itemlistChoice, bookInformationChoice,
                                        bookKaufenMenuChoice, bookKaufenConfirmChoice, buecher, tempQuantity,
                                        booksBought, newBooks, emptyitemlistChoice, q, streetChoice, zeitungen,
                                        addItemsChoice, newNewspapers, newspaperMainMenuChoice,
                                        newspaperInformationChoice, newspaperKaufenMenuChoice,
                                        newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
                }
        }

        private static void doEmptyBookListMenu(ArrayList<String> datalist, Scanner s, int bookMainMenuChoice,
                        int itemlistChoice, int bookInformationChoice, int bookKaufenMenuChoice,
                        int bookKaufenConfirmChoice, Buch[] buecher, int tempQuantity, int booksBought, int newBooks,
                        int emptyitemlistChoice, int q, int streetChoice, int addItemsChoice, Zeitung[] zeitungen,
                        int newNewspapers, int newspaperMainMenuChoice, int newspaperInformationChoice,
                        int newspaperKaufenMenuChoice, int newspaperKaufenConfirmChoice, int newspapersBought,
                        int newspaperListChoice) {

                switch (emptyitemlistChoice) {
                        case 1:
                                doNewspaperList(datalist, s, bookMainMenuChoice, itemlistChoice, bookInformationChoice,
                                                bookKaufenMenuChoice, bookKaufenConfirmChoice, buecher, tempQuantity,
                                                booksBought, newBooks, emptyitemlistChoice, q, streetChoice,
                                                addItemsChoice, zeitungen, newNewspapers, newspaperMainMenuChoice,
                                                newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
                                break;
                        case 2:
                                addItems(addItemsChoice, datalist, s, bookKaufenConfirmChoice, bookKaufenMenuChoice,
                                                booksBought, tempQuantity, newBooks, buecher, itemlistChoice,
                                                bookInformationChoice, bookMainMenuChoice, emptyitemlistChoice, q,
                                                streetChoice, zeitungen, newNewspapers, newspaperMainMenuChoice,
                                                newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
                                break;
                        case 3:
                                System.out.println("\n\n\n\n\n"
                                                + String.format("%_15s %25s", "", "Danke für deinen Besuch!") + "\n"
                                                + String.format("%_20s %25s", "", "Komme jeder Zeit wieder.")
                                                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                break;
                        default:
                                System.out.println("\nUngültige Eingabe");
                                doEmptyBookListMenu(datalist, s, bookMainMenuChoice, itemlistChoice,
                                                bookInformationChoice, bookKaufenMenuChoice, bookKaufenConfirmChoice,
                                                buecher, tempQuantity, booksBought, newBooks, emptyitemlistChoice, q,
                                                streetChoice, addItemsChoice, zeitungen, newNewspapers,
                                                newspaperMainMenuChoice, newspaperInformationChoice,
                                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice,
                                                newspapersBought, newspaperListChoice);
                                break;
                }
        }

        private static void doNewspaperList(ArrayList<String> datalist, Scanner s, int bookMainMenuChoice,
                        int itemlistChoice, int bookInformationChoice, int bookKaufenMenuChoice,
                        int bookKaufenConfirmChoice, Buch[] buecher, int tempQuantity, int booksBought, int newBooks,
                        int emptyitemlistChoice, int q, int streetChoice, int addItemsChoice, Zeitung[] zeitungen,
                        int newNewspapers, int newspaperMainMenuChoice, int newspaperInformationChoice,
                        int newspaperKaufenMenuChoice, int newspaperKaufenConfirmChoice, int newspapersBought,
                        int newspaperListChoice) {
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
                } else {
                        System.out.println("Wähle eine Zeitung [1 - " + NewspapersInStock + "] oder ["
                                        + (NewspapersInStock + 1) + " - " + (NewspapersInStock + 3) + "]\n");
                        newspaperListChoice = s.nextInt();
                        doNewspaperMainMenu(datalist, s, bookMainMenuChoice, itemlistChoice, bookInformationChoice,
                                        bookKaufenMenuChoice, bookKaufenConfirmChoice, buecher, tempQuantity,
                                        booksBought, newBooks, emptyitemlistChoice, q, streetChoice, zeitungen,
                                        addItemsChoice, newNewspapers, newspaperMainMenuChoice,
                                        newspaperInformationChoice, newspaperKaufenMenuChoice,
                                        newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
                }
                newspaperListChoice = s.nextInt();

                switch (newspaperListChoice) {
                        case 1:
                                doItemList(datalist, s, newBooks, buecher, bookMainMenuChoice, itemlistChoice,
                                                bookInformationChoice, bookKaufenMenuChoice, bookKaufenConfirmChoice,
                                                tempQuantity, booksBought, emptyitemlistChoice, q, streetChoice,
                                                zeitungen, addItemsChoice, newNewspapers, newspaperMainMenuChoice,
                                                newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
                                break;
                        case 2:
                                addItems(addItemsChoice, datalist, s, bookKaufenConfirmChoice, bookKaufenMenuChoice,
                                                booksBought, tempQuantity, newBooks, buecher, itemlistChoice,
                                                bookInformationChoice, bookMainMenuChoice, emptyitemlistChoice, q,
                                                streetChoice, zeitungen, newNewspapers, newspaperMainMenuChoice,
                                                newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
                                break;
                        case 3:
                                goStreet(streetChoice, datalist, s, newBooks, buecher, bookMainMenuChoice,
                                                itemlistChoice, bookInformationChoice, bookKaufenMenuChoice,
                                                bookKaufenConfirmChoice, tempQuantity, booksBought, emptyitemlistChoice,
                                                q, DateTime, zeitungen, addItemsChoice, newNewspapers,
                                                newspaperMainMenuChoice, newspaperInformationChoice,
                                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice,
                                                newspapersBought, newspaperListChoice);
                                break;
                        default:
                                System.out.println("\nUngültige Eingabe");
                                doNewspaperList(datalist, s, bookMainMenuChoice, itemlistChoice, bookInformationChoice,
                                                bookKaufenMenuChoice, bookKaufenConfirmChoice, buecher, tempQuantity,
                                                booksBought, newBooks, emptyitemlistChoice, q, streetChoice,
                                                addItemsChoice, zeitungen, newNewspapers, newspaperMainMenuChoice,
                                                newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
                                break;
                }

        }

        private static void doBookMainMenu(ArrayList<String> datalist, Scanner s, int bookMainMenuChoice,
                        int itemlistChoice, int bookInformationChoice, int bookKaufenMenuChoice,
                        int bookKaufenConfirmChoice, Buch[] buecher, int tempQuantity, int booksBought, int newBooks,
                        int emptyitemlistChoice, int q, int streetChoice, Zeitung[] zeitungen, int addItemsChoice,
                        int newNewspapers, int newspaperMainMenuChoice, int newspaperInformationChoice,
                        int newspaperKaufenMenuChoice, int newspaperKaufenConfirmChoice, int newspapersBought,
                        int newspaperListChoice) {

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
                                        doBookInformation(datalist, s, bookMainMenuChoice, itemlistChoice,
                                                        bookInformationChoice, bookKaufenMenuChoice,
                                                        bookKaufenConfirmChoice, buecher, tempQuantity, booksBought,
                                                        newBooks, emptyitemlistChoice, q, streetChoice, zeitungen,
                                                        addItemsChoice, newNewspapers, newspaperMainMenuChoice,
                                                        newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                        newspaperKaufenConfirmChoice, newspapersBought,
                                                        newspaperListChoice);
                                        break;
                                case 2:
                                        doBookKaufenMenu(datalist, s, bookKaufenMenuChoice, tempQuantity,
                                                        bookKaufenConfirmChoice, booksBought, buecher, itemlistChoice,
                                                        newBooks, bookInformationChoice, bookMainMenuChoice,
                                                        emptyitemlistChoice, q, streetChoice, zeitungen, addItemsChoice,
                                                        newNewspapers, newspaperMainMenuChoice,
                                                        newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                        newspaperKaufenConfirmChoice, newspapersBought,
                                                        newspaperListChoice);
                                        break;
                                case 3:
                                        doItemList(datalist, s, newBooks, buecher, bookMainMenuChoice, itemlistChoice,
                                                        bookInformationChoice, bookKaufenMenuChoice,
                                                        bookKaufenConfirmChoice, tempQuantity, booksBought,
                                                        emptyitemlistChoice, q, streetChoice, zeitungen, addItemsChoice,
                                                        newNewspapers, newspaperMainMenuChoice,
                                                        newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                        newspaperKaufenConfirmChoice, newspapersBought,
                                                        newspaperListChoice);
                                        break;
                                default:
                                        System.out.println("\nUngültige Eingabe");
                                        doBookMainMenu(datalist, s, bookMainMenuChoice, itemlistChoice,
                                                        bookInformationChoice, bookKaufenMenuChoice,
                                                        bookKaufenConfirmChoice, buecher, tempQuantity, booksBought,
                                                        newBooks, emptyitemlistChoice, q, streetChoice, zeitungen,
                                                        addItemsChoice, newNewspapers, newspaperMainMenuChoice,
                                                        newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                        newspaperKaufenConfirmChoice, newspapersBought,
                                                        newspaperListChoice);
                                        break;
                        }
                } else if (itemlistChoice == BooksInStock + 1) {
                        doNewspaperList(datalist, s, bookMainMenuChoice, itemlistChoice, bookInformationChoice,
                                        bookKaufenMenuChoice, bookKaufenConfirmChoice, buecher, tempQuantity,
                                        booksBought, newBooks, emptyitemlistChoice, q, streetChoice, addItemsChoice,
                                        zeitungen, newNewspapers, newspaperMainMenuChoice, newspaperInformationChoice,
                                        newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice, newspapersBought,
                                        newspaperListChoice);
                } else if (itemlistChoice == BooksInStock + 2) {
                        addItems(addItemsChoice, datalist, s, bookKaufenConfirmChoice, bookKaufenMenuChoice,
                                        booksBought, tempQuantity, newBooks, buecher, itemlistChoice,
                                        bookInformationChoice, bookMainMenuChoice, emptyitemlistChoice, q, streetChoice,
                                        zeitungen, newNewspapers, newspaperMainMenuChoice, newspaperInformationChoice,
                                        newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice, newspapersBought,
                                        newspaperListChoice);
                } else {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                                        + String.format("%5s |%-1s %-10s", "_____", "Danke für deinen Besuch!",
                                                        "__________")
                                        + "\n" + String.format("%10s |%-1s %-10s", "__________",
                                                        "Komme jeder Zeit wieder.", "__________")
                                        + "\n\n");
                        goStreet(streetChoice, datalist, s, newBooks, buecher, bookMainMenuChoice, itemlistChoice,
                                        bookInformationChoice, bookKaufenMenuChoice, bookKaufenConfirmChoice,
                                        tempQuantity, booksBought, emptyitemlistChoice, q, DateTime, zeitungen,
                                        addItemsChoice, newNewspapers, newspaperMainMenuChoice,
                                        newspaperInformationChoice, newspaperKaufenMenuChoice,
                                        newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
                }
        }

        private static void doNewspaperMainMenu(ArrayList<String> datalist, Scanner s, int bookMainMenuChoice,
                        int itemlistChoice, int bookInformationChoice, int bookKaufenMenuChoice,
                        int bookKaufenConfirmChoice, Buch[] buecher, int tempQuantity, int booksBought, int newBooks,
                        int emptyitemlistChoice, int q, int streetChoice, Zeitung[] zeitungen, int addItemsChoice,
                        int newNewspapers, int newspaperMainMenuChoice, int newspaperInformationChoice,
                        int newspaperKaufenMenuChoice, int newspaperKaufenConfirmChoice, int newspapersBought,
                        int newspaperListChoice) {

                if (itemlistChoice < NewspapersInStock + 1) {
                        System.out.println(
                                        "\n\n\n" + String.format("%5s", zeitungen[itemlistChoice - 1].getHerausgeber()
                                                        + "\t" + zeitungen[itemlistChoice - 1].getAuflage() + ":"));
                        System.out.println(String.format("%s",
                                        "------------------------------------------------------------\n")
                                        + String.format("%1s %7s", "1)", ">Informationen") + "\n"
                                        + String.format("%1s %7s", "2)", ">Zeitung kaufen") + "\n"
                                        + String.format("%1s %7s", "3)", ">zurück zur Auswahl") + "\n");
                        newspaperMainMenuChoice = s.nextInt();

                        switch (newspaperMainMenuChoice) {
                                case 1:
                                        doNewspaperInformation(datalist, s, bookMainMenuChoice, itemlistChoice,
                                                        bookInformationChoice, bookKaufenMenuChoice,
                                                        bookKaufenConfirmChoice, buecher, tempQuantity, booksBought,
                                                        newBooks, emptyitemlistChoice, q, streetChoice, zeitungen,
                                                        addItemsChoice, newNewspapers, newspaperMainMenuChoice,
                                                        newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                        newspaperKaufenConfirmChoice, newspapersBought,
                                                        newspaperListChoice);
                                        break;
                                case 2:
                                        doNewspaperKaufenMenu(datalist, s, bookKaufenMenuChoice, tempQuantity,
                                                        bookKaufenConfirmChoice, booksBought, buecher, itemlistChoice,
                                                        newBooks, bookInformationChoice, bookMainMenuChoice,
                                                        emptyitemlistChoice, q, streetChoice, zeitungen, addItemsChoice,
                                                        newNewspapers, newspaperMainMenuChoice,
                                                        newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                        newspaperKaufenConfirmChoice, newspapersBought,
                                                        newspaperListChoice);
                                        break;
                                case 3:
                                        doItemList(datalist, s, newBooks, buecher, bookMainMenuChoice, itemlistChoice,
                                                        bookInformationChoice, bookKaufenMenuChoice,
                                                        bookKaufenConfirmChoice, tempQuantity, booksBought,
                                                        emptyitemlistChoice, q, streetChoice, zeitungen, addItemsChoice,
                                                        newNewspapers, newspaperMainMenuChoice,
                                                        newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                        newspaperKaufenConfirmChoice, newspapersBought,
                                                        newspaperListChoice);
                                        break;
                                default:
                                        System.out.println("\nUngültige Eingabe");
                                        doNewspaperMainMenu(datalist, s, bookMainMenuChoice, itemlistChoice,
                                                        bookInformationChoice, bookKaufenMenuChoice,
                                                        bookKaufenConfirmChoice, buecher, tempQuantity, booksBought,
                                                        newBooks, emptyitemlistChoice, q, streetChoice, zeitungen,
                                                        addItemsChoice, newNewspapers, newspaperMainMenuChoice,
                                                        newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                        newspaperKaufenConfirmChoice, newspapersBought,
                                                        newspaperListChoice);
                                        break;
                        }
                } else if (itemlistChoice == ItemsInStock + 1) {
                        addItems(addItemsChoice, datalist, s, bookKaufenConfirmChoice, bookKaufenMenuChoice,
                                        booksBought, tempQuantity, newBooks, buecher, itemlistChoice,
                                        bookInformationChoice, bookMainMenuChoice, emptyitemlistChoice, q, streetChoice,
                                        zeitungen, newNewspapers, newspaperMainMenuChoice, newspaperInformationChoice,
                                        newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice, newspapersBought,
                                        newspaperListChoice);
                } else {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                                        + String.format("%5s |%-1s %-10s", "_____", "Danke für deinen Besuch!",
                                                        "__________")
                                        + "\n" + String.format("%10s |%-1s %-10s", "__________",
                                                        "Komme jeder Zeit wieder.", "__________")
                                        + "\n\n");
                        goStreet(streetChoice, datalist, s, newBooks, buecher, bookMainMenuChoice, itemlistChoice,
                                        bookInformationChoice, bookKaufenMenuChoice, bookKaufenConfirmChoice,
                                        tempQuantity, booksBought, emptyitemlistChoice, q, DateTime, zeitungen,
                                        addItemsChoice, newNewspapers, newspaperMainMenuChoice,
                                        newspaperInformationChoice, newspaperKaufenMenuChoice,
                                        newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
                }
        }

        private static void doBookInformation(ArrayList<String> datalist, Scanner s, int bookMainMenuChoice,
                        int itemlistChoice, int bookInformationChoice, int bookKaufenMenuChoice,
                        int bookKaufenConfirmChoice, Buch[] buecher, int tempQuantity, int booksBought, int newBooks,
                        int emptyitemlistChoice, int q, int streetChoice, Zeitung[] zeitungen, int addItemsChoice,
                        int newNewspapers, int newspaperMainMenuChoice, int newspaperInformationChoice,
                        int newspaperKaufenMenuChoice, int newspaperKaufenConfirmChoice, int newspapersBought,
                        int newspaperListChoice) {

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

                boolean isBook = true;
                boolean isNewspaper = false;

                switch (bookInformationChoice) {
                        case 1:
                                doQuantityUp(buecher, zeitungen, s, itemlistChoice, q, isNewspaper, isBook);
                        case 2:
                                doBookMainMenu(datalist, s, bookMainMenuChoice, itemlistChoice, bookInformationChoice,
                                                bookKaufenMenuChoice, bookKaufenConfirmChoice, buecher, tempQuantity,
                                                booksBought, newBooks, emptyitemlistChoice, q, streetChoice, zeitungen,
                                                addItemsChoice, newNewspapers, newspaperMainMenuChoice,
                                                newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
                                break;
                        case 3:
                                doBookKaufenMenu(datalist, s, bookKaufenMenuChoice, tempQuantity,
                                                bookKaufenConfirmChoice, booksBought, buecher, itemlistChoice, newBooks,
                                                bookInformationChoice, bookMainMenuChoice, emptyitemlistChoice, q,
                                                streetChoice, zeitungen, addItemsChoice, newNewspapers,
                                                newspaperMainMenuChoice, newspaperInformationChoice,
                                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice,
                                                newspapersBought, newspaperListChoice);
                                break;
                        default:
                                System.out.println("\nUngültige Eingabe");
                                doBookInformation(datalist, s, bookMainMenuChoice, itemlistChoice,
                                                bookInformationChoice, bookKaufenMenuChoice, bookKaufenConfirmChoice,
                                                buecher, tempQuantity, booksBought, newBooks, emptyitemlistChoice, q,
                                                streetChoice, zeitungen, addItemsChoice, newNewspapers,
                                                newspaperMainMenuChoice, newspaperInformationChoice,
                                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice,
                                                newspapersBought, newspaperListChoice);
                                break;
                }
        }

        private static void doNewspaperInformation(ArrayList<String> datalist, Scanner s, int bookMainMenuChoice,
                        int itemlistChoice, int bookInformationChoice, int bookKaufenMenuChoice,
                        int bookKaufenConfirmChoice, Buch[] buecher, int tempQuantity, int booksBought, int newBooks,
                        int emptyitemlistChoice, int q, int streetChoice, Zeitung[] zeitungen, int addItemsChoice,
                        int newNewspapers, int newspaperMainMenuChoice, int newspaperInformationChoice,
                        int newspaperKaufenMenuChoice, int newspaperKaufenConfirmChoice, int newspapersBought,
                        int newspaperListChoice) {

                System.out.println("\n\n"
                                + String.format("%10s %3s %10s %3s %5s %3s %5s",
                                                zeitungen[itemlistChoice - 1].getHerausgeber(), "|",
                                                zeitungen[itemlistChoice - 1].getAuflage(), "|",
                                                zeitungen[itemlistChoice - 1].getPreis() + "€", "|",
                                                zeitungen[itemlistChoice - 1].getVorrat() + "\n")
                                + String.format("%1s", "Bitte gebe von [1 - 3] ein:") + "\n"
                                + String.format("%1s %7s", "1)", ">Buch hinzufügen (Bitte gebe '1) >Anzahl<' ein)")
                                + "\n" + String.format("%1s %7s", "2)", ">zurück zur Auswahl (2)") + "\n"
                                + String.format("%1s %7s", "3)", ">Buch kaufen (3)") + "\n");
                newspaperInformationChoice = s.nextInt();

                boolean isNewspaper = true;
                boolean isBook = false;

                switch (newspaperInformationChoice) {
                        case 1:
                                doQuantityUp(buecher, zeitungen, s, itemlistChoice, q, isNewspaper, isBook);
                        case 2:
                                doNewspaperMainMenu(datalist, s, bookMainMenuChoice, itemlistChoice,
                                                bookInformationChoice, bookKaufenMenuChoice, bookKaufenConfirmChoice,
                                                buecher, tempQuantity, booksBought, newBooks, emptyitemlistChoice, q,
                                                streetChoice, zeitungen, addItemsChoice, newNewspapers,
                                                newspaperMainMenuChoice, newspaperInformationChoice,
                                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice,
                                                newspapersBought, newspaperListChoice);
                                break;
                        case 3:
                                doNewspaperKaufenMenu(datalist, s, bookKaufenMenuChoice, tempQuantity,
                                                bookKaufenConfirmChoice, booksBought, buecher, itemlistChoice, newBooks,
                                                bookInformationChoice, bookMainMenuChoice, emptyitemlistChoice, q,
                                                streetChoice, zeitungen, addItemsChoice, newNewspapers,
                                                newspaperMainMenuChoice, newspaperInformationChoice,
                                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice,
                                                newspapersBought, newspaperListChoice);
                                break;
                        default:
                                System.out.println("\nUngültige Eingabe");
                                doNewspaperInformation(datalist, s, bookMainMenuChoice, itemlistChoice,
                                                bookInformationChoice, bookKaufenMenuChoice, bookKaufenConfirmChoice,
                                                buecher, tempQuantity, booksBought, newBooks, emptyitemlistChoice, q,
                                                streetChoice, zeitungen, addItemsChoice, newNewspapers,
                                                newspaperMainMenuChoice, newspaperInformationChoice,
                                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice,
                                                newspapersBought, newspaperListChoice);
                                break;
                }
        }

        private static void doQuantityUp(Buch[] buecher, Zeitung[] zeitungen, Scanner s, int itemlistChoice, int q,
                        boolean isNewspaper, boolean isBook) {

                if (isNewspaper = true) {
                        q = s.nextInt();
                        System.out.println("\n"
                                        + String.format("%27s %15s", "",
                                                        "V o r r a t   u m   " + q + "   e r h ö h t .")
                                        + "\n" + String.format("%77s %17s", "", buecher[itemlistChoice - 1].getVorrat())
                                        + "\n" + String.format("%77s %18s", "", q) + "\n"
                                        + String.format("%77s %19s", "", q + buecher[itemlistChoice - 1].getVorrat())
                                        + "\n");

                        buecher[itemlistChoice - 1].setVorrat(q);
                        isNewspaper = false;
                } else if (isBook = true) {
                        q = s.nextInt();
                        System.out.println("\n"
                                        + String.format("%27s %15s", "",
                                                        "V o r r a t   u m   " + q + "   e r h ö h t .")
                                        + "\n"
                                        + String.format("%77s %17s", "", zeitungen[itemlistChoice - 1].getVorrat())
                                        + "\n" + String.format("%77s %18s", "", q) + "\n"
                                        + String.format("%77s %19s", "", q + zeitungen[itemlistChoice - 1].getVorrat())
                                        + "\n");

                        zeitungen[itemlistChoice - 1].setVorrat(q);
                        isBook = false;
                }
        }

        private static void doQuantityDown(int q, int booksBought, int newspapersBought, int newspaperListChoice,
                        Buch[] buecher, Zeitung[] zeitungen, int itemlistChoice, boolean isNewspaper, boolean isBook) {

                if (isBook = true) {
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
                        isBook = false;
                } else if (isNewspaper = true) {
                        q = -1 * newspapersBought;
                        System.out.println("\n"
                                        + String.format("%27s %15s", "",
                                                        "V o r r a t   u m   " + newspapersBought
                                                                        + "   v e r r i n g e r t .")
                                        + "\n"
                                        + String.format("%77s %17s", "", zeitungen[itemlistChoice - 1].getVorrat())
                                        + "\n" + String.format("%77s %18s", "", q) + "\n"
                                        + String.format("%77s %19s", "", q + zeitungen[itemlistChoice - 1].getVorrat())
                                        + "\n");

                        buecher[itemlistChoice - 1].setVorrat(q);
                        isNewspaper = false;
                }

        }

        private static void doBookKaufenMenu(ArrayList<String> datalist, Scanner s, int bookKaufenMenuChoice,
                        int tempQuantity, int bookKaufenConfirmChoice, int booksBought, Buch[] buecher,
                        int itemlistChoice, int newBooks, int bookInformationChoice, int bookMainMenuChoice,
                        int emptyitemlistChoice, int q, int streetChoice, Zeitung[] zeitungen, int addItemsChoice,
                        int newNewspapers, int newspaperMainMenuChoice, int newspaperInformationChoice,
                        int newspaperKaufenMenuChoice, int newspaperKaufenConfirmChoice, int newspapersBought,
                        int newspaperListChoice) {

                System.out.println("\n\t\t" + tempQuantity + " mal " + buecher[itemlistChoice - 1].getTitel());
                System.out.println("\n" + String.format("%1s %7s", "1)", ">kaufen") + "\n"
                                + String.format("%1s %7s", "2)", ">Anzahl bestimmen") + "\n"
                                + String.format("%1s %7s", "3)", ">zurück zur Auswahl") + "\n");
                bookKaufenMenuChoice = s.nextInt();

                switch (bookKaufenMenuChoice) {
                        case 1:
                                doBookKaufenConfirm(datalist, s, bookKaufenConfirmChoice, bookKaufenMenuChoice,
                                                booksBought, tempQuantity, newBooks, buecher, itemlistChoice,
                                                bookInformationChoice, bookMainMenuChoice, emptyitemlistChoice, q,
                                                streetChoice, zeitungen, addItemsChoice, newNewspapers,
                                                newspaperMainMenuChoice, newspaperInformationChoice,
                                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice,
                                                newspapersBought, newspaperListChoice);
                                break;
                        case 2:
                                System.out.println("\n\nAnzahl eingeben:\n");
                                tempQuantity = s.nextInt();
                                doBookKaufenMenu(datalist, s, bookKaufenMenuChoice, tempQuantity,
                                                bookKaufenConfirmChoice, booksBought, buecher, itemlistChoice, newBooks,
                                                bookInformationChoice, bookMainMenuChoice, emptyitemlistChoice, q,
                                                streetChoice, zeitungen, addItemsChoice, newNewspapers,
                                                newspaperMainMenuChoice, newspaperInformationChoice,
                                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice,
                                                newspapersBought, newspaperListChoice);
                                break;
                        case 3:
                                doBookMainMenu(datalist, s, bookMainMenuChoice, itemlistChoice, bookInformationChoice,
                                                bookKaufenMenuChoice, bookKaufenConfirmChoice, buecher, tempQuantity,
                                                booksBought, newBooks, emptyitemlistChoice, q, streetChoice, zeitungen,
                                                addItemsChoice, newNewspapers, newspaperMainMenuChoice,
                                                newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
                                break;
                }
        }

        private static void doNewspaperKaufenMenu(ArrayList<String> datalist, Scanner s, int bookKaufenMenuChoice,
                        int tempQuantity, int bookKaufenConfirmChoice, int booksBought, Buch[] buecher,
                        int itemlistChoice, int newBooks, int bookInformationChoice, int bookMainMenuChoice,
                        int emptyitemlistChoice, int q, int streetChoice, Zeitung[] zeitungen, int addItemsChoice,
                        int newNewspapers, int newspaperMainMenuChoice, int newspaperInformationChoice,
                        int newspaperKaufenMenuChoice, int newspaperKaufenConfirmChoice, int newspapersBought,
                        int newspaperListChoice) {

                System.out.println("\n\t\t" + tempQuantity + " mal " + zeitungen[itemlistChoice - 1].getHerausgeber());
                System.out.println("\n" + String.format("%1s %7s", "1)", ">kaufen") + "\n"
                                + String.format("%1s %7s", "2)", ">Anzahl bestimmen") + "\n"
                                + String.format("%1s %7s", "3)", ">zurück zur Auswahl") + "\n");
                newspaperKaufenMenuChoice = s.nextInt();

                switch (newspaperKaufenMenuChoice) {
                        case 1:
                                doNewspaperKaufenConfirm(datalist, s, bookKaufenConfirmChoice, bookKaufenMenuChoice,
                                                booksBought, tempQuantity, newBooks, buecher, itemlistChoice,
                                                bookInformationChoice, bookMainMenuChoice, emptyitemlistChoice, q,
                                                streetChoice, zeitungen, addItemsChoice, newNewspapers,
                                                newspaperMainMenuChoice, newspaperInformationChoice,
                                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice,
                                                newspapersBought, newspaperListChoice);
                                break;
                        case 2:
                                System.out.println("\n\nAnzahl eingeben:\n");
                                tempQuantity = s.nextInt();
                                doNewspaperKaufenMenu(datalist, s, bookKaufenMenuChoice, tempQuantity,
                                                bookKaufenConfirmChoice, booksBought, buecher, itemlistChoice, newBooks,
                                                bookInformationChoice, bookMainMenuChoice, emptyitemlistChoice, q,
                                                streetChoice, zeitungen, addItemsChoice, newNewspapers,
                                                newspaperMainMenuChoice, newspaperInformationChoice,
                                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice,
                                                newspapersBought, newspaperListChoice);
                                break;
                        case 3:
                                doNewspaperMainMenu(datalist, s, bookMainMenuChoice, itemlistChoice,
                                                bookInformationChoice, bookKaufenMenuChoice, bookKaufenConfirmChoice,
                                                buecher, tempQuantity, booksBought, newBooks, emptyitemlistChoice, q,
                                                streetChoice, zeitungen, addItemsChoice, newNewspapers,
                                                newspaperMainMenuChoice, newspaperInformationChoice,
                                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice,
                                                newspapersBought, newspaperListChoice);
                                break;
                }
        }

        private static void doBookKaufenConfirm(ArrayList<String> datalist, Scanner s, int bookKaufenConfirmChoice,
                        int bookKaufenMenuChoice, int booksBought, int tempQuantity, int newBooks, Buch[] buecher,
                        int itemlistChoice, int bookInformationChoice, int bookMainMenuChoice, int emptyitemlistChoice,
                        int q, int streetChoice, Zeitung[] zeitungen, int addItemsChoice, int newNewspapers,
                        int newspaperMainMenuChoice, int newspaperInformationChoice, int newspaperKaufenMenuChoice,
                        int newspaperKaufenConfirmChoice, int newspapersBought, int newspaperListChoice) {

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

                                boolean isBook = true;
                                boolean isNewspaper = false;

                                doQuantityDown(q, booksBought, newspapersBought, newspaperListChoice, buecher,
                                                zeitungen, itemlistChoice, isNewspaper, isBook);

                                safeToFile(datalist, s, bookKaufenConfirmChoice, bookKaufenMenuChoice, booksBought,
                                                tempQuantity, newBooks, buecher, itemlistChoice, bookInformationChoice,
                                                bookMainMenuChoice, emptyitemlistChoice, q, streetChoice, BooksInStock,
                                                zeitungen, addItemsChoice, newNewspapers, newspaperMainMenuChoice,
                                                newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
                                break;
                        case 2:
                                tempQuantity = 1;
                                doBookKaufenMenu(datalist, s, bookKaufenMenuChoice, tempQuantity,
                                                bookKaufenConfirmChoice, booksBought, buecher, itemlistChoice, newBooks,
                                                bookInformationChoice, bookMainMenuChoice, emptyitemlistChoice, q,
                                                streetChoice, zeitungen, addItemsChoice, newNewspapers,
                                                newspaperMainMenuChoice, newspaperInformationChoice,
                                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice,
                                                newspapersBought, newspaperListChoice);
                                break;
                        default:
                                System.out.println("\nUngültige Eingabe");
                                doBookKaufenConfirm(datalist, s, bookKaufenConfirmChoice, bookKaufenMenuChoice,
                                                booksBought, tempQuantity, newBooks, buecher, itemlistChoice,
                                                bookInformationChoice, bookMainMenuChoice, emptyitemlistChoice, q,
                                                streetChoice, zeitungen, addItemsChoice, newNewspapers,
                                                newspaperMainMenuChoice, newspaperInformationChoice,
                                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice,
                                                newspapersBought, newspaperListChoice);
                                break;
                }
        }

        private static void doNewspaperKaufenConfirm(ArrayList<String> datalist, Scanner s, int bookKaufenConfirmChoice,
                        int bookKaufenMenuChoice, int booksBought, int tempQuantity, int newBooks, Buch[] buecher,
                        int itemlistChoice, int bookInformationChoice, int bookMainMenuChoice, int emptyitemlistChoice,
                        int q, int streetChoice, Zeitung[] zeitungen, int addItemsChoice, int newNewspapers,
                        int newspaperMainMenuChoice, int newspaperInformationChoice, int newspaperKaufenMenuChoice,
                        int newspaperKaufenConfirmChoice, int newspapersBought, int newspaperListChoice) {

                System.out.println("\n\t\t" + tempQuantity + " mal " + buecher[itemlistChoice - 1].getTitel() + " von "
                                + buecher[itemlistChoice - 1].getAutor() + " kaufen?\n"
                                + String.format("%1s %4s", "1)", ">Ja") + "\n" + String.format("%1s %4s", "2)", ">Nein")
                                + "\n");
                newspaperKaufenConfirmChoice = s.nextInt();

                switch (newspaperKaufenConfirmChoice) {
                        case 1:
                                newspapersBought = tempQuantity;
                                tempQuantity = 1;
                                System.out.println("\n\n\nKauf abgeschlossen\n\n");

                                boolean isNewspaper = true;
                                boolean isBook = false;

                                doQuantityDown(q, booksBought, newspapersBought, newspaperListChoice, buecher,
                                                zeitungen, itemlistChoice, isNewspaper, isBook);

                                safeToFile(datalist, s, bookKaufenConfirmChoice, bookKaufenMenuChoice, booksBought,
                                                tempQuantity, newBooks, buecher, itemlistChoice, bookInformationChoice,
                                                bookMainMenuChoice, emptyitemlistChoice, q, streetChoice, BooksInStock,
                                                zeitungen, addItemsChoice, newNewspapers, newspaperMainMenuChoice,
                                                newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
                                break;
                        case 2:
                                tempQuantity = 1;
                                doBookKaufenMenu(datalist, s, bookKaufenMenuChoice, tempQuantity,
                                                bookKaufenConfirmChoice, booksBought, buecher, itemlistChoice, newBooks,
                                                bookInformationChoice, bookMainMenuChoice, emptyitemlistChoice, q,
                                                streetChoice, zeitungen, addItemsChoice, newNewspapers,
                                                newspaperMainMenuChoice, newspaperInformationChoice,
                                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice,
                                                newspapersBought, newspaperListChoice);
                                break;
                        default:
                                System.out.println("\nUngültige Eingabe");
                                doBookKaufenConfirm(datalist, s, bookKaufenConfirmChoice, bookKaufenMenuChoice,
                                                booksBought, tempQuantity, newBooks, buecher, itemlistChoice,
                                                bookInformationChoice, bookMainMenuChoice, emptyitemlistChoice, q,
                                                streetChoice, zeitungen, addItemsChoice, newNewspapers,
                                                newspaperMainMenuChoice, newspaperInformationChoice,
                                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice,
                                                newspapersBought, newspaperListChoice);
                                break;
                }
        }

        private static void addSafedItems(ArrayList<String> datalist, Scanner s, int bookKaufenConfirmChoice,
                        int bookKaufenMenuChoice, int booksBought, int tempQuantity, int newBooks, Buch[] buecher,
                        int itemlistChoice, int bookInformationChoice, int bookMainMenuChoice, int emptyitemlistChoice,
                        int q, int streetChoice, Zeitung[] zeitungen, int addItemsChoice, int newNewspapers,
                        int newspaperMainMenuChoice, int newspaperInformationChoice, int newspaperKaufenMenuChoice,
                        int newspaperKaufenConfirmChoice, int newspapersBought, int newspaperListChoice) {

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
                        zeitungen[i].setType(datalist.get(0 + i * ParameterZ));
                        zeitungen[i].setHerausgeber(datalist.get(1 + i * ParameterZ));
                        zeitungen[i].setAuflage(datalist.get(2 + i * ParameterZ));
                        zeitungen[i].setPreis(Double.parseDouble(datalist.get(3 + i * ParameterZ)));
                        zeitungen[i].setVorrat(Integer.parseInt(datalist.get(4 + i * ParameterZ)));
                        zeitungen[i].setDateTime(datalist.get(5 + i * ParameterZ));
                        zeitungen[i].setParameter(Integer.parseInt(datalist.get(6 + i * ParameterZ)));

                        ItemsInStock = BooksInStock + NewspapersInStock;
                }
        }

        public static void addItems(int addItemsChoice, ArrayList<String> datalist, Scanner s,
                        int bookKaufenConfirmChoice, int bookKaufenMenuChoice, int booksBought, int tempQuantity,
                        int newBooks, Buch[] buecher, int itemlistChoice, int bookInformationChoice,
                        int bookMainMenuChoice, int emptyitemlistChoice, int q, int streetChoice, Zeitung[] zeitungen,
                        int newNewspapers, int newspaperMainMenuChoice, int newspaperInformationChoice,
                        int newspaperKaufenMenuChoice, int newspaperKaufenConfirmChoice, int newspapersBought,
                        int newspaperListChoice) {

                System.out.println("\n\n\nWas willst du hinzufügen?\n\n" + String.format("%1s %7s", "1)", ">Bücher")
                                + "\n" + String.format("%1s %7s", "2)", ">Zeitungen") + "\n");
                addItemsChoice = s.nextInt();

                switch (addItemsChoice) {
                        case 1:
                                addBooks(datalist, s, bookKaufenConfirmChoice, bookKaufenMenuChoice, booksBought,
                                                tempQuantity, newBooks, buecher, itemlistChoice, bookInformationChoice,
                                                bookMainMenuChoice, emptyitemlistChoice, q, streetChoice, BooksInStock,
                                                zeitungen, addItemsChoice, newNewspapers, newspaperMainMenuChoice,
                                                newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
                                break;
                        case 2:
                                addNewspapers(datalist, s, bookKaufenConfirmChoice, bookKaufenMenuChoice, booksBought,
                                                tempQuantity, newBooks, buecher, itemlistChoice, bookInformationChoice,
                                                bookMainMenuChoice, emptyitemlistChoice, q, streetChoice, BooksInStock,
                                                zeitungen, addItemsChoice, newNewspapers, newspaperMainMenuChoice,
                                                newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
                                break;
                        default:
                                System.out.println("\nUngültige Eingabe");
                                addItems(addItemsChoice, datalist, s, bookKaufenConfirmChoice, bookKaufenMenuChoice,
                                                booksBought, tempQuantity, newBooks, buecher, itemlistChoice,
                                                bookInformationChoice, bookMainMenuChoice, emptyitemlistChoice, q,
                                                streetChoice, zeitungen, newNewspapers, newspaperMainMenuChoice,
                                                newspaperInformationChoice, newspaperKaufenMenuChoice,
                                                newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);
                                break;
                }

        }

        private static void addBooks(ArrayList<String> datalist, Scanner s, int bookKaufenConfirmChoice,
                        int bookKaufenMenuChoice, int booksBought, int tempQuantity, int newBooks, Buch[] buecher,
                        int itemlistChoice, int bookInformationChoice, int bookMainMenuChoice, int emptyitemlistChoice,
                        int q, int streetChoice, int BooksInStock, Zeitung[] zeitungen, int addItemsChoice,
                        int newNewspapers, int newspaperMainMenuChoice, int newspaperInformationChoice,
                        int newspaperKaufenMenuChoice, int newspaperKaufenConfirmChoice, int newspapersBought,
                        int newspaperListChoice) {

                newBooks = newBooks(s, newBooks);

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

                safeToFile(datalist, s, bookKaufenConfirmChoice, bookKaufenMenuChoice, booksBought, tempQuantity,
                                newBooks, buecher, itemlistChoice, bookInformationChoice, bookMainMenuChoice,
                                emptyitemlistChoice, q, streetChoice, BooksInStock, zeitungen, addItemsChoice,
                                newNewspapers, newspaperMainMenuChoice, newspaperInformationChoice,
                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice, newspapersBought,
                                newspaperListChoice);

        }

        private static void addNewspapers(ArrayList<String> datalist, Scanner s, int bookKaufenConfirmChoice,
                        int bookKaufenMenuChoice, int booksBought, int tempQuantity, int newBooks, Buch[] buecher,
                        int itemlistChoice, int bookInformationChoice, int bookMainMenuChoice, int emptyitemlistChoice,
                        int q, int streetChoice, int BooksInStock, Zeitung[] zeitungen, int addItemsChoice,
                        int newNewspapers, int newspaperMainMenuChoice, int newspaperInformationChoice,
                        int newspaperKaufenMenuChoice, int newspaperKaufenConfirmChoice, int newspapersBought,
                        int newspaperListChoice) {
                newNewspapers = newNewspapers(s, newNewspapers, newspaperMainMenuChoice, newspaperInformationChoice);

                for (int i = ItemsInStock; i < (ItemsInStock + newNewspapers); i++) {

                        zeitungen[i] = new Zeitung();

                        System.out.println("\n\n\n" + String.format("%10s", "Zeitung " + (i - ItemsInStock + 1)
                                        + " von " + (ItemsInStock + newNewspapers) + " hinzufügen."));

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

                safeToFile(datalist, s, bookKaufenConfirmChoice, bookKaufenMenuChoice, booksBought, tempQuantity,
                                newBooks, buecher, itemlistChoice, bookInformationChoice, bookMainMenuChoice,
                                emptyitemlistChoice, q, streetChoice, BooksInStock, zeitungen, addItemsChoice,
                                newNewspapers, newspaperMainMenuChoice, newspaperInformationChoice,
                                newspaperKaufenMenuChoice, newspaperKaufenConfirmChoice, newspapersBought,
                                newspaperListChoice);
        }

        private static int newBooks(Scanner s, int newBooks) {

                System.out.println("\nBitte gebe ein, wie viele neue Bücher du hinzufügen möchtest:");
                newBooks = s.nextInt();

                return newBooks;
        }

        private static int newNewspapers(Scanner s, int newNewspapers, int newspaperMainMenuChoice,
                        int newspaperInformationChoice) {

                System.out.println("\nBitte gebe ein, wie viele neue Zeitungen du hinzufügen möchtest:");
                newNewspapers = s.nextInt();

                return newNewspapers;
        }

        private static void safeToFile(ArrayList<String> datalist, Scanner s, int bookKaufenConfirmChoice,
                        int bookKaufenMenuChoice, int booksBought, int tempQuantity, int newBooks, Buch[] buecher,
                        int itemlistChoice, int bookInformationChoice, int bookMainMenuChoice, int emptyitemlistChoice,
                        int q, int streetChoice, int BooksInStock, Zeitung[] zeitungen, int addItemsChoice,
                        int newNewspapers, int newspaperMainMenuChoice, int newspaperInformationChoice,
                        int newspaperKaufenMenuChoice, int newspaperKaufenConfirmChoice, int newspapersBought,
                        int newspaperListChoice) {

                try {
                        FileWriter myWriter = new FileWriter(
                                        "Desktop\\StoreItemlist.txt",
                                        false);

                        myWriter.write(BooksInStock);
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
                        myWriter.write(NewspapersInStock);
                        for (int i = 0; i < NewspapersInStock; i++) {
                                /* 1 */ myWriter.write(zeitungen[i].getType() + "\n");
                                /* 2 */ myWriter.write(zeitungen[i].getHerausgeber() + "\n");
                                /* 3 */ myWriter.write(zeitungen[i].getAuflage() + "\n");
                                /* 4 */ myWriter.write(Double.toString(zeitungen[i].getPreis()) + "\n");
                                /* 5 */ myWriter.write(Integer.toString(zeitungen[i].getVorrat()) + "\n");
                                /* 6 */ myWriter.write(zeitungen[i].getDTF().format(zeitungen[i].getNOW()) + "\n");
                                /* 7 */ myWriter.write(Integer.toString(zeitungen[i].getParameter()) + "\n");
                        }
                        myWriter.close();
                } catch (IOException e) {
                        System.out.println("Es ist ein Fehler aufgetreten.");
                        e.printStackTrace();
                }
                itemlistChoice = 0;
                doItemList(datalist, s, newBooks, buecher, bookMainMenuChoice, itemlistChoice, bookInformationChoice,
                                bookKaufenMenuChoice, bookKaufenConfirmChoice, tempQuantity, booksBought,
                                emptyitemlistChoice, q, streetChoice, zeitungen, addItemsChoice, newNewspapers,
                                newspaperMainMenuChoice, newspaperInformationChoice, newspaperKaufenMenuChoice,
                                newspaperKaufenConfirmChoice, newspapersBought, newspaperListChoice);

        }

        private static ArrayList<String> getSafeFile(ArrayList<String> datalist, Scanner s, int bookKaufenConfirmChoice,
                        int bookKaufenMenuChoice, int booksBought, int tempQuantity, int newBooks, Buch[] buecher,
                        int itemlistChoice, int bookInformationChoice, int bookMainMenuChoice,
                        int emptyitemlistChoice) {

                try {
                        File FileItemlist = new File(
                                        "Desktop\\StoreItemlist.txt");

                        /*
                         * try { FileWriter myWriter = new FileWriter(
                         * "Desktop\\StoreItemlist.txt"
                         * );
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