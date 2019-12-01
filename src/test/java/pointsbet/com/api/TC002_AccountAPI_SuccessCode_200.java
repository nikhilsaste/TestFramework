package pointsbet.com.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pointsbet.com.restapi.MessageModule;
import pointsbet.com.restapi.RestModule;

public class TC002_AccountAPI_SuccessCode_200  {

    RestModule restModule = new RestModule();
    MessageModule messageModule = new MessageModule();
    private Logger logger = LogManager.getLogger(TC002_AccountAPI_SuccessCode_200.class);

    @Test
    public void TestPointsbetAPI(){

        try {

        String response = restModule.postResponseWithCookie(messageModule.getAccountAPIEndPoint(), 200, messageModule.getAccountAPIPayLoad());
            logger.info("Success code 200 received for endpoint: "+messageModule.getAccountAPIEndPoint());
            logger.info("API Response is: "+response);


        }catch (Exception e){
            logger.error("Error occured due to: "+e.getMessage());
            Assert.fail("Error occured due to: "+e.getMessage());
        }
    }

}