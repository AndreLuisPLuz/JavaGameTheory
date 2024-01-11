public class AggressiveIndividual extends Individual {
    private int roundsTillTrust;
    
    public AggressiveIndividual(int coins) {
        super(coins, 100);
        this.roundsTillTrust = 0;
    }

    @Override
    public void changeCoins(int coinsQty) {
        super.changeCoins(coinsQty);

        if (coinsQty == 0) {
            this.setTrustPercentage(0);
            this.roundsTillTrust = 3;
        }
    }

    @Override
    public boolean cheatOrTrust() {
        if (this.roundsTillTrust > 0) {
            if (--this.roundsTillTrust == 0) {
                this.setTrustPercentage(100);
            }
        }

        return super.cheatOrTrust();
    }

    protected Individual clone() {
        this.changeCoins(-10);
        return new AggressiveIndividual(10);
    }

    public String getType() {
        return "Aggressive";
    }
}
