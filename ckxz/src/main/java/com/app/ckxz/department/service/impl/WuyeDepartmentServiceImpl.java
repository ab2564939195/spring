package com.app.ckxz.department.service.impl;

import com.alibaba.fastjson.JSON;
import com.app.ckxz.department.mapper.WuyeDepartmentMapper;
import com.app.ckxz.department.moder.WuyeDepartment;
import com.app.ckxz.department.service.WuyeDepartmentService;
import com.app.ckxz.userb.mapper.UserDMapper;
import com.app.ckxz.util.ReturnResult;
import com.app.ckxz.wuyeemployee.mapper.WuyeEmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 物业部门服务层
 */
@Service
public class WuyeDepartmentServiceImpl implements WuyeDepartmentService {
    @Resource
    private WuyeDepartmentMapper wuyeDepartmentMapper;
    @Override
    /**
     * 添加部门
     */
    public ReturnResult insert(String t) {
        ReturnResult returnResult = new ReturnResult();
        if(t == null || "".equals(t)){
            returnResult.setMsg("参数有误");
            returnResult.setReturnCode(-1);
            return returnResult;
        }
        WuyeDepartment wuyeDepartment = JSON.parseObject(t,WuyeDepartment.class);
        if(wuyeDepartment == null){
            returnResult.setMsg("对象有误");
            returnResult.setReturnCode(-1);
            return returnResult;
        }
        if(wuyeDepartment.getDepartmentName() == null || wuyeDepartment.getWuyeUuid() == null ||  "".equals(wuyeDepartment.getDepartmentName()) || "".equals(wuyeDepartment.getWuyeUuid())){
            returnResult.setMsg("参数有误");
            returnResult.setReturnCode(-1);
            return returnResult;
        }
        wuyeDepartment.setUuid(UUID.randomUUID().toString());
        if(wuyeDepartmentMapper.insert(wuyeDepartment)>0){
            returnResult.setMsg("添加部门成功");
            returnResult.setReturnCode(200);
            return returnResult;
        }else{
            returnResult.setMsg("添加部门失败");
            returnResult.setReturnCode(-1);
            return returnResult;
        }
    }

    @Override
    public ReturnResult insertList(String t) {
        return null;
    }

    /**
     * 根据部门uuid删除物业部门
     * @param uuid
     * @return
     */
    @Override
    public ReturnResult deleteById(String uuid) {
        ReturnResult returnResult = new ReturnResult();
        if(uuid == null || "".equals(uuid)){
            returnResult.setMsg("参数有误");
            returnResult.setReturnCode(-1);
            return returnResult;
        }
        if (wuyeDepartmentMapper.deleteByPrimaryKey(uuid)>0) {
            returnResult.setMsg("删除部门成功");
            returnResult.setReturnCode(200);
            return returnResult;
        }else{
            returnResult.setMsg("删除部门失败");
            returnResult.setReturnCode(-1);
            return returnResult;
        }
    }

    /**
     * 根据uuid查询物业部门
     * @param uuid
     * @return
     */
    @Override
    public ReturnResult deleteList(String uuid) {
        ReturnResult returnResult = new ReturnResult();
        if(uuid == null || "".equals(uuid)){
            returnResult.setMsg("参数有误");
            returnResult.setReturnCode(-1);
            return returnResult;
        }
        WuyeDepartment wuyeDepartment = wuyeDepartmentMapper.selectByPrimaryKey(uuid);
        returnResult.setReturnCode(200);
        returnResult.setObject(wuyeDepartment);
        returnResult.setMsg("查询成功");
        return returnResult;
    }

    /**
     * 修改物业部门
     * @param t
     * @return
     */
    @Override
    public ReturnResult update(String t) {
        ReturnResult returnResult = new ReturnResult();
        if(t == null || "".equals(t)){
            returnResult.setMsg("参数有误");
            returnResult.setReturnCode(-1);
            return returnResult;
        }
        WuyeDepartment wuyeDepartment = JSON.parseObject(t,WuyeDepartment.class);
        if(wuyeDepartment == null){
            returnResult.setMsg("对象有误");
            returnResult.setReturnCode(-1);
            return returnResult;
        }
        if(wuyeDepartment.getDepartmentName() == null ||
                wuyeDepartment.getWuyeUuid() == null ||
                wuyeDepartment.getUuid() == null ||
                "".equals(wuyeDepartment.getDepartmentName()) ||
                "".equals(wuyeDepartment.getWuyeUuid())||
                "".equals(wuyeDepartment.getUuid())){

            returnResult.setMsg("参数有误");
            returnResult.setReturnCode(-1);
            return returnResult;
        }
        if(wuyeDepartmentMapper.updateByPrimaryKey(wuyeDepartment)>0){
            returnResult.setMsg("修改部门成功");
            returnResult.setReturnCode(200);
            return returnResult;
        }else{
            returnResult.setMsg("修改部门失败");
            returnResult.setReturnCode(-1);
            return returnResult;
        }
    }

    @Override
    public ReturnResult updateList(String t) {
        return null;
    }

    /**
     * 查询所有部门or根据物业uuid查询or根据部门名模糊查询
     * @param uuid
     * @return
     */
    @Override
    public ReturnResult findById(String uuid) {
        ReturnResult returnResult = new ReturnResult();
        if(uuid == null || "".equals(uuid)){
            returnResult.setMsg("参数有误");
            returnResult.setReturnCode(-1);
            return returnResult;
        }
        Map<String,String> map = JSON.parseObject(uuid,Map.class);
        if(!map.isEmpty()){
            if(map.get("departmentName")!= null){
                map.put("departmentName" , map.get("departmentName")+"%");
            }
        }
        List<WuyeDepartment> wuyeDepartments = wuyeDepartmentMapper.selectAllByWuYeUUid(map);
        returnResult.setReturnCode(200);
        returnResult.setObj(wuyeDepartments);
        returnResult.setMsg("查询成功");
        return returnResult;
    }

    @Override
    public ReturnResult findAll() {
        return null;
    }
}
