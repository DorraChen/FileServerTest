package com.example.demo.compression;

/**
 * @author clz
 * @date 2020/12/11 15:29
 * @description
 */
public class CompressConstants {
    public static final String TEST_STRING = "{\n" +
            "    \"extendDsList\": [\n" +
            "        {\n" +
            "            \"datasource\": {\n" +
            "                \"code\": \"first_internal_1\",\n" +
            "                \"createTime\": \"2019-10-09 14:58:21\",\n" +
            "                \"description\": \"行内第一数据源\",\n" +
            "                \"modifyTime\": \"2019-10-09 16:55:25\",\n" +
            "                \"name\": \"行内第一数据源\",\n" +
            "                \"providerCode\": \"internal_database\",\n" +
            "                \"providerInfo\": \"{\\\"jdbcUrl\\\":\\\"jdbc:mysql://10.2.1.106:3306/data_engine\\\",\\\"password\\\":\\\"Y1R1MTIzNDU2\\\",\\\"userName\\\":\\\"ctu\\\"}\",\n" +
            "                \"providerName\": \"数据聚合联调库\",\n" +
            "                \"providerType\": \"MYSQL\",\n" +
            "                \"querySql\": \"select code, name, url, source from name_list_info where code = #{code}\",\n" +
            "                \"serviceTtl\": 7,\n" +
            "                \"serviceUrl\": \"\",\n" +
            "                \"status\": 1,\n" +
            "                \"type\": 4\n" +
            "            },\n" +
            "            \"paramReqList\": [\n" +
            "                {\n" +
            "                    \"code\": \"name\",\n" +
            "                    \"createTime\": \"2019-10-09 14:58:21\",\n" +
            "                    \"dataType\": \"string\",\n" +
            "                    \"modifyTime\": \"2019-10-09 15:01:30\",\n" +
            "                    \"name\": \"名称\",\n" +
            "                    \"required\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                    \"code\": \"id\",\n" +
            "                    \"createTime\": \"2019-10-09 14:58:21\",\n" +
            "                    \"dataType\": \"long\",\n" +
            "                    \"modifyTime\": \"2019-10-09 15:01:34\",\n" +
            "                    \"name\": \"身份证号\",\n" +
            "                    \"required\": 1\n" +
            "                }\n" +
            "            ],\n" +
            "            \"paramResList\": [\n" +
            "                {\n" +
            "                    \"code\": \"phone\",\n" +
            "                    \"createTime\": \"2019-10-09 14:58:21\",\n" +
            "                    \"dataType\": \"int\",\n" +
            "                    \"modifyTime\": \"2019-10-09 15:01:24\",\n" +
            "                    \"name\": \"手机号\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"code\": \"rank\",\n" +
            "                    \"createTime\": \"2019-10-09 14:58:21\",\n" +
            "                    \"dataType\": \"string\",\n" +
            "                    \"modifyTime\": \"2019-10-09 15:01:19\",\n" +
            "                    \"name\": \"排位分\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"provider\": {\n" +
            "                \"code\": \"internal_database\",\n" +
            "                \"createTime\": \"2019-10-09 14:58:09\",\n" +
            "                \"modifyTime\": \"2019-10-09 14:58:09\",\n" +
            "                \"name\": \"数据聚合联调库\"\n" +
            "            }\n" +
            "        }\n" +
            "    ],\n" +
            "    \"realDsList\": []\n" +
            "}";
}
