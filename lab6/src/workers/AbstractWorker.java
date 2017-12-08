package workers;

public abstract class AbstractWorker {
    private double wynagrodzniaBrutto;
    private String pesel;

    String getPesel() {
        return pesel;
    }

    double getWynagrodzniaBrutto() {
        return wynagrodzniaBrutto;
    }

    void setWynagrodzniaBrutto(double wynagrodzniaBrutto) {
        this.wynagrodzniaBrutto = wynagrodzniaBrutto;
    }

    void setPesel(String pesel) {
        this.pesel = pesel;
    }

    AbstractWorker(String pesel, double wynagrodzniaBrutto) {
        this.wynagrodzniaBrutto = wynagrodzniaBrutto;
        this.pesel = pesel;
    }

    abstract double getNetto();


}
