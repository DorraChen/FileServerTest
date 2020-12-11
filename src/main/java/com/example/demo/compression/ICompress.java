package com.example.demo.compression;

import java.io.IOException;

/**
 * @author clz
 * @date 2020/12/11 15:08
 * @description 接口 定义共性标准
 */
public interface ICompress {
    /**
     * 压缩
     *
     * @param data
     * @return
     * @throws IOException
     */
    byte[] compress(byte[] data) throws IOException;

    /**
     * 解压缩
     *
     * @param data
     * @return
     * @throws IOException
     */
    byte[] uncompress(byte[] data) throws IOException;
}
