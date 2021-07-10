package test;

import domain.IDCard;
import domain.Person;
import service.IDCardService;
import service.PersonService;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {

//        PersonService service = new PersonService();
//        Person person = service.selectOne(1);
//        System.out.println(person);
//        List<Person> personList = service.selectAll();
//        for (Person p :
//                personList) {
//            System.out.println(p.getPid()+"--"+p.getPname()+"--"+p.getIdCard().getCardid());
//
//        }

//        List<IDCard> cardList = service.selectAll();
//        for (IDCard idcard :
//                cardList) {
//            System.out.println(idcard);
//        }
//        IDCardService service = new IDCardService();
//        String str = "20210605";
//        IDCard idCard = service.selectOne(str);
//        System.out.println(idCard);

//        IDCardService service = new IDCardService();
//        service.selectOne("20210604");

        IDCardService service = new IDCardService();
        IDCard idCard = service.selectOne("20210604");
        System.out.println(idCard);

//        List<IDCard> idCards = service.selectAll();
//        for (IDCard card :
//                idCards) {
//            System.out.println(card);
//        }
    }
}
