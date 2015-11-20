/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.applesandberries.ui;

import com.applesandberries.device.Config;
import com.applesandberries.eventListener.naviListener;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author drfrozt
 */
public class frmNavigator extends Form implements ActionListener{
    
    private Container connavi;
    //private Container conbutton;
    private Container conestinfo;
    
    private TextField estinfo;
    private Label lbltype;
    
    private ButtonGroup selection;
    private RadioButton rd_name;
    private RadioButton rd_old_er;
    private RadioButton rd_new_er;
   
    private Button btngetlocaton;
    
    private Command getloc;
    private Command back;
    private Command cmd_name;
    private Command cmd_old_erno;
    private Command cmd_erno;
    
    private naviListener listener;
    
    
    public frmNavigator()
    {
        super("Locate Establishment");
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
         
        init();
      
        
        connavi.addComponent(conestinfo);
        
        //connavi.addComponent(conbutton);
       
        
        
        addCommand(back);
        setBackCommand(back);
      
        addComponent(connavi);
        
    }
    
    
    private void init()
    {
                
        connavi = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        //conbutton = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        conestinfo = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        
        estinfo = new TextField();
        lbltype = new Label("ER. Number");
        
        
        
        
        selection = new ButtonGroup();
        rd_name= new RadioButton("Establishment Name");
        rd_old_er = new RadioButton("Old ER. Number");
        rd_new_er = new RadioButton("ER. Number");
        
        selection.add(rd_new_er);
        selection.add(rd_old_er);
        selection.add(rd_name);
        
        selection.setSelected(rd_new_er);
        
        conestinfo.addComponent(lbltype);
        conestinfo.addComponent(estinfo);
        conestinfo.addComponent(rd_new_er);
        conestinfo.addComponent(rd_old_er);        
        conestinfo.addComponent(rd_name);
        
   
        cmd_erno = new Command("ER. Number");
        cmd_name = new Command("Est. Name");
        cmd_old_erno = new Command("Old ER. Number");
        
        rd_new_er.setCommand(cmd_erno);
        rd_new_er.addActionListener(this);
        
        rd_old_er.setCommand(cmd_old_erno);
        rd_old_er.addActionListener(this);
        
        rd_name.setCommand(cmd_name);
        rd_name.addActionListener(this);
        
        
        btngetlocaton = new Button();
        btngetlocaton.addActionListener(this);
        
        getloc = new Command("Find");
        btngetlocaton.setCommand(getloc);
        
        conestinfo.addComponent(btngetlocaton);
        
                
        back = new Command("Back"){
        
            public void actionPerformed(ActionEvent ev) {
                listener.n_showMainMenu();
            } 
        };
        
        
                
        //conbutton.addComponent(btngetlocaton);   
    }
    
    
    public void setListener(naviListener listener){
        this.listener = listener;
    }

    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource().equals(getloc)){
            Dialog.show(Config.APPNAME,"Data to be sent","Ok" ,null); 
        }else if(evt.getSource().equals(cmd_name)){
            lbltype.setText("Name :");
        }else if(evt.getSource().equals(cmd_erno)){
            lbltype.setText("Er. Number :");
        }else if(evt.getSource().equals(cmd_old_erno)){
            lbltype.setText("Old Er. Number :");
        }
        
    }
            
    
}
