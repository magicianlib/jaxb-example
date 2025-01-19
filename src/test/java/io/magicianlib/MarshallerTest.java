package io.magicianlib;

import io.magicianlib.nest.GeneratorConfiguration;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.StringWriter;

/**
 * 这种方式生成的 XML 头部有 standalone, 且无法通过配置删除. 效果如下:
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8" standalone="yes"?>
 * &lt;generatorConfiguration>
 *     &lt;table tableName="order_paid_receipt_config" domainObjectName="OrderPaidReceiptConfig">
 *         &lt;property column="username" property="Username" javaType="java.lang.String"/>
 *         &lt;property column="deleted" property="Deleted" javaType="java.lang.Integer"/>
 *         &lt;property/>
 *     &lt;/table>
 *     &lt;table tableName="order_flight" domainObjectName="OrderFlight"/>
 *     &lt;table/>
 * &lt;/generatorConfiguration>
 * </pre>
 *
 * @author Shilin <br > magicianlib@gmail.com
 * @since 2023/10/18 16:04
 */
public class MarshallerTest {
    public static void main(String[] args) {

        GeneratorConfiguration configuration = TestData.getData();

        try (StringWriter writer = new StringWriter()) {
            // 将 GeneratorConfiguration 对象序列化为 XML
            JAXBContext context = JAXBContext.newInstance(GeneratorConfiguration.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化输出
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);        //  是否禁止生成 <?xml version="1.0"?>
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");      // 设置生成的 XML 的字符编码

            System.out.println("Marshal XML:");
            marshaller.marshal(configuration, writer);
            System.out.println(writer);

            // or
            // 直接输出到控制台
            // marshaller.marshal(configuration, System.out);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
