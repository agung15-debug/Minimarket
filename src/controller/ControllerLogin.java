package controller;

import dao.daoPegawai;
import javax.swing.JOptionPane;
import model.Pegawai;
import view.viewLogin;
import view.adminUtama;
import dao.interfacePegawai;
//letakkan view user disini

public class ControllerLogin {
    viewLogin frame;
    Pegawai kUser;
    interfacePegawai infcKeUser;

    public ControllerLogin(viewLogin frame) {
        this.frame = frame;
        infcKeUser = new daoPegawai();
    }
    
    public boolean checkLogin(String username, String password){
        boolean hasil = false;
        kUser = infcKeUser.loadUser(username);
        if(kUser.getUsername().equals("") && kUser.getPassword().equals("")){
            if(username.equals("") && password.equals("")){
                JOptionPane.showMessageDialog(frame, "Maaf, Username dan Password tidak boleh kosong..!!!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(frame, "Maaf, Username dan Password anda tidak sesuai..!!!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                frame.setReset("", "");
            }
        }
        else{
            hasil = kUser.getUsername().equals(username)&&kUser.getPassword().equals(password);
        }
        return hasil;
    }
    public void login(String username, String password){
        boolean log = checkLogin(username,password);
        if(log){
            if(kUser.getPrivilage() == 1){
                frame.dispose();
                new adminUtama().setVisible(true);
            }else{
                //letakkan halaman user disini
            }
        }
    }
}
