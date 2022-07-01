import Results.TokenResults;
import Steps.CreateUserSteps;
import Steps.WebSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class Tests {
    @Test
    public void Test() throws InterruptedException {
        String username = "rustaveli";
        Object password = "pass123#";

        Assert.assertEquals(CreateUserSteps.createAccount(username,password).books.length, 0);

        TokenResults response = CreateUserSteps.tokenGeneration(username,password);
        Assert.assertEquals(response.status, "Success");
        Assert.assertEquals(response.result, "User authorized successfully.");

        Assert.assertTrue(CreateUserSteps.checkAuthorization(username,password));

        open("https://demoqa.com/login");

        WebSteps.webPageTest(username,password);
    }
}


