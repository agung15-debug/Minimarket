package controller;

import dao.daoKelolaUser;
import dao.interfaceKelolaUser;
import javax.swing.JOptionPane;
import model.kelolaUser;
import view.viewLogin;
import view.adminUtama;
//letakkan view user disini

public class ControllerLogin {
    viewLogin frame;
    kelolaUser kUser;
    interfaceKelolaUser infcKeUser;

    public ControllerLogin(viewLogin frame) {
        this.frame = frame;
        infcKeUser = new daoKelolaUser();
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
