package com.lance.demo.esper.listener;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class ProcessListener implements UpdateListener{
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        for (EventBean newEventBean : newEvents) {
            System.out.println("new event: "+ newEventBean.get("sum(price)"));
        }

        for (EventBean oldEventBean : oldEvents) {
            System.out.println("old event: "+ oldEventBean.get("sum(price)"));
        }
    }
}
