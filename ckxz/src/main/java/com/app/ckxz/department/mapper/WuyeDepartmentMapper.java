package com.app.ckxz.department.mapper;

import com.app.ckxz.base.mapper.BaseMapper;
import com.app.ckxz.department.moder.WuyeDepartment;
import java.util.List;
import java.util.Map;

public interface WuyeDepartmentMapper extends BaseMapper<WuyeDepartment,String> {
    /**
     * 根据uuid删除物业部门
     * @param uuid
     * @return
     */
    int deleteByPrimaryKey(String uuid);

    /**
     * 添加部门
     * @param record
     * @return
     */
    int insert(WuyeDepartment record);

    /**
     * 根据uuid查看部门
     * @param uuid
     * @return
     */
    WuyeDepartment selectByPrimaryKey(String uuid);

    /**
     * 查询所有部门
     * @return
     */
    List<WuyeDepartment> selectAll();

    /**
     * 修改部门
     * @param record
     * @return
     */
    int updateByPrimaryKey(WuyeDepartment record);

    /**
     * 根据物业uuid查询部门 根据名字模糊查询
     */
    List<WuyeDepartment> selectAllByWuYeUUid(Map<String ,String> map);
}