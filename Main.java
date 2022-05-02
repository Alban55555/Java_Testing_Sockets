


public class Main extends Thread {

    public static void main(String[] args) {
        /*Board lol_1 = new Board();
        lol_1.print_m();
        System.out.println();
        Horse horse = new Horse(4, 2, "b2");
        System.out.println(horse.value);
        System.out.println(horse.get_Pos());

         */
        // Running new thread with the SMTP socket

        Main thread = new Main();
        thread.start();




    }
    public void run()
    {
        System.out.println("Starting the thread \n");

        Socket_testing socket_1 = new Socket_testing();


        //while(true) {

        //}


    }
}
