import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    public Person setup() {
        return new Person("Paul", "McCartney", 2000, true, true, true);
    }

    @Test
    void show_full_name() {
        var person = setup();
        String fullName = "Paul McCartney";

        assertEquals(fullName, person.fullName());
    }

    @Test
    void test_calculateYearlySalary() {
        var person = setup();
        person.setSalary(1200);
        float salaryPerYear = 14400;

        assertEquals(salaryPerYear, person.calculateYearlySalary(person.getSalary()));
    }

    @Test
    void person_is_not_MEI() {
        var person = setup();

        assertFalse(person.isMEI());
    }

    @Test
    void person_is_MEI() {
        var person = setup();
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);

        assertTrue(person.isMEI());
    }

}