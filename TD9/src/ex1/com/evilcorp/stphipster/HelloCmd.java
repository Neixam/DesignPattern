package ex1.com.evilcorp.stphipster;

public record HelloCmd() implements STPCommand {

    @Override
    public void answer(STPVisitor visitor) {
        visitor.visit(this);
    }
}
