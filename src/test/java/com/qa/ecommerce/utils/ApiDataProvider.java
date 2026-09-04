package com.qa.ecommerce.utils;

import org.testng.annotations.DataProvider;

public class ApiDataProvider {

    @DataProvider(name = "createUserData")
    public Object[][] createUserData() {

        return new Object[][] {

            {
                ApiTestDataReader.get("createUserName"),
                ApiTestDataReader.get("createUsername")
            },

            {
                ApiTestDataReader.get("secondCreateUserName"),
                ApiTestDataReader.get("secondCreateUsername")
            },

            {
                ApiTestDataReader.get("thirdCreateUserName"),
                ApiTestDataReader.get("thirdCreateUsername")
            },

            {
                ApiTestDataReader.get("fourthCreateUserName"),
                ApiTestDataReader.get("fourthCreateUsername")
            }
        };
    }
}