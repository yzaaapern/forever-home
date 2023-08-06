/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package foreverhome;

/**
 *
 * @author yzape
 * Name: Yza Pernia
 * Student ID: 21137984
 * Date Created: 06/08/2023
 * 
 * The Interact interface is a collection of required methods that the Animal subclass must have.
 * These methods consist of the interactions the animal rescue must have with its foster caretaker(player)
 * to increase its happiness and level exp.
 */
public interface Interact {
    
    public void givePat();
    
    public void playWithFoster();
    
    public void goPotty();
    
    public void bow();
    
    public void shakeHands();
    
    public void spin();
    
    public void playDead();
    
    public void fetch();
    
}
