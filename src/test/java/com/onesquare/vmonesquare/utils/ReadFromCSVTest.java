package com.onesquare.vmonesquare.utils;

import com.onesquare.vmonesquare.domain.entity.ProductList;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReadFromCSVTest {

    public static final String PRODUCTS_NUTS = "nuts";
    public static final String PRODUCTS_CHIPS = "chips";
    public static final String PRODUCT_CHOCOLATE_BAR = "chocolate bar";
    private ReadFromCSV readFromCSV;
    @Before
    public void setup() {
        readFromCSV = new ReadFromCSV();
    }

    @Test
    public void readFromCSVFileTest(){
        List<ProductList> productListsFromCsvFile = new ArrayList<>();
        productListsFromCsvFile = readFromCSV.readFromCSVFile();
        Assertions.assertThat(productListsFromCsvFile.get(0).getProductName()).isEqualTo(PRODUCTS_NUTS);
        Assertions.assertThat(productListsFromCsvFile.get(1).getProductName()).isEqualTo(PRODUCTS_CHIPS);
        Assertions.assertThat(productListsFromCsvFile.get(2).getProductName()).isEqualTo(PRODUCT_CHOCOLATE_BAR);
    }
}
