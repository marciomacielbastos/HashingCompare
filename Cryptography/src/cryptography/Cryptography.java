/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptography;
/**
 *
 * @author Marcim
 */
public class Cryptography {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SHA512 sha512 =new SHA512("");
        Whirlpool whirlpool = new Whirlpool("");
        Chrono time = new Chrono(10,sha512, whirlpool);
        time.getTime();
    }
    
}
