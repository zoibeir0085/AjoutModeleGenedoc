package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class ModelsPage {
    /*@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div[2]/div/button")
    public WebElement btnNewModel;*/
	/*@FindBy(how = How.ID, using = "newModel")
    public WebElement btnNewModel;*/
    

    /*@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div[3]/form/table/tbody/tr[1]/td[2]/input")
    public WebElement modelName;*/
    @FindBy(how = How.ID, using = "modelName-0")
    public WebElement modelName;

    /*@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div[3]/form/table/tbody/tr[1]/td[3]/input")
    public WebElement modelVersion;*/
    @FindBy(how = How.ID, using = "modelVersion-0")
    public WebElement modelVersion;

    //@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[14]/form/table/tbody/tr[1]/td[5]/div/button")
    public WebElement btnTemplate;
    
    
    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[14]/form/table/tbody/tr[1]/td[5]/div/select")
    public WebElement selectTemplate;
    
    //@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[14]/form/table/tbody/tr[3]/td/button[1]")
    public WebElement btnSaveModel;

    //@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[14]/form/table/tbody/tr[1]/td[7]/input")
    public WebElement checkActivateModel;
    
    //@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[14]/form/table/tbody/tr[1]/td[8]/input")
    public WebElement checkMovedDown;
    
    //@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[14]/form/table/tbody/tr[1]/td[9]/input")
    public WebElement checkAddOnNested;
    
    //@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[14]/form/table/tbody/tr[1]/td[10]/input")
    public WebElement checkDuplicateOnNested;
    
    //@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[14]/form/table/tbody/tr[1]/td[6]/textarea")
    public WebElement description;

    @FindBy(how = How.LINK_TEXT, using="Administration")
    public WebElement btnAdministration;

    @FindBy(how = How.XPATH, using = "/html/body/header/div[3]/ul/li[3]/ul/li[1]")
    public WebElement btnProjects;

    //@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div[1]/table/tbody/tr[10]/td[5]/table/tbody/tr/td[8]/input")
    public WebElement btnDeleteModel;

    //@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[2]/div/div/div/div/div/div/div/div[4]/button[1]")
    public WebElement btnConfirmDeleteModel;
    
    
    public String myModelName;
    public WebDriver _Currentdriver;

    public ModelsPage(WebDriver driver) 
    {
        PageFactory.initElements(driver,this);
        
        _Currentdriver=driver;
    }
    public void addNewModel(WebDriver driver){
    	WebElement btnNewModel= driver.findElement(By.cssSelector("button[id='newModel']"));
        btnNewModel.click();
    }

    public void SelectDocument(WebDriver driver,String document){
        Select SelectedDoc=new Select(driver.findElement(By.id("template-0"))) ;
        SelectedDoc.selectByVisibleText(document);
    }
    
    public void SetmyModelName() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 30) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        myModelName= "AAAAAA"+saltStr;

    }
    public String GetmyModelName() {
       
        return myModelName;

    }
    
    public String createModel(WebDriver driver) throws InterruptedException {
    	
    	
        Thread.sleep(1000);
        
        SetmyModelName();
        Thread.sleep(1000);
        
        modelName.sendKeys(GetmyModelName());
        Thread.sleep(1000);
        
        modelVersion.sendKeys("V1");
        Thread.sleep(1000); 
        
        
        btnTemplate = driver.findElement(By.id("modelFrm_0")).findElement(By.xpath("form/table/tbody/tr[1]/td[5]/div/button"));
        
        btnTemplate.click();
        Thread.sleep(1000);
        
        this.SelectDocument(driver,"LDM_CAC.docx");
        Thread.sleep(1000);
        
        description = driver.findElement(By.id("modelFrm_0")).findElement(By.xpath("form/table/tbody/tr[1]/td[6]/textarea"));
        
        description.sendKeys("LDM_CAC document type");
        Thread.sleep(1000);
        
        
        checkActivateModel = driver.findElement(By.id("modelFrm_0")).findElement(By.xpath("form/table/tbody/tr[1]/td[7]/input"));
        checkActivateModel.click();
        Thread.sleep(1000);
        
        checkMovedDown = driver.findElement(By.id("modelFrm_0")).findElement(By.xpath("form/table/tbody/tr[1]/td[8]/input"));
        checkMovedDown.click();
        Thread.sleep(1000);
        
        checkAddOnNested = driver.findElement(By.id("modelFrm_0")).findElement(By.xpath("form/table/tbody/tr[1]/td[9]/input"));
        checkAddOnNested.click();
        Thread.sleep(1000);
        
        checkDuplicateOnNested = driver.findElement(By.id("modelFrm_0")).findElement(By.xpath("form/table/tbody/tr[1]/td[10]/input"));
        checkDuplicateOnNested.click();
        Thread.sleep(1000);
        
        btnSaveModel = driver.findElement(By.id("modelFrm_0")).findElement(By.xpath("form/table/tbody/tr[3]/td/button[1]"));
        btnSaveModel.click();
        Thread.sleep(3000);
        
        System.out.println(myModelName);
        
        btnDeleteModel = driver.findElement(By.id(myModelName)).findElement(By.xpath("td[8]/table/tbody/tr/td[9]/input"));
        
        System.out.println(btnDeleteModel);  

        
        return myModelName;
    }

    public void goToProjects() throws InterruptedException {
        Thread.sleep(5000);
        btnAdministration.click();
        Thread.sleep(2000);
        btnProjects.click();
    }

    public void deleteModel(String myModelName) throws InterruptedException {
        Thread.sleep(2000);
        
         System.out.println(myModelName);
        
        btnDeleteModel = _Currentdriver.findElement(By.id(myModelName)).findElement(By.xpath("td[8]/table/tbody/tr/td[9]/input"));
        
        System.out.println(btnDeleteModel); 
               
        
        btnDeleteModel.click();
        Thread.sleep(2000);
        
        btnConfirmDeleteModel = _Currentdriver.findElement(By.className("jconfirm-buttons")).findElement(By.xpath("button[1]"));
        
        btnConfirmDeleteModel.click();
        Thread.sleep(3000);

    }



}
