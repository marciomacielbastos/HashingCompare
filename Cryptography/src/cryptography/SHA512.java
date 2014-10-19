/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptography;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 *
 * @author Marcim
 */
public class SHA512 implements HashClass{
    public String text;
    public byte[] hash;
    final private char[] hexArray;
    public SHA512(String text){
        this.hexArray = "0123456789ABCDEF".toCharArray();
        this.text=text;
    }
    @Override
    public void cryptHash() {
        try{
            MessageDigest code= MessageDigest.getInstance("SHA-512");
            hash=code.digest(text.getBytes());
        }
        catch(NoSuchAlgorithmException nsae){
            System.out.println(nsae.getMessage());
        }
    }

    @Override
    public String getHash() {
        return bytesToHex(hash);
    }
    public String bytesToStringUTFCustom(byte[] bytes) {
         char[] buffer = new char[bytes.length >> 1];
         for(int i = 0; i < buffer.length; i++) {
              int bpos = i << 1;
              char c = (char)(((bytes[bpos]&0x00FF)<<8) + (bytes[bpos+1]&0x00FF));
              buffer[i] = c;
         }
         return new String(buffer);
    }
    
    public String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
    
    @Override
    public void setText(String s) {
        this.text=s;
    }
    
    @Override
    public String getName(){
        return "SHA-512";
    }
}
