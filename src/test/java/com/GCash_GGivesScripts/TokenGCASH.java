package com.GCash_GGivesScripts;

import com.Datasheet.GCashAPI_TestData_DataProvider;
import com.utility.LoggingUtils;
import com.utility.Utilities;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class TokenGCASH extends Utilities {

    GCashAPI_TestData_DataProvider dataProvider = new GCashAPI_TestData_DataProvider();
    static LoggingUtils logger = new LoggingUtils();
    @Test
    @Parameters({"APIUrl"})
    public void TokenGCash_200(String url) throws IOException {
        Object[][] data =  dataProvider.GCashapi("Gcashapi_ValidData");
        Response response = TokenGCashAPI(data, url);

        //Response Code Validation
        int reponsecode=response.getStatusCode();
        logger.info("Response Code= "+reponsecode);
        extent.extentLogger("response code", "Response Code= "+reponsecode);
        
//        System.out.println("Response Code= "+reponsecode);
        
        Assert.assertEquals(reponsecode, 200);
        String Token =response.jsonPath().get("token_type");
        Assert.assertEquals(Token, "bearer");

        String access_token =response.jsonPath().get("access_token");
        Assert.assertTrue(access_token !=null);

        int expires_in =response.jsonPath().get("expires_in");
//        System.out.println("expires in Code= "+expires_in);
        
        logger.info("expires in Code= "+expires_in);
        extent.extentLogger("response code", "expires in Code= "+expires_in);
        Assert.assertEquals(expires_in, 7200);
    }

    @Test
    @Parameters({"APIUrl"})
    public void InvalidClientId_TokenGCash(String url) throws IOException {

        Object[][] data =  dataProvider.GCashapi("Gcashapi_InvalidClientId");
        Response response = TokenGCashAPI(data, url);

        //Response Code Validation
        int reponsecode=response.getStatusCode();
//        System.out.println("Response Code= "+reponsecode);
        
        logger.info("Response Code= "+reponsecode);
        extent.extentLogger("response code", "Response Code= "+reponsecode);
        
        Assert.assertEquals(reponsecode, 400);

        String Token =response.jsonPath().get("error");
        Assert.assertEquals(Token, "invalid_client");

        String access_token =response.jsonPath().get("error_description");
        Assert.assertEquals(access_token, "Invalid client authentication");

    }

    @Test
    @Parameters({"APIUrl"})
    public void EmptyClientId_TokenGCash(String url) throws IOException {
        Object[][] data =  dataProvider.GCashapi("Gcashapi_EmptyClientId");
        Response response = TokenGCashAPI(data, url);

        //Response Code Validation
        int reponsecode=response.getStatusCode();
//        System.out.println("Response Code= "+reponsecode);
        
        logger.info("Response Code= "+reponsecode);
        extent.extentLogger("response code", "Response Code= "+reponsecode);
        
        Assert.assertEquals(reponsecode, 400);

        String Token =response.jsonPath().get("error");
        Assert.assertEquals(Token, "invalid_client");

        String access_token =response.jsonPath().get("error_description");
        Assert.assertEquals(access_token, "Invalid client authentication");
    }

    @Test
    @Parameters({"APIUrl"})
    public void EmptyClientSecret_TokenGCash(String url) throws IOException {
        Object[][] data =  dataProvider.GCashapi("Gcashapi_EmptyClientSecret");
        Response response = TokenGCashAPI(data, url);

        //Response Code Validation
        int reponsecode=response.getStatusCode();
//        System.out.println("Response Code= "+reponsecode);
        
        logger.info("Response Code= "+reponsecode);
        extent.extentLogger("response code", "Response Code= "+reponsecode);
        
        Assert.assertEquals(reponsecode, 400);

        String Token =response.jsonPath().get("error");
        Assert.assertEquals(Token, "invalid_client");

        String access_token =response.jsonPath().get("error_description");
        Assert.assertEquals(access_token, "Invalid client authentication");

    }

    @Test
    @Parameters({"APIUrl"})
    public void InvalidClientSecret_TokenGCash(String url) throws IOException {

        Object[][] data =  dataProvider.GCashapi("Gcashapi_InvalidClientSecret");
        Response response = TokenGCashAPI(data, url);

        //Response Code Validation
        int reponsecode=response.getStatusCode();
//        System.out.println("Response Code= "+reponsecode);
        
        logger.info("Response Code= "+reponsecode);
        extent.extentLogger("response code", "Response Code= "+reponsecode);
        
        Assert.assertEquals(reponsecode, 400);

        String Token =response.jsonPath().get("error");
        Assert.assertEquals(Token, "invalid_client");

        String access_token =response.jsonPath().get("error_description");
        Assert.assertEquals(access_token, "Invalid client authentication");

    }

    @Test
    @Parameters({"APIUrl"})
    public void InvalidGrantType_TokenGCash(String url) throws IOException {
        Object[][] data =  dataProvider.GCashapi("Gcashapi_InvalidGrantType");
        Response response = TokenGCashAPI(data, url);

        //Response Code Validation
        int reponsecode=response.getStatusCode();
//        System.out.println("Response Code= "+reponsecode);
        
        logger.info("Response Code= "+reponsecode);
        extent.extentLogger("response code", "Response Code= "+reponsecode);
        
        Assert.assertEquals(reponsecode, 400);

        String Token =response.jsonPath().get("error");
        Assert.assertEquals(Token, "unsupported_grant_type");

        String access_token =response.jsonPath().get("error_description");
        Assert.assertEquals(access_token, "Invalid grant_type");

    }

    @Test
    @Parameters({"APIUrl"})
    public void EmptyGrantType_TokenGCash(String url) throws IOException {

        Object[][] data =  dataProvider.GCashapi("Gcashapi_EmptyGrantType");
        Response response = TokenGCashAPI(data, url);

        //Response Code Validation
        int reponsecode=response.getStatusCode();
//        System.out.println("Response Code= "+reponsecode);
        
        logger.info("Response Code= "+reponsecode);
        extent.extentLogger("response code", "Response Code= "+reponsecode);
        
        Assert.assertEquals(reponsecode, 400);

        String Token =response.jsonPath().get("error");
        Assert.assertEquals(Token, "unsupported_grant_type");

        String access_token =response.jsonPath().get("error_description");
        Assert.assertEquals(access_token, "Invalid grant_type");
    }


}
