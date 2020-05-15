package com.board.article.controller;

import com.board.article.domain.ArticleVO;
import com.board.article.service.ArticleService;
import com.board.commons.paging.Criteria;
import com.board.commons.paging.PageMaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.Date;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    private final ArticleService articleService;

    @Inject
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /* -------------------------------------------------------------------------------- */

    // 등록 페이지 이동
    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String writeGET() {
        logger.info("normal writeGET() called...");

        return "/article/normal/write";
    }

    // 등록 처리
    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String writePOST(ArticleVO articleVO, RedirectAttributes redirectAttributes) throws Exception {
        logger.info("normal writePOST() called...");
        articleVO.setRegDate(new Date());
        logger.info(articleVO.toString());
        articleService.create(articleVO);
        redirectAttributes.addFlashAttribute("msg", "regSuccess");

        return "redirect:/article/list";
    }

    /* -------------------------------------------------------------------------------- */

    // 목록 페이지 이동
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        logger.info("normal list() called...");
        model.addAttribute("articles", articleService.listAll());

        return "/article/normal/list";
    }

    // 페이징 처리
    @RequestMapping(value = "/listCriteria", method = RequestMethod.GET)
    public String listCriteria(Model model, Criteria criteria) throws Exception {
        logger.info("listCriteria...");
        model.addAttribute("articles", articleService.listCriteria(criteria));

        return "/article/normal/list_criteria";
    }

    /* -------------------------------------------------------------------------------- */

    // 조회 페이지 이동
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String read(@RequestParam("articleNo") int articleNo, Model model) throws Exception {
        logger.info("normal read() called...");
        model.addAttribute("article", articleService.read(articleNo));

        return "/article/normal/read";
    }

    /* -------------------------------------------------------------------------------- */

    // 수정 페이지 이동
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modifyGET(@RequestParam("articleNo") int articleNo, Model model) throws Exception {
        logger.info("normal modifyGET() called...");
        model.addAttribute("article", articleService.read(articleNo));

        return "/article/normal/modify";
    }

    // 수정 처리
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyPOST(ArticleVO articleVO, RedirectAttributes redirectAttributes) throws Exception {
        logger.info("normal modifyPOST() called...");
        articleService.update(articleVO);
        redirectAttributes.addFlashAttribute("msg", "modSuccess");

        return "redirect:/article/list";
    }

    /* -------------------------------------------------------------------------------- */

    // 삭제 처리
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@RequestParam("articleNo") int articleNo, RedirectAttributes redirectAttributes) throws Exception {
        logger.info("normal remove()...");
        articleService.delete(articleNo);
        redirectAttributes.addFlashAttribute("msg", "delSuccess");

        return "redirect:/article/list";
    }

}
