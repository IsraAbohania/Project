/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import com.mysql.cj.xdevapi.Statement;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


/**
 *
 * @author hp
 */
public class server extends UnicastRemoteObject implements jdbcguiInterface{

    public server() throws RemoteException{
      super() ; 
    }
    public static void main(String[] args) throws RemoteException{
       Registry reg=LocateRegistry.createRegistry(5000);
       server s=new server();
       reg.rebind("db", s);
        System.out.println("server is running now.....");
       
    }
    @Override
     public String Delete(int id)  {
     try{
//           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/rmitest", "root", "");
            java.sql.Statement st=  con.createStatement();
          String sql="delete from student where id="+id+"";
         st.executeUpdate(sql);
          return "record delete Succesfully";

        }
        catch(Exception ex){
            ex.printStackTrace();
          return (ex.toString());
        }
    } 
    @Override
    public String Insert(String name, int id, String gender, int age, String department, String year)  {
        try{
//           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/rmitest", "root", "");
            java.sql.Statement st=  con.createStatement();
          String sql="insert into student values('"+id+"','"+name+"','"+gender+"','"+department+"','"+age+"','"+year+"')";
          st.executeUpdate(sql);
          return "record Iserted Succesfully";

        }
        catch(Exception e){
          return (e.toString());
        }
    }

    @Override
    

   
    

    
   
    
    public String Update(String name, int id, String gender, int age, String department, String year) {
try{
//           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/rmitest", "root", "");
            java.sql.Statement st=  con.createStatement();
          String sql="Update student set name='"+name+"',gender='"+gender+"',department='"+department+"',age="+age+",year='"+year+"' where id="+id+")";
         System.out.println(sql);
          st.executeUpdate(sql);
          return "record update Succesfully";

        }
        catch(Exception e){
          return (e.toString());
        }
    }

    @Override
    public String Delete(String name, int id, String gender, int age, String dept, String year) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


    