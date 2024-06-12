package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.dto.FlightContentDTO;
import com.sky.dto.FlightDiscussDTO;
import com.sky.exception.FlightContentException;
import com.sky.mapper.FlightContentMapper;
import com.sky.result.PageResult;
import com.sky.service.FlightContentService;
import com.sky.service.FlightDiscussService;
import com.sky.vo.FlightContentVO;
import com.sky.vo.FlightDiscussVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FlightContentServiceImpl implements FlightContentService {

    @Autowired
    private FlightContentMapper flightContentMapper;
    @Override
    public void save(FlightContentDTO flightContentDTO) {
        if(flightContentDTO.getContentUrl()==null&&flightContentDTO.getContentPictureUrl()==null){
            throw new FlightContentException("广告链接或者广告图片的链接未填写");
        }
        flightContentMapper.save(flightContentDTO);
    }

    /**
     * 删除广告
     * @param contentIds
     */
    @Override
    public void deleteContentById(List<Integer> contentIds) {
        for(Integer id:contentIds) {
            flightContentMapper.deleteContentById(id);
        }
    }

    /**
     * 查询广告信息
     * @param flightContentDTO
     * @return
     */
    @Override
    public PageResult getContent(FlightContentDTO flightContentDTO) {
        PageHelper.startPage(flightContentDTO.getPageNum(),flightContentDTO.getPageSize());
        Page<FlightContentVO> page = flightContentMapper.getContent(flightContentDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
