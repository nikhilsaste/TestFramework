package pointsbet.com.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pointsbet.com.restapi.MessageModule;
import pointsbet.com.restapi.RestModule;

import java.util.HashMap;

public class TC003_AuthTokenAPI_SuccessCode_200 {

    RestModule restModule = new RestModule();
    MessageModule messageModule = new MessageModule();
    private Logger logger = LogManager.getLogger(TC003_AuthTokenAPI_SuccessCode_200.class);

    @Test
    public void TestSignUpPage(){

        try {

            String response = restModule.postResponseWithHeaderAuthToken(messageModule.getTokenAPIEndPoint(), 200, messageModule.getAuthTokenAPIHeaders(),messageModule.getAuthTOkenAPIPayLoad());
            logger.info("Success code 200 received for endpoint: "+messageModule.getTokenAPIEndPoint());
            logger.info("API Response is: "+response);

            HashMap<String, String> arrayList = messageModule.getJsonKeyValue(response);
            System.setProperty("AccessToken",messageModule.retrieveTokenFromAuthAPIResponse(arrayList));
            logger.info("Token retrieved successfully from Auth API response");

        }catch (Exception e){
            logger.error("Error occured due to: "+e.getMessage());
            Assert.fail("Error occured due to: "+e.getMessage());
        }
    }

}