package com.lance.demo.esper.config;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;

public class EsperConfig {
    public void config() {
        Configuration config = new Configuration();
        config.addEventTypeAutoName("org.myapp.event");
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
    }
}
