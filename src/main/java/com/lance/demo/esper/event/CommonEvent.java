package com.lance.demo.esper.event;

import lombok.Getter;

import java.util.Map;
public class CommonEvent {
    public CommonEvent(Map<String,Double> map) {
        this.map = map;
    }
    @Getter
    private Map<String,Double> map;
}
