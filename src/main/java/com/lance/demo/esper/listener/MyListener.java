package com.lance.demo.esper.listener;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyListener implements UpdateListener {

    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        EventBean event = newEvents[0];
        System.out.println("avg=" + event.get("avg(price)"));
        log.info("avg={}",event.get("avg(price)"));
    }
}
