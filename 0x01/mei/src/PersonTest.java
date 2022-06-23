import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("Este teste foi desabilitado pois a regra do MEI está diferente e ainda não foi Implementado #FIX: 1000")
class PersonTest {

    public Person setup() {
        return new Person("Paul", "McCartney", 2000, true, true, true);
    }

    @Disabled("Este teste foi desabilitado pois a regra do MEI está diferente e ainda não foi Implementado #FIX: 1000")
    @Test
    @DisplayName("Check full name")
    void show_full_name() {
        var person = setup();
        String fullName = "Paul McCartney";

        assertEquals(fullName, person.fullName());
    }

    @Test
    @DisplayName("Check calculate salary")
    void test_calculateYearlySalary() {
        var person = setup();
        person.setSalary(1200);
        float salaryPerYear = 14400;

        assertEquals(salaryPerYear, person.calculateYearlySalary(person.getSalary()));
    }

    @Test
    @DisplayName("Check if person is not MEI")
    void person_is_not_MEI() {
        var person = setup();

        assertFalse(person.isMEI());
    }

    @Test
    @DisplayName("Check if person is MEI")
    void person_is_MEI() {
        var person = setup();
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);

        assertTrue(person.isMEI());
    }

    @Test
    @DisplayName("Check if Person IS MEI with salary equals R$ 1200,00")
    void person_is_MEI_1200_salary() {
        var person = new Person("Ale", "Pereira");

        person.setSalary(1200);

        assertTrue(person.isMEI());
    }

    @ParameterizedTest(name = "Por exemplo, o salario de {0} se enquadra no MEI?")
    @ValueSource(ints = { 1200, 20000 } )
    void person_is_MEI_2_times(float salary) {
        Person person = new Person("Daiana", "Damaceno");

        person.setSalary(salary);

        assertTrue(person.isMEI());
    }

}