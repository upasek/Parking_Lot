package alphateam;

import org.junit.Test;
import static org.junit.Assert.*;

public class PaymentTest {
    @Test public void TotalAmount20() {
        Payment classUnderTest = new Payment();
        assertEquals(80, 80, classUnderTest.TotalAmount(2, 30));
    }

    @Test public void TotalAmount15() {
        Payment classUnderTest = new Payment();
        assertEquals(75, 75, classUnderTest.TotalAmount(2, 15));
    }

    @Test public void TotalAmount10() {
        Payment classUnderTest = new Payment();
        assertEquals(70, 70, classUnderTest.TotalAmount(2, 1));
    }
}
