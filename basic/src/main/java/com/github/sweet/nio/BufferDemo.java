package com.github.sweet.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author sweet
 * @description
 * @date 2021/10/19 11:40
 */
public class BufferDemo {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put("iloveyou".getBytes(StandardCharsets.UTF_8));
        System.out.println(buffer.capacity());  //10
        System.out.println(buffer.limit()); //10
        System.out.println(buffer.position()); //8

        buffer.flip();
        System.out.println(buffer.capacity()); //10
        System.out.println(buffer.limit()); //8
        System.out.println(buffer.position()); //0

        char c = (char) buffer.get();
        System.out.println("c " + c); //c
        System.out.println(buffer.capacity()); //10
        System.out.println(buffer.limit()); //8
        System.out.println(buffer.position()); //1

        //clear会将position恢复到0，但是仍然可以读数据
        buffer.clear();
        System.out.println(buffer.capacity()); //10
        System.out.println(buffer.limit()); //10
        System.out.println(buffer.position()); //0
        System.out.println((char)buffer.get()); //i

        //
        ByteBuffer buffer2 =ByteBuffer.allocate(10);
        buffer2.put("iloveyou".getBytes(StandardCharsets.UTF_8));
        buffer2.flip();
        byte[] bytes = new byte[2];
        buffer2.get(bytes);
        String s = new String(bytes);
        System.out.println(s);
        System.out.println(buffer2.capacity()); //10
        System.out.println(buffer2.limit()); //10
        System.out.println(buffer2.position()); //0

        System.out.println("mark");
        //mark()标记； reset() 回到标记的位置
        //hasRemaining()
        buffer2.mark();
        byte[] bytes1 = new byte[3];
        buffer2.get(bytes1);
        System.out.println(buffer2.position());

        buffer2.reset();
        System.out.println(buffer2.position());
        if (buffer2.hasRemaining()) {
            System.out.println(buffer2.remaining());
        }

    }
}
