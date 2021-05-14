package observerPrototype;

import java.util.Observable;


@SuppressWarnings("deprecation")
public class ObservableDemo extends Observable {
    private int myInt;
    
    public ObservableDemo() {
        myInt = 3;
    }
    
    public int getInt() {
        return myInt;
    }
    
    // notifies the observer that myInt has changed
    public void setInt(int theInt) {
         myInt = theInt;
         this.setChanged();
         this.notifyObservers("change int");
         this.clearChanged();
    }
    
}
