package io.magicianlib;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

/**
 * 这种方式生成的 XML 可以自定义头部信息. 效果如下(手动执行了格式化):
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?>
 * &lt;generatorConfiguration>
 *   &lt;table tableName="order_paid_receipt_config" domainObjectName="OrderPaidReceiptConfig">
 *     &lt;property column="username" property="Username" javaType="java.lang.String">&lt;/property>
 *     &lt;property column="deleted" property="Deleted" javaType="java.lang.Integer">&lt;/property>
 *     &lt;property>&lt;/property>
 *   &lt;/table>
 *   &lt;table tableName="order_flight" domainObjectName="OrderFlight">&lt;/table>
 *   &lt;table>&lt;/table>
 * &lt;/generatorConfiguration>
 * </pre>
 *
 * @author Shilin <br > magicianlib@gmail.com
 * @since 2023/10/18 16:04
 */
public class XMLOutputFactoryTest {
    public static void main(String[] args) {
        generateXml(TestData.getData());
    }

    public static <T> void generateXml(T obj) {
        try {
            XMLStreamWriter writer = XMLOutputFactory.newFactory().createXMLStreamWriter(System.out, "UTF-8");

            // 自定义XML头元素
            writer.writeStartDocument("UTF-8", "1.0");

            // 使用marshaller生成XML中间部分内容
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true); // 已经自定义XML头元素了, 这里不需要重复生成了
            marshaller.marshal(obj, writer); // 生成中间元素

            // 生成XML尾元素
            writer.writeEndDocument();

            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
