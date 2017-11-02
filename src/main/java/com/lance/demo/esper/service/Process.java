package com.lance.demo.esper.service;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.lance.demo.esper.event.ProcessInsertStreamEvent;
import com.lance.demo.esper.listener.MyListener;
import com.lance.demo.esper.listener.ProcessListener;

public class Process {
    public void insertStream() {
        Configuration config = new Configuration();
        config.addEventTypeAutoName("com.lance.demo.esper.event.ProcessInsertStreamEvent");

        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
        String expression = "select istream sum(price) from com.lance.demo.esper.event.ProcessInsertStreamEvent.win:length(5)";
        // String expression = "select avg(price) from OrderEvent#time(30 sec)";
        EPStatement statement = epService.getEPAdministrator().createEPL(expression);
        ProcessListener listener = new ProcessListener();
        statement.addListener(listener);

        ProcessInsertStreamEvent processInsertStreamEvent = new ProcessInsertStreamEvent(5.5);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
    }

    public void removeStream() {
        Configuration config = new Configuration();
        config.addEventTypeAutoName("com.lance.demo.esper.event.ProcessInsertStreamEvent");

        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
        String expression = "select rstream sum(price) from com.lance.demo.esper.event.ProcessInsertStreamEvent.win:length(5)";
        // String expression = "select avg(price) from OrderEvent#time(30 sec)";
        EPStatement statement = epService.getEPAdministrator().createEPL(expression);
        ProcessListener listener = new ProcessListener();
        statement.addListener(listener);

        ProcessInsertStreamEvent processInsertStreamEvent = new ProcessInsertStreamEvent(3.5);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
    }

    public void iremoveStream() {
        Configuration config = new Configuration();
        config.addEventTypeAutoName("com.lance.demo.esper.event.ProcessInsertStreamEvent");

        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
        String expression = "select irstream sum(price) from com.lance.demo.esper.event.ProcessInsertStreamEvent.win:length(5)";
        // String expression = "select avg(price) from OrderEvent#time(30 sec)";
        EPStatement statement = epService.getEPAdministrator().createEPL(expression);
        ProcessListener listener = new ProcessListener();
        statement.addListener(listener);

        ProcessInsertStreamEvent processInsertStreamEvent = new ProcessInsertStreamEvent(10.5);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
        epService.getEPRuntime().sendEvent(processInsertStreamEvent);
    }
}
