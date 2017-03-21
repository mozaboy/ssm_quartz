package com.zxk175.ssm.controller;

import com.zxk175.ssm.dto.NodeVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxk175 on 17/3/21.
 */
@Controller
@RequestMapping("/tree")
public class TreeController {

    @RequestMapping("/")
    public ModelAndView toTreePage() {
        ModelAndView mv = new ModelAndView("show_tree");
        mv.addObject("page_title", "TreeView");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/init")
    public List<NodeVO> doInitTreeData() {
        List<NodeVO> nodeVOS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            NodeVO node = new NodeVO();
            node.setId(i);
            node.setText("Name" + i);
            node.setLink("http://www.baidu.com");
            nodeVOS.add(node);
        }
        return nodeVOS;
    }


}
