package Aok;

import java.util.Observable;

/**
 * AokModel 讓使用者可以做資料處理、商業邏輯的處理
 */
public abstract class AokModel extends Observable {
    /**
     * 可以生成資料物件給View來做模板綁定
     * @return View 使用的資料物件
     */
    public abstract Object generateAokData();

    /**
     * AokModel 建構子
     */
    public AokModel(){}

    /**
     * 可以新增View，當資料變動時，會透過Observer的方式通知
     * @param view
     */
    public void addView(AokView view){
        super.addObserver(view);
    }

    /**
     * 傳送更動給 Observer
     */
    public void sendDataToView(){
        this.setChanged();
        this.notifyObservers(this.generateAokData());
    }
}
