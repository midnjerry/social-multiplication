package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.Multiplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {
    private RandomGeneratorService service;

    @Autowired
    public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService){
        service = randomGeneratorService;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = service.generateRandomFactor();
        int factorB = service.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }
}
