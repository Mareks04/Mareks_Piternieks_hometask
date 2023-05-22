package custom.objects;

public class Money {
    private int euros;
    private int cents;

    public Money(int euros, int cents) {
        this.euros = euros;
        this.cents = cents;
    }

    public int getEuros() {
        return euros;
    }

    public int getCents() {
        return cents;
    }
}
