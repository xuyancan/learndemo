package com.ctoedu.common.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.ctoedu.common.model.search.Searchable;

/**
 * 抽象DAO层基类 提供一些简便方法
 * 具体使用请参考测试用例：{@see com.sishuok.es.common.repository.UserRepository}
 * 想要使用该接口需要在spring配置文件的jpa:repositories中添加
 * factory-class="com.sishuok.es.common.repository.support.SimpleBaseRepositoryFactoryBean"
 * 泛型 ： M 表示实体类型；ID表示主键类型
 *
 * Date:2016年11月4日 下午4:47:29
 * Version:1.0
 */
@NoRepositoryBean
public interface BaseRepository<M, ID extends Serializable> extends JpaRepository<M, ID> {

    /**
     * 根据条件查询所有
     * 条件 + 分页 + 排序
     *
     * @param searchable
     * @return
     */
    public Page<M> findAll(Searchable searchable);


    /**
     * 根据条件统计所有记录数
     *
     * @param searchable
     * @return
     */
    public long count(Searchable searchable);
    
    /**
     * 根据主键删除
     *
     * @param ids
     */
    public void delete(ID[] ids);

}