package domain;

import java.util.List;

public class Room {
    private String name;
    private List<Computer> computerList;

    public Room() {
    }

    public Room(String name, List<Computer> computerList) {
        this.name = name;
        this.computerList = computerList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Computer> getComputerList() {
        return computerList;
    }

    public void setComputerList(List<Computer> computerList) {
        this.computerList = computerList;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", computerList=" + computerList +
                '}';
    }
}
