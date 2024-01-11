import java.util.Random;

public abstract class Individual {
    private int coins;
    private int trustPercentage;

    public Individual(int coins, int trustPercentage) {
        this.coins = coins;
        this.trustPercentage = trustPercentage;
    }

    protected int getCoins() {
        return this.coins;
    }

    protected void setTrustPercentage(int newTrustPercentage) {
        this.trustPercentage = newTrustPercentage;
    }

    public boolean cheatOrTrust() {
        Random rand = new Random();
        int randNum = rand.nextInt(100);

        return (randNum < this.trustPercentage);
    }

    public void changeCoins(int coinsQty) {
        this.coins += coinsQty;
    }

    public boolean payForSurvival(int survivalCost) {
        this.coins -= survivalCost;
        return (this.coins >= 0);
    }

    public Individual reproduceIfPossible() {
        return (this.coins >= 20 ? this.clone() : null);
    }

    protected abstract Individual clone();

    public abstract String getType();
}
