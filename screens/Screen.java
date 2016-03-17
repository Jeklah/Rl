/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rltut.screens;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
/**
 *
 * @author arthu
 */
public interface Screen {
    public void displayOutput(AsciiPanel terminal);
    
    public Screen respondToUserInput(KeyEvent key);
}
