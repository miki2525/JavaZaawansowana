package pl.pjatk.mikkal;

import org.springframework.beans.factory.annotation.Value;

//zad 1 27.03
public class Pojo {

    private Integer field1;
    private Integer field2;
    private Integer field3;
    @Value("${my.custom.property}")
    private String text;
    @Value("${my.custom.property:default value}")
    private String textDefault;

    public Pojo(Integer field1, Integer field2, Integer field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public Integer getField1() {
        return field1;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setField1(Integer field1) {
        this.field1 = field1;
    }

    public String getTextDefault() {
        return textDefault;
    }

    public void setTextDefault(String textDefault) {
        this.textDefault = textDefault;
    }

    public Integer getField2() {
        return field2;
    }

    public void setField2(Integer field2) {
        this.field2 = field2;
    }

    public Integer getField3() {
        return field3;
    }

    public void setField3(Integer field3) {
        this.field3 = field3;
    }
}
