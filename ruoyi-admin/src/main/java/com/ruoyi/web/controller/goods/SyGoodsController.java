package com.ruoyi.web.controller.goods;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SyGoods;
import com.ruoyi.system.service.ISyGoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-07-29
 */
@Controller
@RequestMapping("/system/syGoods")
public class SyGoodsController extends BaseController
{
    private String prefix = "system/syGoods";
	
	@Autowired
	private ISyGoodsService syGoodsService;
	
	@RequiresPermissions("system:syGoods:view")
	@GetMapping()
	public String syGoods()
	{
	    return prefix + "/syGoods";
	}
	
	/**
	 * 查询商品列表
	 */
	@RequiresPermissions("system:syGoods:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SyGoods syGoods)
	{
		startPage();
        List<SyGoods> list = syGoodsService.selectSyGoodsList(syGoods);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商品列表
	 */
	@RequiresPermissions("system:syGoods:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SyGoods syGoods)
    {
    	List<SyGoods> list = syGoodsService.selectSyGoodsList(syGoods);
        ExcelUtil<SyGoods> util = new ExcelUtil<SyGoods>(SyGoods.class);
        return util.exportExcel(list, "syGoods");
    }
	
	/**
	 * 新增商品
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品
	 */
	@RequiresPermissions("system:syGoods:add")
	@Log(title = "商品", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SyGoods syGoods)
	{		
		return toAjax(syGoodsService.insertSyGoods(syGoods));
	}

	/**
	 * 修改商品
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		SyGoods syGoods = syGoodsService.selectSyGoodsById(id);
		mmap.put("syGoods", syGoods);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品
	 */
	@RequiresPermissions("system:syGoods:edit")
	@Log(title = "商品", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SyGoods syGoods)
	{		
		return toAjax(syGoodsService.updateSyGoods(syGoods));
	}
	
	/**
	 * 删除商品
	 */
	@RequiresPermissions("system:syGoods:remove")
	@Log(title = "商品", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(syGoodsService.deleteSyGoodsByIds(ids));
	}
	
}
