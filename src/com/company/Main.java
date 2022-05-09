package com.company;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.nio.file.Path;
import java.util.Set;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;


public class Main extends Thread{

    public static void main(String[] args) throws IOException {

        //Main thread = new Main();
        //thread.start();
        /*Random ranndo = new Random();
        try {
            Selector_writing_to_file test_1 = new Selector_writing_to_file();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int random = ranndo.nextInt(25);
        System.out.println(random);
        */
        ArrayList<Integer> random_numbers = new ArrayList<>(9999);
        Charset charset= null;
        charset = Charset.forName("US-ASCII");

        try{

            String test = "Test";
            byte[] buffer = test.getBytes();
            ByteBuffer message = ByteBuffer.allocate(buffer.length);
            message.put(buffer);
            message.flip();
            Random rand = new Random();
            int random_number = rand.nextInt(9999); //upperband 9999
            if(random_numbers.size()!=9999) {   //check if there are less entries than 9999 in array list

                while (random_numbers.contains(random_number)) ;    //to check if the same number does not occur twice
                {
                    random_number = rand.nextInt(9999);
                }
                random_numbers.add(random_number);
            }else
            {
                System.out.println("The maximum number of entries has been reached");
            }
            String Directory = "c://receiver//";
            Path Dir = Paths.get(Directory);
            String FULL_Path_string = "c://receiver/sender_"+String.valueOf(random_number)+".txt//";
            //Path p = Paths.get(Path_string);     //destination path
            String file_only_string = "sender_"+String.valueOf(random_number)+".txt//";
            System.out.println(FULL_Path_string);
            Path p = Paths.get("C://receiver//"+file_only_string);
            if (Files.exists(p))
            {
                System.out.println("file already exists, deleting it");
                Files.delete(Paths.get(FULL_Path_string));

            }
            else
            {
                try {
                    //Path newDir = Files.createDirectory(p);
                    if(!Files.exists(Dir))
                    {
                        Files.createDirectory(Dir);
                    }


                } catch(Exception e){
                    // the directory already exists.

                    e.printStackTrace();
                }
                Set<StandardOpenOption> options = new HashSet<>();
                options.add(StandardOpenOption.CREATE);
                options.add(StandardOpenOption.APPEND);
                FileChannel fileChannel = FileChannel.open(p,options);  //creates the file
                fileChannel.write(message); //writing the data to the file
                fileChannel.close();
            }






















            /*
            String test = "Test";
            byte[] buffer = test.getBytes();
            ByteBuffer message = ByteBuffer.allocate(buffer.length);

            Random rand = new Random();
            int random_number = rand.nextInt(9999);
            if(random_numbers.size()!=9999) {
                while (random_numbers.contains(random_number)) ;
                {
                    random_number = rand.nextInt(9999);
                }
                random_numbers.add(random_number);
            }else
            {
                System.out.println("There are more than 9999 entries");
            }
            message.put(buffer);
            message.flip();
            String Directory = "c://receiver//";
            Path Dir = Paths.get(Directory);
            //if (Files.notExists(Dir)) {
              //  try { Files.createDirectory(Dir); }
                //catch (Exception e ) { e.printStackTrace(); }
            //}
            String Path_string = "c://receiver//sender_"+String.valueOf(random_number)+".txt";
            String file_only_string = "sender_"+String.valueOf(random_number)+".txt//";
            System.out.println(Path_string);
            Path p = Paths.get("C://receiver//"+file_only_string);
            if (Files.exists(p))
            {
                System.out.println("file already exists, deleting it");
                Files.delete(Paths.get("test.txt"));
            }
            else
            {
                try {
                    //Path newDir = Files.createDirectory(p);
                    Files.createDirectory(Dir);
                    //Set<StandardOpenOption> options = new HashSet<>();
                    //options.add(StandardOpenOption.CREATE);
                   // options.add(StandardOpenOption.APPEND);
                    //FileChannel fileChannel = FileChannel.open(p,options);

                } catch(Exception e){
                    // the directory already exists.

                    e.printStackTrace();
                }///*
                try (OutputStream out = new BufferedOutputStream(
                        Files.newOutputStream(p, CREATE, APPEND))) {
                    out.write(buffer, 0, buffer.length);
                } catch (IOException x) {
                    System.err.println(x);
                }
                   //

                //Path donePath = Files.createFile(p);
                Set<StandardOpenOption> options = new HashSet<>();
                options.add(StandardOpenOption.CREATE);
                options.add(StandardOpenOption.APPEND);
                FileChannel blabla = FileChannel.open(p,options);
                blabla.write(message);
                blabla.close();
            }*/
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        try{
            FileOutputStream newFile;
            String test = "LOL";
            byte[] buffer = test.getBytes(charset);
            ByteBuffer message = ByteBuffer.allocate(buffer.length);
            message.put(buffer);
            try {
                newFile = new FileOutputStream("test_2.txt");
                FileChannel fc = newFile.getChannel();
                fc.write(message);
                fc.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void run()
    {
        System.out.println("Starting the thread \n");

        testing_sockets socket_1 = new testing_sockets();


        //while(true) {

        //}


    }
}
