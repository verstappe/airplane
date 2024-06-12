package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.dto.FlightDiscussDTO;
import com.sky.mapper.FlightDiscussMapper;
import com.sky.result.PageResult;
import com.sky.service.FlightDiscussService;
import com.sky.service.FlightOrderService;
import com.sky.vo.FlightDiscussVO;
import com.sky.vo.FlightOrderVO;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 林先生
 * @version 1.0
 */
@Service
public class FlightDiscussServiceImpl implements FlightDiscussService {
    @Autowired
    private FlightDiscussMapper flightDiscussMapper;
    /**
     * 删除评论
     * @param ids
     */
    @Override
    public void deleteUserDiscussByIds(List<Integer> ids) {
        for(Integer id : ids){
            flightDiscussMapper.deleteUserDidcussById(id);
        }
    }

    /**
     * 根据日期或者留言用户来查询
     * @param flightDiscussDTO
     * @return
     */
    @Override
    public PageResult getDiscussByDateOrUser(FlightDiscussDTO flightDiscussDTO) {
        PageHelper.startPage(flightDiscussDTO.getPageNum(),flightDiscussDTO.getPageSize());
        Page<FlightDiscussVO> page = flightDiscussMapper.getDiscussByDateOrUser(flightDiscussDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
