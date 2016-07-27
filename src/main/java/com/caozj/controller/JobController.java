package com.caozj.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.caozj.controller.form.EasyUIPageForm;
import com.caozj.framework.model.easyui.PageGrid;
import com.caozj.framework.util.jdbc.Pager;
import com.caozj.framework.model.json.JsonResult;
import com.caozj.framework.util.common.JsonUtil;
import com.caozj.model.Job;
import com.caozj.service.JobService;

/**
 * 任务 Controller
 * 
 * @author caozj
 *  
 */
@Controller
@RequestMapping("/job")
public class JobController {

	@Autowired
	private JobService jobService;
	@RequestMapping("/list.do")
	public String list(ModelMap model) {
		return "job/list";
	}
	
	@RequestMapping("/listDataOfEasyUI.do")
	public String listDataOfEasyUI(ModelMap model, EasyUIPageForm form) {
		Pager page = new Pager((form.getPage()-1) * form.getRows(), form.getRows());
		List<Job> list = jobService.page(page);
		String message = JsonUtil.toJson(new PageGrid(page.getTotalCount(), list));
		model.put("message", message);
		return "message";
	}
	
	@RequestMapping("/toAdd.do")
	public String toAdd() {
		return "job/add";
	}
	
	@RequestMapping("/toUpdate.do")
	public String toUpdate(int id, ModelMap model) {
		Job job = jobService.get(id);
		model.put("job", job);
		return "job/update";
	}



	@RequestMapping("/add.do")
	public String add(Job job, ModelMap model) {
		jobService.add(job);
		model.put("message", new JsonResult().toJson());
		return "message";
	}

	@RequestMapping("/update.do")
	public String update(Job job, ModelMap model) {
		jobService.update(job);
		model.put("message", JsonUtil.successJson());
		return "message";
	}

	@RequestMapping("/batchDelete.do")
	public String batchDelete(Integer[] ids, ModelMap model) {
		List<Integer> idList = Arrays.asList(ids);
		jobService.batchDelete(idList);
		model.put("message", new JsonResult().toJson());
		return "message";
	}
	
	@RequestMapping("/delete.do")
	public String delete(int id, ModelMap model) {
		jobService.delete(id);
		model.put("message", JsonUtil.successJson());
		return "message";
	}

	@RequestMapping("/show.do")
	public String show(int id, ModelMap model) {
		Job job = jobService.get(id);
		model.put("job", job);
		return "job/show";
	}
	
	@RequestMapping("/get.do")
	public String get(int id, ModelMap model) {
		Job job = jobService.get(id);
		model.put("message", new JsonResult(job).toJson());
		return "message";
	}

}
