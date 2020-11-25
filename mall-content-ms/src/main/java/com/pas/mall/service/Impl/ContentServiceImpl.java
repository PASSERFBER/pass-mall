package com.pas.mall.service.Impl;

import com.pas.mall.entity.ResultPage;
import com.pas.mall.mapper.TbContentMapper;
import com.pas.mall.pojo.TbContent;
import com.pas.mall.pojo.TbContentExample;
import com.pas.mall.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper tbContentMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<TbContent> findAll() {
        return tbContentMapper.selectByExample(null);
    }

    @Override
    public void update(TbContent tbContent) {
        TbContent oldContent = tbContentMapper.selectByPrimaryKey(tbContent.getId());
        redisTemplate.boundHashOps("content").delete(oldContent.getCategoryId());
        tbContentMapper.updateByPrimaryKey(tbContent);
        if (oldContent.getCategoryId() != tbContent.getCategoryId()){
            redisTemplate.boundHashOps("content").delete(tbContent.getCategoryId());
        }

    }

    @Override
    public void add(TbContent tbContent) {
        tbContentMapper.insert(tbContent);
        redisTemplate.boundHashOps("content").delete(tbContent.getCategoryId());
        System.out.println("添加成功，redis");

    }

    @Override
    public TbContent findOne(Long id) {
        return tbContentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids) {
            TbContent tbContent = tbContentMapper.selectByPrimaryKey(id);
            redisTemplate.boundHashOps("content").delete(tbContent.getCategoryId());
            tbContentMapper.deleteByPrimaryKey(id);
            System.out.println("删除成功");
        }
    }

    @Override
    public ResultPage findPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public List<TbContent> findCategoryById(Long categoryId) {
        List<TbContent> list = (List<TbContent>) redisTemplate.boundHashOps("content").get(categoryId);

        if(list==null){
            System.out.println("redis中没有，需要从数据库中读取！！！！！！！！！！！！！！！");
            TbContentExample example = new TbContentExample();
            TbContentExample.Criteria criteria = example.createCriteria();
            criteria.andStatusEqualTo("1");  //category有效的
            criteria.andCategoryIdEqualTo(categoryId);//category相同的
            list = tbContentMapper.selectByExample(example);
            redisTemplate.boundHashOps("content").put(categoryId,list);//向content域中添加键值对

        }else {
            System.out.println("redis中有，不需要从数据库中读取！！！！！！！！！！！！！！！");
        }
        return list;
    }
}
