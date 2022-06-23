import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class  TesteEmail {
    @Test
    void testar_email_com_arroba() {
        String validEmail = "email_teste@dominio.com.br";

        assertTrue(Pessoa.emailValid(validEmail));
    }

    @Test
    void testar_email_sem_arroba() {
        String validEmail = "email_testedominio.com.br";

        assertFalse(!Pessoa.emailValid(validEmail));
    }

    @Test
    void testar_email_mais_50_caracteres() {
        String validEmail = "email_teste_muito_longo_nao_deve_ser_valido@dominio.com.br";

        assertEquals(false, !Pessoa.emailValid(validEmail));
    }
}