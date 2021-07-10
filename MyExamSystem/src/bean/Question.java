package bean;

import java.util.Objects;

public class Question {

    private String title;//存储题干，包含了题目和选项
    private String answer;//存储答案
    private String picture;//存储图片的路径

    public Question() {
    }

    public Question(String title, String answer) {
        this.title = title;
        this.answer = answer;
    }

    public Question(String title, String answer, String picture) {
        this.title = title;
        this.answer = answer;
        this.picture = picture;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Question{" +
                "title='" + title + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {

            return true;
        }
        if (o instanceof Question){
            Question anthorQuestion = (Question) o;
            if (this.getTitle().substring(0,this.getTitle().indexOf("<br>")).equals(((Question) o).getTitle().substring(0,((Question) o).getTitle().indexOf("<br>"))));
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getTitle().hashCode();
    }
}
