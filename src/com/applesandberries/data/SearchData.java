/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.applesandberries.data;

/**
 *
 * @author drfrozt
 */
public class SearchData {
    
    public SearchData()
    {
        
    }
    
    private String searchValue;
    
    private int searchType;
    
    
    
    public void setSearchValue(String value){
        this.searchValue= value;
        
    }
    
    public String getSearchValue(){   
        return this.searchValue;
    }
    
    public void setSearchType(int type){
        this.searchType = type;
    }
    
    
    public int getSearchType(){
        return this.searchType;
    }
    
    
}
