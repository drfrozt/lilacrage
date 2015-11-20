/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.applesandberries.ui;

import com.applesandberries.device.Config;
import com.applesandberries.eventListener.menuListener;
import com.codename1.components.MultiButton;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

//private 

/**
 *
 * @author drfrozt
 */
public class frmMain extends Form implements ActionListener{

    private MultiButton mtiMarker;
    private MultiButton mtiNavigator;    
    private MultiButton mtiAbout;
    
    private Command comMarker;
    private Command comNavigator;
    private Command comAbout;
    private Command exit;
    
    private Container menucontainer;
    
    
    private menuListener listener;
    
    
    public frmMain()
    {
            
        super("XY pro alpha");
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
         
        init();
                
        menucontainer.addComponent(mtiMarker);   
        menucontainer.addComponent(mtiNavigator);       
        menucontainer.addComponent(mtiAbout);
       
        addCommand(exit);
        setBackCommand(exit);
        
        addComponent(menucontainer);
        
    }
    
    public void setListener(menuListener listener)
    {
        this.listener = listener;
    }
    
    
    
    public void init()
    {
        menucontainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         
        comMarker = new Command("mkr_code");
        
        mtiMarker = new MultiButton();
        mtiMarker.setTextLine1("Marker");  
        mtiMarker.setTextLine3("Mark Establishments");
        mtiMarker.setCommand(comMarker);  
        mtiMarker.addActionListener(this);
        
        comNavigator = new Command ("nav_code");
        
        mtiNavigator = new MultiButton();
        mtiNavigator.setTextLine1("Navigator");
        mtiNavigator.setTextLine3("Locate Establishments");
        mtiNavigator.setCommand(comNavigator);
        mtiNavigator.addActionListener(this);
        
        comAbout = new Command ("about");
        
        mtiAbout = new MultiButton();
        mtiAbout.setTextLine1("About");
        mtiAbout.setCommand(comAbout);
        mtiAbout.addActionListener(this);
        
                
        exit = new Command("Exit"){
            public void actionPerformed(ActionEvent ev) {
                if (Dialog.show(Config.APPNAME,"Do you want to exit "+Config.APPNAME+"?","Ok" ,"Cancel")){
                    System.exit(0);
                }
            } 
        };

        

    }

    public void actionPerformed(ActionEvent evt) {
    
        if (evt.getSource().equals(comMarker)){
            listener.markerSelected();
        }else if (evt.getSource().equals(comNavigator)){
            listener.navigatorSelected();
        }else if (evt.getSource().equals(comAbout)){
            listener.aboutSelected();             
        }       
    }


    
    
}
