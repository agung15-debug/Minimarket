/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.kasirUtama;
import model.Pegawai;
import view.viewLogin;
import view.detailOrder;

public class ControllerKasirUtama {
    kasirUtama frame;
    
    public ControllerKasirUtama(kasirUtama frame){
        this.frame = frame;
    }
    
    public void getIdPegawai(Pegawai pegawai){
        frame.getIdPegawai(pegawai.getId());
    }
    
    public void halamanOrderDetail(){
        frame.dispose();
        new detailOrder().setVisible(true);
    }
    
    public void halamanLogin(){
        frame.dispose();
        new viewLogin().setVisible(true);
    }
}
