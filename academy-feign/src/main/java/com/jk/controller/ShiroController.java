package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.pojo.Course;
import com.jk.pojo.Mongo;
import com.jk.pojo.MongoCou;
import com.jk.pojo.User;
import com.jk.service.ShiroServiceFeign;
import com.jk.utils.ValidateCodeUtil;
import com.mongodb.client.result.DeleteResult;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
public class ShiroController {

    @Autowired
    public MongoTemplate mongoTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private ShiroServiceFeign shiroServiceFeign;


    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    /**
     * 视频课程查询
     * @return
     */
    @GetMapping("acaDemyQuery")
    @ResponseBody
    public List<Course> acaDemyQuery(){
        List<Course> list = shiroServiceFeign.acaDemyQuery();
        return list;
    }


    @RequestMapping("listHtml")
    public String listHtml(){
        return "listHtml";
    }

    /**
     * ES搜索引擎
     * @param course
     * @return
     */
    @RequestMapping("noopsycheEs")
    @ResponseBody
    public JSONObject queryProduct(Course course){
        JSONObject result = new JSONObject();
        //获取到es的客户端
        Client client = elasticsearchTemplate.getClient();
        /*Integer startIndex = rows*(page-1);*/
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("noopsyche").setTypes("noopsycheType");
        //条件
        if(course.getNoopsycheName() !=null && course.getNoopsycheName() != "" ){
            searchRequestBuilder.setQuery(QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("noopsychename", course.getNoopsycheName())));
        }
        /*if(course.get !=null){
            searchRequestBuilder.setQuery(QueryBuilders.boolQuery().must(QueryBuilders.rangeQuery("price").gte(shop.getStartPrice())));
        }
        if(shop.getEndPrice() !=null){
            searchRequestBuilder.setQuery(QueryBuilders.boolQuery().must(QueryBuilders.rangeQuery("price").lte(shop.getEndPrice())));
        }*/
        //价格排序
        /*if(shop.getSortPrice() == ConstantUtil.ORDER_SORT_ASC){
            searchRequestBuilder.addSort("price", SortOrder.ASC);
        }else if(shop.getSortPrice() == ConstantUtil.ORDER_SORT_DESC){
            searchRequestBuilder.addSort("price", SortOrder.DESC);
        }
        searchRequestBuilder.setFrom(startIndex).setSize(rows);
        // 设置是否按查询匹配度排序
        searchRequestBuilder.setExplain(true);*/

        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("noopsychename");
        highlightBuilder.preTags("<font color='red'>");
        highlightBuilder.postTags("</font>");
        searchRequestBuilder.highlighter(highlightBuilder);

        SearchResponse searchResponse = searchRequestBuilder.get();

        SearchHits hits = searchResponse.getHits();
        //long total = hits.getTotalHits();
        //System.out.println("total = [" + total + "]");

        Iterator<SearchHit> iterator = hits.iterator();

        List<Course> list = new ArrayList<Course>();

        while (iterator.hasNext()){
            SearchHit next = iterator.next();
            Map<String, HighlightField> highlightFields = next.getHighlightFields();

            String sourceAsString = next.getSourceAsString();
            HighlightField info = highlightFields.get("noopsychename");
            Course shopBean = JSON.parseObject(sourceAsString, Course.class);
            //取得定义的高亮标签
            if(info !=null) {
                Text[] fragments = info.fragments();
                //为thinkName（相应字段）增加自定义的高亮标签
                String title = "";
                for (Text text1 : fragments) {
                    title += text1;
                }
                shopBean.setNoopsycheName(title);
            }
            list.add(shopBean);
        }
        //result.put("total",total);
        result.put("returnData",list);
        return result;
    }

    /**
     * 详情查询
     * @param id
     * @return
     */
    @RequestMapping("queryOrder")
    @ResponseBody
    public Course queryOrder(Integer id){
        Client client = elasticsearchTemplate.getClient();
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("noopsyche").setTypes("noopsycheType").setQuery(QueryBuilders.matchQuery("id",id));
        SearchResponse searchResponse = searchRequestBuilder.get();
        SearchHits hits = searchResponse.getHits();
        Iterator<SearchHit> iterator = hits.iterator();
        SearchHit next = iterator.next();
        String sourceAsString = next.getSourceAsString();
        Course housBean1 = JSON.parseObject(sourceAsString, Course.class);
        return housBean1;
    }

    /**
     * 登录
     * @return
     */
    @GetMapping("userLogin")
    @ResponseBody
    public List<User> userLogin(){
        List<User> list = shiroServiceFeign.userLogin();

        return list;
    }

    /**
     * 登录跳页面
     * @return
     */
    @RequestMapping("listHtm")
    public String listHtm(){

        return "loginUser";
    }



}
