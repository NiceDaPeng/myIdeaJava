package domain;

public class Room {
    private String name;
    private Computer computer;

    public Room() {
    }

    public Room(String name, Computer computer) {
        this.name = name;
        this.computer = computer;
    }

    public String getName() {
        return this.name;
    }

    public Computer getComputer() {
        return this.computer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Room)) return false;
        final Room other = (Room) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$computer = this.getComputer();
        final Object other$computer = other.getComputer();
        if (this$computer == null ? other$computer != null : !this$computer.equals(other$computer)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Room;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $computer = this.getComputer();
        result = result * PRIME + ($computer == null ? 43 : $computer.hashCode());
        return result;
    }

    public String toString() {
        return "Room(name=" + this.getName() + ", computer=" + this.getComputer() + ")";
    }
}
