package Buecher;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Zeitung {

    private String Type;
    private String Herausgeber;   
    private String Auflage;
    private String DateTime;
    private double Preis;
    private int Vorrat;
    private int Parameter = 7;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private LocalDateTime now = LocalDateTime.now();

    
    public String getType() {
        return Type;
    }
    public String getHerausgeber() {
        return Herausgeber;
    }
    public String getAuflage() {
        return Auflage;
    }
    public int getVorrat() {
        return Vorrat;
    }
    public double getPreis() {
        return Preis;
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
    public void setHerausgeber(String Herausgeber) {
        this.Herausgeber = Herausgeber;
    }
    public void setAuflage(String Auflage) {
        this.Auflage = Auflage;
    }
    public void setVorrat(int Vorrat) {
        this.Vorrat = this.Vorrat + Vorrat;
    }
    public void setPreis(double Preis) {
        this.Preis = Preis;
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

    public Zeitung() {
        Type = "Zeitung";
        Herausgeber = "leer";
        Auflage = "leer";
        Preis = 0;
        Vorrat = 0;
        DateTime = dtf.format(now);
        Parameter = 7;
    }
}