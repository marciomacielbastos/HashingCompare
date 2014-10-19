/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptography;
import java.security.NoSuchAlgorithmException;
import jonelo.jacksum.JacksumAPI;
import jonelo.jacksum.algorithm.AbstractChecksum;
/**
 *
 * @author Marcim
 */
public class Whirlpool implements HashClass{
    public String text;
    public String hash;
    public Whirlpool(String text){
        this.text=text;
    }
    public static void main(String arg[])
    {
        
    }

    @Override
    public void cryptHash() {
        AbstractChecksum checksum = null; 
        try { 
           checksum = JacksumAPI.getChecksumInstance("whirlpool"); 
           checksum.update(text.getBytes());
           hash=checksum.getFormattedValue();
        } catch (NoSuchAlgorithmException nsae) { }
    }

    @Override
    public String getHash() {
        return hash;
    }

    @Override
    public void setText(String s) {
        this.text=s;
    }
    
    @Override
    public String getName(){
        return "Whirlpool";
    }
}
