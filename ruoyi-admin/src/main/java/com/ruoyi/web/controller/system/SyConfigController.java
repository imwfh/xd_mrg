package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SyConfig;
import com.ruoyi.system.service.ISyConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 参数配置 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-12-28
 */
@Controller
@RequestMapping("/system/syConfig")
public class SyConfigController extends BaseController
{
    private String prefix = "system/syConfig";
	
	@Autowired
	private ISyConfigService syConfigService;
	
	@RequiresPermissions("system:syConfig:view")
	@GetMapping()
	public String syConfig()
	{
	    return prefix + "/syConfig";
	}
	
	/**
	 * 查询参数配置列表
	 */
	@RequiresPermissions("system:syConfig:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SyConfig syConfig)
	{
		startPage();
        List<SyConfig> list = syConfigService.selectSyConfigList(syConfig);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出参数配置列表
	 */
	@RequiresPermissions("system:syConfig:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SyConfig syConfig)
    {
    	List<SyConfig> list = syConfigService.selectSyConfigList(syConfig);
        ExcelUtil<SyConfig> util = new ExcelUtil<SyConfig>(SyConfig.class);
        return util.exportExcel(list, "syConfig");
    }
	
	/**
	 * 新增参数配置
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存参数配置
	 */
	@RequiresPermissions("system:syConfig:add")
	@Log(title = "参数配置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SyConfig syConfig)
	{		
		return toAjax(syConfigService.insertSyConfig(syConfig));
	}

	/**
	 * 修改参数配置
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		SyConfig syConfig = syConfigService.selectSyConfigById(id);
		mmap.put("syConfig", syConfig);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存参数配置
	 */
	@RequiresPermissions("system:syConfig:edit")
	@Log(title = "参数配置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SyConfig syConfig)
	{		
		return toAjax(syConfigService.updateSyConfig(syConfig));
	}
	
	/**
	 * 删除参数配置
	 */
	@RequiresPermissions("system:syConfig:remove")
	@Log(title = "参数配置", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(syConfigService.deleteSyConfigByIds(ids));
	}
	
}
