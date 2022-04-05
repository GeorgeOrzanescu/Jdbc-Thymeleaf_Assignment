# Jdbc-Thymeleaf_Assignment
DB School JDBC and THYMELEAF assignement
Homework:

  - Remove ID from customer addition, modify ALL tables to auto increment id (do not change anything)
  - Create controller classes for products: add/delete/update product, list products, list all (products, order) pairs (with join)
  - Controller for customer: already done, add an “updateCustomerPhone”
  - Controller for placing order: this will not be your standard CRUD API, it will contain:
        - placeOrder(orderId, orderDetails):  add new order details to order, will fail if orderId does not already exist, also updated product stock
        - placeOrder(order, orderDetails)”: add new order and order details, will fail if orderId already exists
        - placeOrder methods should make their checks and call product stock updates in the business logic layer (separate package and annotate with @Service)
   - Controller for payments
   - registerPayment(payment): add payment to database
   
   - Respect coding conventions and style, send me a message on slack if anything is unclear!
