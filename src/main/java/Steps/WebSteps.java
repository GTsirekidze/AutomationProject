package Steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    public static void webPageTest(String username, Object password) {
        $x("//*[@id='userName']").sendKeys(username);
        $x("//*[@id='password']").sendKeys((CharSequence) password);
        $x("//*[@id='login']").click();

        $x("//*[@id='userName-value']").shouldHave(Condition.text(username));

        $x("//*[@id='gotoStore']").click();
        $x("//span[starts-with(@id, 'see-book-You')]").$("a").click();

        $x("//*[@id='addNewRecordButton']").click();


        $("#item-3").$x("/span[starts-with(text(), 'Profile')]").click();

        $x("//span[starts-with(@id, 'see-book-You')]").$("a").shouldHave(Condition.text("You Don't Know JS"));

        $x("//*[@id=\"submit\"]").click();

    }
}

