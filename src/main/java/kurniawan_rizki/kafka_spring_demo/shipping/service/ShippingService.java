package kurniawan_rizki.kafka_spring_demo.shipping.service;

import kurniawan_rizki.kafka_spring_demo.order.dto.OrderEventDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
     private KafkaTemplate<String, OrderEventDto> kafkaTemplate;
     public ShippingService(KafkaTemplate<String, OrderEventDto> kafkaTemplate) {
          this.kafkaTemplate = kafkaTemplate;
     }

     @KafkaListener(topics = "order-processed", groupId = "shipping-group")
     public void shipOrder(OrderEventDto orderEvent) {
          System.out.println("Checking Shipping for Order: " + orderEvent.getOrderId());
          System.out.println("Shipping for Order: " + orderEvent.getOrderId());
          orderEvent.setStatus("SHIPPED");
          kafkaTemplate.send("order-shipped", orderEvent);
     }
}
