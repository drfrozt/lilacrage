/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.applesandberries.data;

import com.codename1.ui.Image;

/**
 *
 * @author drfrozt
 */
public class CombData {
    
    private Double longitude;
    private Double latitude;  
    private Image est_image;

    
    public CombData()
    {
        
    }
    
    public CombData(Double longitude, Double latitude, Image est_image) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.est_image = est_image;
    }
    
    
    
    
    public double getLongitude(){
        return this.longitude;
    }
    public void setLongitude(double lon){
        this.longitude = lon;
    }
    
    public double getLatitude(){
        return this.latitude;
    }
    public void setLatitude(double lat){
        this.latitude = lat;
    }
    
    public void setImage(Image img){
        this.est_image = img;
    }
    public Image getImage(){
        return this.est_image;
    }
    
}
