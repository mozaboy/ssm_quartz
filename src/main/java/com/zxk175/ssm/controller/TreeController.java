package com.zxk175.ssm.controller;

import com.zxk175.ssm.dao.TChinaMapper;
import com.zxk175.ssm.dto.NodeVO;
import com.zxk175.ssm.pojo.TChina;
import com.zxk175.ssm.pojo.TChinaCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxk175 on 17/3/21.
 */
@Controller
@RequestMapping("/tree")
public class TreeController {

    @Resource
    private TChinaMapper tChinaMapper;

    @RequestMapping("/")
    public ModelAndView toTreePage() {
        ModelAndView mv = new ModelAndView("show_tree");
        mv.addObject("page_title", "TreeView");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/init")
    public List<NodeVO> doInitTreeData() {
        TChinaCriteria example = new TChinaCriteria();
        TChinaCriteria.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(0);
        List<TChina> list = tChinaMapper.selectByExample(example);
        int size = list.size();
        List<NodeVO> nodeVOS = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            NodeVO node = new NodeVO();
            node.setNodeId(list.get(i).getCityId());
            node.setText(list.get(i).getCityName());
            node.setParentId(list.get(i).getParentId());
            nodeVOS.add(node);
        }
        return nodeVOS;
    }
}
