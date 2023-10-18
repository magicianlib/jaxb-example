package io.magicianlib.nest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8" standalone="yes"?>
 * &lt;generatorConfiguration>
 *   &lt;table>
 *     // ...
 *   &lt;/table>
 * &lt;/generatorConfiguration>
 * </pre>
 * <p>
 * <code>@XmlAccessorType</code>用于控制Java类中的字段或属性如何映射到XML元素或属性的JAXB注解。
 * 主要有三种<code>@XmlAccessorType</code>的值:
 * <ul>
 *     <li><code>XmlAccessType.FIELD</code>表示JAXB使用字段名映射XML元素或属性(可以通过在字段上加 <code>@XmlElement</code> 注解修改XML元素或属性)。</li>
 *     <li><code>XmlAccessType.PROPERTY</code>表示JAXB使用setter和getter映射XML元素或属性(可以通过在getter上加 <code>@XmlElement</code> 注解修改XML元素或属性)。</li>
 *     <li><code>XmlAccessType.PUBLIC_MEMBER</code>表示JAXB使用public字段setter/getter方法映射XML元素或属性。</li>
 * </ul>
 * </p>
 * <p>
 * <code>@XmlElement</code>用于(通过name属性)自定义映射到XML元素名以及如何从XML数据中解析数据。除此之外, 还可以:
 * <ul>
 *     <li>使用 required 标记是否为必填项</li>
 *     <li>使用 order 控制XML元素顺序</li>
 *     <li>使用 nillable 指示字段或属性是否可以包含空值</li>
 *     <li>使用 type 显式指定数据类型</li>
 * </ul>
 * </p>
 */
@XmlRootElement(name = "generatorConfiguration")
@XmlAccessorType(XmlAccessType.FIELD)
public class GeneratorConfiguration {

    @XmlElement(name = "table")
    private List<Table> tables;

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    @Override
    public String toString() {
        return "GeneratorConfiguration{" +
                "tables=" + tables +
                '}';
    }
}
