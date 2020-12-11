package com.example.demo.compression.snappy;

import com.example.demo.compression.AbstCompress;
import com.example.demo.compression.CompressConstants;
import com.example.demo.compression.ICompress;
import org.xerial.snappy.Snappy;

import java.io.IOException;

/**
 * @author clz
 * @date 2020/12/11 15:21
 * @description Snappy压缩
 * Snappy（以前称Zippy）是Google基于LZ77的思路
 * 用C++语言编写的快速数据压缩与解压程序库，并在2011年开源。
 * 它的目标并非最大压缩率或与其他压缩程序库的兼容性，而是非常高的速度和合理的压缩率。
 */
public class SnappyCompress extends AbstCompress implements ICompress {

    public static void main(String[] args) {
        SnappyCompress snappyCompress = new SnappyCompress();
        System.out.println(snappyCompress.unCompress(snappyCompress.compress(CompressConstants.TEST_STRING)));
    }

    @Override
    public byte[] compress(byte[] data) throws IOException {
        return Snappy.compress(data);
        /*ByteArrayOutputStream baos = new ByteArrayOutputStream();
        SnappyOutputStream sos = new SnappyOutputStream(baos);
        sos.write(data);
        sos.flush();
        sos.close();
        return baos.toByteArray();*/
    }

    @Override
    public byte[] uncompress(byte[] data) throws IOException {
        return Snappy.uncompress(data);
        /*ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        SnappyInputStream sis = new SnappyInputStream(bais);
        int n;
        byte[] buff = new byte[256];
        while ((n = sis.read(buff)) >= 0){
            baos.write(buff, 0, n);
        }
        return baos.toByteArray();*/
    }
}
