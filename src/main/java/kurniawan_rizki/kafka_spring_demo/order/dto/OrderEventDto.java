package kurniawan_rizki.kafka_spring_demo.order.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderEventDto {
     private String orderId;
     private String userId;
     private String status;
     private LocalDateTime createdAt;
}
