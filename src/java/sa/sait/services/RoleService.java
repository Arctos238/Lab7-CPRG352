/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sa.sait.services;
import ca.sait.dataaccess.RoleDB;
import ca.sait.models.Role;
import java.util.List;

/**
 *
 * @author J.Pointer
 */
public class RoleService {
    public RoleService() {

    }

    public List<Role> getAll() {
        RoleDB roleDb = new RoleDB();
        
        return roleDb.getAll();
    }
}
