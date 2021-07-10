package homework;

public class QuentionsBank {

    private String title;
    private String answer;

    public QuentionsBank(String title,String answer){
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

        if (obj instanceof QuentionsBank){
            QuentionsBank anotherQuestion = (QuentionsBank)obj;
            if (anotherQuestion.getTitle().equals(this.getAnswer())){
                return true;
            }
        }

        return false;
    }

    public int hashCode(){
        return this.title.hashCode();
    }
}
