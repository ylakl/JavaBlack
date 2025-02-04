package main.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferEx {
    public static void main(String[] args) {
        try(RandomAccessFile file = new RandomAccessFile("Stih3.txt", "rw");
            FileChannel channel = file.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(25);
            StringBuilder stix = new StringBuilder();
            int b =channel.read(buffer);
            while (b>0){
                System.out.println("Read" + b);
                buffer.flip();
                while (buffer.hasRemaining()){
                    stix.append((char)buffer.get());
                }
                buffer.clear();
                b = channel.read(buffer);
            }
System.out.println(stix);
            String h = "ggggggjjjkkk";
            ByteBuffer bf = ByteBuffer.wrap(h.getBytes());
            channel.write(bf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
