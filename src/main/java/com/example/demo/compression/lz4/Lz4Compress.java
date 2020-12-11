package com.example.demo.compression.lz4;

import com.example.demo.compression.AbstCompress;
import com.example.demo.compression.CompressConstants;
import com.example.demo.compression.ICompress;
import net.jpountz.lz4.LZ4BlockInputStream;
import net.jpountz.lz4.LZ4BlockOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author clz
 * @date 2020/12/11 15:07
 * @description lz4压缩：LZ4是一种无损数据压缩算法，着重于压缩和解压缩速度
 * Yann Collet 在2011年发明了LZ4压缩算法。
 * LZ4算法虽然没有middle out那么牛逼得无死角，但在能保证一定压缩率的情况下，它以它无敌的压缩速度和更快的解压速度著称
 * 如果一句话概括LZ4：LZ4就是一个用16k大小哈希表储存字典并简化检索的LZ77
 */
public class Lz4Compress extends AbstCompress implements ICompress {

    public static void main(String[] args) {
        Lz4Compress lz4Compress = new Lz4Compress();
        System.out.println(lz4Compress.unCompress(lz4Compress.compress(CompressConstants.TEST_STRING)));
    }

    @Override
    public byte[] compress(byte[] data) throws IOException {

        try {
            //1.zip压缩
            ByteArrayOutputStream baOs = new ByteArrayOutputStream();
            LZ4BlockOutputStream lz4Os = new LZ4BlockOutputStream(baOs);
            lz4Os.write(data);
            lz4Os.flush();
            lz4Os.close();//关闭流 输出缓存区内容  否则解压时eof异常

            //2.获取并转义压缩内容
            return baOs.toByteArray();
        } catch (IOException e) {
            throw e;
        }

    }

    @Override
    public byte[] uncompress(byte[] data) throws IOException {
        try {
            //1.zip解压缩
            ByteArrayOutputStream baOs = new ByteArrayOutputStream();
            ByteArrayInputStream baIs = new ByteArrayInputStream(data);
            LZ4BlockInputStream zipIs = new LZ4BlockInputStream(baIs);

            byte[] temp = new byte[256];
            /*while (zipIs.read(temp) >=0){
                baOs.write(temp);
                1.当报文较大时，会存在冗余读，导致解压后出现冗余内容!
                2.原因在于倒数第二部分内容 为较长字符串时,内容超长
                3.当解析最后一部分内容时 由于内容较短，只覆盖了前N个长度的内容， 但是write是写了全部的
            }*/
            int n;
            while ((n = zipIs.read(temp)) >= 0) {
                baOs.write(temp, 0, n);
            }

            return baOs.toByteArray();
        } catch (IOException e) {
            throw e;
        }
    }
}
