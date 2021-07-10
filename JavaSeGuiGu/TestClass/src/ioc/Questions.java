package ioc;

public class Questions {

    private String title;
    private String answer;

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

    public Questions(String title, String answer) {
        this.title = title;
        this.answer = answer;
    }

    public Questions() {
    }

    @Override
    public String toString() {
        return "Questions{" +
                "title='" + title + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
