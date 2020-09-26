package leoli.pattern.memento.extend.morestate;

/**
 * 备忘录管理者
 *
 * @author leoli
 * @date 2020/9/25
 */
public class Caretaker {

    //备忘录对象
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}