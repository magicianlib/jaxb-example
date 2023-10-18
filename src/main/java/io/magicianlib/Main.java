package io.magicianlib;

import io.magicianlib.xml.GeneratorConfiguration;
import io.magicianlib.xml.Property;
import io.magicianlib.xml.Table;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Property> properties = new ArrayList<>();
        properties.add(new Property("username", "Username", "java.lang.String"));
        properties.add(new Property("deleted", "Deleted", "java.lang.Integer"));

        List<Table> tables = new ArrayList<>();
        tables.add(new Table("order_paid_receipt_config", "OrderPaidReceiptConfig", properties));
        tables.add(new Table("order_flight", "OrderFlight")); // no properties

        GeneratorConfiguration configuration = new GeneratorConfiguration();
        configuration.setTables(tables);

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\">";
        try (StringWriter writer = new StringWriter()) {
            // 将 GeneratorConfiguration 对象序列化为 XML
            JAXBContext context = JAXBContext.newInstance(GeneratorConfiguration.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化输出
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false); // 禁用 standalone 声明
            marshaller.setProperty(Marshaller.JAXB_ENCODING, false); // 设置生成的 XML 的字符编码

            // 直接输出到控制台
            System.out.println("marshal XML:");
            marshaller.marshal(configuration, writer);
            xml = writer.toString();
            System.out.println(writer);

            // or
            // marshaller.marshal(configuration, System.out);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (StringReader reader = new StringReader(xml)) {
            // 将 GeneratorConfiguration 对象序列化为 XML
            JAXBContext context = JAXBContext.newInstance(GeneratorConfiguration.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            GeneratorConfiguration ctx = (GeneratorConfiguration) unmarshaller.unmarshal(reader);
            System.out.println(ctx.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
