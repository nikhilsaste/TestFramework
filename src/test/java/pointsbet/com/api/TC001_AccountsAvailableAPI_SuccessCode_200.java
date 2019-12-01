package pointsbet.com.api;

import org.testng.Assert;
import org.testng.annotations.Test;
import pointsbet.com.restapi.MessageModule;
import pointsbet.com.restapi.RestModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TC001_AccountsAvailableAPI_SuccessCode_200 {

    RestModule restModule = new RestModule();
    MessageModule messageModule = new MessageModule();
    private Logger logger = LogManager.getLogger(TC001_AccountsAvailableAPI_SuccessCode_200.class);

    @Test
    public void TestPointsbetAPI(){

        try {

            String response = restModule.getResponseWithCookie(messageModule.getAccountsAvailableAPIEndPoint("testUserName"),200);
            logger.info("Success code 200 received for endpoint: "+messageModule.getAccountsAvailableAPIEndPoint("testUserName"));
            logger.info("API Response is: "+response);


        }catch (Exception e){
            logger.error("Error occured due to: "+e.getMessage());
            Assert.fail("Error occured due to: "+e.getMessage());
        }
    }

}
