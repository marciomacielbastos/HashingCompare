/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptography;

import java.util.Random;

/**
 *
 * @author Marcim
 */
public class RandomString {
    private String rString;
    final private String array;
    public RandomString(){
        this.array = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*?{}[]:;,.~";
        Random  random= new Random();
        
    }
    private String randomString(int len) {
        Random  random= new Random();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ ) 
            sb.append( array.charAt( random.nextInt(array.length()) ) );
        return sb.toString();
    }
    public void setRString(int len){
       this.rString = randomString(len);
    }
    public String getRString(){
        return this.rString;
    }
}
