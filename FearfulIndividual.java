public class FearfulIndividual extends Individual {

    public FearfulIndividual(int coins) {
        super(coins, 100);
    }

    @Override
    public boolean cheatOrTrust() {
        if (this.getCoins() > 3)
            this.setTrustPercentage(100);
        else
            this.setTrustPercentage(0);
        
        return super.cheatOrTrust();
    }

    protected Individual clone() {
        this.changeCoins(-10);
        return new FearfulIndividual(10);
    }

    public String getType() {
        return "Fearful";
    }
}
