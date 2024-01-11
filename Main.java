import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Aggressive individuals quantity: ");
        int qty = sc.nextInt();

        Individual[] aggressive = new Individual[qty];
        for (int i = 0; i < qty; i++) {
            aggressive[i] = new AggressiveIndividual(5);
        }

        System.out.println("Cheater individuals quantity: ");
        qty = sc.nextInt();

        Individual[] cheaters = new Individual[qty];
        for (int i = 0; i < qty; i++) {
            cheaters[i] = new CheaterIndividual(5);
        }

        System.out.println("Confused individuals quantity: ");
        qty = sc.nextInt();

        Individual[] confused = new Individual[qty];
        for (int i = 0; i < qty; i++) {
            confused[i] = new ConfusedIndividual(5);
        }

        System.out.println("Copycat individuals quantity: ");
        qty = sc.nextInt();

        Individual[] copycats = new Individual[qty];
        for (int i = 0; i < qty; i++) {
            copycats[i] = new CopycatIndividual(5);
        }

        System.out.println("Fearful individuals quantity: ");
        qty = sc.nextInt();

        Individual[] fearful = new Individual[qty];
        for (int i = 0; i < qty; i++) {
            fearful[i] = new FearfulIndividual(5);
        }

        System.out.println("Good individuals quantity: ");
        qty = sc.nextInt();

        Individual[] good = new Individual[qty];
        for (int i = 0; i < qty; i++) {
            good[i] = new GoodIndividual(5);
        }

        System.out.println("Resented individuals quantity: ");
        qty = sc.nextInt();

        Individual[] resented = new Individual[qty];
        for (int i = 0; i < qty; i++) {
            resented[i] = new ResentedIndividual(5);
        }

        Game game = new Game(1, 2, 5, 25, 10, 1000);
        game.addIndividuals(aggressive);
        game.addIndividuals(cheaters);
        game.addIndividuals(confused);
        game.addIndividuals(copycats);
        game.addIndividuals(fearful);
        game.addIndividuals(good);
        game.addIndividuals(resented);
        game.start();

        sc.close();
    }
}