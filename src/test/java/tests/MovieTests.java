package tests;

import common.BaseTest;
import models.MovieModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.readonly;
import static com.codeborne.selenide.Condition.text;

public class MovieTests extends BaseTest {      //MovieTests está herdando as propriedades de BaseTest


    @BeforeMethod
    public void setup(){
        login
                .open() // Abrindo a pagina
                .with("papito@ninjaplus.com", "pwd123");

        side.loggedUser().shouldHave(text("Papito")); // Verificação da pessoa que está logada
    }

    @Test
    public void shouldRegisterANewMovie() {

        MovieModel movieData = new MovieModel(
                "Jumanji - Proxima fase",
                "Pré-venda",
                2020,
                "16/01/2020",
                Arrays.asList("The Rock", "Jack Black", "Karen Gillan", "Danny DeVito"),
                "Tentando a revisitar o mundo de Jumanji, Spencer decide"
                        + "consertar o bug do game que permite que sejam transportados ao local");

        movie.add().create(movieData);
    }
}