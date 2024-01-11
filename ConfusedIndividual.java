public class ConfusedIndividual extends Individual {

    public ConfusedIndividual(int coins) {
        super(coins, 50);
    }

    protected Individual clone() {
        this.changeCoins(-10);
        return new ConfusedIndividual(10);
    }

    public String getType() {
        return "Confused";
    }
}
