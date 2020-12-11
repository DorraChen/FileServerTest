package com.example.demo.compression.deflate;

import com.example.demo.compression.AbstCompress;
import com.example.demo.compression.CompressConstants;
import com.example.demo.compression.ICompress;
import com.jcraft.jzlib.DeflaterOutputStream;
import com.jcraft.jzlib.InflaterInputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author clz
 * @date 2020/12/11 15:14
 * @description Deflate 压缩
 * DEFLATE是同时使用了LZ77算法与哈夫曼编码（Huffman Coding）的一个无损数据压缩算法，
 * DEFLATE压缩与解压的源代码可以在自由、通用的压缩库zlib上找到，
 * zlib官网：http://www.zlib.net/ jdk中对zlib压缩库提供了支持，
 * 压缩类Deflater和解压类Inflater，Deflater和Inflater都提供了native方法。
 */
public class DeflateCompress extends AbstCompress implements ICompress {

    public static void main(String[] args) throws IOException {
        DeflateCompress deflateCompress = new DeflateCompress();
        System.out.println(deflateCompress.unCompress(deflateCompress.compress(CompressConstants.TEST_STRING)));
    }

    @Override
    public byte[] compress(byte[] data) throws IOException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DeflaterOutputStream dos = new DeflaterOutputStream(baos);
            dos.write(data);
            dos.flush();
            dos.close();
            return baos.toByteArray();
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public byte[] uncompress(byte[] data) throws IOException {
        try {
            ByteArrayOutputStream baOs = new ByteArrayOutputStream();
            ByteArrayInputStream baIs = new ByteArrayInputStream(data);
            InflaterInputStream deflateIs = new InflaterInputStream(baIs);

            int n;
            byte[] buff = new byte[256];
            while ((n = deflateIs.read(buff)) >= 0) {
                baOs.write(buff, 0, n);
            }

            return baOs.toByteArray();
        } catch (IOException e) {
            throw e;
        }
    }
}
