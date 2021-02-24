package cn.sw.controller;
import cn.sw.entity.User;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetRequest;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@RestController
public class ElasticSearchController {

    @Autowired
    RestHighLevelClient restHighLevelClient;


    /**
     * 新建索引
     * @throws Exception
     */
    @RequestMapping("createIndexTest")
    public void createIndexTest() throws Exception{
        System.out.println("");
        // 1. 创建索引请求
        CreateIndexRequest firstIndex = new CreateIndexRequest("test_one");
        // 2. 客户端执行创建索引的请求
        CreateIndexResponse response = restHighLevelClient.indices().create(firstIndex, RequestOptions.DEFAULT);
        System.out.println(response);
    }


    /**
     * 判断索引是否存在
     * @throws Exception
     */
    @RequestMapping("existsIndexTest")
    public void existsIndexTest() throws Exception{
        // 1. 创建一个get请求获取指定索引的信息
        GetIndexRequest getIndexRequest = new GetIndexRequest("test_one");

        // 2. 客户端执行请求判断索引是否存在
        boolean exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
        if (!exists) {
            System.out.println(">>>>>>>>> 索引不存在。。。。。");
            return;
        }
    }

    /**
     * 删除指定的索引
     * @throws Exception
     */
    @RequestMapping("deleteIndexTest")
    public void deleteIndexTest() throws Exception{
        // 1. 创建一个get请求获取指定索引的信息
        GetIndexRequest getIndexRequest = new GetIndexRequest("test_one");

        // 2. 客户端执行请求判断索引是否存在
        boolean exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
        if (!exists) {
            System.out.println(">>>>>>>>> 索引不存在。。。。。");
            return;
        }
    }

    /**
     * 创建文档
     * @throws Exception
     */
    @RequestMapping("addDocumentTest")
    public void addDocumentTest(String id) throws Exception{
        // 1. 创建对象
        User user = new User("张刚", 27);
        // 2. 创建请求并指定索引
        IndexRequest indexRequest = new IndexRequest("test_one");
        // 3. 创建的规则：put /xununan_index/_doc/1
        indexRequest.id(id);            // 设置ID
        indexRequest.timeout("1s");      // 设置超时时间
        // 4. 将数据放入到请求中
        indexRequest.source(JSON.toJSONString(user), XContentType.JSON);
        // 5. 使用客户端发送请求
        IndexResponse index = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(index));
    }

    /**
     * 获取文档信息
     * @throws Exception
     */
    @RequestMapping("getDocumentTest")
    public void getDocumentTest() throws Exception{
        // 1. 创建请求信息绑定索引和指定需要查询的文档id
        GetRequest getRequest = new GetRequest("test_one", "1");
        // 设置不获取的返回时的_source的上下文，一般情况是不需要设置的
//        getRequest.fetchSourceContext(new FetchSourceContext(false)).storedFields("_none_");

        // 2. 判断指定的索引和id是否存在
        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        if (!exists) {
            System.out.println(">>>>>>>> 当前索引：xununan_index对应的id：1 不存在");
            return;
        }
        System.out.println(">>>>>>>> 当前索引：xununan_index对应的id：1 存在");
        // 3. 获取指定ID的资源信息
        GetResponse response = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        // 4. 打印获取到的资源信息
        System.out.println(response.getSourceAsString());
        System.out.println(JSON.toJSONString(response));
    }

    /**
     * 更新文档信息
     * @throws Exception
     */
    @RequestMapping("updateDocmentTest")
    public void updateDocmentTest() throws Exception {
        // 1. 创建一个更新请求的信息，绑定索引名称和需要更新的文档ID
        UpdateRequest updateRequest = new UpdateRequest("test_one", "1");
        updateRequest.timeout("1s");     // 设置超时时间
        User user = new User("小明", 28);
        // 2. 封装需要更新的文档信息
        updateRequest.doc(JSON.toJSONString(user), XContentType.JSON);
        // 3. 使用update更新文档
        UpdateResponse updateResponse = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(updateResponse));
    }

    /**
     * 删除文档信息
     * @throws Exception
     */
    @RequestMapping("deleteDocmentTest")
    public void deleteDocmentTest() throws Exception {
        // 1. 创建一个删除的请求，绑定索引名和需要删除的文档ID
        DeleteRequest deleteRequest = new DeleteRequest("test_one", "1");
        // 2. 发起删除请求
        DeleteResponse response = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response));
    }

    /**
     * 批量创建文档
     * @throws Exception
     */
    @RequestMapping("addDocmentByBatchTest")
    public void addDocmentByBatchTest() throws Exception {
        // 1. 创建批量的请求
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");     //  设置超时时间

        List<User> list = new ArrayList<>();
        User user = null;
        for (int i = 1; i <= 10; i++) {
            user = new User("姓名" + i, 20+i);
            list.add(user);
        }

        // 2. 将多条数据批量的放入bulkRequest中
        for (int i = 0; i <list.size(); i++) {
            // 批量更新和批量删除在这里修改对应的请求即可
            bulkRequest.add(new IndexRequest("test_one")
                    .id("" + i)
                    .source(JSON.toJSONString(list.get(i)), XContentType.JSON)
            );
        }

        // 3. 执行批量创建文档
        BulkResponse responses = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(responses.hasFailures());    // 是否失败，如果false则表示全部成功
        System.out.println(JSON.toJSONString(responses));
    }


    @RequestMapping("test1")
    public void test1(){
        MultiGetRequest request = new MultiGetRequest();

        request.add(new MultiGetRequest.Item("test1", "1"));
        request.add(new MultiGetRequest.Item("test1", "4"));
        request.add(new MultiGetRequest.Item("test1", "5"));

        MultiGetResponse mget = null;
        try {
            mget = restHighLevelClient.mget(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 打印查詢結果
        System.out.println("mget:");
        mget.forEach(item -> System.out.println(item.getResponse().getSourceAsString()));
    }


    @RequestMapping("test2")
    public void test2(){
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest("user2").id("2").source(XContentType.JSON, "field", "foo", "user", "lucky"));
        request.add(new IndexRequest("user2").id("4").source(XContentType.JSON, "field", "bar", "user", "Jon"));
        request.add(new IndexRequest("user2").id("5").source(XContentType.JSON, "field", "baz", "user", "Lucy"));
        // id为10的不存在
        request.add(new DeleteRequest("user2", "3"));
        request.add(new UpdateRequest("user2", "2").doc(XContentType.JSON, "other", "test"));
        BulkResponse bulkResponse = null;
        try {
            bulkResponse = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取执行状态
        System.out.println("批量更新结果状态：" + bulkResponse.status());

    }


}
