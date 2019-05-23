package com.onesquare.vmonesquare.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Getter
public class VendorMachineResponseEntity {

    private static final Map<String, Double> MONEY_DENOMINATION_CENTS = initMapCentsDenominations();

    private static final Map<String, Double> MONEY_DENOMINATION_BILLS = initMapBillsDenominations();
    private static final String NOT_ENOUGH_MONEY = "- it's not enough money, please enter ";
    private static final String YOU_HAVE_ENOUGH_MONEY =
            "- You have enough money, do you want to keep buying? you have extra balance of ";
    private static final String THE_EXACT_AMOUNT =
            "- Congrats, you complete the exact amount, do you want to keep buying?";
    private static final String ZERO = "zero";
    private static final String ONE = "one";
    private static final String FIVE = "five";
    private static final String TEN = "ten";
    private static final String TWENTY_FIVE = "twentyFive";
    private static final String FIFTY = "fifty";
    private static final String TWO = "two";
    private static final String PRODUCT_CODE_L5 = "L5";
    private static final String PRODUCT_NAME_NUTS = "nuts";
    private static final double PRODUCT_PRICE_2_5 = 2.50;
    private static final String PRODUCT_CODE_L3 = "L3";
    private static final String PRODUCT_NAME_CHIPS = "chips";
    private static final double PRODUCT_PRICE_4_5 = 4.50;
    private static final String CENTS_DENOMINATIONS = "Cents denominations";
    private static final String BILLS_DENOMINATIONS = "Bills denominations";
    private static final String PRODUCT_NOT_EXIST = "- The product not exist";
    private static final String WRONG = "Wrong ";
    private static final String TERRIFIC = "Terrific ";

    private Map<Integer, ProductList> productListMap = initMapProductList();

    private int isProdutListPresent = 0;
    private double productPrice;

    @Setter
    public int responseCode = 0;
    @Setter
    public String message = "";

    private static Map<String, Double> initMapCentsDenominations() {
        Map<String, Double> cents = new HashMap<>();
        cents.put(ZERO, 0.0);
        cents.put(ONE, 0.01);
        cents.put(FIVE, 0.05);
        cents.put(TEN, 0.10);
        cents.put(TWENTY_FIVE, 0.25);
        cents.put(FIFTY, 0.50);
        return Collections.unmodifiableMap(cents);
    }

    private static Map<String, Double> initMapBillsDenominations() {
        Map<String, Double> bills = new HashMap<>();
        bills.put(ZERO, 0.0);
        bills.put(ONE, 1.0);
        bills.put(TWO, 2.0);
        return Collections.unmodifiableMap(bills);
    }

    private Map<Integer, ProductList> initMapProductList() {
        Map<Integer, ProductList> productsMap = new HashMap<>();
        ProductList productList = new ProductList();
        productList.setProductCode(PRODUCT_CODE_L5);
        productList.setProductName(PRODUCT_NAME_NUTS);
        productList.setProductPrice(PRODUCT_PRICE_2_5);
        productsMap.put(1, productList);
        productList = new ProductList();
        productList.setProductCode(PRODUCT_CODE_L3);
        productList.setProductName(PRODUCT_NAME_CHIPS);
        productList.setProductPrice(PRODUCT_PRICE_4_5);
        productsMap.put(2, productList);
        return Collections.unmodifiableMap(productsMap);
    }

    public void getValidateMoney(VendorMachineEntity vendorMachineEntity) {

        if (!MONEY_DENOMINATION_CENTS.containsValue(vendorMachineEntity.cents)) {
            setFailResponse(CENTS_DENOMINATIONS);
        }
        if (!MONEY_DENOMINATION_BILLS.containsValue(vendorMachineEntity.bills)) {
            setFailResponse(BILLS_DENOMINATIONS);
        }
        findProductFromProductList(vendorMachineEntity);
        if (isProdutListPresent == 0) {
            setFailResponse(PRODUCT_NOT_EXIST);
        }
    }

    public void getProductFromVendorMachine(VendorMachineEntity vendorMachineEntity){
        productListMap.entrySet().stream().forEach( p -> {
            if(p.getValue().getProductCode().equals(vendorMachineEntity.getVmItem().getCode()))
                productPrice = p.getValue().getProductPrice();
        });
        if(vendorMachineEntity.getTotalAmount() > productPrice){
            setOkResponse(YOU_HAVE_ENOUGH_MONEY + (vendorMachineEntity.getTotalAmount() - productPrice));
        }else{
            setFailResponse(NOT_ENOUGH_MONEY + (productPrice - vendorMachineEntity.getTotalAmount()));
        }
        if(vendorMachineEntity.getTotalAmount() == productPrice)
            setOkResponse(THE_EXACT_AMOUNT);
    }

    private void findProductFromProductList(VendorMachineEntity vendorMachineEntity) {
        productListMap.entrySet().stream().forEach(e -> {
            if(e.getValue().getProductCode().equals(vendorMachineEntity.getVmItem().getCode()))
                isProdutListPresent += 1;
        });
    }

    private void setFailResponse(String failResponse) {
        this.setMessage(WRONG + failResponse);
        this.setResponseCode(-1);
    }

    private void setOkResponse(String okResponse) {
        this.setMessage(TERRIFIC + okResponse);
        this.setResponseCode(0);
    }
}
