package com.example.demo.compression.gzip;

import com.example.demo.compression.AbstCompress;
import com.example.demo.compression.CompressConstants;
import com.example.demo.compression.ICompress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author clz
 * @date 2020/12/11 15:16
 * @description gzip压缩
 * gzip的实现算法还是deflate，只是在deflate格式上增加了文件头和文件尾，
 * 同样jdk也对gzip提供了支持，分别是GZIPOutputStream和GZIPInputStream类，
 * 可以发现GZIPOutputStream是继承于DeflaterOutputStream的，
 * GZIPInputStream继承于InflaterInputStream，
 * 并且可以在源码中发现writeHeader和writeTrailer方法
 */
public class GzipCompress extends AbstCompress implements ICompress {

    public static void main(String[] args) {
        GzipCompress gzipCompress = new GzipCompress();
        System.out.println(gzipCompress.unCompress(gzipCompress.compress(CompressConstants.TEST_STRING)));
    }

    @Override
    public byte[] compress(byte[] data) throws IOException {
        try {

            //1.zip压缩
            ByteArrayOutputStream baOs = new ByteArrayOutputStream();
            GZIPOutputStream zipOs = new GZIPOutputStream(baOs, true);
            zipOs.write(data);
            zipOs.flush();
            zipOs.close();//关闭流 输出缓存区内容  否则解压时eof异常

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
            GZIPInputStream zipIs = new GZIPInputStream(baIs);

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