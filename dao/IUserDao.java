/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package dao;
import beans.User;
/**
 *
 * @author ichou
 */
public interface IUserDao {

    /**
     * @param user
     * @return 
     */
    
    boolean addUser(User user); 
    User findUserByLogin(String login); 
    boolean authenticate(String login, String password); 

}
