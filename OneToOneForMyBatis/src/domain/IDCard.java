package domain;

public class IDCard {

    private String cardid;
    private String address;
    private Person person;

    public IDCard() {
    }

    public IDCard(String cardid, String address, Person person) {

        this.cardid = cardid;
        this.address = address;
        this.person = person;
    }

    public String getCardid() {

        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "IDCard{" +
                "cardid='" + cardid + '\'' +
                ", address='" + address + '\'' +
                ", person=" + person +
                '}';
    }
}
