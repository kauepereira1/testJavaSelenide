package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    public LoginPage open(){        //Metodo que abre a pagina
        Selenide.open("/login");
        return this;
    }
    public LoginPage with(String email, String pass) {
        $("input[name=email").setValue(email);  //Buscando Elemento e passando o valor para o mesmo
        $("input[type=password").setValue(pass);
        $(byText("Entrar")).click(); // Clicando no botão entrar pelo nome do mesmo
        return this;
    }

    public SelenideElement alert(){    // Metodo que retonar um elemento
        return $(".alert span");
    }

    public void clearSession() {
        executeJavaScript("localStorage.clear();"); // Limpando a seção/token com o comando em JavaScript
    }
}
