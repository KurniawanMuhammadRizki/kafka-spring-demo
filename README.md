# Event-Driven Order Management with Kafka

Welcome to the **Event-Driven Order Management** repository! 🎉 This project continues my Kafka exploration, focusing on an **event-driven architecture** using **Spring Boot**. It simulates a real-world **Order Management Workflow** where services communicate asynchronously via Kafka topics.

---

## What is this?
This project demonstrates:

- **Order Creation**: REST API to create an order, publishes `order-created` events.
- **Order Processing**: Processes orders, publishes `order-processed` events.
- **Order Shipping**: Simulates shipping, publishes `order-shipped` events.
- **User Notifications**: Listens for shipped orders, simulates user notifications.

It's a **simulation** (no database) to showcase service interaction through Kafka. Future updates may add persistence and more features! 🚀

---

## How to Run

### Prerequisites
- **Java 17**
- **Maven**
- **Apache Kafka** (running on `localhost:9092`)

### Steps
1. Clone the repository
2. Install dependencies:
3. Start Kafka and create topics:
4. Run the application:
5. Test the API:
   Check logs to see the workflow in action!

---

## Tech Stack
- **Spring Boot**: REST APIs and Kafka integration.
- **Apache Kafka**: Messaging backbone.
- **Java**: Language of choice.

---

## Future Improvements
Plans include:

- Adding a **database** for persistence.
- Implementing **retry mechanisms** for failed events.
- Adding **monitoring tools** like Kafka UI.
- Expanding workflows with additional services (e.g., payment, inventory).

---

## Feedback & Contributions

- Feel free to share feedback or contribute! Open an issue or submit a pull request to collaborate. 🌟
- Thanks for checking out my project. Stay Happy and Healthy! 😄
---



