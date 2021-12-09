package ex1.fr.uge.poo.visitors.stp;

import ex1.com.evilcorp.stp.*;

public class TrivialVisitor implements STPVisitor {
    @Override
    public void visit(HelloCmd cmd) {
        System.out.println("Au revoir");
    }

    @Override
    public void visit(StartTimerCmd cmd) {
        System.out.println("non implémenté");
    }

    @Override
    public void visit(StopTimerCmd cmd) {
        System.out.println("non implémenté");
    }

    @Override
    public void visit(ElapsedTimeCmd cmd) {
        System.out.println("non implémenté");
    }
}
