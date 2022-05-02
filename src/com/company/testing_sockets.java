package com.company;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class testing_sockets {
    public testing_sockets() {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel servSock = ServerSocketChannel.open();
            servSock.configureBlocking(false);
            servSock.bind(new InetSocketAddress(9999));
            servSock.register(selector, SelectionKey.OP_ACCEPT);

            /*
            while(true)         //Notification
            {
                if(selector.select()==0) //blocking
                {
                    continue;
                }
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectedKeys.iterator();
                while(iter.hasNext())
                {
                    SelectionKey key = iter.next();
                    iter.remove();
                }
            }
            SelectionKey key;
            if(key.isAcceptable())
            {

            }*/
            //writing data to a FileChannel
            String newData = "Test connection"+System.currentTimeMillis();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            buf.clear();
            buf.put(newData.getBytes(StandardCharsets.UTF_8));
            buf.flip();
            while(true)
            {
                SocketChannel socket_chan = servSock.accept();
                if(socket_chan!=null)
                {
                    while(buf.hasRemaining())   //writing to a channel
                        socket_chan.write(buf);
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
