import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class GenericState implements HamsterState {
    private final Consumer<Hamster> actionLambda;
    private final Function<Hamster, Optional<HamsterState>> nextStateLambda;

    public GenericState (final Consumer<Hamster> actionLambda, final Function<Hamster, Optional<HamsterState>> nextStateLambda) {
        super();
        this.actionLambda = actionLambda;
        this.nextStateLambda = nextStateLambda;
    }

    @Override
    public void executeAction(final Hamster hamster) {
        actionLambda.accept(hamster);
    }

    @Override
    public Optional<HamsterState> getNextState(final Hamster hamster) {
        return nextStateLambda.apply(hamster);
    }
}
