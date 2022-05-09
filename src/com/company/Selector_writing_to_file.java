package com.company;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;
import java.nio.channels.FileChannel;
import java.io.RandomAccessFile;

public class Selector_writing_to_file {
    private static Charset charset= null;

    private static String hostName = null;

    //FileChannel writing_to_file =

    //RandomAccessFile randomAccessFile = new RandomAccessFile("C:/Test/temp.txt",
      //      "rw");
    //FileChannel fileChannel = randomAccessFile.getChannel();
    public Selector_writing_to_file() throws FileNotFoundException {
        String message_1 = "Some test";

        //State state = new State(hostName);
        byte[] buffer = message_1.getBytes(charset);
        ByteBuffer message = ByteBuffer.allocate(buffer.length);
        message.put(buffer);


        FileOutputStream newFile;
        newFile = new FileOutputStream("c:/receiver/sender_id");
        FileChannel fc = newFile.getChannel();
        try {
            fc.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
