package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SyProfitRec;
import com.ruoyi.system.service.ISyProfitRecService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户投资收益 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
@Controller
@RequestMapping("/system/syProfitRec")
public class SyProfitRecController extends BaseController
{
    private String prefix = "system/syProfitRec";
	
	@Autowired
	private ISyProfitRecService syProfitRecService;
	
	@RequiresPermissions("system:syProfitRec:view")
	@GetMapping()
	public String syProfitRec()
	{
	    return prefix + "/syProfitRec";
	}
	
	/**
	 * 查询用户投资收益列表
	 */
	@RequiresPermissions("system:syProfitRec:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SyProfitRec syProfitRec)
	{
		startPage();
        List<SyProfitRec> list = syProfitRecService.selectSyProfitRecList(syProfitRec);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户投资收益列表
	 */
	@RequiresPermissions("system:syProfitRec:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SyProfitRec syProfitRec)
    {
    	List<SyProfitRec> list = syProfitRecService.selectSyProfitRecList(syProfitRec);
        ExcelUtil<SyProfitRec> util = new ExcelUtil<SyProfitRec>(SyProfitRec.class);
        return util.exportExcel(list, "syProfitRec");
    }
	
	/**
	 * 新增用户投资收益
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户投资收益
	 */
	@RequiresPermissions("system:syProfitRec:add")
	@Log(title = "用户投资收益", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SyProfitRec syProfitRec)
	{		
		return toAjax(syProfitRecService.insertSyProfitRec(syProfitRec));
	}

	/**
	 * 修改用户投资收益
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		SyProfitRec syProfitRec = syProfitRecService.selectSyProfitRecById(id);
		mmap.put("syProfitRec", syProfitRec);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户投资收益
	 */
	@RequiresPermissions("system:syProfitRec:edit")
	@Log(title = "用户投资收益", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SyProfitRec syProfitRec)
	{		
		return toAjax(syProfitRecService.updateSyProfitRec(syProfitRec));
	}
	
	/**
	 * 删除用户投资收益
	 */
	@RequiresPermissions("system:syProfitRec:remove")
	@Log(title = "用户投资收益", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(syProfitRecService.deleteSyProfitRecByIds(ids));
	}
	
}
