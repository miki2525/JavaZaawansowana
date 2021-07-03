package project.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@ApiModel("Logi tworzone po każdym zapytaniu o średni kurs z NBP Api")
public class jaznbp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Unikalne ID", dataType = "Long")
    private Long id;
    @ApiModelProperty(value = "Waluta", dataType = "String", example = "eur")
    private String waluta;
    @ApiModelProperty(value = "Początek zakresu przeszukiwanych dat", dataType = "LocalDate", example = "2012-05-05")
    private LocalDate datastart;
    @ApiModelProperty(value = "Końcowy zakres przeszukiwanych dat", dataType = "LocalDate", example = "2012-05-06")
    private LocalDate datakoniec;
    @ApiModelProperty(value = "Średni kurs", dataType = "Double", example = "5.1234")
    private Double kurs;
    @ApiModelProperty(value = "Data i czas wykonanego zapytania", dataType = "Date", example = "2021-07-03 17:32:10")
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
