package ex1.com.evilcorp.stp;

import java.util.List;
import java.util.Objects;

public final class ElapsedTimeCmd implements STPCommand {

    private final List<Integer> timers;

    @Override
    public void answer(STPVisitor visitor) {
        visitor.visit(this);
    }

    public ElapsedTimeCmd(List<Integer> timers) {
        Objects.requireNonNull(timers);
        this.timers = List.copyOf(timers);
    }

    public List<Integer> getTimers() {
        return timers;
    }
}
