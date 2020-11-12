package pages;

import com.codeborne.selenide.SelenideElement;
import models.MovieModel;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MoviePage {
    public MoviePage add(){
        $(".movie-add").click();
        return this;
    }

    public MoviePage create(MovieModel movie) {
        $("input[name=title").setValue(movie.title);
        this.selectStatus(movie.status);  //Chamando um objeto da propria classe
        $("input[name=year").setValue(movie.year.toString()); // toString utilizado para converter inteiro para string
        $("input[name=release_date").setValue(movie.releaseDate);
        this.inputCast(movie.cast);
        $("textarea[name=overview").setValue(movie.plot);

            return this;
    }

    private void inputCast(List<String> cast){
        SelenideElement element = $(".cast"); // Passando o valor do cast para o element

        for (String actor: cast) {
            element.setValue(actor);
            element.sendKeys(Keys.TAB); // Eviando o compando para precinar o TAB
        }
    }
    private void selectStatus(String status){
        $("input[placeholder=Status]").click(); //Buscando o elemento do tipo placeholder
        $$("ul li span").findBy(text(status)).click(); // $$ Busca mais de um elemento e findBy para selecionar um entre esses elementos
    }
}
