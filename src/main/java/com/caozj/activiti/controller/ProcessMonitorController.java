package com.caozj.activiti.controller;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caozj.activiti.util.ActivitiObjectUtil;
import com.caozj.activiti.vo.ProcessInstanceVo;
import com.caozj.controller.form.EasyUIPageForm;
import com.caozj.framework.model.easyui.PageGrid;
import com.caozj.framework.model.json.JsonResult;
import com.caozj.framework.util.common.JsonUtil;

/**
 * 流程监控
 * 
 * @author caozj
 *
 */
@Controller
@RequestMapping("/processMonitor")
public class ProcessMonitorController {

  @Autowired
  private RuntimeService runtimeService;

  @RequestMapping
  public String list() {
    return "activiti/processMonitorList";
  }

  @RequestMapping("/listDataOfEasyUI.do")
  public String listDataOfEasyUI(ModelMap model, EasyUIPageForm form, String processName) {
    ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery();
    if (StringUtils.isNotEmpty(processName)) {
      query.processDefinitionName(processName);
    }
    List<ProcessInstance> list = query.orderByProcessInstanceId().desc()
        .listPage((form.getPage() - 1) * form.getRows(), form.getRows());
    int total = NumberUtils.toInt(query.count() + "");
    List<ProcessInstanceVo> voList = new ArrayList<>(list.size());
    list.forEach((processInstance) -> {
      ProcessInstanceVo vo = ActivitiObjectUtil.buildProcessInstanceVo(processInstance);
      voList.add(vo);
    });
    String message = JsonUtil.toJson(new PageGrid(total, voList));
    model.put("message", message);
    return "message";
  }

  /**
   * 启动流程实例
   * 
   * @param id 流程实例ID
   * @param model
   * @return
   */
  @RequestMapping
  public String startProcessInstance(String id, ModelMap model) {
    runtimeService.activateProcessInstanceById(id);
    model.put("message", new JsonResult().toJson());
    return "message";
  }

  /**
   * 暂停流程实例
   * 
   * @param id 流程实例ID
   * @param model
   * @return
   */
  @RequestMapping
  public String stopProcessInstance(String id, ModelMap model) {
    runtimeService.suspendProcessInstanceById(id);
    model.put("message", new JsonResult().toJson());
    return "message";
  }
}
