public class CopycatIndividual extends Individual {
    
    public CopycatIndividual(int coins) {
        super(coins, 100);
    }

    @Override
    public void changeCoins(int coinsQty) {
        super.changeCoins(coinsQty);
        if (coinsQty == 0)
            this.setTrustPercentage(0);
        else
            this.setTrustPercentage(100);
    }

    protected Individual clone() {
        this.changeCoins(-10);
        return new CopycatIndividual(10);
    }

    public String getType() {
        return "Copycat";
    }
}
