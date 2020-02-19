package com.kodilla.good.patterns.challenges.task2;

public class ProductOrderService {

    private InformationService informationService;
    private SaleService saleService;
    private SaleRepository saleRepository;

    public ProductOrderService(final InformationService informationService,
                               final SaleService saleService,
                               final SaleRepository saleRepository) {
        this.informationService = informationService;
        this.saleService = saleService;
        this.saleRepository = saleRepository;
    }

    public SaleDto process(final SaleRequest saleRequest) {
        boolean isSold = saleService.sale(saleRequest.getUser(), saleRequest.getItem(), saleRequest.getTime());

        if (isSold) {
            informationService.inform(saleRequest.getUser(), saleRequest.getItem());
            saleRepository.createSale(saleRequest.getUser(), saleRequest.getItem(), saleRequest.getTime());
            return new SaleDto(saleRequest.getUser(), true);
        } else {
            return new SaleDto(saleRequest.getUser(), false);
        }
    }
}
//metoda całego procesu kupna - jeśli kupienie powiodło się -> mail, wykreowania procesu kupna, zapisanie w bazie danych
