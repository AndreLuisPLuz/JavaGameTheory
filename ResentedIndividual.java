public class ResentedIndividual extends Individual {

    public ResentedIndividual(int coins) {
        super(coins, 100);
    }

    @Override
    public void changeCoins(int coinsQty) {
        super.changeCoins(coinsQty);
        if (coinsQty == 0)
            this.setTrustPercentage(0);
    }

    protected Individual clone() {
        this.changeCoins(-10);
        return new ResentedIndividual(10);
    }

    public String getType() {
        return "Resented";
    }
}
