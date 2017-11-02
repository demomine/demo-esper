package com.lance.demo.esper.service;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.lance.demo.esper.event.ProcessInsertStreamEvent;
import com.lance.demo.esper.listener.ProcessListener;

public class Filter {
    public void filter() {
        Configuration config = new Configuration();
        config.addEventTypeAutoName("com.lance.demo.esper.event.ProcessInsertStreamEvent");

        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
        String expression = "select sum(price) from com.lance.demo.esper.event.ProcessInsertStreamEvent(price>5).win:length(5)";
        EPStatement statement = epService.getEPAdministrator().createEPL(expression);
        ProcessListener listener = new ProcessListener();
        statement.addListener(listener);

        ProcessInsertStreamEvent processInsertStreamEvent = new ProcessInsertStreamEvent(5);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        processInsertStreamEvent = new ProcessInsertStreamEvent(10);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        processInsertStreamEvent = new ProcessInsertStreamEvent(5);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        processInsertStreamEvent = new ProcessInsertStreamEvent(10);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);

        processInsertStreamEvent = new ProcessInsertStreamEvent(5);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        processInsertStreamEvent = new ProcessInsertStreamEvent(5);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        processInsertStreamEvent = new ProcessInsertStreamEvent(5);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        processInsertStreamEvent = new ProcessInsertStreamEvent(5);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        processInsertStreamEvent = new ProcessInsertStreamEvent(5);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        processInsertStreamEvent = new ProcessInsertStreamEvent(5);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);



    }

    public void where() {
        Configuration config = new Configuration();
        config.addEventTypeAutoName("com.lance.demo.esper.event.ProcessInsertStreamEvent");

        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
        String expression = "select sum(price) from com.lance.demo.esper.event.ProcessInsertStreamEvent.win:length(5) where price>10";
        EPStatement statement = epService.getEPAdministrator().createEPL(expression);
        ProcessListener listener = new ProcessListener();
        statement.addListener(listener);

        ProcessInsertStreamEvent processInsertStreamEvent = new ProcessInsertStreamEvent(10);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        processInsertStreamEvent = new ProcessInsertStreamEvent(20);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        processInsertStreamEvent = new ProcessInsertStreamEvent(10);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        processInsertStreamEvent = new ProcessInsertStreamEvent(20);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);

        processInsertStreamEvent = new ProcessInsertStreamEvent(10);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        processInsertStreamEvent = new ProcessInsertStreamEvent(10);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        processInsertStreamEvent = new ProcessInsertStreamEvent(10);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        processInsertStreamEvent = new ProcessInsertStreamEvent(10);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        processInsertStreamEvent = new ProcessInsertStreamEvent(10);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        processInsertStreamEvent = new ProcessInsertStreamEvent(10);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
    }


}
