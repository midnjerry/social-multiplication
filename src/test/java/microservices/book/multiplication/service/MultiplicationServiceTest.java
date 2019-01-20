package microservices.book.multiplication.service;

import com.sun.org.apache.xpath.internal.operations.Mult;
import microservices.book.multiplication.domain.Multiplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest {
    @MockBean
    private RandomGeneratorService randomGeneratorService;

    @Autowired
    private MultiplicationService multiplicationService;

    @Test
    public void createRandomMultiplcationTest() {
        when(randomGeneratorService.generateRandomFactor()).thenReturn(50).thenReturn(30);
        Multiplication multiplication = multiplicationService.createRandomMultiplication();
        assertEquals(50, multiplication.getFactorA());
        assertEquals(30, multiplication.getFactorB());
        assertEquals(1500, multiplication.getResult());
    }
}