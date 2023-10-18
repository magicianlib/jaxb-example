package io.magicianlib;

import io.magicianlib.nest.GeneratorConfiguration;
import io.magicianlib.nest.Property;
import io.magicianlib.nest.Table;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static GeneratorConfiguration getData() {
        List<Property> properties = new ArrayList<>();
        properties.add(new Property("username", "Username", "java.lang.String"));
        properties.add(new Property("deleted", "Deleted", "java.lang.Integer"));
        properties.add(new Property());

        List<Table> tables = new ArrayList<>();
        tables.add(new Table("order_paid_receipt_config", "OrderPaidReceiptConfig", properties));
        tables.add(new Table("order_flight", "OrderFlight")); // no properties
        tables.add(new Table()); // no properties

        GeneratorConfiguration configuration = new GeneratorConfiguration();
        configuration.setTables(tables);
        return configuration;
    }
}
