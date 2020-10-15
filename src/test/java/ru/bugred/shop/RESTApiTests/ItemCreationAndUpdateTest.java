package ru.bugred.shop.RESTApiTests;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.bugred.shop.RestApi.entities.Product;

import static ru.bugred.shop.RestApi.services.CreationService.createItem;
import static ru.bugred.shop.RestApi.services.CreationService.updateItem;

public class ItemCreationAndUpdateTest extends BaseTest {
    Product initialProduct;

    @BeforeTest
    public void init() {
        initialProduct = new Product.Builder().setName("Шортики").setSection("Платья")
                .setDescription("Модное платье из новой коллекции!").build();
    }

    @Test
    public void createItemTest() {
        createItem(initialProduct);

    }

    @Test
    public void updateItemTest() {
        updateItem(initialProduct);

    }
}
