package Maze;
import TriviaDataBase.*;

public class Door {

    private boolean lock;
    private Question question;

    public Door(final Question q) {
        setLock(true);
        setQuestion(q);
    }


    public Door() {
        setLock(true);
        this.question = null;
    }


    private void setLock(final boolean lock) {
        this.lock = lock;
    }


    public boolean getLock() {
        return this.lock;
    }


    public void setQuestion(final Question q) {
        this.question = q;
    }


    public Question getQuestion() {
        return this.question;
    }


    public void question(final String answer) {
        setLock(answer.equalsIgnoreCase(this.question.getAnswer()));
    }

}
