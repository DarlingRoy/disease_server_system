package com.example.disease_server_system.service.impl;

import com.example.disease_server_system.bo.DangerousNum;
import com.example.disease_server_system.entity.Health;
import com.example.disease_server_system.dao.HealthDao;
import com.example.disease_server_system.service.HealthService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * 健康状况记录表(Health)表服务实现类
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
@Service("healthService")
public class HealthServiceImpl implements HealthService {
    @Autowired
    private HealthDao healthDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Health queryById(Integer id) {
        return this.healthDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<Health> queryAll() {
        return this.healthDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param health 实例对象
     * @return 实例对象
     */
    @Override
    public Health insert(Health health) {
        this.healthDao.insert(health);
        return health;
    }

    /**
     * 修改数据
     *
     * @param health 实例对象
     * @return 实例对象
     */
    @Override
    public Health update(Health health) {
        this.healthDao.update(health);
        return this.queryById(health.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.healthDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param health 实例对象
     * @return 实例对象
     */
    @Override
    public Health insertSelective(Health health) {
        this.healthDao.insert(health);
        return health;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return healthDao.count();
     }

    /**
     * 根据可选字段查询
     *
     * @return
     */
    @Override
    public List<Health> queryByOptionalField(Health health) {
        return healthDao.queryByOptionalField(health);
    }

    /**
     * 统计当天内填报总人数
     *
     * @return
     */
    @Override
    public Integer countTodayTotalNum() {
        return healthDao.countTodayTotalNum();
    }

    /**
     * 当天内 去过湖北、在国外、去过国外、接触过境人员、接触病例、非健康状态 的人数
     *
     * @return
     */
    @Override
    public DangerousNum countTodayDangerousNum() {
        return healthDao.countTodayDangerousNum();
    }
}