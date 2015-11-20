/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.applesandberries.eventListener;

/**
 *
 * @author drfrozt
 */
public interface transportListener {
    public void postDataSuccessful();
    public void postDataFailed();
    public String postDataStatus();
    
    
    public void getDataSucccessful();
    public void getDataFailed();
    public String getDataStatus();
            
}
