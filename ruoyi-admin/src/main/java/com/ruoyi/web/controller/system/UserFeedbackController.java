package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.UserFeedback;
import com.ruoyi.system.service.IUserFeedbackService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 用户反馈 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-12-28
 */
@Controller
@RequestMapping("/system/userFeedback")
public class UserFeedbackController extends BaseController
{
    private String prefix = "system/userFeedback";
	
	@Autowired
	private IUserFeedbackService userFeedbackService;
	
	@RequiresPermissions("system:userFeedback:view")
	@GetMapping()
	public String userFeedback()
	{
	    return prefix + "/userFeedback";
	}
	
	/**
	 * 查询用户反馈列表
	 */
	@RequiresPermissions("system:userFeedback:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(UserFeedback userFeedback)
	{
		startPage();
        List<UserFeedback> list = userFeedbackService.selectUserFeedbackList(userFeedback);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户反馈列表
	 */
	@RequiresPermissions("system:userFeedback:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserFeedback userFeedback)
    {
    	List<UserFeedback> list = userFeedbackService.selectUserFeedbackList(userFeedback);
        ExcelUtil<UserFeedback> util = new ExcelUtil<UserFeedback>(UserFeedback.class);
        return util.exportExcel(list, "userFeedback");
    }
	
	/**
	 * 新增用户反馈
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户反馈
	 */
	@RequiresPermissions("system:userFeedback:add")
	@Log(title = "用户反馈", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(UserFeedback userFeedback)
	{		
		return toAjax(userFeedbackService.insertUserFeedback(userFeedback));
	}

	/**
	 * 修改用户反馈
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		UserFeedback userFeedback = userFeedbackService.selectUserFeedbackById(id);
		mmap.put("userFeedback", userFeedback);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户反馈
	 */
	@RequiresPermissions("system:userFeedback:edit")
	@Log(title = "用户反馈", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(UserFeedback userFeedback)
	{		
		return toAjax(userFeedbackService.updateUserFeedback(userFeedback));
	}
	
	/**
	 * 删除用户反馈
	 */
	@RequiresPermissions("system:userFeedback:remove")
	@Log(title = "用户反馈", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(userFeedbackService.deleteUserFeedbackByIds(ids));
	}
	
}
