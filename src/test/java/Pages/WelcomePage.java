package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
    @FindBy(how = How.LINK_TEXT, using="Administration")
    public WebElement btnAdministration;

    @FindBy(how = How.XPATH, using = "/html/body/header/div[3]/ul/li[3]/ul/li[2]")
    public WebElement btnModel;

    public WelcomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);

    }

    public void goToAdministration(){
        btnAdministration.click();
    }

    public void goToModel(){
        btnAdministration.click();
        btnModel.click();
    }


}
