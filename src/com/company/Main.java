package com.company;

public class Main extends Thread{

    public static void main(String[] args) {

        Main thread = new Main();
        thread.start();
    }
    public void run()
    {
        System.out.println("Starting the thread \n");

        testing_sockets socket_1 = new testing_sockets();


        //while(true) {

        //}


    }
}
