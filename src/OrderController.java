public class OrderController {
    package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("orders")
    public class OrderController {


//        @aakashparab07
//        aakashparab07 41 minutes ago Collaborator
        // @Autowired
        OrderService orderService = new OrderService();

//        @aakashparab07	Reply…

        @PostMapping("/add-order")
        public ResponseEntity<String> addOrder(@RequestBody Order order){


//            @aakashparab07
//            aakashparab07 40 minutes ago Collaborator
            orderService.addOrder(order);

            @aakashparab07	Reply…
            return new ResponseEntity<>("New order added successfully", HttpStatus.CREATED);
        }

        @PostMapping("/add-partner/{partnerId}")
        public ResponseEntity<String> addPartner(@PathVariable String partnerId){


//            @aakashparab07
//            aakashparab07 39 minutes ago Collaborator
            orderService.addPartner(partnerId);

//            @aakashparab07	Reply…
            return new ResponseEntity<>("New delivery partner added successfully", HttpStatus.CREATED);
        }

        @PutMapping("/add-order-partner-pair")
        public ResponseEntity<String> addOrderPartnerPair(@RequestParam String orderId, @RequestParam String partnerId){


//            @aakashparab07
//            aakashparab07 36 minutes ago Collaborator
            orderService.addOrderPartnerPair(orderId, partnerId);

//            @aakashparab07	Reply…
            //This is basically assigning that order to that partnerId
            return new ResponseEntity<>("New order-partner pair added successfully", HttpStatus.CREATED);
        }

        @GetMapping("/get-order-by-id/{orderId}")
        public ResponseEntity<Order> getOrderById(@PathVariable String orderId){

            Order order= null;


            Order order= orderService.getOrderById(orderId);


            //order should be returned with an orderId.

            return new ResponseEntity<>(order, HttpStatus.CREATED);
        }

        @GetMapping("/get-partner-by-id/{partnerId}")
        public ResponseEntity<DeliveryPartner> getPartnerById(@PathVariable String partnerId){

            DeliveryPartner deliveryPartner = null;



            DeliveryPartner deliveryPartner = orderService.getpartnerById(partnerId);

//            @aakashparab07	Reply…
            //deliveryPartner should contain the value given by partnerId

            return new ResponseEntity<>(deliveryPartner, HttpStatus.CREATED);
        }

        @GetMapping("/get-order-count-by-partner-id/{partnerId}")
        public ResponseEntity<Integer> getOrderCountByPartnerId(@PathVariable String partnerId){

            Integer orderCount = 0;

            //orderCount should denote the orders given by a partner-id

            return new ResponseEntity<>(orderCount, HttpStatus.CREATED);
        }

        @GetMapping("/get-orders-by-partner-id/{partnerId}")
        public ResponseEntity<List<String>> getOrdersByPartnerId(@PathVariable String partnerId){
            List<String> orders = null;

            List orders = orderService.getOrderByPartnerId(partnerId);



            //orders should contain a list of orders by PartnerId

            return new ResponseEntity<>(orders, HttpStatus.CREATED);
        }

        @GetMapping("/get-all-orders")
        public ResponseEntity<List<String>> getAllOrders(){
            List<String> orders = null;


            List orders = orderService.getAllOrders();

//            @aakashparab07	Reply…

            //Get all orders
            return new ResponseEntity<>(orders, HttpStatus.CREATED);
        }

        @GetMapping("/get-count-of-unassigned-orders")
        public ResponseEntity<Integer> getCountOfUnassignedOrders(){
            Integer countOfOrders = 0;

            //Count of orders that have not been assigned to any DeliveryPartner


//            @aakashparab07
//            aakashparab07 27 minutes ago Collaborator
                    countOfOrders = orderService.getCountofunassignedorders();

//            @aakashparab07	Reply…
            return new ResponseEntity<>(countOfOrders, HttpStatus.CREATED);
        }

        @GetMapping("/get-count-of-orders-left-after-given-time/{partnerId}")
        public ResponseEntity<Integer> getOrdersLeftAfterGivenTimeByPartnerId(@PathVariable String time, @PathVariable String partnerId){

            Integer countOfOrders = 0;


            Integer countOfOrders = orderService.getOrdersLeftAfterGiventimeByPartnerId(time,partnerId);

//            @aakashparab07	Reply…

            //countOfOrders that are left after a particular time of a DeliveryPartner

            return new ResponseEntity<>(countOfOrders, HttpStatus.CREATED);
        }

        @GetMapping("/get-last-delivery-time/{partnerId}")
        public ResponseEntity<String> getLastDeliveryTimeByPartnerId(@PathVariable String partnerId){
            String time = null;


//            @aakashparab07
//            aakashparab07 21 minutes ago Collaborator
            String time = orderService.getLastDeliveryTimeByPartnerId(partnerId);

//            @aakashparab07	Reply…
            //Return the time when that partnerId will deliver his last delivery order.

            return new ResponseEntity<>(time, HttpStatus.CREATED);
        }

        @DeleteMapping("/delete-partner-by-id/{partnerId}")
        public ResponseEntity<String> deletePartnerById(@PathVariable String partnerId){

            //Delete the partnerId
            //And push all his assigned orders to unassigned orders.


//            @aakashparab07
//            aakashparab07 22 minutes ago Collaborator
            orderService.deletepartnerById(partnerId);

//            @aakashparab07	Reply…
            return new ResponseEntity<>(partnerId + " removed successfully", HttpStatus.CREATED);
        }

        @DeleteMapping("/delete-order-by-id/{orderId}")
        public ResponseEntity<String> deleteOrderById(@PathVariable String orderId){

            //Delete an order and also
            // remove it from the assigned order of that partnerId


//            @aakashparab07
//            aakashparab07 23 minutes ago Collaborator
            orderService.deleteOrderById(order Id);

//            @aakashparab07	Reply…
            return new ResponseEntity<>(orderId + " removed successfully", HttpStatus.CREATED);
        }
    }
}
