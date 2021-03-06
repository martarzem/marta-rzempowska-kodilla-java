package com.kodilla.good.patterns.challenges.task3;

public class ProductOrderService {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public ProductOrderService(final InformationService informationService,
                               final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) throws Exception {
        orderService = OrderServiceFactory.getOrderService(orderRequest.getOrderServiceName());
        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getOrder(), orderRequest.getTime());

        if (isOrdered) {
            informationService.inform(orderRequest.getUser(), orderRequest.getOrder());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getOrder(), orderRequest.getTime());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
