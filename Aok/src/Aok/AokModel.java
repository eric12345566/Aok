package Aok;

import java.util.Observable;

public abstract class AokModel extends Observable {

    public abstract AokData generateAokData();

    public AokModel(){}

    public void addView(AokView view){
        super.addObserver(view);
    }

    public void sendDataToView(){
        this.setChanged();
        this.notifyObservers(this.generateAokData());
    }
}
