package com.sky.service.impl;

import com.alibaba.druid.sql.dialect.postgresql.ast.expr.PGInetExpr;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.constant.PasswordConstant;
import com.sky.constant.StatusConstant;
import com.sky.dto.*;

import com.sky.entity.FlightUser;
import com.sky.exception.AccountLockedException;
import com.sky.exception.AccountNotFoundException;
import com.sky.exception.FlightException;
import com.sky.exception.PasswordErrorException;
import com.sky.mapper.FlightUserMapper;
import com.sky.result.PageResult;
import com.sky.service.FlightAdminService;
import com.sky.service.FlightUserService;
import com.sky.vo.FlightOrderVO;
import com.sky.vo.FlightUserVO;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;


@Service
public class FlightUserServiceImpl implements FlightUserService {
   @Autowired
   private FlightUserMapper flightUserMapper;

    @Override
    public FlightUser login(FlightUserLoginDTO flightUserLoginDTO) {
        String userName = flightUserLoginDTO.getUserName();
        String password = flightUserLoginDTO.getUserPwd();

        //1、根据用户名查询数据库中的数据
        FlightUser flightUser = flightUserMapper.getByUsername(userName);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (flightUser == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码比对
        //对前端传过来的明文密码进行md5加密处理
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(flightUser.getUserPwd())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (flightUser.getUserStatus() == StatusConstant.DISABLE) {
            //账号被锁定
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        //3、返回实体对象
        return flightUser;
    }

    /**
     * 注册用户账号
     *
     * @param flightUserDTO
     */
    public void save(FlightUserDTO flightUserDTO) {
        FlightUser flightUser = new FlightUser();

        //对象属性拷贝
        BeanUtils.copyProperties(flightUserDTO, flightUser);

        //设置账号的状态，默认正常状态 1表示正常 0表示锁定
        flightUser.setUserStatus(StatusConstant.ENABLE);

        //设置密码，默认密码123456
        flightUser.setUserPwd(DigestUtils.md5DigestAsHex(PasswordConstant.DEFAULT_PASSWORD.getBytes()));


        flightUserMapper.insert(flightUser);
    }

    /**
     * 分页查询
     *
     * @param flightUserPageQueryDTO
     * @return
     */
    public PageResult pageQuery(FlightUserPageQueryDTO flightUserPageQueryDTO) {

        //开始分页查询
        PageHelper.startPage(flightUserPageQueryDTO.getPageNum(),flightUserPageQueryDTO.getPageSize());
        Page<FlightUser> page = flightUserMapper.pageQuery(flightUserPageQueryDTO);
        long total = page.getTotal();
        List<FlightUser> records = page.getResult();
        return new PageResult(total, records );
    }

    /**
     * 启用禁用员工账号
     *
     * @param userStatus
     * @param userId
     */
    public void startOrStop(Integer userStatus, Integer userId) {

        FlightUser flightUser = FlightUser.builder()
                .userStatus(userStatus)
                .userId(userId)
                .build();

        flightUserMapper.update(flightUser);
    }

    /**
     * 根据userId查询用户
     *
     * @param userId
     * @return
     */
    public FlightUser getById(Integer userId) {
        FlightUser flightUser = flightUserMapper.getById(userId);
        flightUser.setUserPwd("****");
        return flightUser;
    }

    /**
     * 编辑用户信息
     *
     * @param flightUserDTO
     */
    public void update(FlightUserDTO flightUserDTO) {
        FlightUser flightUser = new FlightUser();
        BeanUtils.copyProperties(flightUserDTO, flightUser);
        if(flightUserDTO.getUserId() == null || flightUserDTO.getRealName() == null){
            throw new FlightException("用户ID和用户的真实姓名必须填");
        }

        flightUserMapper.update(flightUser);
    }

}
