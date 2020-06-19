package com.example.disease_server_system.service.impl;

import com.example.disease_server_system.entity.Log;
import com.example.disease_server_system.dao.LogDao;
import com.example.disease_server_system.service.LogService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * 日志表(Log)表服务实现类
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
@Service("logService")
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Log queryById(Integer id) {
        return this.logDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<Log> queryAll() {
        return this.logDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    @Override
    public Log insert(Log log) {
        this.logDao.insert(log);
        return log;
    }

    /**
     * 修改数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    @Override
    public Log update(Log log) {
        this.logDao.update(log);
        return this.queryById(log.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.logDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    @Override
    public Log insertSelective(Log log) {
        this.logDao.insert(log);
        return log;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return logDao.count();
     }
}