package model;

public class Door {
    /**
     * Whether or not this door is currently locked.
     */
    private boolean myIsLocked;
    
    
    public Door() {
        myIsLocked = true;
    }
    
    public String toString() {
        return "I am a door";
    }
}
