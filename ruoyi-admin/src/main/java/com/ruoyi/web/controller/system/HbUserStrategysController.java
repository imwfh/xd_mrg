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
import com.ruoyi.system.domain.HbUserStrategys;
import com.ruoyi.system.service.IHbUserStrategysService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 火币用户策略集 信息操作处理
 * 
 * @author ruoyi
 * @date 2021-06-07
 */
@Controller
@RequestMapping("/system/hbUserStrategys")
public class HbUserStrategysController extends BaseController
{
    private String prefix = "system/hbUserStrategys";
	
	@Autowired
	private IHbUserStrategysService hbUserStrategysService;
	
	@RequiresPermissions("system:hbUserStrategys:view")
	@GetMapping()
	public String hbUserStrategys()
	{
	    return prefix + "/hbUserStrategys";
	}
	
	/**
	 * 查询火币用户策略集列表
	 */
	@RequiresPermissions("system:hbUserStrategys:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HbUserStrategys hbUserStrategys)
	{
		startPage();
        List<HbUserStrategys> list = hbUserStrategysService.selectHbUserStrategysList(hbUserStrategys);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出火币用户策略集列表
	 */
	@RequiresPermissions("system:hbUserStrategys:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HbUserStrategys hbUserStrategys)
    {
    	List<HbUserStrategys> list = hbUserStrategysService.selectHbUserStrategysList(hbUserStrategys);
        ExcelUtil<HbUserStrategys> util = new ExcelUtil<HbUserStrategys>(HbUserStrategys.class);
        return util.exportExcel(list, "hbUserStrategys");
    }
	
	/**
	 * 新增火币用户策略集
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存火币用户策略集
	 */
	@RequiresPermissions("system:hbUserStrategys:add")
	@Log(title = "火币用户策略集", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HbUserStrategys hbUserStrategys)
	{		
		return toAjax(hbUserStrategysService.insertHbUserStrategys(hbUserStrategys));
	}

	/**
	 * 修改火币用户策略集
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		HbUserStrategys hbUserStrategys = hbUserStrategysService.selectHbUserStrategysById(id);
		mmap.put("hbUserStrategys", hbUserStrategys);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存火币用户策略集
	 */
	@RequiresPermissions("system:hbUserStrategys:edit")
	@Log(title = "火币用户策略集", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HbUserStrategys hbUserStrategys)
	{		
		return toAjax(hbUserStrategysService.updateHbUserStrategys(hbUserStrategys));
	}
	
	/**
	 * 删除火币用户策略集
	 */
	@RequiresPermissions("system:hbUserStrategys:remove")
	@Log(title = "火币用户策略集", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(hbUserStrategysService.deleteHbUserStrategysByIds(ids));
	}
	
}
