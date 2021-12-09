package ex1.fr.uge.poo.visitors.stp;
import ex1.com.evilcorp.stp.STPCommand;
import ex1.com.evilcorp.stp.STPParser;

import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        try (var scan = new Scanner(System.in)) {
            var visitor = new AppVisitor();
            while (scan.hasNextLine()) {
                var line = scan.nextLine();
                if (line.equals("quit")) {
                    break;
                }
                Optional<STPCommand> answer = STPParser.parse(line);
                if (answer.isEmpty()) {
                    System.out.println("Unrecognized command");
                } else {
                    answer.get().answer(visitor);
                }
            }
        }
    }
}
