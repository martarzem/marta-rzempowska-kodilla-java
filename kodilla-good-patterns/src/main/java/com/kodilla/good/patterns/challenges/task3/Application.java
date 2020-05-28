package com.kodilla.good.patterns.challenges.task3;

public class Application {

    public static void main(String[] args) throws Exception {

        //ExtraFoodShop
        OrderRequestRetriever orderRetrieverExtra = new OrderRequestRetriever();
        OrderRequest orderExtra = orderRetrieverExtra.retrieveExtraShop();

        ProductOrderService productExtra = new ProductOrderService(
                new MailService(), new ExtraFoodShopOrderRepository());
        productExtra.process(orderExtra);

    }
}