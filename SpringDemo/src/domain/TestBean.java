package domain;

import java.util.Map;

public class TestBean {
    private String name;
    private Computer computer;
    private Map<String,Computer> map;

    public TestBean() {
    }


    public String getName() {
        return this.name;
    }

    public Computer getComputer() {
        return this.computer;
    }

    public Map<String, Computer> getMap() {
        return this.map;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public void setMap(Map<String, Computer> map) {
        this.map = map;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TestBean)) return false;
        final TestBean other = (TestBean) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$computer = this.getComputer();
        final Object other$computer = other.getComputer();
        if (this$computer == null ? other$computer != null : !this$computer.equals(other$computer)) return false;
        final Object this$map = this.getMap();
        final Object other$map = other.getMap();
        if (this$map == null ? other$map != null : !this$map.equals(other$map)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TestBean;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $computer = this.getComputer();
        result = result * PRIME + ($computer == null ? 43 : $computer.hashCode());
        final Object $map = this.getMap();
        result = result * PRIME + ($map == null ? 43 : $map.hashCode());
        return result;
    }

    public String toString() {
        return "TestBean(name=" + this.getName() + ", computer=" + this.getComputer() + ", map=" + this.getMap() + ")";
    }
}
