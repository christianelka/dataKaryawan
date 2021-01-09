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
public abstract class tunjanganB extends GajiPokok{
    private final int statusK;
    private final int umurK;
    private final int anakK;

    public tunjanganB(int b){
        this.statusK = b;
        this.umurK  = b;
        this.anakK = b; 
    }
    
    public long tunjanganNikah(){
        if(this.statusK == 1){
            return (long) (0.1*this.gaPokB());
        }
        return 0;
    }
    
    public long tunjanganUsia(){
        if(this.umurK > 30){
            return (long) (0.15*this.gaPokB());
        }
        return 0;
    }
    
    public long tunjanganAnak(){
        if(this.anakK > 0){
            return (long) (this.gaPokB()/20*this.anakK);
        }
        return 0;
    }
}
