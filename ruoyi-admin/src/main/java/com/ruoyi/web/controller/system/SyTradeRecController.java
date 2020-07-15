package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SyTradeRec;
import com.ruoyi.system.service.ISyTradeRecService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 账变记录 信息操作处理
 * 
 * @author ruoyi
 * @date 2020-07-14
 */
@Controller
@RequestMapping("/system/syTradeRec")
public class SyTradeRecController extends BaseController
{
    private String prefix = "system/syTradeRec";
	
	@Autowired
	private ISyTradeRecService syTradeRecService;
	
	@RequiresPermissions("system:syTradeRec:view")
	@GetMapping()
	public String syTradeRec()
	{
	    return prefix + "/syTradeRec";
	}
	
	/**
	 * 查询账变记录列表
	 */
	@RequiresPermissions("system:syTradeRec:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SyTradeRec syTradeRec)
	{
		startPage();
        List<SyTradeRec> list = syTradeRecService.selectSyTradeRecList(syTradeRec);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出账变记录列表
	 */
	@RequiresPermissions("system:syTradeRec:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SyTradeRec syTradeRec)
    {
    	List<SyTradeRec> list = syTradeRecService.selectSyTradeRecList(syTradeRec);
        ExcelUtil<SyTradeRec> util = new ExcelUtil<SyTradeRec>(SyTradeRec.class);
        return util.exportExcel(list, "syTradeRec");
    }
	
	/**
	 * 新增账变记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存账变记录
	 */
	@RequiresPermissions("system:syTradeRec:add")
	@Log(title = "账变记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SyTradeRec syTradeRec)
	{		
		return toAjax(syTradeRecService.insertSyTradeRec(syTradeRec));
	}

	/**
	 * 修改账变记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		SyTradeRec syTradeRec = syTradeRecService.selectSyTradeRecById(id);
		mmap.put("syTradeRec", syTradeRec);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存账变记录
	 */
	@RequiresPermissions("system:syTradeRec:edit")
	@Log(title = "账变记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SyTradeRec syTradeRec)
	{		
		return toAjax(syTradeRecService.updateSyTradeRec(syTradeRec));
	}
	
	/**
	 * 删除账变记录
	 */
	@RequiresPermissions("system:syTradeRec:remove")
	@Log(title = "账变记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(syTradeRecService.deleteSyTradeRecByIds(ids));
	}
	
}
