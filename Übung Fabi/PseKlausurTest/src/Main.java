import java.util.Optional;

interface HamsterState {
    void executeAction(Hamster hamster);
    Optional<HamsterState> getNextState(Hamster hamster);
}

public class Main {
    protected static void run() {
        Hamster paule = new Hamster();

        GenericState walkingState = new GenericState(
                (hamster -> hamster.move()),
                (hamster -> Optional.of(new WalkingState()))
        );

        HamsterState currentState = new CollectingState();
        boolean running = true;
        do {
            currentState.executeAction(paule);
            final Optional<HamsterState> nextState = currentState.getNextState(paule);
            if (nextState.isPresent()) {
                currentState = nextState.get();
            } else {
                running = false;
            }
        } while (running);
    }

    public static void main(String[] args) {
        Main.run();
    }
}

