import java.util.Optional;

public class WalkingState implements HamsterState {
    @Override
    public void executeAction(Hamster hamster) {
        for (int i = 0; i < 3; i++) {System.out.println("walking");}
    }

    public Optional<HamsterState> getNextState(Hamster hamster) {
        return Optional.of(new CollectingState());
    }
}
