package ex1.com.evilcorp.stp;

public final class HelloCmd implements STPCommand {

    @Override
    public void answer(STPVisitor visitor) {
        visitor.visit(this);
    }
}
