import java.util.ArrayList;
import java.util.Random;

public class Game {
    private ArrayList<Individual> individuals;
    private int survivalCost;
    private int trustCoins;
    private int cheatCoins;
    private int matchesPerRound;
    private int unluckyPerRound;
    private int roundsQty;
    private int populationSize;
    private int aggressiveQty;
    private int cheaterQty;
    private int confusedQty;
    private int copycatQty;
    private int fearfulQty;
    private int goodQty;
    private int resentedQty;
    private int totalRounds;

    public Game (
            int survivalCost, 
            int trustCoins, 
            int cheatCoins, 
            int matchesPerRound, 
            int unluckyPerRound,
            int roundsQty
        ) {
        this.individuals = new ArrayList<Individual>();
        this.survivalCost = survivalCost;
        this.trustCoins = trustCoins;
        this.cheatCoins = cheatCoins;
        this.matchesPerRound = matchesPerRound;
        this.unluckyPerRound = unluckyPerRound;
        this.roundsQty = roundsQty;
    }

    public int getPopulationSize() {
        return this.populationSize;
    }

    public void addIndividuals(Individual[] newIndividuals) {
        for (int i = 0; i < newIndividuals.length; i++) {
            this.individuals.add(newIndividuals[i]);
            this.populationSize++;
        }
    }

    public void start() {
        for (int i = 0; i < this.roundsQty; i++) {
            this.makeRound();

            if (this.hasEndedEarly())
                break;
        }

        this.end();
    }
    
    private void makeRound() {
        for (int i = 0; i < this.matchesPerRound; i++) {
            this.randomMatch();
        }

        this.badLuck();
        this.endRound();
    }

    private void randomMatch() {
        Random rand = new Random(System.currentTimeMillis());
        Individual first = this.individuals.get(rand.nextInt(
            this.populationSize));
        Individual second = this.individuals.get(rand.nextInt(
            this.populationSize));

        boolean firstTrusts = first.cheatOrTrust();
        boolean secondTrusts = second.cheatOrTrust();

        if (firstTrusts && secondTrusts) {
            first.changeCoins(this.trustCoins);
            second.changeCoins(this.trustCoins);
        } else if (firstTrusts || secondTrusts) {
            first.changeCoins(firstTrusts? 0 : cheatCoins);
            second.changeCoins(secondTrusts? 0 : cheatCoins);
        }
    }

    private void badLuck() {
        Random rand = new Random();

        for (int i = 0; i < this.unluckyPerRound; i++) {
            int index = rand.nextInt(this.populationSize);
            this.individuals.get(index).changeCoins(-1);
        }
    }

    private void changeStats() {
        this.aggressiveQty = 0;
        this.cheaterQty = 0;
        this.confusedQty = 0;
        this.copycatQty = 0;
        this.fearfulQty = 0;
        this.goodQty = 0;
        this.resentedQty = 0;

        for (Individual individual: this.individuals) {
            switch (individual.getType()) {
                case "Aggressive":
                    this.aggressiveQty++;
                    break;

                case "Cheater":
                    this.cheaterQty++;
                    break;
                
                case "Confused":
                    this.confusedQty++;
                    break;
                
                case "Copycat":
                    this.copycatQty++;
                    break;
                
                case "Fearful":
                    this.fearfulQty++;
                    break;
                
                case "Good":
                    this.goodQty++;
                    break;
                
                case "Resented":
                    this.resentedQty++;
                    break;
            
                default:
                    break;
            }
        }
    }

    private void endRound() {
        ArrayList<Individual> deadIndividuals = new ArrayList<Individual>();

        for (int i = 0; i < this.populationSize; i++) {
            Individual individual = this.individuals.get(i);
            boolean individualHasSurvived = individual.payForSurvival(
                this.survivalCost);

            if (individualHasSurvived) {
                Individual child = individual.reproduceIfPossible();

                if (child != null) {
                    this.individuals.add(child);
                    this.populationSize++;
                }
            } else {
                deadIndividuals.add(this.individuals.get(i));
            }
        }

        for (Individual deadIndividual : deadIndividuals) {
            this.individuals.remove(deadIndividual);
            this.populationSize--;
        }

        this.changeStats();
        System.out.println(this.toString());

        this.totalRounds++;
    }

    private boolean hasEndedEarly() {
        return (this.populationSize == 0);
    }

    public String toString() {
        return String.format (
            "Current round: %d | Population size: %d\n" + 
            "Aggressive: %d | Cheater: %d" + 
            " | Confused: %d | Copycat: %d" + 
            " | Fearful: %d | Good: %d | Resented: %d\n",
            this.totalRounds,
            this.populationSize,
            this.aggressiveQty,
            this.cheaterQty,
            this.confusedQty,
            this.copycatQty,
            this.fearfulQty,
            this.goodQty,
            this.resentedQty
        );
    }

    private void end() {
        System.out.println("Game ended with a population of " + 
            this.populationSize);
    }
}
