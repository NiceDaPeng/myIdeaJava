package domain;

public class IDCard {

    private String cardid;
    private String address;
    private Person person;//为了业务的需求放了一个关联属性。
    //通过一个cardid查询一个身份证信息和与其关联的人的信息；

    public IDCard() {
    }

    public IDCard(String cardid, String address,Person person) {

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
