package com.onesquare.vmonesquare.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Getter
public class VendorMachineResponseEntity {

    private static final Map<String, Integer> MONEY_DENOMINATION_CENTS = initMapCentsDenominations();

    private static final Map<String, Integer> MONEY_DENOMINATION_BILLS = initMapBillsDenominations();

    private Map<Integer, ProductList> productListMap = initMapProductList();

    private int isProdutListPresent = 0;

    @Setter
    public int responseCode = 0;
    @Setter
    public String message = "";

    private static Map<String, Integer> initMapCentsDenominations() {
        Map<String, Integer> cents = new HashMap<>();
        cents.put("zero", 0);
        cents.put("one", 1);
        cents.put("five", 5);
        cents.put("ten", 10);
        cents.put("twentyFive", 25);
        cents.put("fifty", 50);
        return Collections.unmodifiableMap(cents);
    }

    private static Map<String, Integer> initMapBillsDenominations() {
        Map<String, Integer> bills = new HashMap<>();
        bills.put("zero", 0);
        bills.put("one", 1);
        bills.put("two", 2);
        return Collections.unmodifiableMap(bills);
    }

    private Map<Integer, ProductList> initMapProductList() {
        Map<Integer, ProductList> productsMap = new HashMap<>();
        ProductList productList = new ProductList();
        productList.setProductCode("L5");
        productList.setProductName("nuts");
        productList.setProductPrice(5.50);
        productsMap.put(1, productList);
        productsMap.put(2, productList);
        productsMap.put(3, productList);
        return Collections.unmodifiableMap(productsMap);
    }

    public void getValidateMoney(VendorMachineEntity vendorMachineEntity) {

        if (!MONEY_DENOMINATION_CENTS.containsValue(vendorMachineEntity.cents)) {
            setFailResponse("Cents denominations");
        }
        if (!MONEY_DENOMINATION_BILLS.containsValue(vendorMachineEntity.bills)) {
            setFailResponse("Bills denominations");
        }
        findProductFromProductList(vendorMachineEntity);
        if (isProdutListPresent == 0) {
            setFailResponse("- The product not exist");
        }
    }

    private void findProductFromProductList(VendorMachineEntity vendorMachineEntity) {
        productListMap.entrySet().stream().forEach(e -> {
            if(e.getValue().getProductCode().equals(vendorMachineEntity.vmItem.code))
                isProdutListPresent += 1;
        });
    }

    private void setFailResponse(String denomination) {
        this.setMessage("Wrong " + denomination);
        this.setResponseCode(-1);
    }
}
