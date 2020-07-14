package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SyFeeRate;
import com.ruoyi.system.service.ISyFeeRateService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 收益比率 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
@Controller
@RequestMapping("/system/syFeeRate")
public class SyFeeRateController extends BaseController
{
    private String prefix = "system/syFeeRate";
	
	@Autowired
	private ISyFeeRateService syFeeRateService;
	
	@RequiresPermissions("system:syFeeRate:view")
	@GetMapping()
	public String syFeeRate()
	{
	    return prefix + "/syFeeRate";
	}
	
	/**
	 * 查询收益比率列表
	 */
	@RequiresPermissions("system:syFeeRate:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SyFeeRate syFeeRate)
	{
		startPage();
        List<SyFeeRate> list = syFeeRateService.selectSyFeeRateList(syFeeRate);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出收益比率列表
	 */
	@RequiresPermissions("system:syFeeRate:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SyFeeRate syFeeRate)
    {
    	List<SyFeeRate> list = syFeeRateService.selectSyFeeRateList(syFeeRate);
        ExcelUtil<SyFeeRate> util = new ExcelUtil<SyFeeRate>(SyFeeRate.class);
        return util.exportExcel(list, "syFeeRate");
    }
	
	/**
	 * 新增收益比率
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存收益比率
	 */
	@RequiresPermissions("system:syFeeRate:add")
	@Log(title = "收益比率", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SyFeeRate syFeeRate)
	{		
		return toAjax(syFeeRateService.insertSyFeeRate(syFeeRate));
	}

	/**
	 * 修改收益比率
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		SyFeeRate syFeeRate = syFeeRateService.selectSyFeeRateById(id);
		mmap.put("syFeeRate", syFeeRate);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存收益比率
	 */
	@RequiresPermissions("system:syFeeRate:edit")
	@Log(title = "收益比率", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SyFeeRate syFeeRate)
	{		
		return toAjax(syFeeRateService.updateSyFeeRate(syFeeRate));
	}
	
	/**
	 * 删除收益比率
	 */
	@RequiresPermissions("system:syFeeRate:remove")
	@Log(title = "收益比率", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(syFeeRateService.deleteSyFeeRateByIds(ids));
	}
	
}
