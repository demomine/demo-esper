package com.lance.demo.esper.service;

import com.espertech.esper.client.*;
import com.lance.demo.esper.event.OrderEvent;
import com.lance.demo.esper.listener.MyListener;
import com.lance.demo.esper.listener.PersonMapListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EsperOrder {
    public void demo() {
        Configuration config = new Configuration();
        config.addEventTypeAutoName("com.lance.demo.esper.event.OrderEvent");

        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
        String expression = "select avg(price) from com.lance.demo.esper.event.OrderEvent#time(30 sec)";
        // String expression = "select avg(price) from OrderEvent#time(30 sec)";
        EPStatement statement = epService.getEPAdministrator().createEPL(expression);
        MyListener listener = new MyListener();
        statement.addListener(listener);

        OrderEvent event = new OrderEvent("shirt", 74.50);
        OrderEvent event2 = new OrderEvent("shirt", 11.50);
        epService.getEPRuntime().sendEvent(event);
        epService.getEPRuntime().sendEvent(event2);
    }



    public void demoMap() {
        EPServiceProvider epService=EPServiceProviderManager.getDefaultProvider();
        EPAdministrator admin=epService.getEPAdministrator();

        Map<String,Object> person=new HashMap<String,Object>();
        person.put("name", String.class);
        person.put("age", int.class);
        person.put("children", List.class);
        person.put("phones", Map.class);

        admin.getConfiguration().addEventType("Person",person);
        String epl = "select age,children from Person where name='cjq'";

        EPStatement state = admin.createEPL(epl);
        state.addListener(new PersonMapListener());
        EPRuntime runtime = epService.getEPRuntime();

        Map<String,Object> person1=new HashMap<String,Object>();

        List<String> children=new ArrayList<String>();
        children.add("x");
        children.add("y");
        children.add("z");

        Map<String,Integer> phones=new HashMap<String,Integer>();
        phones.put("a", 123);
        phones.put("b", 234);
        person1.put("name","cjq");
        person1.put("age",12);
        person1.put("children", children);
        person1.put("phones", phones);

        runtime.sendEvent(person1, "Person");
    }
}
