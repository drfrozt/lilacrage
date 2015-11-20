/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.applesandberries.device;

import com.applesandberries.eventListener.gpsListener;
import com.codename1.capture.Capture;
import com.codename1.components.InfiniteProgress;
import com.codename1.location.Location;
import com.codename1.location.LocationListener;
import com.codename1.location.LocationManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;

/**
 *
 * @author drfrozt
 */
public class mobileDevice {
    
    gpsListener listener;
    private Double longitude;
    private Double latitude;
    
    public mobileDevice()
    {
        
    }
    
    
    public void setGsmListener(gpsListener listener)
    {
        this.listener = listener;
    }
    
    
    public String takePhotograph()
    {   
       return Capture.capturePhoto(-1, -1);        
    }
         
    
    public void GetGPSLocation()
    {
        final InfiniteProgress loading = new InfiniteProgress();
        final Dialog dlg = loading.showInifiniteBlocking();
        
        final LocationManager lmgr = LocationManager.getLocationManager();
        
        
        
        lmgr.setLocationListener(new LocationListener() {

            public void locationUpdated(Location location) {
                
                if (Display.getInstance().getCurrent()==dlg){
                    dlg.dispose();
                }
               
                location = lmgr.getCurrentLocationSync(60000);
                
                if (location.getStatus()==LocationManager.AVAILABLE){                     
                    listener.GPSCoordinatedReceived(location);
                }
                
            }

            public void providerStateChanged(int newState) {
               
                if (Display.getInstance().getCurrent()==dlg){
                    dlg.dispose();
                }
                //function to return updated postion. Not yet in use
            }
        });
        
       
        
    }


    
}
