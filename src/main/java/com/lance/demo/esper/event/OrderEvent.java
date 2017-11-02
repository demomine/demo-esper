package com.lance.demo.esper.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
public class OrderEvent {
    private String itemName;
    private double price;
}
