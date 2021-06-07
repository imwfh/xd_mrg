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
import com.ruoyi.system.domain.HbApiUser;
import com.ruoyi.system.service.IHbApiUserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 火币用户授权 信息操作处理
 * 
 * @author ruoyi
 * @date 2021-06-07
 */
@Controller
@RequestMapping("/system/hbApiUser")
public class HbApiUserController extends BaseController
{
    private String prefix = "system/hbApiUser";
	
	@Autowired
	private IHbApiUserService hbApiUserService;
	
	@RequiresPermissions("system:hbApiUser:view")
	@GetMapping()
	public String hbApiUser()
	{
	    return prefix + "/hbApiUser";
	}
	
	/**
	 * 查询火币用户授权列表
	 */
	@RequiresPermissions("system:hbApiUser:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HbApiUser hbApiUser)
	{
		startPage();
        List<HbApiUser> list = hbApiUserService.selectHbApiUserList(hbApiUser);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出火币用户授权列表
	 */
	@RequiresPermissions("system:hbApiUser:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HbApiUser hbApiUser)
    {
    	List<HbApiUser> list = hbApiUserService.selectHbApiUserList(hbApiUser);
        ExcelUtil<HbApiUser> util = new ExcelUtil<HbApiUser>(HbApiUser.class);
        return util.exportExcel(list, "hbApiUser");
    }
	
	/**
	 * 新增火币用户授权
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存火币用户授权
	 */
	@RequiresPermissions("system:hbApiUser:add")
	@Log(title = "火币用户授权", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HbApiUser hbApiUser)
	{		
		return toAjax(hbApiUserService.insertHbApiUser(hbApiUser));
	}

	/**
	 * 修改火币用户授权
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		HbApiUser hbApiUser = hbApiUserService.selectHbApiUserById(id);
		mmap.put("hbApiUser", hbApiUser);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存火币用户授权
	 */
	@RequiresPermissions("system:hbApiUser:edit")
	@Log(title = "火币用户授权", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HbApiUser hbApiUser)
	{		
		return toAjax(hbApiUserService.updateHbApiUser(hbApiUser));
	}
	
	/**
	 * 删除火币用户授权
	 */
	@RequiresPermissions("system:hbApiUser:remove")
	@Log(title = "火币用户授权", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(hbApiUserService.deleteHbApiUserByIds(ids));
	}
	
}
