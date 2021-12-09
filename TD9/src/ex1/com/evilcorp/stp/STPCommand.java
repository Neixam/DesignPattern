package ex1.com.evilcorp.stp;

public sealed interface STPCommand permits HelloCmd, StopTimerCmd, StartTimerCmd, ElapsedTimeCmd {
    void answer(STPVisitor visitor);
}
