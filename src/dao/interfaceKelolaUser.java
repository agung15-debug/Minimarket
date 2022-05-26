package dao;

import model.kelolaUser;
import java.util.List;
import java.sql.*;

public interface interfaceKelolaUser {
    public void insert(kelolaUser kUser);

    public void update(kelolaUser kUser);

    public void delete(int id);
    
    public kelolaUser loadUser(String username);
    
    public List<kelolaUser> getData();
}
