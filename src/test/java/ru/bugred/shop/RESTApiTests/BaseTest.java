package ru.bugred.shop.RESTApiTests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://shop.bugred.ru/api/items";
    }

}
