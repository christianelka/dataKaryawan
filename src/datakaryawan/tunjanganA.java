/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datakaryawan;

/**
 *
 * @author Nel
 * Ini Halaman Abstract
 */
public abstract class tunjanganA extends GajiPokok{
    private final int statusK;
    private final int umurK;
    private final int anakK;

    public tunjanganA(int a){
        this.statusK = a;
        this.umurK  = a;
        this.anakK = a; 
    }
    
    public long tunjanganNikah(){
        if(this.statusK == 1){
            return (long) (0.1*this.gaPokA());
        }
        return 0;
    }
    
    public long tunjanganUsia(){
        if(this.umurK > 30){
            return (long) (0.15*this.gaPokA());
        }
        return 0;
    }
    
    public long tunjanganAnak(){
        if(this.anakK > 0){
            return (long) (this.gaPokA()/20*this.anakK);
        }
        return 0;
    }
}