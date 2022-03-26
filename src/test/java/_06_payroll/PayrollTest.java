package _06_payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PayrollTest {

    Payroll payroll = new Payroll();

    @Test
    void itShouldCalculatePaycheck() {
        //given
        int hours = 10;
        double wage = 14.00;
        double expected = 140;

        //when
        double actual = payroll.calculatePaycheck(wage,hours);

        //then
        assertEquals(expected,actual);
    }

    @Test
    void itShouldCalculateMileageReimbursement() {
        //given
        int miles = 10;

        double expected = 5.75;

        //when
        double actual = payroll.calculateMileageReimbursement(miles);

        //then
        assertEquals(expected,actual);
    }

    @Test
    void itShouldCreateOfferLetter() {
        //given
        String name = "Sanjay";
        double hourlyWage = 200.00;
        String expected = "Hello " + name +", We are pleased to offer you an hourly wage of " + hourlyWage;

        //when
        String actual = payroll.createOfferLetter(name, hourlyWage);

        //then
        assertEquals(expected,actual);
    }

}