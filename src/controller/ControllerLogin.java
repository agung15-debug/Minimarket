package controller;

import dao.daoPegawai;
import dao.interfacePegawai;
import javax.swing.JOptionPane;
import model.Pegawai;
import view.viewLogin;
import view.adminUtama;
//import view.kasirUtama;

public class ControllerLogin {
    viewLogin frame;
    Pegawai pegawai;
    interfacePegawai infcPegawai;

    public ControllerLogin(viewLogin frame) {
        this.frame = frame;
        infcPegawai = new daoPegawai();
    }
    
    public boolean checkLogin(String username, String password){
        boolean hasil = false;
        pegawai = infcPegawai.loadUser(username);
        if(pegawai.getUsername().equals("") && pegawai.getPassword().equals("")){
            if(username.equals("") && password.equals("")){
                JOptionPane.showMessageDialog(frame, "Maaf, Username dan Password tidak boleh kosong..!!!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(frame, "Maaf, Username dan Password anda tidak sesuai..!!!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                frame.setReset("", "");
            }
        }
        else{
            hasil = pegawai.getUsername().equals(username)&&pegawai.getPassword().equals(password);
        }
        return hasil;
    }
    public void login(String username, String password){
        boolean log = checkLogin(username,password);
        if(log){
            if(pegawai.getPrivilage() == 1){
                frame.dispose();
                new adminUtama().setVisible(true);
            }else{
                frame.dispose();
//                new kasirUtama().setVisible(true);
            }
        }
    }
}
