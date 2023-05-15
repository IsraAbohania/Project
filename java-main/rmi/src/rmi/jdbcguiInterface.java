package rmi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public interface jdbcguiInterface {

    public String Insert(String name, int id, String gender, int age, String dept, String year);

    public String Delete(String name, int id, String gender, int age, String dept, String year);

    public String Delete(int id);

    public String Update(String name, int id, String gender, int age, String dept, String year);
    
}
