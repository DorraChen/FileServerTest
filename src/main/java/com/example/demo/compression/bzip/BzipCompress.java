package com.example.demo.compression.bzip;

import com.example.demo.compression.AbstCompress;
import com.example.demo.compression.CompressConstants;
import com.example.demo.compression.ICompress;
import org.itadaki.bzip2.BZip2InputStream;
import org.itadaki.bzip2.BZip2OutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author clz
 * @date 2020/12/11 15:12
 * @description bzip压缩
 * bzip2是Julian Seward开发并按照自由软件／开源软件协议发布的数据压缩算法及程序。
 * Seward在1996年7月第一次公开发布了bzip2 0.15版，
 * 在随后几年中这个压缩工具稳定性得到改善并且日渐流行，
 * Seward在2000年晚些时候发布了1.0版。
 * bzip2比传统的gzip的压缩效率更高，但是它的压缩速度较慢
 */
public class BzipCompress extends AbstCompress implements ICompress {

    public static void main(String[] args) {
        BzipCompress bzipCompress = new BzipCompress();
        System.out.println(bzipCompress.unCompress(bzipCompress.compress(CompressConstants.TEST_STRING)));
    }

    @Override
    public byte[] compress(byte[] data) throws IOException {

        //1.bzip压缩
        ByteArrayOutputStream baOs = new ByteArrayOutputStream();
        BZip2OutputStream bzipOs = new BZip2OutputStream(baOs);
        bzipOs.write(data);
        bzipOs.flush();
        bzipOs.close();//关闭流 输出缓存区内容  否则解压时eof异常

        //2.获取并转义压缩内容
        return baOs.toByteArray();
    }

    @Override
    public byte[] uncompress(byte[] data) throws IOException {
        //1.bzip解压缩
        ByteArrayOutputStream baOs = new ByteArrayOutputStream();
        ByteArrayInputStream baIs = new ByteArrayInputStream(data);
        BZip2InputStream bzipIs = new BZip2InputStream(baIs, false);

        byte[] temp = new byte[256];
            /*while (zipIs.read(temp) >=0){
                baOs.write(temp);
                1.当报文较大时，会存在冗余读，导致解压后出现冗余内容!
                2.原因在于倒数第二部分内容 为较长字符串时,内容超长
                3.当解析最后一部分内容时 由于内容较短，只覆盖了前N个长度的内容， 但是write是写了全部的
            }*/
        int n;
        while ((n = bzipIs.read(temp)) >= 0) {
            baOs.write(temp, 0, n);
        }

        return baOs.toByteArray();
    }
}