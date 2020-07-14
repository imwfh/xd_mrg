package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SyNotice;
import com.ruoyi.system.service.ISyNoticeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 公告 信息操作处理
 * 
 * @author ruoyi
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/system/syNotice")
public class SyNoticeController extends BaseController
{
    private String prefix = "system/syNotice";
	
	@Autowired
	private ISyNoticeService syNoticeService;
	
	@RequiresPermissions("system:syNotice:view")
	@GetMapping()
	public String syNotice()
	{
	    return prefix + "/syNotice";
	}
	
	/**
	 * 查询公告列表
	 */
	@RequiresPermissions("system:syNotice:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SyNotice syNotice)
	{
		startPage();
        List<SyNotice> list = syNoticeService.selectSyNoticeList(syNotice);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出公告列表
	 */
	@RequiresPermissions("system:syNotice:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SyNotice syNotice)
    {
    	List<SyNotice> list = syNoticeService.selectSyNoticeList(syNotice);
        ExcelUtil<SyNotice> util = new ExcelUtil<SyNotice>(SyNotice.class);
        return util.exportExcel(list, "syNotice");
    }
	
	/**
	 * 新增公告
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存公告
	 */
	@RequiresPermissions("system:syNotice:add")
	@Log(title = "公告", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SyNotice syNotice)
	{		
		return toAjax(syNoticeService.insertSyNotice(syNotice));
	}

	/**
	 * 修改公告
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		SyNotice syNotice = syNoticeService.selectSyNoticeById(id);
		mmap.put("syNotice", syNotice);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存公告
	 */
	@RequiresPermissions("system:syNotice:edit")
	@Log(title = "公告", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SyNotice syNotice)
	{		
		return toAjax(syNoticeService.updateSyNotice(syNotice));
	}
	
	/**
	 * 删除公告
	 */
	@RequiresPermissions("system:syNotice:remove")
	@Log(title = "公告", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(syNoticeService.deleteSyNoticeByIds(ids));
	}
	
}
