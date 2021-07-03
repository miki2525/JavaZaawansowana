package project.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class jaznbp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String waluta;
    private LocalDate datastart;
    private LocalDate datakoniec;
    private Double kurs;
    private Date zapytanie;

    public jaznbp(String waluta, LocalDate datastart, LocalDate datakoniec, Double kurs, Date zapytanie) {
        this.waluta = waluta;
        this.datastart = datastart;
        this.datakoniec = datakoniec;
        this.kurs = kurs;
        this.zapytanie = zapytanie;
    }

    public jaznbp() {}

    public Long getId() {
        return id;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public LocalDate getDatastart() {
        return datastart;
    }

    public void setDatastart(LocalDate datastart) {
        this.datastart = datastart;
    }

    public LocalDate getDatakoniec() {
        return datakoniec;
    }

    public void setDatakoniec(LocalDate datakoniec) {
        this.datakoniec = datakoniec;
    }

    public Double getKurs() {
        return kurs;
    }

    public void setKurs(Double kurs) {
        this.kurs = kurs;
    }

    public Date getZapytanie() {
        return zapytanie;
    }

    public void setZapytanie(Date zapytanie) {
        this.zapytanie = zapytanie;
    }
}
