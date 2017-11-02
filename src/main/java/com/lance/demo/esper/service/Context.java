package com.lance.demo.esper.service;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.lance.demo.esper.event.ContextEvent;
import com.lance.demo.esper.listener.ContextListener;

public class Context {
    public void context() {
        Configuration config = new Configuration();
        config.addEventTypeAutoName("com.lance.demo.esper.event.ContextEvent");

        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
        String context = "create context contextDemo partition by name from com.lance.demo.esper.event.ContextEvent";
        epService.getEPAdministrator().createEPL(context);

        String expression = "context contextDemo select sum(age)  from com.lance.demo.esper.event.ContextEvent";
        // String expression = "select name from com.lance.demo.esper.event.ContextEvent";
        EPStatement statement = epService.getEPAdministrator().createEPL(expression);
        ContextListener listener = new ContextListener();
        statement.addListener(listener);

        ContextEvent contextEvent = new ContextEvent("lance", 10);
        epService.getEPRuntime().sendEvent(contextEvent);

        contextEvent = new ContextEvent("lance", 20);
        epService.getEPRuntime().sendEvent(contextEvent);

        contextEvent = new ContextEvent("perdonare", 20);
        epService.getEPRuntime().sendEvent(contextEvent);

        contextEvent = new ContextEvent("lance", 30);
        epService.getEPRuntime().sendEvent(contextEvent);
    }
}
