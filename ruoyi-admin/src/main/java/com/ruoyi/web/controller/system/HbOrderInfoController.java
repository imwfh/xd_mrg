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
import com.ruoyi.system.domain.HbOrderInfo;
import com.ruoyi.system.service.IHbOrderInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 火币用户下单 信息操作处理
 * 
 * @author ruoyi
 * @date 2021-06-07
 */
@Controller
@RequestMapping("/system/hbOrderInfo")
public class HbOrderInfoController extends BaseController
{
    private String prefix = "system/hbOrderInfo";
	
	@Autowired
	private IHbOrderInfoService hbOrderInfoService;
	
	@RequiresPermissions("system:hbOrderInfo:view")
	@GetMapping()
	public String hbOrderInfo()
	{
	    return prefix + "/hbOrderInfo";
	}
	
	/**
	 * 查询火币用户下单列表
	 */
	@RequiresPermissions("system:hbOrderInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HbOrderInfo hbOrderInfo)
	{
		startPage();
        List<HbOrderInfo> list = hbOrderInfoService.selectHbOrderInfoList(hbOrderInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出火币用户下单列表
	 */
	@RequiresPermissions("system:hbOrderInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HbOrderInfo hbOrderInfo)
    {
    	List<HbOrderInfo> list = hbOrderInfoService.selectHbOrderInfoList(hbOrderInfo);
        ExcelUtil<HbOrderInfo> util = new ExcelUtil<HbOrderInfo>(HbOrderInfo.class);
        return util.exportExcel(list, "hbOrderInfo");
    }
	
	/**
	 * 新增火币用户下单
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存火币用户下单
	 */
	@RequiresPermissions("system:hbOrderInfo:add")
	@Log(title = "火币用户下单", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HbOrderInfo hbOrderInfo)
	{		
		return toAjax(hbOrderInfoService.insertHbOrderInfo(hbOrderInfo));
	}

	/**
	 * 修改火币用户下单
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		HbOrderInfo hbOrderInfo = hbOrderInfoService.selectHbOrderInfoById(id);
		mmap.put("hbOrderInfo", hbOrderInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存火币用户下单
	 */
	@RequiresPermissions("system:hbOrderInfo:edit")
	@Log(title = "火币用户下单", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HbOrderInfo hbOrderInfo)
	{		
		return toAjax(hbOrderInfoService.updateHbOrderInfo(hbOrderInfo));
	}
	
	/**
	 * 删除火币用户下单
	 */
	@RequiresPermissions("system:hbOrderInfo:remove")
	@Log(title = "火币用户下单", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(hbOrderInfoService.deleteHbOrderInfoByIds(ids));
	}
	
}
