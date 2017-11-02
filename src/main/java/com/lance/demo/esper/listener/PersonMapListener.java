package com.lance.demo.esper.listener;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class PersonMapListener implements UpdateListener {
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        if (newEvents != null) {
            Integer age = (Integer) newEvents[0].get("age");
            System.out.println("age is:"+age);
        }
    }
}
