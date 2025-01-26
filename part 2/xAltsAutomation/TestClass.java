package ui;

import org.testng.Assert;
import org.testng.annotations.*;
import org2.ui.config.DriverManager;
import xAltsAutomation.page.PageActions;

import java.time.Duration;
import java.util.List;

public class TestClass {

    @BeforeMethod
    public void setPrerequisite() {
        DriverManager.getInstance().initialiseDriver("chrome", "head");
        DriverManager.driver.manage().window().maximize();
        DriverManager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        DriverManager.driver.get("https://xaltsocnportal.web.app/");
    }

    @Test(groups = "Positive")
    public void testValidInputFieldsFormat() {
        PageActions pageActions = new PageActions();
        pageActions.clickGetStarted();
        pageActions.enterEmail("abc@gmail.com");
        pageActions.checkErrorForEmail();
        pageActions.enterPassword("Hello123@");
        pageActions.checkErrorForPassword();
        pageActions.checkPasswordCondition();
        pageActions.enterConfirmPassword("Hello123@");
        pageActions.checkErrorForConfirmPassword();
        pageActions.checkConfirmPasswordMatch();
    }

    @Test(groups = "Negative")
    public void testInvalidInputFieldsFormat() {
        PageActions pageActions = new PageActions();
        pageActions.clickGetStarted();
        pageActions.enterEmail("abcd");
        pageActions.checkErrorForEmail();
        pageActions.enterPassword("1234");
        pageActions.checkErrorForPassword();
        pageActions.checkPasswordCondition();
        pageActions.enterConfirmPassword("1234");
        pageActions.checkErrorForConfirmPassword();
        pageActions.checkConfirmPasswordMatch();
    }

    @Test(groups = "Positive")
    public void testSuccessfulSignUp() {
        PageActions pageActions = new PageActions();
        pageActions.clickGetStarted();
        pageActions.enterEmail("abc@gmail.com");
        pageActions.enterPassword("Hello123@");
        pageActions.enterConfirmPassword("Hello123@");
        pageActions.clickSignUpButton();
    }

    @Test(groups = "Positive")
    public void testAlreadyRegisteredEmail() {
        PageActions pageActions = new PageActions();
        pageActions.clickGetStarted();
        pageActions.enterEmail("abc@gmail.com");
        pageActions.enterPassword("Hello123@");
        pageActions.enterConfirmPassword("Hello123@");
        pageActions.clickSignUpButton();
        pageActions.checkAlreadyRegisteredEmail();
    }

    @Test(groups = "Positive")
    public void testSuccessfulSignIn() {
        PageActions pageActions = new PageActions();
        pageActions.clickGetStarted();
        pageActions.clickAlreadyHaveAccount();
        pageActions.enterEmail("abc@gmail.com");
        pageActions.enterPassword("Hello123@");
        pageActions.clickSignInButton();
    }

    @Test(groups = "Negative")
    public void testUnsuccessfulSignIn() {
        PageActions pageActions = new PageActions();
        pageActions.clickGetStarted();
        pageActions.clickAlreadyHaveAccount();
        pageActions.enterEmail("abc@gmail.com");
        String wrongPassword = "Hello123@";
        pageActions.enterPassword(wrongPassword);
        pageActions.clickSignInButton();
        pageActions.checkPasswordError();
    }

    @Test(groups = "Positive")
    public void testAddNodeSuccessfully() {
        PageActions pageActions = new PageActions();
        pageActions.clickGetStarted();
        pageActions.clickAlreadyHaveAccount();
        pageActions.enterEmail("abc@gmail.com");
        pageActions.enterPassword("Hello123@");
        pageActions.clickSignInButton();
        pageActions.navigateToOnboardOCNNode();
        List<String> nodes = List.of("NodeID-1234");
        List<String> ips = List.of("225.0.0.1");
        for (int i=0; i<nodes.size(); i++) {
            pageActions.enterNodeId(nodes.get(i));
            pageActions.checkErrorForNodeId();
            pageActions.enterPublicIP(ips.get(i));
            pageActions.checkErrorForPublicIP();
            pageActions.clickAddNode();
        }
        List<String> addedNodes = pageActions.getAllAddedNodes();
        Assert.assertEquals(nodes, addedNodes);
        pageActions.clickButtonNext();
        List<String> addresses = List.of("0x88fa61d2faA13aad8Fbd5B030372B4A159BbbDFb");
        for (String ad : addresses) {
            pageActions.enterWalletAddress(ad);
            pageActions.checkErrorForWalletAddress();
            pageActions.clickAddWallet();
        }
        List<String> addedAddresses = pageActions.getAllAddedWalletAddress();
        Assert.assertEquals(addresses, addedAddresses);
        pageActions.clickButtonNext();
        List<String> nodesOnPreviewPage = pageActions.getAllNodesOnPreviewPage();
        List<String> addressesOnPreviewPage = pageActions.getAllWalletAddressOnPreviewPage();
        Assert.assertEquals(nodes, nodesOnPreviewPage);
        Assert.assertEquals(addresses, addressesOnPreviewPage);
        pageActions.clickButtonSubmit();
    }

    @Test(groups = "Positive")
    public void testSignOut() {
        PageActions pageActions = new PageActions();
        pageActions.clickGetStarted();
        pageActions.clickAlreadyHaveAccount();
        pageActions.enterEmail("abc@gmail.com");
        pageActions.enterPassword("Hello123@");
        pageActions.clickSignInButton();
        pageActions.navigateToOnboardOCNNode();
        pageActions.clickSignOut();
        pageActions.verifySignedOut();
    }

    @AfterMethod
    public void endExecution() {
        DriverManager.getInstance().quitDriver();
    }
}
