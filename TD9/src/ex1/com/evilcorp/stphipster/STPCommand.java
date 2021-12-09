package ex1.com.evilcorp.stphipster;

public sealed interface STPCommand permits HelloCmd, ElapsedTimeCmd, StartTimerCmd, StopTimerCmd {
    void answer(STPVisitor visitor);
}
