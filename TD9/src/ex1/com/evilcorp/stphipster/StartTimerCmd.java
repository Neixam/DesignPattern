package ex1.com.evilcorp.stphipster;

public record StartTimerCmd(int timerId) implements STPCommand {

    @Override
    public void answer(STPVisitor visitor) {
        visitor.visit(this);
    }

    public int getTimerId() {
        return timerId;
    }
}
