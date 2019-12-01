package pointsbet.com.restapi;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import java.util.Map;
import static io.restassured.RestAssured.given;


public class RestModule {

    /**
     * @return
     */
    public Cookie getCookie() {

        Cookie myCookie = new Cookie.Builder("ft_cookie", "Y2U2ZjQ5NGE2NWMyNGE4MGIxODQwMjUxZWUzZTUzYjg=")
                .build();
        return myCookie;
    }

    /**
     * @param endPoint
     * @param statusCode
     * @param body
     * @return
     * @throws Exception
     */
    public String postResponseWithCookie(String endPoint, int statusCode, String body) throws Exception {

        return given().cookie(getCookie()).
                contentType(ContentType.JSON).
                when().
                body(body).
                post(endPoint).
                then().
                assertThat().statusCode(statusCode).extract().response().asString();
    }

    /**
     * @param endPoint
     * @param statusCode
     * @return
     * @throws Exception
     */
    public String getResponseWithCookie(String endPoint, int statusCode) throws Exception {

        return given().cookie(getCookie()).
                contentType(ContentType.JSON).
                when().
                get(endPoint).
                then().
                assertThat().statusCode(statusCode).extract().response().asString();
    }

    /**
     * @param endPoint
     * @param statusCode
     * @param
     * @return
     * @throws Exception
     */
    public String postResponseWithHeaderAuthToken(String endPoint, int statusCode, Map<String, String> map, String body) throws Exception {

        return  given()
               .headers(map)
               .when()
               .body(body)
               .post(endPoint)
               .then()
               .assertThat().statusCode(statusCode).extract().response().asString();
    }

    /**
     * @param endPoint
     * @param statusCode
     * @param token
     * @return
     * @throws Exception
     */
    public String getResponseWithHeader(String endPoint, int statusCode, String token) throws Exception {

        return given().
                header("authorization", token).
                contentType(ContentType.JSON).
                when().
                get(endPoint).
                then().
                assertThat().statusCode(statusCode).extract().response().asString();
    }

    /**
     * @param endPoint
     * @param statusCode
     * @param token
     * @param body
     * @return
     * @throws Exception
     */
    public String postResponseWithHeader(String endPoint, int statusCode, String token, String body) throws Exception {

        return given().
                header("authorization", token).
                contentType(ContentType.JSON).
                when().
                body(body).
                post(endPoint).
                then().
                assertThat().statusCode(statusCode).extract().response().asString();
    }

}
