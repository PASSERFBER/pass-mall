package com.pas.mall.junit;


import com.pas.mall.mapper.TbItemMapper;
import com.pas.mall.pojo.TbItem;
import org.bouncycastle.crypto.paddings.TBCPadding;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;

import java.util.List;

@SpringBootTest
public class testItem {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private SolrTemplate solrTemplate;

    @Test
    public void testRemoveAll(){
        Query query = new SimpleQuery("*:*");
        solrTemplate.delete("collection1",query);
        solrTemplate.commit("collection1");
        System.out.println("操作完成");
    }
    @Test
    public void testImportAll(){

        List<TbItem> list = tbItemMapper.selectByExample(null);
        solrTemplate.saveBeans("collection1",list);
        solrTemplate.commit("collection1");
        System.out.println("导入数据完成");
    }

    @Test
    public void testQuery(){
        Query query = new SimpleQuery("*:*");
        Criteria criteria = new Criteria("item_title").endsWith("手机");
        query.addCriteria(criteria);
        ScoredPage<TbItem> page = solrTemplate.queryForPage("collection1",query,TbItem.class);
        List<TbItem> list = page.getContent();
        for (TbItem tbItem : list) {
            System.out.println(tbItem);
        }
    }

}
