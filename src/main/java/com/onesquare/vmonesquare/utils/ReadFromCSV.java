package com.onesquare.vmonesquare.utils;

import com.onesquare.vmonesquare.domain.entity.ProductList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromCSV {

    public static final String PATH_TO_CSV = "C:/test/productList.csv";

    public static List<ProductList> readFromCSVFile() {
        List<ProductList> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_CSV))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                ProductList productList = new ProductList();
                productList.setId(Integer.parseInt(values[0]));
                productList.setProductCode(values[1]);
                productList.setProductName(values[2]);
                productList.setProductPrice(Double.parseDouble(values[3]));
                records.add(productList);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
