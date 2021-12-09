package ex1.fr.uge.poo.visitors.stp;

import ex1.com.evilcorp.stp.STPParser;

import java.util.Scanner;

public class Trivial {
    public static void main(String[] args) {
        try (var scan = new Scanner(System.in)) {
            for (;;) {
                var t = STPParser.parse(scan.nextLine());
                if (t.isPresent()) {
                    t.get().answer(new TrivialVisitor());
                } else
                    System.out.println("Pas Compris");
            }
        }
    }
}
