package com.zxk175.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
