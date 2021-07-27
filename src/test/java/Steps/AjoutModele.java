package Steps;

import Pages.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.TestNGAntTask;

import java.util.HashMap;
import java.util.Map;


public class AjoutModele {
    WebDriver driver;
    public String myModelName;

    public WebDriver getDriver() {
        return driver;
    }


    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() {
        System.out.println("Navigate login page");
        try {
            //for linux
            System.setProperty("webdriver.chrome.driver","chromedriver");


            Map<String, Object> prefs = new HashMap<String, Object>();

            //To Turns off multiple download warning
            prefs.put("profile.default_content_setting_values.automatic_downloads", 1);

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);

            driver.manage().window().maximize();

            driver.navigate().to("https://aezan.genedoc.fr/Login");
        } catch (Exception e) {
            System.out.println("ChromeDriver for Windows");
        }

        try {

            //for windows
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");


            Map<String, Object> prefs = new HashMap<String, Object>();

            //To Turns off multiple download warning
            prefs.put("profile.default_content_setting_values.automatic_downloads", 1);

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);

            driver.manage().window().maximize();

            driver.navigate().to("https://aezan.genedoc.fr/Login");
        } catch (Exception e) {
            System.out.println("ChromeDriver for Linux");
        }

    }

    @And("I click login button")
    public void iClickLoginButton() {

        LoginPage page = new LoginPage(driver);

        page.ClickLogin();
    }


    @And("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterUsernameAndPassword(String username, String password) throws InterruptedException {
        LoginPage page = new LoginPage(driver);
        page.Login(username, password);
        Thread.sleep(2000);
    }

    @Then("I navigate to the model page")
    public void iNavigateToTheModelPage() throws InterruptedException {
        driver.navigate().to("https://aezan.genedoc.fr/AdminDoc/Models");

        WelcomePage page = new WelcomePage(driver);
        //page.goToAdministration();
        //page.goToModel();
        Thread.sleep(2000);

    }

    @Then("I add new model")
    public void iAddNewModel() throws InterruptedException {
        ModelsPage page= new ModelsPage(driver);
        page.addNewModel(driver);
        myModelName=page.createModel(driver);
        
    }

    @Then("I navigate to projects page and I select COVID page")
    public void iNavigateToProjectsPageAndISelectCOVIDPage() throws InterruptedException {
        ModelsPage page= new ModelsPage(driver);
        driver.navigate().to("https://aezan.genedoc.fr/AdminDoc/Projects");
        ProjectsPage page1 = new ProjectsPage(driver);
        page1.selectCovidProject();


    }

    @Then("I associate the model to the project")
    public void iAssociateTheModelToTheProject() throws InterruptedException {
        ProjectsPage page = new ProjectsPage(driver);
        page.addModelToProject();
    }

    @Then("I detach the model from the project")
    public void iDetachTheModelFromTheProject() throws InterruptedException {
        ProjectsPage page = new ProjectsPage(driver);
        page.detachModel();

    }

    @Then("I delete the model added")
    public void iDeleteTheModelAdded() throws InterruptedException {
        driver.navigate().to("https://aezan.genedoc.fr/AdminDoc/Models");
        ModelsPage page= new ModelsPage(driver);
        page.deleteModel(myModelName);
    }


    @Then("I close the browser")
    public void iCloseTheBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        driver = null;
    }


}

