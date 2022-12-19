package com.bosonit.queueluckitest.controller;

import com.bosonit.queueluckitest.application.App;
import com.bosonit.queueluckitest.model.Order;
import com.bosonit.queueluckitest.model.Pose;
import com.bosonit.queueluckitest.model.StatusUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Queue;

@RestController
public class Controller {

    @Autowired
    App app;

    @PostMapping("api/v1/order/{type}")
    public void receiveOrder(@PathVariable String type, @RequestParam(required = false) Map<String, Object> arguments) {
        arguments.put("delete",true);
        app.pickOrder(type, arguments);
    }

    @GetMapping("api/v1/order/pending_orders")
    public Order getNextOrder() {
        return app.getNextOrder();
    }


    @GetMapping("api/v1/order")
    public Queue<Order> getAllOrders() {
        return app.getAllOrders();
    }

    @PostMapping("api/v1/status")
    public void updateStatus(@RequestBody StatusUpdate statusUpdate) {
        System.out.println(statusUpdate);
        app.setStatus(statusUpdate);
    }

    @GetMapping("api/v1/status")
    public StatusUpdate getStatus() {
        return app.getStatus();
    }

    @GetMapping("api/v1/map/point")
    public List<Pose> getPoints() {
        return app.getListaPuntos();
    }

    @GetMapping("api/v1/map")
    public String getMapName() {
        return app.getMapName();
    }

    //Cola de ordenes custom

    @PostMapping("api/v1/orderqueue/{type}")
    public void queueOrder(@PathVariable String type, @RequestParam(required = false) Map<String, Object> arguments) {
        arguments.put("delete","false");
        app.queueOrder(type, arguments);
    }

//    @GetMapping("api/v1/orderqueue/pending_orders")
//    public Order getNextQueuedOrder() {
//        return app.getNextQueuedOrder();
//    }

    @GetMapping("api/v1/orderqueue")
    public Queue<Order> getCustomQueue() {
        return app.getCustomQueue();
    }



    @GetMapping("api/v1/clearqueues")
    public void clearQueues() {
        app.clearQueues();
    }

    @GetMapping("api/v1/startcustomqueue")
    public void startOrderQueue() {
        System.out.println("Empezando customqueue");
        app.setOrderQueue();
    }


    @PostMapping("api/v1/file/map")
    public void storeMap(@RequestBody byte[] mapData) {
        System.out.println("Mapa recibido");
        app.saveMap(mapData);
    }


}
