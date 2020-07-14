package com.ruoyi.web.controller.goods;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SyIndexInfo;
import com.ruoyi.system.service.ISyIndexInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 首页轮播图 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-07
 */
@Controller
@RequestMapping("/system/syIndexInfo")
public class SyIndexInfoController extends BaseController
{
    private String prefix = "system/syIndexInfo";
	
	@Autowired
	private ISyIndexInfoService syIndexInfoService;
	
	@RequiresPermissions("system:syIndexInfo:view")
	@GetMapping()
	public String syIndexInfo()
	{
	    return prefix + "/syIndexInfo";
	}
	
	/**
	 * 查询首页轮播图列表
	 */
	@RequiresPermissions("system:syIndexInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SyIndexInfo syIndexInfo)
	{
		startPage();
        List<SyIndexInfo> list = syIndexInfoService.selectSyIndexInfoList(syIndexInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出首页轮播图列表
	 */
	@RequiresPermissions("system:syIndexInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SyIndexInfo syIndexInfo)
    {
    	List<SyIndexInfo> list = syIndexInfoService.selectSyIndexInfoList(syIndexInfo);
        ExcelUtil<SyIndexInfo> util = new ExcelUtil<SyIndexInfo>(SyIndexInfo.class);
        return util.exportExcel(list, "syIndexInfo");
    }
	
	/**
	 * 新增首页轮播图
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存首页轮播图
	 */
	@RequiresPermissions("system:syIndexInfo:add")
	@Log(title = "首页轮播图", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SyIndexInfo syIndexInfo)
	{		
		return toAjax(syIndexInfoService.insertSyIndexInfo(syIndexInfo));
	}

	/**
	 * 修改首页轮播图
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		SyIndexInfo syIndexInfo = syIndexInfoService.selectSyIndexInfoById(id);
		mmap.put("syIndexInfo", syIndexInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存首页轮播图
	 */
	@RequiresPermissions("system:syIndexInfo:edit")
	@Log(title = "首页轮播图", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SyIndexInfo syIndexInfo)
	{		
		return toAjax(syIndexInfoService.updateSyIndexInfo(syIndexInfo));
	}
	
	/**
	 * 删除首页轮播图
	 */
	@RequiresPermissions("system:syIndexInfo:remove")
	@Log(title = "首页轮播图", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(syIndexInfoService.deleteSyIndexInfoByIds(ids));
	}
	
}
