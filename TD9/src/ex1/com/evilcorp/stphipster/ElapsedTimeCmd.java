package ex1.com.evilcorp.stphipster;

import java.util.List;
import java.util.Objects;

public record ElapsedTimeCmd(List<Integer> timers) implements STPCommand {
    @Override
    public void answer(STPVisitor visitor) {
        visitor.visit(this);
    }

    public ElapsedTimeCmd {
        Objects.requireNonNull(timers);
    }

    public List<Integer> getTimers() {
        return timers;
    }
}
