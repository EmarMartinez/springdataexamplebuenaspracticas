package com.bosonit.queueluckitest.application;

import com.bosonit.queueluckitest.model.*;
import com.bosonit.queueluckitest.repository.ArchivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Queue;

@Component
public class App {

    StatusUpdate statusUpdate = new StatusUpdate();
    OrderQueue orderQueue = new OrderQueue();

    OrderQueue customOrderQueue = new OrderQueue();

    Order orderInProcess ;
    @Autowired
    ArchivoRepository archivoRepository;

    public Order getOrderInProcess() {
        return orderInProcess;
    }

    public void setOrderInProcess(Order orderInProcess) {
        this.orderInProcess = orderInProcess;
    }

    public void pickOrder(String type, Map<String,Object> arguments) {
        Order order = new Order();
        order.setAction(type);
        order.setArguments(arguments);
        orderQueue.pushOrder(order);
        System.out.println(orderQueue);

    }

    public Order getNextOrder() {
        Order order = orderQueue.getNextOrder();
        System.out.println(orderQueue);
        orderInProcess = order;
        return order;
    }

    public Queue<Order> getAllOrders() {
        return orderQueue.getQueue();
    }

    public void setStatus(StatusUpdate statusUpdate) {
        this.statusUpdate = statusUpdate;
    }

    public String getBatteryLvl() {
        return statusUpdate.getBatteryLevel();
    }

    public StatusUpdate getStatus() {
        return statusUpdate;
    }

    public void setBatteryLevel(String batterylevel) {
        this.statusUpdate.setBatteryLevel(batterylevel);
    }

    public List<Pose> getListaPuntos() {
        return this.statusUpdate.getListaPuntos();
    }

    public String getMapName() {
        return this.statusUpdate.getMapName();
    }

    public List<String> getListaVideos() {
        return this.statusUpdate.getListaVideos();
    }

    //custom queue

    public void queueOrder(String type, Map<String,Object> arguments) {
        Order order = new Order();
        order.setAction(type);
        order.setArguments(arguments);
        customOrderQueue.pushOrder(order);
        System.out.println(customOrderQueue);
    }

    public Order getNextQueuedOrder() {
        return orderInProcess = this.customOrderQueue.consumeOrderAndRequeue();
    }

    public Queue<Order> getCustomQueue() {
        return this.customOrderQueue.getQueue();
    }

    public void clearQueues() {
        this.customOrderQueue = new OrderQueue();
        this.orderQueue = new OrderQueue();
    }

    public void setOrderQueue() {

        this.orderQueue = new OrderQueue();
        orderQueue = customOrderQueue;
        customOrderQueue = new OrderQueue();
        }


    public void saveMap(byte[] mapData) {
        Archivo archivo = new Archivo();
//        archivo.setName(name);
        archivo.setData(mapData);
        archivoRepository.save(archivo);
        System.out.println("Mapa guardado");
    }
}
