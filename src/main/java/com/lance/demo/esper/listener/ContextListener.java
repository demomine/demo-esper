package com.lance.demo.esper.listener;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class ContextListener implements UpdateListener{
    //不需要添加context
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        System.out.println("context event :  "+newEvents[0].get("sum(age)"));
    }
}
