package Buecher;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Buch {

    private String Type;
    private String Titel;   
    private String Autor;
    private String Verlag;
    private String DateTime;
    private double Preis;
    private int Seitenzahl;
    private int Vorrat;
    private int Parameter = 9;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private LocalDateTime now = LocalDateTime.now();

    
    public String getType() {
        return Type;
    }
    public String getTitel() {
        return Titel;
    }
    public String getAutor() {
        return Autor;
    }
    public int getVorrat() {
        return Vorrat;
    }
    public String getVerlag() {
        return Verlag;
    }
    public double getPreis() {
        return Preis;
    }
    public int getSeitenzahl() {
        return Seitenzahl;
    }
    public DateTimeFormatter getDTF() {
        return dtf;
    }
    public LocalDateTime getNOW() {
        return now;
    }
    public String getDateTime() {
        return DateTime;
    }
    public int getParameter() {
        return Parameter;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
    public void setTitel(String Titel) {
        this.Titel = Titel;
    }
    public void setAutor(String Autor) {
        this.Autor = Autor;
    }
    public void setVorrat(int Vorrat) {
        this.Vorrat = this.Vorrat + Vorrat;
    }
    public void setVerlag(String Verlag) {
        this.Verlag = Verlag;
    }
    public void setPreis(double Preis) {
        this.Preis = Preis;
    }
    public void setSeitenzahl(int Seitenzahl) {
        this.Seitenzahl = Seitenzahl;
    }
    public void setDTF(DateTimeFormatter dtf) {
        this.dtf = dtf;
    }
    public void setNOW(LocalDateTime now) {
        this.now = now;
    }
    public void setDateTime(String DateTime) {
        this.DateTime = DateTime;
    }
    public void setParameter(int Parameter) {
        this.Parameter = Parameter;
    }

    public Buch() {
        Type = "Buch";
        Titel = "leer";
        Autor = "leer";
        Verlag = "leer";
        Preis = 0;
        Seitenzahl = 0;
        Vorrat = 0;
        DateTime = dtf.format(now);
        Parameter = 9;
    }
/*
    public void printTable(String Titel, String Autor, String Verlag, double Preis, int Seitenzahl) {

        Buch.buildInvoice(Titel, Autor, Verlag, Preis, Seitenzahl).forEach(Buch::printInvoice);
    }

    private voice printInvoice() {
        System.out.println(String.format("%30s %10s %30s %10s %30s %10s %25s %10s %25s", this.getTitel(), "|", this.getAutor(), "|", this.getVerlag(), "|", this.getPreis() + "€", "|", this.getSeitenzahl() + " Seiten"));
        System.out.println(String.format("%s", "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"))
    }

    private static List buildInvoice(String Titel, String Autor, String Verlag, double Preis, int Seitenzahl) {
        List<Buch> Buecherliste = new ArrayList<>();
        Buecherliste.add(new Buch(Titel, Autor, Verlag, Preis, Seitenzahl));
        return Buecherliste;
    }

    public static List needName(List Buecherliste, Scanner s, String Titel, String Autor, String Verlag, double Preis, int Seitenzahl) {
        int neueBuecher;
        System.out.pirntln("Wie viele Bücher möchtest du hinzufügen?");
        neueBuecher = s.nextInt();

        for(int i = 0; i < neueBuecher; i++) {
            buildInvoice(Titel, Autor, Verlag, Preis, Seitenzahl);
            System.out.println("\nGib die Daten des " + (i + 1) + ". Buches wie folgt ein:\n\tTitel --> Enter, Autor --> Enter, Verlag --> Enter, Preis --> Enter, Seitenzahl --> Enter\n");
            Buecherliste.get(i).setTitel(s.nextLine());
            Buecherliste.get(i).setAutor(s.nextLine());
            Buecherliste.get(i).setVerlag(s.nextLine());
            Buecherliste.get(i).setPreis(s.nextDouble());
            Buecherliste.get(i).setSeitenzahl(s.nextInt());
        }



        return Buecherliste;
    }*/
}
