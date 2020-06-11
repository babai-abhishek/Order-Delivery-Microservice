# Order-Delivery-Microservice
The idea is to build a simple application to Order some burger in example and Deliver it accordingly using Microservices with event-driven pattern (Choreography Saga pattern).

**Tools and Techniques**
```
Java Spring Boot, JPA-Hibernate, Rest APIs, MySQL, Kafka
```
**Prerequisits**
```
Kafka, Zookeeper, MySQL
```

**Steps**
1. clean and build
2. Run MySQL
3. Change the ports for mysql db and others according to your needs into the **application.yml** files. Give DB name according to your choice
4. Run Kafka
5. Add 3 topics into Kafka as - **orderservice**, **deliveryservice**, **orderservicecallback** with no of partition as 1 and replication factor as 1 as well
6. Run all services.

**Available APIs**
```
1.Add Burger to MySQL DB

POST http://localhost:8082/kitchen/add
Request Body 
{
"hamburgerType": "ANGUS",
"quantity": 10
}
  
2. Create an Order

POST http://localhost:8081/order/create
Request Body 
{
  "address": {
    "number": "43/1",
    "street": "Test street"
  },
  "cookingType": "BLOOD",
  "hamburgerList": [
    {
      "hamburgerType": "ANGUS",
      "quantity": 10
    }
  ],
  "orderStatus": "WAITING",
  "price": 110,
  "statusDescription": "Test description"
}

3. View all orders

GET http://localhost:8081/order/view
Response Body
[
  {
    "orderId": 1,
    "statusDescription": "Delivered",
    "hamburgerList": [
      {
        "_id": 101,
        "hamburgerType": "ANGUS",
        "quantity": 10
      }
    ],
    "cookingType": "BLOOD",
    "orderStatus": "DELIVERED",
    "price": 110
  },
  {
    "orderId": 2,
    "statusDescription": "Test description",
    "hamburgerList": [
      {
        "_id": 112,
        "hamburgerType": "ANGUS",
        "quantity": 10
      }
    ],
    "cookingType": "BLOOD",
    "orderStatus": "WAITING",
    "price": 110
  }
]

4. Get particular order

GET http://localhost:8081/order/view/{id}
Request : http://localhost:8081/order/view/1
Response Body
{
  "orderId": 1,
  "statusDescription": "Delivered",
  "hamburgerList": [
    {
      "_id": 101,
      "hamburgerType": "ANGUS",
      "quantity": 10
    }
  ],
  "cookingType": "BLOOD",
  "orderStatus": "DELIVERED",
  "price": 110
}
```
