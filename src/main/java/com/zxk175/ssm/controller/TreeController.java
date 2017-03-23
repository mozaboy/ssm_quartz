package com.zxk175.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxk175.ssm.dao.TChinaMapper;
import com.zxk175.ssm.dto.table.BTPages;
import com.zxk175.ssm.dto.tree.Node;
import com.zxk175.ssm.pojo.TChina;
import com.zxk175.ssm.pojo.TChinaCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxk175 on 17/3/21.
 */
@ApiIgnore
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
    @RequestMapping(value = "/show/{id}/{type}", method = RequestMethod.POST)
    public BTPages<TChina> showTreeDataByParentId(@PathVariable Integer id, @PathVariable String type, HttpServletRequest request) {
        String limit = request.getParameter("limit");
        String nowPage = request.getParameter("nowPage");

        // 当前页数
        int nowPaged = Integer.parseInt(null == nowPage ? "1" : nowPage);
        // 每页显示页数
        int limitd = Integer.parseInt(null == limit ? "10" : limit);

        BTPages<TChina> pages = new BTPages<>();
        // 开始分页,参数1为请求第几页,参数2为请求条数
        PageHelper.startPage(nowPaged, limitd);

        // 查询条件
        TChinaCriteria example = new TChinaCriteria();
        TChinaCriteria.Criteria criteria = example.createCriteria();
        if ("singe".equals(type)) {
            criteria.andParentIdEqualTo(id);
        } else {
            criteria.andParentIdEqualTo(id);
            criteria.andCityIdNotEqualTo(id);
        }
        List<TChina> list = tChinaMapper.selectByExample(example);

        // 取记录总条数
        PageInfo<TChina> pageInfo = new PageInfo<>(list);
        int total = (int) pageInfo.getTotal();

        pages.setSuccess(true);
        pages.setMsg("共查询出" + total + "条数据!");
        pages.setRecords(list);
        pages.setTotal(total);
        pages.setStatus(0);
        return pages;
    }

    @ResponseBody
    @RequestMapping("/init")
    public List<Node> doInitTreeData() {
        List<Node> nodes = getTreeNodesByPId(0);
        return nodes;
    }

    /**
     * 通过父Id,得到下面的数据节点集合
     *
     * @param id
     * @return
     */
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
    public List<Node> getTreeNodesByPId(Integer pid) {
        List<TChina> chinas = listTree(pid);
        List<Node> treeNodes = new ArrayList<>();
        for (TChina module : chinas) {
            // 分别得到每个节点下的子节点集合
            Node treeNode = initData(module);
            treeNodes.add(treeNode);
        }
        return treeNodes;
    }

    /**
     * 递归获取City数据
     *
     * @param tChina
     * @return
     */
    private Node initData(TChina tChina) {
        List<TChina> chinas = listTree(Integer.valueOf(tChina.getCityId()));
        Node node = new Node();
        Integer cityId = tChina.getCityId();
        node.setNodeId(cityId);
        node.setText(tChina.getCityName());
        node.setHref("http://www.baidu.com");
        node.setTags(new String[]{String.valueOf(chinas.size())});
        node.setSelectable(true);
        List<Node> nodes = null;

        // 判断是否为叶子节点
        if (chinas.isEmpty()) {
            node.setLeaf(true);
            node.setIcon("glyphicon glyphicon-leaf");
        } else {
            // 不是叶子节点，递归查询下一层子节点
            nodes = new ArrayList<>();
            for (TChina china : chinas) {
                Node sub = initData(china);
                nodes.add(sub);
            }
        }

        node.setNodes(nodes);
        return node;
    }
}
