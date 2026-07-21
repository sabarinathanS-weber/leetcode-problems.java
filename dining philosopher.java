class DiningPhilosophers {

    private final Object[] forks;

    public DiningPhilosophers() {

        forks = new Object[5];

        for (int i = 0; i < 5; i++) {
            forks[i] = new Object();
        }
    }

    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {

        int left = philosopher;
        int right = (philosopher + 1) % 5;

        Object first = forks[Math.min(left, right)];
        Object second = forks[Math.max(left, right)];

        synchronized(first) {

            synchronized(second) {

                pickLeftFork.run();
                pickRightFork.run();

                eat.run();

                putLeftFork.run();
                putRightFork.run();
            }
        }
    }
}
