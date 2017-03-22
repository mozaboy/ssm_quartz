package com.zxk175.ssm.controller;

import com.zxk175.ssm.dao.TChinaMapper;
import com.zxk175.ssm.dto.NodeVO;
import com.zxk175.ssm.pojo.TChina;
import com.zxk175.ssm.pojo.TChinaCriteria;
import io.swagger.models.auth.In;
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
        List<NodeVO> nodes = getTreeNodesById(0);
        return nodes;
    }

    public List<TChina> listTree(Integer id) {
        TChinaCriteria example = new TChinaCriteria();
        TChinaCriteria.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(id);
        criteria.andCityIdNotEqualTo(id);
        List<TChina> list = tChinaMapper.selectByExample(example);
        return list;
    }

    /**
     * 根据父Id,得到模块树列表
     *
     * @param pid
     * @return
     */
    public List<NodeVO> getTreeNodesById(Integer pid) {
        // 该方法可不用理会,这是内部得到数据的方法,通过父ID,得到下面的数据节点集合
        List<TChina> chinas = listTree(pid);
        List<NodeVO> treeNodes = new ArrayList<>();
        for (TChina module : chinas) {
            // 分别得到每个节点下的子节点集合
            NodeVO treeNode = init(module);
            treeNodes.add(treeNode);
        }
        return treeNodes;
    }

    private NodeVO init(TChina list) {
        List<TChina> chinas = listTree(Integer.valueOf(list.getCityId()));
        NodeVO node = new NodeVO();
        Integer cityId = list.getCityId();
        node.setNodeId(cityId);
        node.setText(list.getCityName());
        node.setHref("http://www.baidu.com");
        node.setTags(new String[]{String.valueOf(chinas.size())});
        List<NodeVO> nodes = new ArrayList<>();
        for (TChina china : chinas) {
            NodeVO sub = init(china);
            nodes.add(sub);
        }
        node.setNodes(nodes);
        return node;
    }
}
