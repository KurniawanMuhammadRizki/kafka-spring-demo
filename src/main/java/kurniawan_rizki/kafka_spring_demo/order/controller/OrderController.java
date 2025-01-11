package kurniawan_rizki.kafka_spring_demo.order.controller;

import kurniawan_rizki.kafka_spring_demo.order.dto.OrderRequestDto;
import kurniawan_rizki.kafka_spring_demo.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
     private final OrderService orderService;
     public OrderController(OrderService orderService) {
          this.orderService = orderService;
     }

     @PostMapping
     public ResponseEntity<String> createOrder(@RequestBody OrderRequestDto req){
          orderService.createOrder(req);
          return ResponseEntity.ok("Order created successfully!");
     }


}
