package com.bosonit.queueluckitest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    String action;
    Map<String, Object> arguments;
}
