package observerPrototype;

import java.util.Scanner;

public class ObserverTest {
    
    @SuppressWarnings("deprecation")
    public static void main(final String[] theArgs) {
        ObservableDemo observable = new ObservableDemo();
        ObserverDemo observer = new ObserverDemo();
        
        observable.addObserver(observer);
        observable.setInt(66);
        observable.setInt(67);
        observable.setInt(68);
        observable.setInt(69);
          
    }
    
}
