package microservices.book.multiplication.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Multiplication {
    private int factorA;
    private int factorB;
    private int result;

    public Multiplication(int factorA, int factorB) {
        this.factorA = factorA;
        this.factorB = factorB;
    }

    public int getResult() {
        return factorA * factorB;
    }
}
