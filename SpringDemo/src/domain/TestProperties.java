package domain;

import java.util.Properties;

/**
 * 这个对象是我要管理的bean
 * bean里面有个properties属性
 *
 */
public class TestProperties {
    private Properties properties;

    public TestProperties() {
    }

    public TestProperties(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return this.properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TestProperties)) return false;
        final TestProperties other = (TestProperties) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$properties = this.getProperties();
        final Object other$properties = other.getProperties();
        if (this$properties == null ? other$properties != null : !this$properties.equals(other$properties))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TestProperties;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $properties = this.getProperties();
        result = result * PRIME + ($properties == null ? 43 : $properties.hashCode());
        return result;
    }

    public String toString() {
        return "TestProperties(properties=" + this.getProperties() + ")";
    }
}
