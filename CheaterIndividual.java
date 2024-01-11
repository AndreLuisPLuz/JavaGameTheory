public class CheaterIndividual extends Individual {
    
    public CheaterIndividual(int coins) {
        super(coins, 0);
    }

    protected Individual clone() {
        this.changeCoins(-10);
        return new CheaterIndividual(10);
    }

    public String getType() {
        return "Cheater";
    }
}
