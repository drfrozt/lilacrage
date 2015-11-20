/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.applesandberries.ui;

import com.applesandberries.device.Config;
import com.applesandberries.device.mobileDevice;
import com.applesandberries.eventListener.gpsListener;
import com.applesandberries.eventListener.markerListener;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author drfrozt
 */
public class frmMarker extends Form implements ActionListener{
    
    private Container conmarker;
    private Container conbutton;
    
    private Button btngetlocaton;
    private Button btnsend;
    private Image est_picture;
    
    private Command back;
    private Command getloc;
    private Command submit;
    
    private String img_path="";
    
    private gpsListener gpslistener;
    private markerListener listener;
    
    private Double longitude;
    private Double latitude;
    
    private mobileDevice device;
    
    
    
    public void setEstImage(String path){
        this.img_path = path;
        //Dialog.show(Config.APPNAME,img_path,"Ok" ,null); 
        
       // est_picture = URLImage.create(img_path);
        System.out.print("000"+img_path+"000");
    }
   
    
    public void setGPSListener(gpsListener gpslistener)
    {
        this.gpslistener = gpslistener;
        
        device = new mobileDevice();
          
        device.setGsmListener(gpslistener);
    }
    
    public void setListener(markerListener listener)
    {
        this.listener=listener;
    }
    
    
    public void init()
    {
        conmarker = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        conmarker.addComponent(new Label("Establishment Image"+img_path));
        
        //System.out.print("111"+img_path+"111");
        //conimage = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        //Dialog.show(Config.APPNAME,img_path,"Ok" ,null); 


//uncomment to display image        
//        try {
//            //est_picture = Image.createImage(img_path);
//            est_picture = URLImage.create(img_path);
//            //conimage.addComponent(est_picture);
//        } catch (IOException ex) {
//            Dialog.show(Config.APPNAME,img_path,"Ok" ,null);       
//
//            //Logger.getLogger(frmMarker.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        conbutton = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        btngetlocaton = new Button();
        btngetlocaton.addActionListener(this);
        
        getloc = new Command("Mark Location");       
        btngetlocaton.setCommand(getloc);
        
        
        btnsend = new Button();
        btnsend.addActionListener(this);
        
        submit = new Command("Submit");     
        btnsend.setCommand(submit);
               
        

        
                        
        back = new Command("Back"){
        
            public void actionPerformed(ActionEvent ev) {
                listener.showMainMenu();
            } 
        };
        
              
        
        conbutton.addComponent(btngetlocaton);   
        conbutton.addComponent(btnsend);
    }
    
    
    public frmMarker()
    {
                
        super("Tag Establishment");
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
         
        init();
      
        conmarker.addComponent(conbutton);
       
        addCommand(back);
        setBackCommand(back);
      
        addComponent(conmarker);
    }

    public void actionPerformed(ActionEvent evt) {
        
        if(evt.getSource().equals(getloc)){
            device.GetGPSLocation();         
        }else if(evt.getSource().equals(submit)){
            Dialog.show(Config.APPNAME,"Data to be sent","Ok" ,null); 
            
            //call the send procedure
            
            //new frmMain().showBack();
            
        }
        
    }

//    public void GPSCoordinatedReceived(Location loc) {
//
//        longitude= loc.getLongitude();
//        latitude= loc.getLatitude();
//        
//        Dialog.show(Config.APPNAME,longitude.toString()+" "+latitude.toString(),"Ok" ,null); 
//    }



    
}
