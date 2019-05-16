package pl.jacek;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Jacek
 */
public class DataPattern {
    
    private final StringProperty value1 = new SimpleStringProperty();
    private final StringProperty value2 = new SimpleStringProperty();
    private final StringProperty value3 = new SimpleStringProperty();
    private final StringProperty value4 = new SimpleStringProperty();
    private final StringProperty value5 = new SimpleStringProperty();
    private final StringProperty value6 = new SimpleStringProperty();
    private final StringProperty value7 = new SimpleStringProperty();
    private final StringProperty value8 = new SimpleStringProperty();
    private final StringProperty value9 = new SimpleStringProperty();
    private final StringProperty value10 = new SimpleStringProperty();
    private final StringProperty value11 = new SimpleStringProperty();
    private final StringProperty value12 = new SimpleStringProperty();
    private final StringProperty value13 = new SimpleStringProperty();
    private final StringProperty value14 = new SimpleStringProperty();

    public String getValue(int numer) {
        if (numer == 1) {
            return value1.get();
        } else if (numer == 2) {
            return value2.get();
        } else if (numer == 3) {
            return value3.get();
        } else if (numer == 4) {
            return value4.get();
        } else if (numer == 5) {
            return value5.get();
        } else if (numer == 6) {
            return value6.get();
        } else if (numer == 7) {
            return value7.get();
        } else if (numer == 8) {
            return value8.get();
        } else if (numer == 9) {
            return value9.get();
        } else if (numer == 10) {
            return value10.get();
        } else if (numer == 11) {
            return value11.get();
        } else if (numer == 12) {
            return value12.get();
        } else if (numer == 13) {
            return value13.get();
        } else if (numer == 14) {
            return value14.get();
        }
        return "Błąd";
    }

    public void setValue(String value, int index) {
        if (index == 1) {
            value1.set(value);
        } else if (index == 2) {
            value2.set(value);
        } else if (index == 3) {
            value3.set(value);
        } else if (index == 4) {
            value4.set(value);
        } else if (index == 5) {
            value5.set(value);
        } else if (index == 6) {
            value6.set(value);
        } else if (index == 7) {
            value7.set(value);
        } else if (index == 8) {
            value8.set(value);
        } else if (index == 9) {
            value9.set(value);
        } else if (index == 10) {
            value10.set(value);
        } else if (index == 11) {
            value11.set(value);
        } else if (index == 12) {
            value12.set(value);
        } else if (index == 13) {
            value13.set(value);
        } else if (index == 14) {
            value14.set(value);
        }
    }

    public String getValue1() {
        return value1.get();
    }

    public StringProperty value1Property() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1.set(value1);
    }

    public String getValue2() {
        return value2.get();
    }

    public StringProperty value2Property() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2.set(value2);
    }

    public String getValue3() {
        return value3.get();
    }

    public StringProperty value3Property() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3.set(value3);
    }

    public String getValue4() {
        return value4.get();
    }

    public StringProperty value4Property() {
        return value4;
    }

    public void setValue4(String value4) {
        this.value4.set(value4);
    }

    public String getValue5() {
        return value5.get();
    }

    public StringProperty value5Property() {
        return value5;
    }

    public void setValue5(String value5) {
        this.value5.set(value5);
    }

    public String getValue6() {
        return value6.get();
    }

    public StringProperty value6Property() {
        return value6;
    }

    public void setValue6(String value6) {
        this.value6.set(value6);
    }

    public String getValue7() {
        return value7.get();
    }

    public StringProperty value7Property() {
        return value7;
    }

    public void setValue7(String value7) {
        this.value7.set(value7);
    }

    public String getValue8() {
        return value8.get();
    }

    public StringProperty value8Property() {
        return value8;
    }

    public void setValue8(String value8) {
        this.value8.set(value8);
    }

    public String getValue9() {
        return value9.get();
    }

    public StringProperty value9Property() {
        return value9;
    }

    public void setValue9(String value9) {
        this.value9.set(value9);
    }

    public String getValue10() {
        return value10.get();
    }

    public StringProperty value10Property() {
        return value10;
    }

    public void setValue10(String value10) {
        this.value10.set(value10);
    }

    public String getValue11() {
        return value11.get();
    }

    public StringProperty value11Property() {
        return value11;
    }

    public void setValue11(String value11) {
        this.value11.set(value11);
    }

    public String getValue12() {
        return value12.get();
    }

    public StringProperty value12Property() {
        return value12;
    }

    public void setValue12(String value12) {
        this.value12.set(value12);
    }

    public String getValue13() {
        return value13.get();
    }

    public StringProperty value13Property() {
        return value13;
    }

    public void setValue13(String value13) {
        this.value13.set(value13);
    }

    public String getValue14() {
        return value14.get();
    }

    public StringProperty value14Property() {
        return value14;
    }

    public void setValue14(String value14) {
        this.value14.set(value14);
    }

    @Override
    public String toString() {
        return "" + value1.get() +
                ";" + value2.get() +
                ";" + value3.get() +
                ";" + value4.get() +
                ";" + value5.get() +
                ";" + value6.get() +
                ";" + value7.get() +
                ";" + value8.get() +
                ";" + value9.get() +
                ";" + value10.get() +
                ";" + value11.get() +
                ";" + value12.get() +
                ";" + value13.get() +
                ";" + value14.get() +
                ';';
    }
}
