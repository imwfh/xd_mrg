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
import com.ruoyi.system.domain.GameInOrder;
import com.ruoyi.system.service.IGameInOrderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 用户下zhu记录 信息操作处理
 * 
 * @author ruoyi
 * @date 2020-07-25
 */
@Controller
@RequestMapping("/system/gameInOrder")
public class GameInOrderController extends BaseController
{
    private String prefix = "system/gameInOrder";
	
	@Autowired
	private IGameInOrderService gameInOrderService;
	
	@RequiresPermissions("system:gameInOrder:view")
	@GetMapping()
	public String gameInOrder()
	{
	    return prefix + "/gameInOrder";
	}
	
	/**
	 * 查询用户下zhu记录列表
	 */
	@RequiresPermissions("system:gameInOrder:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(GameInOrder gameInOrder)
	{
		startPage();
        List<GameInOrder> list = gameInOrderService.selectGameInOrderList(gameInOrder);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户下zhu记录列表
	 */
	@RequiresPermissions("system:gameInOrder:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GameInOrder gameInOrder)
    {
    	List<GameInOrder> list = gameInOrderService.selectGameInOrderList(gameInOrder);
        ExcelUtil<GameInOrder> util = new ExcelUtil<GameInOrder>(GameInOrder.class);
        return util.exportExcel(list, "gameInOrder");
    }
	
	/**
	 * 新增用户下zhu记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户下zhu记录
	 */
	@RequiresPermissions("system:gameInOrder:add")
	@Log(title = "用户下zhu记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(GameInOrder gameInOrder)
	{		
		return toAjax(gameInOrderService.insertGameInOrder(gameInOrder));
	}

	/**
	 * 修改用户下zhu记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		GameInOrder gameInOrder = gameInOrderService.selectGameInOrderById(id);
		mmap.put("gameInOrder", gameInOrder);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户下zhu记录
	 */
	@RequiresPermissions("system:gameInOrder:edit")
	@Log(title = "用户下zhu记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(GameInOrder gameInOrder)
	{		
		return toAjax(gameInOrderService.updateGameInOrder(gameInOrder));
	}
	
	/**
	 * 删除用户下zhu记录
	 */
	@RequiresPermissions("system:gameInOrder:remove")
	@Log(title = "用户下zhu记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(gameInOrderService.deleteGameInOrderByIds(ids));
	}
	
}
