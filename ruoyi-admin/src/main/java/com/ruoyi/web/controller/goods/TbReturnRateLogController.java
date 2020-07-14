package com.ruoyi.web.controller.goods;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.TbReturnRateLog;
import com.ruoyi.system.service.ITbReturnRateLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户费率日志记录 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-06
 */
@Controller
@RequestMapping("/system/tbReturnRateLog")
public class TbReturnRateLogController extends BaseController
{
    private String prefix = "system/tbReturnRateLog";
	
	@Autowired
	private ITbReturnRateLogService tbReturnRateLogService;
	
	@RequiresPermissions("system:tbReturnRateLog:view")
	@GetMapping()
	public String tbReturnRateLog()
	{
	    return prefix + "/tbReturnRateLog";
	}
	
	/**
	 * 查询用户费率日志记录列表
	 */
	@RequiresPermissions("system:tbReturnRateLog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TbReturnRateLog tbReturnRateLog)
	{
		startPage();
        List<TbReturnRateLog> list = tbReturnRateLogService.selectTbReturnRateLogList(tbReturnRateLog);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户费率日志记录列表
	 */
	@RequiresPermissions("system:tbReturnRateLog:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbReturnRateLog tbReturnRateLog)
    {
    	List<TbReturnRateLog> list = tbReturnRateLogService.selectTbReturnRateLogList(tbReturnRateLog);
        ExcelUtil<TbReturnRateLog> util = new ExcelUtil<TbReturnRateLog>(TbReturnRateLog.class);
        return util.exportExcel(list, "tbReturnRateLog");
    }
	
	/**
	 * 新增用户费率日志记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户费率日志记录
	 */
	@RequiresPermissions("system:tbReturnRateLog:add")
	@Log(title = "用户费率日志记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TbReturnRateLog tbReturnRateLog)
	{		
		return toAjax(tbReturnRateLogService.insertTbReturnRateLog(tbReturnRateLog));
	}

	/**
	 * 修改用户费率日志记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		TbReturnRateLog tbReturnRateLog = tbReturnRateLogService.selectTbReturnRateLogById(id);
		mmap.put("tbReturnRateLog", tbReturnRateLog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户费率日志记录
	 */
	@RequiresPermissions("system:tbReturnRateLog:edit")
	@Log(title = "用户费率日志记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TbReturnRateLog tbReturnRateLog)
	{		
		return toAjax(tbReturnRateLogService.updateTbReturnRateLog(tbReturnRateLog));
	}
	
	/**
	 * 删除用户费率日志记录
	 */
	@RequiresPermissions("system:tbReturnRateLog:remove")
	@Log(title = "用户费率日志记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tbReturnRateLogService.deleteTbReturnRateLogByIds(ids));
	}
	
}
