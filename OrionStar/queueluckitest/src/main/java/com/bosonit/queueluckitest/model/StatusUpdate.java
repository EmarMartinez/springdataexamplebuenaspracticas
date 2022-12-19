package com.bosonit.queueluckitest.model;

import java.util.List;

public class StatusUpdate {
    String batteryLevel;
    List<Pose> listaPuntos;
    String mapName;

    List<String> listaVideos;

    public List<String> getListaVideos() {
        return listaVideos;
    }

    public void setListaVideos(List<String> listaVideos) {
        this.listaVideos = listaVideos;
    }

    public StatusUpdate(String batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public StatusUpdate() {
    }

    public StatusUpdate(String batteryLevel, List<Pose> listaPuntos, String mapName, List<String> listaVideos) {
        this.batteryLevel = batteryLevel;
        this.listaPuntos = listaPuntos;
        this.mapName = mapName;
        this.listaVideos = listaVideos;
    }

    public String getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(String batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public String toString() {
        return "StatusUpdate{" +
                "batteryLevel='" + batteryLevel + '\'' +
                ", listaPuntos=" + listaPuntos +
                ", mapName='" + mapName + '\'' +
                ", listaVideos=" + listaVideos +
                '}';
    }

    public List<Pose> getListaPuntos() {
        return listaPuntos;
    }

    public void setListaPuntos(List<Pose> listaPuntos) {
        this.listaPuntos = listaPuntos;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }
}
