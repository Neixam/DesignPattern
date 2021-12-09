package ex1.fr.uge.poo.visitors.stp;

import ex1.com.evilcorp.stphipster.STPCommand;
import ex1.com.evilcorp.stphipster.STPParser;

import java.util.Optional;
import java.util.Scanner;

public class ApplicationHipster {
    public static void main(String[] args) {
        try (var scan = new Scanner(System.in)) {
            var visitor = new AppHipVisitor();
            while (scan.hasNextLine()) {
                var line = scan.nextLine();
                if (line.equals("quit")) {
                    break;
                }
                Optional<STPCommand> answer = STPParser.parse(line);
                if (answer.isEmpty()) {
                    System.out.println("Unrecognized command");
                } else {
                    visitor.visit(answer.get());
                }
            }
        }
    }
}
