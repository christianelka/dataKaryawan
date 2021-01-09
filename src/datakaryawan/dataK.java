/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datakaryawan;

/**
 *
 * @author Nel
 */
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;  
import java.util.GregorianCalendar;
public class dataK {
    ArrayList<String> kode = new ArrayList();    
    ArrayList<String> nama = new ArrayList();
    ArrayList<Integer> umur = new ArrayList();
    ArrayList<Integer> status = new ArrayList();
    ArrayList<String> golongan = new ArrayList();
    ArrayList<String> alamat = new ArrayList();
    ArrayList<Integer> jmlanak = new ArrayList();
    int pilihan;
    Date hari;
    String cari;
    Scanner input=new Scanner(System.in);
    
    void tampilAwal() throws ParseException{
        OUTER:
        while (true) {
            System.out.println("************************");
            System.out.println("Main Menu");
            System.out.println("************************");
            System.out.println("1. Tambah Data\n"
                    + "2. Hapus Data\n"
                    + "3. Cari Data\n"
                    + "4. Tampil Data\n"
                    + "5. Keluar");
            System.out.print("Pilih Nomor Menu : ");
            pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    //Tambah Data
                    System.out.println("************************");
                    System.out.print("Input jumlah Data : ");   
                    int jumlah = input.nextInt();
                    for(int a = 0; a < jumlah; a++)
                    {
                        System.out.println("************************");
                        System.out.println("Data ke-"+(a+1));
                        System.out.print("Masukkan Kode Karyawan    : ");                        
                        String value = input.next();
                        kode.add(value);
                        
                        System.out.print("Masukkan Nama Karyawan    : ");
                        Scanner inputx = new Scanner(System.in);
                        String value1;
                        value1 = inputx.nextLine();
                        nama.add(value1);
                        
                        System.out.print("Masukkan Alamat           : ");
                        Scanner inputAlamat = new Scanner(System.in);
                        String valueAlamat;
                        valueAlamat = inputAlamat.nextLine();
                        alamat.add(valueAlamat);

                        System.out.print("Masukkan Tahun Lahir      : ");
                        int valueTahun = input.nextInt();
                        System.out.print("Masukkan Bulan Lahir      : ");
                        int valueBulan   = input.nextInt();
                        System.out.print("Masukkan Tanggal Lahir    : ");
                        int valueTanggal   = input.nextInt();
                        
                        this.hari = new GregorianCalendar(valueTahun, valueBulan - 1, valueTanggal).getTime();
                        LocalDate ld = new java.sql.Date( hari.getTime()).toLocalDate();
                        LocalDate x = LocalDate.now();
                        Period usia = Period.between(ld, x);
                        int age = usia.getYears();
//                        System.out.print(age);
                        umur.add(age);
                        
                        System.out.print("Masukkan Golongan(A/B/C/D): ");
                        Scanner inputGolongan = new Scanner(System.in);
                        String valueGolongan;
                        valueGolongan = inputGolongan.nextLine();
//                        GajiPokok gol = new GajiPokok();
//                        if("A".equals(valueGolongan)){
//                            System.out.println(gol.gaPokA());
//                        }
                        golongan.add(valueGolongan);

                        System.out.print("Masukkan Status Menikah (1:Sudah 0:Belum)   : ");
                        int value3 = input.nextInt();
                        status.add(value3);    
                        
                        System.out.print("Masukkan Jumlah Anak      : ");
                        int valueAnak = input.nextInt();
                        jmlanak.add(valueAnak);
                    }
                    break;
                    
                case 2:
                    //Hapus Data
                    System.out.println("************************");
                    if(kode.size() <= 0){
                        System.out.println("\nData Masih Kosong");
                    } else {
                        for(int i=0; i<kode.size(); i++){
                           System.out.println("Data ke-"+(i+1)+" "+kode.get(i));
                       }
                        System.out.print("\nPilih Data Yang Mau Dihapus : ");                    
                        String value5 = input.next();
                        int baris = kode.indexOf(value5);
                        kode.remove(baris);
                        nama.remove(baris);
                        alamat.remove(baris);
                        umur.remove(baris);
                        golongan.remove(baris);
                        status.remove(baris);  
                        jmlanak.remove(baris);
                        System.out.println("Data Berhasil Dihapus \n");
                    }
                    break;
                    
                case 3:
                    //Cari Data
                    System.out.println("************************");
                    if(kode.size() <= 0){
                        System.out.println("\nData Masih Kosong");
                    } else {
                        for(int i=0; i<kode.size(); i++){
                           System.out.println("Data ke-"+(i+1)+" "+kode.get(i));
                        }
                        System.out.print("Masukkan Kode Karyawan : ");
                        String tipeY = input.next();
                        int cariNim = Collections.binarySearch(kode, tipeY);
                        String kode1 = kode.get(cariNim);
                        String nama1 = nama.get(cariNim);
                        String alamat1 = alamat.get(cariNim);
                        int umur1 = umur.get(cariNim);
                        String golongan1 = golongan.get(cariNim);
                        int status1 = status.get(cariNim);
                        int jmlanak1 = jmlanak.get(cariNim);
                        
                        System.out.println("************************");
                        System.out.println("Kode Karyawan       : "+kode1);
                        System.out.println("Nama Karyawan       : "+nama1);
                        System.out.println("Alamat Karyawan     : "+alamat1);
                        System.out.println("Usia Karyawan       : "+umur1);
                        System.out.println("Golongan Karyawan   : "+golongan1);
                        System.out.println("Status Menikah      : "+status1);
                        System.out.println("Jumlah Anak         : "+jmlanak1+"\n");
                        
                        GajiPokok gol = new GajiPokok();
                        tunjanganA aStatus = new tunjanganA (this.status.get(cariNim)) {};
                        tunjanganA aUmur = new tunjanganA (this.umur.get(cariNim)) {};
                        tunjanganA aJmlAnk = new tunjanganA (this.jmlanak.get(cariNim)) {};  
                        
                        tunjanganB bStatus = new tunjanganB (this.status.get(cariNim)) {};
                        tunjanganB bUmur = new tunjanganB (this.umur.get(cariNim)) {};
                        tunjanganB bJmlAnk = new tunjanganB (this.jmlanak.get(cariNim)) {};
                        
                        tunjanganC cStatus = new tunjanganC (this.status.get(cariNim)) {};
                        tunjanganC cUmur = new tunjanganC (this.umur.get(cariNim)) {};
                        tunjanganC cJmlAnk = new tunjanganC (this.jmlanak.get(cariNim)) {};
                        
                        tunjanganD dStatus = new tunjanganD (this.status.get(cariNim)) {};
                        tunjanganD dUmur = new tunjanganD (this.umur.get(cariNim)) {};
                        tunjanganD dJmlAnk = new tunjanganD (this.jmlanak.get(cariNim)) {};
                        
                        if("A".equals(golongan.get(cariNim))){
                            System.out.println("Gaji Pokok               : Rp " + gol.gaPokA()); 
                            System.out.println("Tunjangan Istri/Suami    : Rp "+ aStatus.tunjanganNikah());
                            System.out.println("Tunjangan Pegawai        : Rp "+ aUmur.tunjanganUsia());
                            System.out.println("Tunjangan Anak           : Rp "+ aJmlAnk.tunjanganAnak());
                            System.out.println("---------------------------------------------------- +");
                            long gajiKotor = gol.gaPokA() + aStatus.tunjanganNikah() + aUmur.tunjanganUsia() + aJmlAnk.tunjanganAnak();
                            System.out.println("Gaji Kotor               : Rp "+ gajiKotor);
                            long potongan = gajiKotor/40;
                            System.out.println("Potongan                 : Rp "+ potongan);
                            System.out.println("---------------------------------------------------- -");
                            long gajiBersih = gajiKotor - potongan;
                            System.out.println("Gaji Bersih              : Rp "+ gajiBersih);
                        }
                        if("B".equals(golongan.get(cariNim))){
                            System.out.println("Gaji Pokok               : Rp " + gol.gaPokB()); 
                            System.out.println("Tunjangan Istri/Suami    : Rp "+ bStatus.tunjanganNikah());
                            System.out.println("Tunjangan Pegawai        : Rp "+ bUmur.tunjanganUsia());
                            System.out.println("Tunjangan Anak           : Rp "+ bJmlAnk.tunjanganAnak());
                            System.out.println("---------------------------------------------------- +");
                            long gajiKotor = gol.gaPokB() + bStatus.tunjanganNikah() + bUmur.tunjanganUsia() + bJmlAnk.tunjanganAnak();
                            System.out.println("Gaji Kotor               : Rp "+ gajiKotor);
                            long potongan = gajiKotor/40;
                            System.out.println("Potongan                 : Rp "+ potongan);
                            System.out.println("---------------------------------------------------- -");
                            long gajiBersih = gajiKotor - potongan;
                            System.out.println("Gaji Bersih              : Rp "+ gajiBersih);
                        }
                        if("C".equals(golongan.get(cariNim))){
                            System.out.println("Gaji Pokok               : Rp " + gol.gaPokC()); 
                            System.out.println("Tunjangan Istri/Suami    : Rp "+ cStatus.tunjanganNikah());
                            System.out.println("Tunjangan Pegawai        : Rp "+ cUmur.tunjanganUsia());
                            System.out.println("Tunjangan Anak           : Rp "+ cJmlAnk.tunjanganAnak());
                            System.out.println("---------------------------------------------------- +");
                            long gajiKotor = gol.gaPokC() + bStatus.tunjanganNikah() + bUmur.tunjanganUsia() + bJmlAnk.tunjanganAnak();
                            System.out.println("Gaji Kotor               : Rp "+ gajiKotor);
                            long potongan = gajiKotor/40;
                            System.out.println("Potongan                 : Rp "+ potongan);
                            System.out.println("---------------------------------------------------- -");
                            long gajiBersih = gajiKotor - potongan;
                            System.out.println("Gaji Bersih              : Rp "+ gajiBersih);
                        }
                        if("D".equals(golongan.get(cariNim))){
                            System.out.println("Gaji Pokok               : Rp " + gol.gaPokD()); 
                            System.out.println("Tunjangan Istri/Suami    : Rp "+ dStatus.tunjanganNikah());
                            System.out.println("Tunjangan Pegawai        : Rp "+ dUmur.tunjanganUsia());
                            System.out.println("Tunjangan Anak           : Rp "+ dJmlAnk.tunjanganAnak());
                            System.out.println("---------------------------------------------------- +");
                            long gajiKotor = gol.gaPokD() + dStatus.tunjanganNikah() + dUmur.tunjanganUsia() + dJmlAnk.tunjanganAnak();
                            System.out.println("Gaji Kotor               : Rp "+ gajiKotor);
                            long potongan = gajiKotor/40;
                            System.out.println("Potongan                 : Rp "+ potongan);
                            System.out.println("---------------------------------------------------- -");
                            long gajiBersih = gajiKotor - potongan;
                            System.out.println("Gaji Bersih              : Rp "+ gajiBersih);
                        }
                        break;

                    }
                    break;
                    
                case 4:
                    //Lihat Data
                    System.out.println("************************");
                    if(kode.size() <= 0){
                        System.out.println("\nData Masih Kosong");
                    } else {
                        System.out.println("\nMenampilkan Semua Data Mahasiswa");
                        System.out.println("************************");               
//                        align.addLine("Kode Karyawan","Nama Karyawan","Alamat","Tanggal","Golongan","Status","Jumlah Anak", "\n");
                        System.out.println("Kode Karyawan \t\t Nama Karyawan \t\t Golongan \t Usia \t\t Status Menikah \t Jumlah Anak");                        
                        for(int i = 0; i<kode.size(); i++){

                            if (status.get(i) ==1 ) {
                                String statuss = "Sudah Menikah";
                                System.out.println(kode.get(i)+"\t\t "+nama.get(i)+"\t\t "+golongan.get(i)+"\t\t "+umur.get(i)+"\t\t "+statuss+"\t\t "+jmlanak.get(i));
                            } else if (status.get(i) == 0) {
                                String statuss = "Belum Menikah";
                                System.out.println(kode.get(i)+"\t\t "+nama.get(i)+"\t\t "+golongan.get(i)+"\t\t "+umur.get(i)+"\t\t "+statuss+"\t\t "+jmlanak.get(i));
                            }                                                
                        }
                        System.out.println("Jumlah Karyawan : " + kode.size());
                        System.out.println("************************");
                    }
                    break;
                    
                case 5:
                    System.exit(0);
                default:
                    break;
            }
            if (pilihan <= 0 | pilihan > 4){
                System.out.println("Terima Kasih");
                break;
            }
        }
}
}
