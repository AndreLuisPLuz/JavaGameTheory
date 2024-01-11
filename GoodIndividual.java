public class GoodIndividual extends Individual {
    
    public GoodIndividual(int coins) {
        super(coins, 100);
    }

    protected Individual clone() {
        this.changeCoins(-10);
        return new GoodIndividual(10);
    }

    public String getType() {
        return "Good";
    }
}
