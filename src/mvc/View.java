package mvc;
import javax.swing.*;

public class View extends JPanel implements Subscriber{
    Model model;

    public View(Model model){
        this.model = model;
        this.model.subscribe(this);
    }

    public void setView(Model newModel){
        model.unsubscribe(this);
        model = newModel;
        model.subscribe(this);
        update();
    }

    @Override
    public void update(){
        repaint();
    }
}
