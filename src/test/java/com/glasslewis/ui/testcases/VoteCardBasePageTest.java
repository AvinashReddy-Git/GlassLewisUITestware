package com.glasslewis.ui.testcases;

import static com.glasslewis.ui.constants.Constants.SERVER_URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.glasslewis.ui.base.TestBase;
import com.glasslewis.ui.pages.VoteCardPage;
import com.glasslewis.ui.pages.WDLandingPage;

public class VoteCardBasePageTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(VoteCardBasePageTest.class);
    private WDLandingPage landingPage;
    private VoteCardPage voteCardPage;

    @BeforeMethod
    @Parameters("BrowserType")
    public void setUp(final String browserType) {
        logger.info("In setUp method");
        initialization(SERVER_URL, browserType);
        landingPage = new WDLandingPage(getDriver());
    }

    @Test(description = "Verify country filter functionality")
    public void countryFilterTest() {

        voteCardPage = landingPage.navigateToVoteCardPage();
        Assert.assertEquals(voteCardPage.getText().trim(), "Activision Blizzard Inc", "Banner not matching");

    }

    @AfterMethod
    public void tearDown() {
        cleanUp();
    }
}
