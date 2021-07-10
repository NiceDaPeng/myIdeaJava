package domain;

import java.util.List;

public class Room {

    private String name;
    private List<Computer> computerList;

    public Room() {
    }

    public String getName() {
        return this.name;
    }

    public List<Computer> getComputerList() {
        return this.computerList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComputerList(List<Computer> computerList) {
        this.computerList = computerList;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Room)) return false;
        final Room other = (Room) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$computerList = this.getComputerList();
        final Object other$computerList = other.getComputerList();
        if (this$computerList == null ? other$computerList != null : !this$computerList.equals(other$computerList))
            return false;
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
        final Object $computerList = this.getComputerList();
        result = result * PRIME + ($computerList == null ? 43 : $computerList.hashCode());
        return result;
    }

    public String toString() {
        return "Room(name=" + this.getName() + ", computerList=" + this.getComputerList() + ")";
    }
}
