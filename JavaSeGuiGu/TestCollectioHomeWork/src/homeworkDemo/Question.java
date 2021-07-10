package homeworkDemo;

public class Question {

    private String title;
    private String answer;

    public Question(String title,String answer){
        this.title = title;
        this.answer = answer;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAnswer(){
        return this.answer;
    }

    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if (obj instanceof Question){
            Question antherQuestion = (Question)obj;
            if (antherQuestion.getTitle().equals(this.title)){
                return true;
            }
        }

        return false;
    }

    public int hashCode(){
        return this.title.hashCode();
    }
}
