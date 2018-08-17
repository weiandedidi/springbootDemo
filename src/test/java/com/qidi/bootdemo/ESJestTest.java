package com.qidi.bootdemo;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/8/17
 * Time: 下午1:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ESJestTest {

//    @Autowired
//    JestClient jestClient;

/*    @Test
    public void contextloads() {
        //1. 给es索引保存一个文档
        Artitle artitle = new Artitle();
        artitle.setId(1);
        artitle.setTitle("wenzhang");
        artitle.setAuthor("mamamam");
        artitle.setContent("我是内容");

        //构建索引功能
        Index index = new Index.Builder(artitle).index("qidi").type("news").build();

        //执行

        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

/*
    @Test
    public void search() {
        String json = "{\n" +
                "  \"query\": {\n" +
                "    \"match\": {\n" +
                "      \"last_name\": \"Smith\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        Search search = new Search.Builder(json).addIndex("atguigu").addType("news").build();
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
*/


}
