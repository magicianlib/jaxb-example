package io.magicianlib;

import io.magicianlib.nest.GeneratorConfiguration;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import java.io.StringReader;

/**
 * 这种方式生成的 XML 头部有 standalone, 且无法删除
 *
 * @author Shilin <br > magicianlib@gmail.com
 * @since 2023/10/18 16:04
 */
public class UnmarshallerTest {
    public static void main(String[] args) {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><generatorConfiguration><table tableName=\"order_paid_receipt_config\" domainObjectName=\"OrderPaidReceiptConfig\"><property column=\"username\" property=\"Username\" javaType=\"java.lang.String\"></property><property column=\"deleted\" property=\"Deleted\" javaType=\"java.lang.Integer\"></property><property></property></table><table tableName=\"order_flight\" domainObjectName=\"OrderFlight\"></table><table></table></generatorConfiguration>";

        try (StringReader reader = new StringReader(xml)) {
            JAXBContext context = JAXBContext.newInstance(GeneratorConfiguration.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            GeneratorConfiguration ctx = (GeneratorConfiguration) unmarshaller.unmarshal(reader);

            System.out.println(ctx.getTables());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
