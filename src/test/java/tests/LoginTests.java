package tests;

import common.BaseTest;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.text;

public class LoginTests extends BaseTest {          //LoginTests está herdando as propriedades de BaseTest

    // Definindo a massa de Teste
    @DataProvider(name = "login-alerts")
    public Object[][] loginProvider() {
        return new Object[][]{ //Array com quartro linhas
                {"papito@ninjaplus.com", "abc123", "Usuário e/ou senha inválidos"},
                {"404@ninjaplus.com", "abc123", "Usuário e/ou senha inválidos"},
                {"", "abc123", "Opps. Cadê o email?"},
                {"papito@ninjaplus.com", "", "Opps. Cadê a senha?"}
        };
    }

    @Test
    public void shouldSeeLoggedUser() {
        login
                .open() // Abrindo a pagina
                .with("papito@ninjaplus.com", "pwd123");

        side.loggedUser().shouldHave(text("Papito")); // Verificação da pessoa que está logada
    }

    // Padrão DDT (Data Driven Testing) Teste orientado a dados
    @Test(dataProvider = "login-alerts") //Chamando minha massa de dados
    public void shouldSeeLoginAlerts(String email, String pass, String expectAlert) {

        login
                .open() // Abrindo a pagina
                .with(email, pass)
                .alert().shouldHave(text(expectAlert));

    }

    @AfterMethod
    public void cleanup() {
        login.clearSession();
    }
}