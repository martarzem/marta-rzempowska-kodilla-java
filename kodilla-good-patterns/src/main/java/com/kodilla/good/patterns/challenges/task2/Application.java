package com.kodilla.good.patterns.challenges.task2;

public class Application {

    public static void main (String[] args) {

        SaleRequestRetriever saleRequestRetriever = new SaleRequestRetriever();
        SaleRequest saleRequest = saleRequestRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService(
                new MailService(), new ItemSaleService(), new ItemSaleRepository());
        productOrderService.process(saleRequest);
    }
}
//uruchamia aplikację