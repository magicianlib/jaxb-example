package io.magicianlib.nest;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8" standalone="yes"?>
 * &lt;generatorConfiguration>
 *   &lt;table tableName="table_name" domainObjectName="TableName">
 *     &lt;property column="username" property="Username"/>
 *     &lt;property column="deleted" property="Deleted" javaType="java.lang.Integer"/>
 *   &lt;/table>
 * &lt;/generatorConfiguration>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Property {

    @XmlAttribute(required = true)
    private String column;

    @XmlAttribute(required = true)
    private String property;

    @XmlAttribute
    private String javaType;

    public Property() {
    }

    public Property(String column, String property, String javaType) {
        this.column = column;
        this.property = property;
        this.javaType = javaType;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    @Override
    public String toString() {
        return "Property{" +
                "column='" + column + '\'' +
                ", property='" + property + '\'' +
                ", javaType='" + javaType + '\'' +
                '}';
    }
}
