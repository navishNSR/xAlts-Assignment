package xAltsAutomation.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import xAltsAutomation.config.DriverManager;
import xAltsAutomation.utilities.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class PageActions {

    CommonMethods commonMethods;
    WebDriver driver;

    public PageActions() {
        commonMethods = new CommonMethods();
        driver = DriverManager.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Get Started']")
    private WebElement getStartedButton;

    @FindBy(xpath = "//label[text()='E-Mail']//following-sibling::div/input")
    private WebElement inputEmail;

    @FindBy(xpath = "//label[text()='Password']//following-sibling::div/input")
    private WebElement inputPassword;

    @FindBy(xpath = "//label[text()='Confirm Password']//following-sibling::div/input")
    private WebElement inputConfirmPassword;

    @FindBy(xpath = "//label[text()='Password']//following-sibling::p")
    private WebElement textPasswordFormat;

    @FindBy(xpath = "//button[text()='Sign Up']")
    private WebElement buttonSignUp;

    @FindBy(xpath = "//button[text()='Sign In']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//button[text()='Already have an account? Click here to sign in.']")
    private WebElement linkTextAlreadyHaveAnAccount;

    @FindBy(xpath = "//p[text()='Passwords do not match']")
    private WebElement textPasswordMatch;

    @FindBy(xpath = "//h2[text()='Onboard OCN Node']")
    private WebElement onboardOCNNode;

    @FindBy(xpath = "//label[text()='Node ID']//following-sibling::div/input")
    private WebElement inputNodeId;

    @FindBy(xpath = "//label[text()='Public IP']//following-sibling::div/input")
    private WebElement inputPublicIP;

    @FindBy(xpath = "//button[text()='+ Add Node ']")
    private WebElement buttonAddNode;

    @FindBy(xpath = "//div[text()='Preview']//following-sibling::div/div[contains(@class, 'MuiDataGrid-main')]/div[2]//div[contains(@class, 'MuiDataGrid-row')]/div[2]")
    private List<WebElement> addedNodes;

    @FindBy(xpath = "//button[text()='Next']")
    private WebElement buttonNext;

    @FindBy(xpath = "//label[text()='Wallet Address']//following-sibling::div/input")
    private WebElement inputWalletAddress;

    @FindBy(xpath = "//button[text()=' + Add Wallet ']")
    private WebElement buttonAddWallet;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//div[text()='Preview Node Details']//following-sibling::div/div[contains(@class, 'MuiDataGrid-main')]/div[2]//div[contains(@class, 'MuiDataGrid-row')]/div[1]")
    private List<WebElement> previewNodeDetails;

    @FindBy(xpath = "//div[text()='Preview Wallet Details']//following-sibling::div/div[contains(@class, 'MuiDataGrid-main')]/div[2]//div[contains(@class, 'MuiDataGrid-row')]/div[1]")
    private List<WebElement> previewWalletDetails;

    @FindBy(xpath = "//button[text()='Sign In']")
    private WebElement linkSignIn;

    @FindBy(xpath = "//button[text()='Sign Out']")
    private WebElement linkSignOut;


    public void clickGetStarted() {
        commonMethods.waitUntilElementLoaded(getStartedButton);
        getStartedButton.click();
    }

    public String enterEmail(String emailId) {
        inputEmail.sendKeys(emailId);
        return emailId;
    }

    public String enterPassword(String password) {
        inputPassword.sendKeys(password);
        return password;
    }

    public String enterConfirmPassword(String password) {
        inputConfirmPassword.sendKeys(password);
        return password;
    }

    public void checkErrorForEmail() {
        String className = inputEmail.getDomAttribute("class");
        assert className != null;
        if (className.contains("Mui-error")) {
            System.out.println("Invalid Email");
        } else {
            System.out.println("Valid Email");
        }
    }

    public void checkErrorForPassword() {
        String className = inputPassword.getDomAttribute("class");
        assert className != null;
        if (className.contains("Mui-error")) {
            System.out.println("Invalid Password");
        } else {
            System.out.println("Valid Password");
        }
    }

    public void checkPasswordCondition() {
        if (textPasswordFormat.isDisplayed()) {
            System.out.println("Password condition is not matching");
        }
        System.out.println("Password Conditions Fulfilled");
    }

    public void checkErrorForConfirmPassword() {
        String className = inputConfirmPassword.getDomAttribute("class");
        assert className != null;
        if (className.contains("Mui-error")) {
            System.out.println("Invalid Password");
        }
        System.out.println("Valid Password");
    }

    public void checkConfirmPasswordMatch() {
        if (textPasswordMatch.isDisplayed()) {
            System.out.println("Password and Confirm Password is same");
        } else {
            System.out.println("Password and Confirm Password is not same");
        }
    }

    public void clickSignUpButton() {
        buttonSignUp.click();
    }

    public void clickSignInButton() {
        buttonSignIn.click();
    }

    public void checkAlreadyRegisteredEmail() {
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
        } catch (NoAlertPresentException e) {
            System.out.println("New Email - Sign Up in Progress");
        }
    }

    public void checkPasswordError() {
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
        } catch (NoAlertPresentException e) {
            System.out.println("Correct Password");
        }
    }

    public Boolean isSignUpButtonDisabled() {
        return buttonSignUp.getDomAttribute("disabled") == null;
    }

    public Boolean isSignInButtonDisabled() {
        return buttonSignIn.getDomAttribute("disabled") == null;
    }

    public void clickAlreadyHaveAccount() {
        linkTextAlreadyHaveAnAccount.click();
    }

    public void navigateToOnboardOCNNode() {
        onboardOCNNode.click();
    }

    public String enterNodeId(String nodeId) {
        inputNodeId.sendKeys(nodeId);
        return nodeId;
    }

    public String enterPublicIP(String publicIP) {
        inputNodeId.sendKeys(publicIP);
        return publicIP;
    }

    public void checkErrorForNodeId() {
        String className = inputNodeId.getDomAttribute("class");
        assert className != null;
        if (className.contains("Mui-error")) {
            System.out.println("Invalid Node Id");
        } else {
            System.out.println("Valid Node Id");
        }
    }

    public void checkErrorForPublicIP() {
        String className = inputPublicIP.getDomAttribute("class");
        assert className != null;
        if (className.contains("Mui-error")) {
            System.out.println("Invalid Public IP");
        } else {
            System.out.println("Valid Public IP");
        }
    }

    public void clickAddNode() {
        if (buttonAddNode.getDomAttribute("disabled") == null) {
            buttonAddNode.click();
        } else {
            System.out.println("Enter Valid Node ID and Public IP");
        }
    }

    public List<String> getAllAddedNodes() {
        List<String> nodes = new ArrayList<>();
        for (WebElement e : addedNodes) {
            nodes.add(e.getText());
        }
        return nodes;
    }

    public void clickButtonNext() {
        buttonNext.click();
    }

    public String enterWalletAddress(String walletAdd) {
        inputWalletAddress.sendKeys(walletAdd);
        return walletAdd;
    }

    public void checkErrorForWalletAddress() {
        String className = inputWalletAddress.getDomAttribute("class");
        assert className != null;
        if (className.contains("Mui-error")) {
            System.out.println("Invalid Wallet Address");
        } else {
            System.out.println("Valid Wallet Address");
        }
    }

    public void clickAddWallet() {
        if (buttonAddWallet.getDomAttribute("disabled") == null) {
            buttonAddWallet.click();
        } else {
            System.out.println("Enter Valid Wallet Address");
        }
    }

    public List<String> getAllAddedWalletAddress() {
        List<String> address = new ArrayList<>();
        for (WebElement e : addedNodes) {
            address.add(e.getText());
        }
        return address;
    }

    public void clickButtonSubmit() {
        buttonSubmit.click();
    }

    public List<String> getAllNodesOnPreviewPage() {
        List<String> nodes = new ArrayList<>();
        for (WebElement e : previewNodeDetails) {
            nodes.add(e.getText());
        }
        return nodes;
    }

    public List<String> getAllWalletAddressOnPreviewPage() {
        List<String> address = new ArrayList<>();
        for (WebElement e : previewWalletDetails) {
            address.add(e.getText());
        }
        return address;
    }

    public void clickSignOut() {
        linkSignOut.click();
    }

    public void verifySignedOut() {
        if (getStartedButton.isDisplayed() && linkSignIn.isDisplayed()) {
            System.out.println("Successfully Signed Out");
        } else {
            System.out.println("Not Signed Out yet");
        }
    }



}

