package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SomeServiceTest {
        private SomeService someService;

        @BeforeEach
        void setUp() {
            someService = new SomeService();
        }

    @Test
    void calculatingRightDiscount() {
        assertThat(someService.calculatingDiscount(2000.0, 50))
                .isEqualTo(1000);
        assertThat(someService.calculatingDiscount(2000.0, 100))
                .isEqualTo(0);
        assertThat(someService.calculatingDiscount(2000.0, 0))
                .isEqualTo(2000);
    }

    @Test
    void calculatingWrongDiscount() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, 110))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }

    @Test
    void calculatingPurchaseAmountDiscount() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(-10.0, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");
    }

    @Test
    void evenNumber() {
        assertTrue(someService.evenOddNumber(22));
    }
    @Test
    void NumberEqualsZero() {
        assertTrue(someService.evenOddNumber(0));
    }
    @Test
    void oddNumber() {
        assertFalse(someService.evenOddNumber(23));
    }

    @Test
    void numberInInterval() {
        assertTrue(someService.numberInInterval(30));
    }

    @Test
    void numberNotInInterval() {
        assertFalse(someService.numberInInterval(101));
    }







}