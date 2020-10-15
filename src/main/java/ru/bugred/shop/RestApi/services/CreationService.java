package ru.bugred.shop.RestApi.services;

import ru.bugred.shop.RestApi.entities.Product;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreationService {

    private static int createBaseItem(Product product) {
        Response response = given()
                .contentType("application/json")
                .body(product)
                .when().post("/create");
        Assert.assertEquals(response.statusCode(), 200);

        String parsedId = response.jsonPath().getString("result.id");
        int id = Integer.parseInt(parsedId);

        return id;
    }

    private static void updateBaseItem(Product product) {
        Response response = given()
                .contentType("application/json")
                .body(product)
                .when().post("/update");
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("result"), "Товар обновлен!");

    }

    private static void getItemById(int itemId, Product product) {
        HashMap<String,Integer> requestBody = new HashMap<>();
        requestBody.put("id", itemId);

        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when().post("/get");
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains(product.getName()));
        Assert.assertTrue(response.getBody().asString().contains(product.getSection()));
        Assert.assertTrue(response.getBody().asString().contains(product.getDescription()));

    }

    public static void createItem(Product product) {
        int itemId = createBaseItem(product);
        getItemById(itemId, product);

    }



    public static void updateItem(Product product) {
        int id = createBaseItem(product);

        Product productUpdates = new Product.Builder().setId(id).setName("Шортики")
                .setSection("Платья").setDescription("тыгыдык").build();

        updateBaseItem(productUpdates);

        getItemById(id, productUpdates);

    }


}
