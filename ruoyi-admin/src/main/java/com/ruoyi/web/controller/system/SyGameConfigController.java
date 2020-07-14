package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SyGameConfig;
import com.ruoyi.system.service.ISyGameConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 游戏配置 信息操作处理
 * 
 * @author ruoyi
 * @date 2020-07-14
 */
@Controller
@RequestMapping("/system/syGameConfig")
public class SyGameConfigController extends BaseController
{
    private String prefix = "system/syGameConfig";
	
	@Autowired
	private ISyGameConfigService syGameConfigService;
	
	@RequiresPermissions("system:syGameConfig:view")
	@GetMapping()
	public String syGameConfig()
	{
	    return prefix + "/syGameConfig";
	}
	
	/**
	 * 查询游戏配置列表
	 */
	@RequiresPermissions("system:syGameConfig:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SyGameConfig syGameConfig)
	{
		startPage();
        List<SyGameConfig> list = syGameConfigService.selectSyGameConfigList(syGameConfig);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出游戏配置列表
	 */
	@RequiresPermissions("system:syGameConfig:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SyGameConfig syGameConfig)
    {
    	List<SyGameConfig> list = syGameConfigService.selectSyGameConfigList(syGameConfig);
        ExcelUtil<SyGameConfig> util = new ExcelUtil<SyGameConfig>(SyGameConfig.class);
        return util.exportExcel(list, "syGameConfig");
    }
	
	/**
	 * 新增游戏配置
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存游戏配置
	 */
	@RequiresPermissions("system:syGameConfig:add")
	@Log(title = "游戏配置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SyGameConfig syGameConfig)
	{		
		return toAjax(syGameConfigService.insertSyGameConfig(syGameConfig));
	}

	/**
	 * 修改游戏配置
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		SyGameConfig syGameConfig = syGameConfigService.selectSyGameConfigById(id);
		mmap.put("syGameConfig", syGameConfig);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存游戏配置
	 */
	@RequiresPermissions("system:syGameConfig:edit")
	@Log(title = "游戏配置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SyGameConfig syGameConfig)
	{		
		return toAjax(syGameConfigService.updateSyGameConfig(syGameConfig));
	}
	
	/**
	 * 删除游戏配置
	 */
	@RequiresPermissions("system:syGameConfig:remove")
	@Log(title = "游戏配置", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(syGameConfigService.deleteSyGameConfigByIds(ids));
	}
	
}
