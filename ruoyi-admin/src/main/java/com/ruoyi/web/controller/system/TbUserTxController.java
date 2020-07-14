package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.TbUserTx;
import com.ruoyi.system.service.ITbUserTxService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 提现记录 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-12-28
 */
@Controller
@RequestMapping("/system/tbUserTx")
public class TbUserTxController extends BaseController
{
    private String prefix = "system/tbUserTx";
	
	@Autowired
	private ITbUserTxService tbUserTxService;
	
	@RequiresPermissions("system:tbUserTx:view")
	@GetMapping()
	public String tbUserTx()
	{
	    return prefix + "/tbUserTx";
	}
	
	/**
	 * 查询提现记录列表
	 */
	@RequiresPermissions("system:tbUserTx:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TbUserTx tbUserTx)
	{
		startPage();
        List<TbUserTx> list = tbUserTxService.selectTbUserTxList(tbUserTx);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出提现记录列表
	 */
	@RequiresPermissions("system:tbUserTx:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbUserTx tbUserTx)
    {
    	List<TbUserTx> list = tbUserTxService.selectTbUserTxList(tbUserTx);
        ExcelUtil<TbUserTx> util = new ExcelUtil<TbUserTx>(TbUserTx.class);
        return util.exportExcel(list, "tbUserTx");
    }
	
	/**
	 * 新增提现记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存提现记录
	 */
	@RequiresPermissions("system:tbUserTx:add")
	@Log(title = "提现记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TbUserTx tbUserTx)
	{		
		return toAjax(tbUserTxService.insertTbUserTx(tbUserTx));
	}

	/**
	 * 修改提现记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		TbUserTx tbUserTx = tbUserTxService.selectTbUserTxById(id);
		mmap.put("tbUserTx", tbUserTx);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存提现记录
	 */
	@RequiresPermissions("system:tbUserTx:edit")
	@Log(title = "提现记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TbUserTx tbUserTx)
	{		
		return toAjax(tbUserTxService.updateTbUserTx(tbUserTx));
	}
	
	/**
	 * 删除提现记录
	 */
	@RequiresPermissions("system:tbUserTx:remove")
	@Log(title = "提现记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tbUserTxService.deleteTbUserTxByIds(ids));
	}
	
}
