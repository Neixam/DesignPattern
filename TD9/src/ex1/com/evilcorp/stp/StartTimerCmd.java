package ex1.com.evilcorp.stp;

public final class StartTimerCmd implements STPCommand {

    private int  timerId;

    @Override
    public void answer(STPVisitor visitor) {
        visitor.visit(this);
    }

    public StartTimerCmd(int timerId){
        this.timerId=timerId;
    }

    public int getTimerId() {
        return timerId;
    }
}
