package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SyOrder;
import com.ruoyi.system.service.ISyOrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 采购订单 信息操作处理
 * 
 * @author ruoyi
 * @date 2020-09-14
 */
@Controller
@RequestMapping("/system/syOrder")
public class SyOrderController extends BaseController
{
    private String prefix = "system/syOrder";
	
	@Autowired
	private ISyOrderService syOrderService;
	
	@RequiresPermissions("system:syOrder:view")
	@GetMapping()
	public String syOrder()
	{
	    return prefix + "/syOrder";
	}
	
	/**
	 * 查询采购订单列表
	 */
	@RequiresPermissions("system:syOrder:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SyOrder syOrder)
	{
		startPage();
        List<SyOrder> list = syOrderService.selectSyOrderList(syOrder);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出采购订单列表
	 */
	@RequiresPermissions("system:syOrder:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SyOrder syOrder)
    {
    	List<SyOrder> list = syOrderService.selectSyOrderList(syOrder);
        ExcelUtil<SyOrder> util = new ExcelUtil<SyOrder>(SyOrder.class);
        return util.exportExcel(list, "syOrder");
    }
	
	/**
	 * 新增采购订单
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存采购订单
	 */
	@RequiresPermissions("system:syOrder:add")
	@Log(title = "采购订单", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SyOrder syOrder)
	{		
		return toAjax(syOrderService.insertSyOrder(syOrder));
	}

	/**
	 * 修改采购订单
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		SyOrder syOrder = syOrderService.selectSyOrderById(id);
		mmap.put("syOrder", syOrder);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存采购订单
	 */
	@RequiresPermissions("system:syOrder:edit")
	@Log(title = "采购订单", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SyOrder syOrder)
	{		
		return toAjax(syOrderService.updateSyOrder(syOrder));
	}
	
	/**
	 * 删除采购订单
	 */
	@RequiresPermissions("system:syOrder:remove")
	@Log(title = "采购订单", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(syOrderService.deleteSyOrderByIds(ids));
	}
	
}
