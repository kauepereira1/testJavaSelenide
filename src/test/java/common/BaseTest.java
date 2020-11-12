package common;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.MoviePage;
import pages.SideBar;

public class BaseTest {
    protected static LoginPage login; // Chamando a Classe LoginPage
    protected static SideBar side; // Chamando a Classe SideBar
    protected static MoviePage movie;

    @BeforeMethod              // Antes de executar qualquer teste irá executar o Before
    public void start() {
        Configuration.browser = "chrome"; // Configurando qual é o browser
        Configuration.baseUrl = "http://ninjaplus-web:5000"; // Configurando a url

        login = new LoginPage();  // Instanciando a classe LoginPage
        side = new SideBar(); // Instanciando a classe SideBar
        movie = new MoviePage();
    }
}
