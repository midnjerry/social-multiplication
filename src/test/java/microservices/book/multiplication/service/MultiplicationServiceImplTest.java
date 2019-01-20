package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.Multiplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class MultiplicationServiceImplTest {

    //Same as randomGeneratorService = Mockito.mock(RandomGeneratorService.class)
    @Mock
    private RandomGeneratorService randomGeneratorService;

    private MultiplicationServiceImpl service;

    @Before
    public void setup() {
        //This is needed for @Mock annotations
        MockitoAnnotations.initMocks(this);
        service = new MultiplicationServiceImpl(randomGeneratorService);
    }

    @Test
    public void createRandomMultiplcationTest() {
        when(randomGeneratorService.generateRandomFactor()).thenReturn(50).thenReturn(30);
        Multiplication multiplication = service.createRandomMultiplication();
        assertEquals(50, multiplication.getFactorA());
        assertEquals(30, multiplication.getFactorB());
        assertEquals(1500, multiplication.getResult());
    }
}