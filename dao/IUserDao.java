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

    boolean addUser(User user);

    User findUserByLogin(String login);

    boolean authenticate(String login, String password);

    boolean userExists(String login);

    boolean updatePassword(String login, String newPassword);
}
