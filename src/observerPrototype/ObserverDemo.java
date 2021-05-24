/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */

package observerPrototype;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class ObserverDemo implements Observer {
    
    // runs when the passed observable object notifies that a change was made
    @Override
    public void update(Observable observable, Object thePassedObj) {
        System.out.println("int has changed to " + ((ObservableDemo) observable).getInt());
        
        
       
    }
    
}