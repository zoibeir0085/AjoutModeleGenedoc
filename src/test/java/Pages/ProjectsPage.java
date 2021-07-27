package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProjectsPage {

    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[1]/div/div/div[2]")
    public WebElement projectCOVID;

    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[3]/form/table/tbody/tr[3]/td/button[4]")
    public WebElement projectModels;

    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[5]/div/button[1]")
    public WebElement btnAttachModel;

    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[4]/div[2]/div/table/tbody/tr[2]/td[5]/input")
    public WebElement attachModelAdded;

    @FindBy(how = How.XPATH, using = "/html/body/div[5]/div[2]/div/div/div/div/div/div/div/div[4]/button[1]")
    public WebElement btnConfirmAttachModel;

    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/table/tbody/tr[1]/td[5]/input")
    public WebElement btnDetachModel;

    @FindBy(how = How.XPATH, using = "/html/body/div[5]/div[2]/div/div/div/div/div/div/div/div[4]/button[1]")
    public WebElement btnConfirmDetachModel;

    @FindBy(how = How.LINK_TEXT, using="Administration")
    public WebElement btnAdministration;

    @FindBy(how = How.XPATH, using = "/html/body/header/div[3]/ul/li[3]/ul/li[2]")
    public WebElement btnModel;


    public ProjectsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void selectCovidProject() throws InterruptedException {
        Thread.sleep(2000);
        projectCOVID.click();
        Thread.sleep(1000);
    }

    public void addModelToProject() throws InterruptedException {
        Thread.sleep(1000);
        projectModels.click();
        Thread.sleep(1000);
        btnAttachModel.click();
        Thread.sleep(7000);
        attachModelAdded.click();
        Thread.sleep(2000);
        btnConfirmAttachModel.click();
        Thread.sleep(5000);

    }

    public void detachModel() throws InterruptedException {
        btnDetachModel.click();
        Thread.sleep(2000);
        btnConfirmDetachModel.click();
        Thread.sleep(2000);

    }

    public void goToModel(){
        btnAdministration.click();
        btnModel.click();
    }

}
