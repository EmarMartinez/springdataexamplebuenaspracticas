package com.bosonit.queueluckitest.controller;

import com.bosonit.queueluckitest.application.App;
import com.bosonit.queueluckitest.model.Order;
import com.bosonit.queueluckitest.model.Pose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Queue;

@Controller
public class ThController {

    @Autowired
    App app;

    @GetMapping("index")
    public String index(Model model) {
        System.out.println("En thymeleaf controller");
        String batteryLvl = app.getBatteryLvl();
        String mapName = app.getMapName();
        List<Pose> pointList = app.getListaPuntos();
        Queue<Order> orderQueue = app.getAllOrders();
        List<String> listaVideos = app.getListaVideos();
        Queue<Order> customOrderQueue = app.getCustomQueue();
        Order orderInProcess = app.getOrderInProcess();
        model.addAttribute("orderqueue", orderQueue);
        model.addAttribute("batteryLvl", batteryLvl);
        model.addAttribute("mapName", mapName);
        model.addAttribute("pointList", pointList);
        model.addAttribute("listaVideos", listaVideos);
        model.addAttribute("customorderqueue",customOrderQueue);
        model.addAttribute("orderinprocess",orderInProcess);
        return "main";
    }
}
