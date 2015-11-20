package com.applesandberries.xy;


import com.applesandberries.device.Config;
import com.applesandberries.device.mobileDevice;
import com.applesandberries.eventListener.cameraListener;
import com.applesandberries.eventListener.gpsListener;
import com.applesandberries.eventListener.markerListener;
import com.applesandberries.eventListener.menuListener;
import com.applesandberries.eventListener.naviListener;
import com.applesandberries.ui.frmMain;
import com.applesandberries.ui.frmMarker;
import com.applesandberries.ui.frmNavigator;
import com.codename1.location.Location;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
//import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;

public class xymain implements menuListener,cameraListener,gpsListener,markerListener,naviListener{

    private Form current;
    
    private frmMain mainMenu;
    private frmMarker marker;
    private frmNavigator finder; 
    
    private Double longitude;
    private Double latitude;
    
    private boolean loc_received = false;

    public void init(Object context) {
        try {
            Resources theme = Resources.openLayered("/theme");
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
        } catch(IOException e){
            e.printStackTrace();
        }
        // Pro users - uncomment this code to get crash reports sent to you automatically
        /*Display.getInstance().addEdtErrorHandler(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                evt.consume();
                Log.p("Exception in AppName version " + Display.getInstance().getProperty("AppVersion", "Unknown"));
                Log.p("OS " + Display.getInstance().getPlatformName());
                Log.p("Error " + evt.getSource());
                Log.p("Current Form " + Display.getInstance().getCurrent().getName());
                Log.e((Throwable)evt.getSource());
                Log.sendLog();
            }
        });*/
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
       
        mainMenu = new frmMain();
        mainMenu.setListener(this);
        mainMenu.show();       
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
    }
    
    public void destroy() {
    }

    public void navigatorSelected() {    
        finder = new frmNavigator();
        finder.setListener(this);
        finder.show();
        
        //Dialog.show(Config.APPNAME,"Navigator Selected","Ok" ,null);
    }

    public void aboutSelected() {
        Dialog.show(Config.APPNAME, Config.ABOUT_MSG, "Ok", null);
    }

    public void markerSelected() {
        //take a picture of the establishment.
        getEstImage();
    }

    public void getEstImage() {
        
        String path = new mobileDevice().takePhotograph();
       
        marker = new frmMarker();
        marker.setEstImage(path);
        
        marker.setGPSListener(this);
        marker.setListener(this);
        marker.show();      
    }

    public void GPSCoordinatedReceived(Location loc) {

        if(!loc_received)
        {
            UpdateCoordinates(loc);
        }

    }
    
    

    
    public void UpdateCoordinates(Location loc)
    {
        longitude= loc.getLongitude();
        latitude= loc.getLatitude();
        
        loc_received = true;
        
        //Dialog.show(Config.APPNAME,longitude.toString()+" "+latitude.toString(),"Ok" ,null); 
        
        
        
        System.out.println("Locatoin: lon: "+longitude.toString()+" lat: "+latitude.toString());
    }

    public void showMainMenu() {
        mainMenu.showBack();
    }

    public void n_showMainMenu() {
        mainMenu.showBack();
    }


}
