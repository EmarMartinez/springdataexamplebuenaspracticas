package com.bosonit.queueluckitest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.LinkedList;
import java.util.Queue;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderQueue {
    Queue<Order> queue = new LinkedList<>();

    public Order getNextOrder() {
        Order order = this.queue.poll();
        if(order!=null && order.getArguments().get("delete").equals("false")) {
            queue.add(order);
        }
        return order;

    }

    public void pushOrder(Order order) {
        this.queue.add(order);
    }

    public Order consumeOrderAndRequeue() {
        Order order = this.queue.poll();
        this.queue.add(order);
        return order;
    }


    public Order getAndDeleteOrder() {
        return this.queue.poll();
    }
}
