package kurniawan_rizki.kafka_spring_demo.notification.service;

import kurniawan_rizki.kafka_spring_demo.order.dto.OrderEventDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
     private KafkaTemplate<String, OrderEventDto> kafkaTemplate;

     public NotificationService(KafkaTemplate<String, OrderEventDto> kafkaTemplate) {
          this.kafkaTemplate = kafkaTemplate;
     }

     @KafkaListener(topics = "order-created", groupId = "notification-group")
     public void notifyOrderCreated(OrderEventDto orderEvent) {
          System.out.println("Notifying user: " + orderEvent.getUserId() +
                  " about order creation: " + orderEvent.getOrderId());
     }

     @KafkaListener(topics = "order-processed", groupId = "notification-group")
     public void notifyOrderProcessed(OrderEventDto orderEvent) {
          System.out.println("Notifying user: " + orderEvent.getUserId() +
                  " about order processing: " + orderEvent.getOrderId());
     }

     @KafkaListener(topics = "order-shipped", groupId = "notification-group")
     public void notifyOrderShipped(OrderEventDto orderEvent) {
          System.out.println("Notifying user: " + orderEvent.getUserId() +
                  " about order shipment: " + orderEvent.getOrderId());
     }

}
