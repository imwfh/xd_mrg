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
import com.ruoyi.system.domain.SyGameRate;
import com.ruoyi.system.service.ISyGameRateService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 用户等级 信息操作处理
 * 
 * @author ruoyi
 * @date 2020-07-14
 */
@Controller
@RequestMapping("/system/syGameRate")
public class SyGameRateController extends BaseController
{
    private String prefix = "system/syGameRate";
	
	@Autowired
	private ISyGameRateService syGameRateService;
	
	@RequiresPermissions("system:syGameRate:view")
	@GetMapping()
	public String syGameRate()
	{
	    return prefix + "/syGameRate";
	}
	
	/**
	 * 查询用户等级列表
	 */
	@RequiresPermissions("system:syGameRate:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SyGameRate syGameRate)
	{
		startPage();
        List<SyGameRate> list = syGameRateService.selectSyGameRateList(syGameRate);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户等级列表
	 */
	@RequiresPermissions("system:syGameRate:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SyGameRate syGameRate)
    {
    	List<SyGameRate> list = syGameRateService.selectSyGameRateList(syGameRate);
        ExcelUtil<SyGameRate> util = new ExcelUtil<SyGameRate>(SyGameRate.class);
        return util.exportExcel(list, "syGameRate");
    }
	
	/**
	 * 新增用户等级
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户等级
	 */
	@RequiresPermissions("system:syGameRate:add")
	@Log(title = "用户等级", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SyGameRate syGameRate)
	{		
		return toAjax(syGameRateService.insertSyGameRate(syGameRate));
	}

	/**
	 * 修改用户等级
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		SyGameRate syGameRate = syGameRateService.selectSyGameRateById(id);
		mmap.put("syGameRate", syGameRate);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户等级
	 */
	@RequiresPermissions("system:syGameRate:edit")
	@Log(title = "用户等级", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SyGameRate syGameRate)
	{		
		return toAjax(syGameRateService.updateSyGameRate(syGameRate));
	}
	
	/**
	 * 删除用户等级
	 */
	@RequiresPermissions("system:syGameRate:remove")
	@Log(title = "用户等级", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(syGameRateService.deleteSyGameRateByIds(ids));
	}
	
}
