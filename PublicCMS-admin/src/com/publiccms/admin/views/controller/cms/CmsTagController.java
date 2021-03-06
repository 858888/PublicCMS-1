package com.publiccms.admin.views.controller.cms;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.publiccms.entities.cms.CmsTag;
import com.publiccms.logic.service.cms.CmsTagService;
import com.sanluan.common.base.BaseController;
@Controller
@RequestMapping("cmsTag")
public class CmsTagController extends BaseController {
	@Autowired
	private CmsTagService service;

	@RequestMapping(value = { "save" })
	public String save(CmsTag entity, HttpServletRequest request) {
		if (notEmpty(entity.getId())) {
			service.update(entity.getId(), entity, new String[]{"id"});
		} else {
			service.save(entity);
		}
		return "common/ajaxDone";
	}

	@RequestMapping(value = { "delete" })
	public String delete(Integer id) {
		service.delete(id);
		return "common/ajaxDone";
	}
}