package ex1.com.evilcorp.stphipster;

public interface STPVisitor {
    void visit(HelloCmd cmd);

    void visit(StartTimerCmd cmd);

    void visit(StopTimerCmd cmd);

    void visit(ElapsedTimeCmd cmd);
}
