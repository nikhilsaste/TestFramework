package pointsbet.com.restapi;


import org.json.JSONObject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MessageModule {

    /**
     *
     * @param userName
     * @return
     * @throws Exception
     */
    public String getAccountsAvailableAPIEndPoint (String userName) throws Exception{

        return "https://api-uat.pointsbet.com/api/v2/accounts/users/"+userName+"/available";
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public String getAccountAPIEndPoint () throws Exception{

        return "https://user.test.pointsbet.com.au/asl/api/account";
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public String getAccountAPIPayLoad () throws Exception {

        return "{\"title\":\"Mr\",\"firstName\":\"test\",\"lastName\":\"new\",\"DOB\":\"1996/01/01\",\"contactNumber\":\"0400000000\",\"email\":\"test.new@gmail.com\",\"username\":\"testnew\",\"password\":\"Password1\",\"confirmPassword\":\"Password1\",\"addressLine1\":\"700 Bourke St\",\"addressLine2\":\"\",\"addressSuburb\":\"Adamstown\",\"addressPostCode\":\"2289\",\"addressState\":\"New South Wales\",\"addressCountry\":\"Australia\",\"termsAccepted\":true,\"promotionCode\":\"WELCOME\",\"campaignTrackingInfo\":\"\",\"ssn\":\"\",\"mfaMode\":null,\"termsConditionsTime\":\"\"}";

    }

    /**
     *
     * @return
     * @throws Exception
     */
    public String getTokenAPIEndPoint () throws Exception{

        return "https://auth-ut.pointsbet.com/token";
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public Map<java.lang.String, java.lang.String> getAuthTokenAPIHeaders () throws Exception{

        java.util.Map<java.lang.String, java.lang.String> map = new HashMap<>();
        map.put("Content-Type", "application/x-www-form-urlencoded");
        map.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        map.put("Cookie", "__cfduid=d9075aff93730a73bda1ce7540d983bfe1574074282");

        return map;
    }

    public String getAuthTOkenAPIPayLoad () throws Exception {

        return "username=userName&password=Welcome123&client_id=578fea8f9950488e9a2a585e834bf03a&sms=&grant_type=password";
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public String getSummaryAPIEndPoint () throws Exception{

        return "https://api-uat.pointsbet.com/api/v2/accounts/user/summary";
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public String getDepositPaymentAPIEndPoint () throws Exception{

        return "https://user.test.pointsbet.com.au/asl/api/payments/deposit/begin";
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public String getDepositPaymentAPIPayLoad () throws Exception {

        return "{\"maskedCard\":\"411111...111\",\"amount\":5,\"cardExpiryMonth\":\"01\",\"cardExpiryYear\":2022,\"gatewayType\":\"bpoint\",\"promoCode\":null}";

    }

    /**
     *
     * @param response
     * @return
     */
    public LinkedHashMap <String, String> getJsonKeyValue (String response) throws Exception{

        JSONObject jsonobject = new JSONObject(response);
        LinkedHashMap <String, String> map = new LinkedHashMap<>();

        for (String key: jsonobject.keySet()){
            map.put(key.toUpperCase(),jsonobject.get(key).toString());
        }

        return map;
    }

    /**
     *
     * @param arrayList
     * @return
     * @throws Exception
     */
    public String retrieveTokenFromAuthAPIResponse (HashMap<String, String> arrayList) throws  Exception{

        for (String i:arrayList.keySet()){

            if (i.contains("ACCESS_TOKEN")){

                return arrayList.get(i);
            }

        }

        return "";
    }
}
