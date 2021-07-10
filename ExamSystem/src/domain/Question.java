package domain;

import java.util.Objects;

public class Question {

    private String title;
    private String answer;

    public Question() {
    }

    public Question(String title, String answer) {
        this.title = title;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
       if (this == o){
           return true;
       }
       if (o instanceof Question){
           Question value = (Question) o;
           String thisQuestion = this.getTitle().substring(0, this.getTitle().indexOf("<br>"));
           String anthorQuestion = value.getTitle().substring(0,value.getTitle().indexOf("<br>"));
           if (thisQuestion.equals(anthorQuestion)){
               return true;
           }
       }
       return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, answer);
    }
}
