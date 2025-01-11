package kurniawan_rizki.kafka_spring_demo.order.service;

import kurniawan_rizki.kafka_spring_demo.order.dto.OrderEventDto;
import kurniawan_rizki.kafka_spring_demo.order.dto.OrderRequestDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrderService {
     private final KafkaTemplate<String, OrderEventDto> kafkaTemplate;
     public OrderService(KafkaTemplate<String, OrderEventDto> kafkaTemplate) {
     this.kafkaTemplate = kafkaTemplate;
     }

     public void createOrder(OrderRequestDto req) {
          OrderEventDto orderEvent = new OrderEventDto();
          orderEvent.setOrderId(UUID.randomUUID().toString());
          orderEvent.setUserId(req.getUserId());
          orderEvent.setStatus("CREATED");
          orderEvent.setCreatedAt(LocalDateTime.now());

          kafkaTemplate.send("order-created", orderEvent);
     }
}
