package com.company.JavaGof.ChainOfResponsibility;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private  static  Server server;
    public static void main(String[] args) throws IIOException {
         init();
         boolean success;
         try {
             do {
                 System.out.println("Enter email ");
                 var email = reader.readLine();
                 System.out.println("Input password ");
                 var password = reader.readLine();
                 success = server.LogIn(email,password);
             }while (!success);
         }catch (Exception e) {

         }
    }

    public  static  void  init(){
        server = new Server();
        server.register("admin","122");
        var middleware = new ThorttlingMiddleware(1);
        server.setMiddleware(middleware);
    }
}



