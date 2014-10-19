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
public class Chrono {
    private long[] time1;
    private long[] time2;
    private HashClass crypt1;
    private HashClass crypt2;
    public Chrono(int x, HashClass crypt1, HashClass crypt2){
        this.time1=new long[x];
        this.time2=new long[x];
        this.crypt1 = crypt1;
        this.crypt2 = crypt2;
        timeMeasure();
    }
    public void timeMeasure(){
        RandomString random = new RandomString();
        int j=1;
        for(int i=0;i<time1.length;i++){
            random.setRString(j*=5);
            crypt1.setText(random.getRString());
            long in = System.nanoTime();
            crypt1.cryptHash();
            long out = System.nanoTime();
            time1[i]=(out - in);
            crypt2.setText(random.getRString());
            in = System.nanoTime();
            crypt2.cryptHash();
            out = System.nanoTime();
            time2[i]=(out - in);
        }
    }
    public void getTime(){
        System.out.println("Tempos medidos da função "+this.crypt1.getName());
        for(int i=0; i<time1.length;i++){
            System.out.print(time1[i]+" ");
        }
        System.out.println("");
        System.out.println("Tempos medidos da função "+this.crypt2.getName());
        for(int i=0; i<time2.length;i++){
            System.out.print(time2[i]+" ");
        }
        System.out.println("");
    }
}
