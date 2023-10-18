package io.magicianlib.xml;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8" standalone="yes"?>
 * &lt;generatorConfiguration>
 *   &lt;table tableName="table_name" domainObjectName="TableName">
 *     // ...
 *   &lt;/table>
 * &lt;/generatorConfiguration>
 * </pre>
 * <p>
 * <code>@XmlAttribute</code>用于标记该字段是XML元素的一个属性, 另外还可以做更细粒度的控制:
 * <ul>
 *     <li>使用 required 标记是否为必填项</li>
 *     <li>使用 name 控制属性名</li>
 * </ul>
 * </p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Table {

    @XmlAttribute(required = true)
    private String tableName;

    @XmlAttribute
    private String domainObjectName;

    @XmlElement(name = "property")
    private List<Property> properties;

    public Table() {
    }

    public Table(String tableName, String domainObjectName) {
        this.tableName = tableName;
        this.domainObjectName = domainObjectName;
    }

    public Table(String tableName, String domainObjectName, List<Property> properties) {
        this.tableName = tableName;
        this.domainObjectName = domainObjectName;
        this.properties = properties;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDomainObjectName() {
        return domainObjectName;
    }

    public void setDomainObjectName(String domainObjectName) {
        this.domainObjectName = domainObjectName;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
