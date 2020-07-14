package com.ruoyi.web.controller.goods;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.TbReturnRate;
import com.ruoyi.system.service.ITbReturnRateService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户费率 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-06
 */
@Controller
@RequestMapping("/system/tbReturnRate")
public class TbReturnRateController extends BaseController
{
    private String prefix = "system/tbReturnRate";
	
	@Autowired
	private ITbReturnRateService tbReturnRateService;
	
	@RequiresPermissions("system:tbReturnRate:view")
	@GetMapping()
	public String tbReturnRate()
	{
	    return prefix + "/tbReturnRate";
	}



	
	/**
	 * 查询用户费率列表
	 */
	@RequiresPermissions("system:tbReturnRate:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TbReturnRate tbReturnRate)
	{
		startPage();
        List<TbReturnRate> list = tbReturnRateService.selectTbReturnRateList(tbReturnRate);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户费率列表
	 */
	@RequiresPermissions("system:tbReturnRate:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbReturnRate tbReturnRate)
    {
    	List<TbReturnRate> list = tbReturnRateService.selectTbReturnRateList(tbReturnRate);
        ExcelUtil<TbReturnRate> util = new ExcelUtil<TbReturnRate>(TbReturnRate.class);
        return util.exportExcel(list, "tbReturnRate");
    }
	
	/**
	 * 新增用户费率
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户费率
	 */
	@RequiresPermissions("system:tbReturnRate:add")
	@Log(title = "用户费率", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TbReturnRate tbReturnRate)
	{		
		return toAjax(tbReturnRateService.insertTbReturnRate(tbReturnRate));
	}

	/**
	 * 修改用户费率
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		TbReturnRate tbReturnRate = tbReturnRateService.selectTbReturnRateById(id);
		mmap.put("tbReturnRate", tbReturnRate);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户费率
	 */
	@RequiresPermissions("system:tbReturnRate:edit")
	@Log(title = "用户费率", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TbReturnRate tbReturnRate)
	{		
		return toAjax(tbReturnRateService.updateTbReturnRate(tbReturnRate));
	}
	
	/**
	 * 删除用户费率
	 */
	@RequiresPermissions("system:tbReturnRate:remove")
	@Log(title = "用户费率", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tbReturnRateService.deleteTbReturnRateByIds(ids));
	}
	
}
