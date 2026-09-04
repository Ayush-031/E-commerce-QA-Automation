package com.qa.ecommerce.api.tests;

import com.qa.ecommerce.api.base.BaseApi;
import com.qa.ecommerce.api.endpoints.UserEndpoints;
import com.qa.ecommerce.models.User;
import com.qa.ecommerce.utils.ApiTestDataReader;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.ecommerce.utils.ApiDataProvider;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class UserApiTest extends BaseApi {

    @Test
    public void getAllUsers() {

        given(requestSpec)

        .when()
            .get(UserEndpoints.USERS)

        .then()
            .statusCode(200);
    }


    @Test
    public void getUserById() {

        int userId = Integer.parseInt(
                ApiTestDataReader.get("getUserId")
        );

        given(requestSpec)
            .pathParam("id", userId)

        .when()
            .get(UserEndpoints.USER_BY_ID)

        .then()
            .statusCode(200)
            .body(
                "id",
                equalTo(userId)
            )
            .body(
                "name",
                equalTo(
                    ApiTestDataReader.get("expectedUserName")
                )
            );
    }


    @Test
    public void getUsersWithQueryParameter() {

        int userId = Integer.parseInt(
                ApiTestDataReader.get("getUserId")
        );

        given(requestSpec)
            .queryParam("id", userId)

        .when()
            .get(UserEndpoints.USERS)

        .then()
            .statusCode(200)
            .body(
                "[0].id",
                equalTo(userId)
            );
    }


    @Test
    public void verifyHeaders() {

        int userId = Integer.parseInt(
                ApiTestDataReader.get("getUserId")
        );

        given(requestSpec)
            .header("Accept", "application/json")
            .pathParam("id", userId)

        .when()
            .get(UserEndpoints.USER_BY_ID)

        .then()
            .statusCode(200)
            .header(
                "Content-Type",
                containsString("application/json")
            );
    }


@Test(dataProvider = "createUserData", dataProviderClass = ApiDataProvider.class)
public void createUser(String name, String username) {

    User user = new User(
            name,
            username
    );

    given(requestSpec)
        .body(user)

    .when()
        .post(UserEndpoints.USERS)

    .then()
        .statusCode(201)
        .body(
            "name",
            equalTo(name)
        )
        .body(
            "username",
            equalTo(username)
        );
}


    @Test
    public void createUserAndValidateResponse() {

        User user = new User(
                ApiTestDataReader.get("secondCreateUserName"),
                ApiTestDataReader.get("secondCreateUsername")
        );

        given(requestSpec)
            .body(user)

        .when()
            .post(UserEndpoints.USERS)

        .then()
            .statusCode(201)
            .body(
                "name",
                equalTo(
                    ApiTestDataReader.get("secondCreateUserName")
                )
            )
            .body(
                "username",
                equalTo(
                    ApiTestDataReader.get("secondCreateUsername")
                )
            );
    }


    @Test
    public void getUserAndDeserialize() {

        int userId = Integer.parseInt(
                ApiTestDataReader.get("getUserId")
        );

        User user =
            given(requestSpec)
                .pathParam("id", userId)

            .when()
                .get(UserEndpoints.USER_BY_ID)

            .then()
                .statusCode(200)
                .extract()
                .as(User.class);

        Assert.assertEquals(
                user.getId(),
                userId
        );

        Assert.assertEquals(
                user.getName(),
                ApiTestDataReader.get("expectedUserName")
        );

        Assert.assertEquals(
                user.getUsername(),
                ApiTestDataReader.get("expectedUsername")
        );
    }


    @Test
    public void updateUser() {

        User user = new User(
                ApiTestDataReader.get("updateUserName"),
                ApiTestDataReader.get("updateUsername")
        );

        int userId = Integer.parseInt(
                ApiTestDataReader.get("getUserId")
        );

        given(requestSpec)
            .pathParam("id", userId)
            .body(user)

        .when()
            .put(UserEndpoints.USER_BY_ID)

        .then()
            .statusCode(200)
            .body(
                "name",
                equalTo(
                    ApiTestDataReader.get("updateUserName")
                )
            )
            .body(
                "username",
                equalTo(
                    ApiTestDataReader.get("updateUsername")
                )
            );
    }


    @Test
    public void updateAnotherUser() {

        User user = new User(
                ApiTestDataReader.get("secondUpdateUserName"),
                ApiTestDataReader.get("secondUpdateUsername")
        );

        int userId = Integer.parseInt(
                ApiTestDataReader.get("secondDeleteUserId")
        );

        given(requestSpec)
            .pathParam("id", userId)
            .body(user)

        .when()
            .put(UserEndpoints.USER_BY_ID)

        .then()
            .statusCode(200)
            .body(
                "name",
                equalTo(
                    ApiTestDataReader.get("secondUpdateUserName")
                )
            )
            .body(
                "username",
                equalTo(
                    ApiTestDataReader.get("secondUpdateUsername")
                )
            );
    }


    @Test
    public void deleteUser() {

        int userId = Integer.parseInt(
                ApiTestDataReader.get("deleteUserId")
        );

        given(requestSpec)
            .pathParam("id", userId)

        .when()
            .delete(UserEndpoints.USER_BY_ID)

        .then()
            .statusCode(200);
    }


    @Test
    public void deleteAnotherUser() {

        int userId = Integer.parseInt(
                ApiTestDataReader.get("secondDeleteUserId")
        );

        given(requestSpec)
            .pathParam("id", userId)

        .when()
            .delete(UserEndpoints.USER_BY_ID)

        .then()
            .statusCode(200);
    }


    @Test
    public void getInvalidUser() {

        int userId = Integer.parseInt(
                ApiTestDataReader.get("invalidUserId")
        );

        given(requestSpec)
            .pathParam("id", userId)

        .when()
            .get(UserEndpoints.USER_BY_ID)

        .then()
            .statusCode(404);
    }
}