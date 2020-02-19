package com.kodilla.good.patterns.challenges.task3;

public class Application {

    public static void main (String[] args) {

        //ExtraFoodShop
        OrderRequestRetriever orderRetrieverExtra = new OrderRequestRetriever();
        OrderRequest orderExtra = orderRetrieverExtra.retrieveExtraShop();

        ProductOrderService productExtra = new ProductOrderService(
                new MailService(), new ExtraFoodShopOrderService(), new ExtraFoodShopOrderRepository());
        productExtra.process(orderExtra);

        //HealthyShop
        OrderRequestRetriever orderRetrieverHealthy = new OrderRequestRetriever();
        OrderRequest orderHealthy = orderRetrieverHealthy.retrieveHealthyShop();

        ProductOrderService productHealthy = new ProductOrderService(
                new MailService(), new HealthyShopOrderService(), new HealthyShopOrderRepository());
        productHealthy.process(orderHealthy);

        //GlutenFreeShop
        OrderRequestRetriever orderRetrieverGluten = new OrderRequestRetriever();
        OrderRequest orderGluten = orderRetrieverGluten.retrieveGlutenShop();

        ProductOrderService productGluten = new ProductOrderService(
                new MailService(), new GlutenFreeShopOrderService(), new GlutenFreeShopOrderRepository());
        productGluten.process(orderGluten);
    }
}