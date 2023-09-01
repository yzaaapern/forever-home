/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

/**
 *
 * @author annga
 */
public abstract class Interaction
{
    // Instance variables
    private String interactionName = "";
    private String interactionType = "";
    private String interactionDesc = "";
    private int levelUnlocked = 0;
    
    // Constructor
    public Interaction(String interactionName, int levelUnlocked, String interactionType, String interactionDesc)
    {
        this.interactionName = interactionName;
        this.levelUnlocked = levelUnlocked;
        this.interactionDesc = interactionDesc;
    }

    public String getInteractionName() {
        return this.interactionName;
    }

    public String getInteractionType() {
        return this.interactionType;
    }
    
    public int getLevelUnlocked() {
        return this.levelUnlocked;
    }
    
    public String getInteractionDesc()
    {
        return this.interactionDesc;
    }
    
    @Override
    public String toString()
    {
        return this.getInteractionName() + "\n\t-Type: " + this.getInteractionType() + "\n\t-Unlocked at level: " + this.getLevelUnlocked();
    }
 
}
