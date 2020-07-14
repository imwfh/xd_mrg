package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.TbProfitUser;
import com.ruoyi.system.service.ITbProfitUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户基本 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
@Controller
@RequestMapping("/system/tbProfitUser")
public class TbProfitUserController extends BaseController
{
    private String prefix = "system/tbProfitUser";
	
	@Autowired
	private ITbProfitUserService tbProfitUserService;
	
	@RequiresPermissions("system:tbProfitUser:view")
	@GetMapping()
	public String tbProfitUser()
	{
	    return prefix + "/tbProfitUser";
	}
	
	/**
	 * 查询用户基本列表
	 */
	@RequiresPermissions("system:tbProfitUser:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TbProfitUser tbProfitUser)
	{
		startPage();
        List<TbProfitUser> list = tbProfitUserService.selectTbProfitUserList(tbProfitUser);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户基本列表
	 */
	@RequiresPermissions("system:tbProfitUser:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbProfitUser tbProfitUser)
    {
    	List<TbProfitUser> list = tbProfitUserService.selectTbProfitUserList(tbProfitUser);
        ExcelUtil<TbProfitUser> util = new ExcelUtil<TbProfitUser>(TbProfitUser.class);
        return util.exportExcel(list, "tbProfitUser");
    }
	
	/**
	 * 新增用户基本
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户基本
	 */
	@RequiresPermissions("system:tbProfitUser:add")
	@Log(title = "用户基本", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TbProfitUser tbProfitUser)
	{		
		return toAjax(tbProfitUserService.insertTbProfitUser(tbProfitUser));
	}

	/**
	 * 修改用户基本
	 */
	@GetMapping("/edit/{userId}")
	public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
	{
		TbProfitUser tbProfitUser = tbProfitUserService.selectTbProfitUserById(userId);
		mmap.put("tbProfitUser", tbProfitUser);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户基本
	 */
	@RequiresPermissions("system:tbProfitUser:edit")
	@Log(title = "用户基本", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TbProfitUser tbProfitUser)
	{		
		return toAjax(tbProfitUserService.updateTbProfitUser(tbProfitUser));
	}
	
	/**
	 * 删除用户基本
	 */
	@RequiresPermissions("system:tbProfitUser:remove")
	@Log(title = "用户基本", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tbProfitUserService.deleteTbProfitUserByIds(ids));
	}
	
}
