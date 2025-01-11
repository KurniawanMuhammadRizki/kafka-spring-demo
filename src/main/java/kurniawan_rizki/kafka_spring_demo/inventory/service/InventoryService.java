package kurniawan_rizki.kafka_spring_demo.inventory.service;

import kurniawan_rizki.kafka_spring_demo.order.dto.OrderEventDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
     private final KafkaTemplate<String, OrderEventDto> kafkaTemplate;
     public InventoryService(KafkaTemplate<String, OrderEventDto> kafkaTemplate) {
          this.kafkaTemplate = kafkaTemplate;
     }

     @KafkaListener(topics = "order-created",  groupId = "inventory-group")
     public void processOrder(OrderEventDto orderEvent) {
          System.out.println("Checking inventory for order: " + orderEvent.getOrderId());

          orderEvent.setStatus("PROCESSED");
          kafkaTemplate.send("order-processed", orderEvent);
     }

}
