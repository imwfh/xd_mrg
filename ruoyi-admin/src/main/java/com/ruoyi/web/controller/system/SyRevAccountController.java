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
import com.ruoyi.system.domain.SyRevAccount;
import com.ruoyi.system.service.ISyRevAccountService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 平台收款账户 信息操作处理
 * 
 * @author ruoyi
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/system/syRevAccount")
public class SyRevAccountController extends BaseController
{
    private String prefix = "system/syRevAccount";
	
	@Autowired
	private ISyRevAccountService syRevAccountService;
	
	@RequiresPermissions("system:syRevAccount:view")
	@GetMapping()
	public String syRevAccount()
	{
	    return prefix + "/syRevAccount";
	}
	
	/**
	 * 查询平台收款账户列表
	 */
	@RequiresPermissions("system:syRevAccount:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SyRevAccount syRevAccount)
	{
		startPage();
        List<SyRevAccount> list = syRevAccountService.selectSyRevAccountList(syRevAccount);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出平台收款账户列表
	 */
	@RequiresPermissions("system:syRevAccount:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SyRevAccount syRevAccount)
    {
    	List<SyRevAccount> list = syRevAccountService.selectSyRevAccountList(syRevAccount);
        ExcelUtil<SyRevAccount> util = new ExcelUtil<SyRevAccount>(SyRevAccount.class);
        return util.exportExcel(list, "syRevAccount");
    }
	
	/**
	 * 新增平台收款账户
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存平台收款账户
	 */
	@RequiresPermissions("system:syRevAccount:add")
	@Log(title = "平台收款账户", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SyRevAccount syRevAccount)
	{		
		return toAjax(syRevAccountService.insertSyRevAccount(syRevAccount));
	}

	/**
	 * 修改平台收款账户
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		SyRevAccount syRevAccount = syRevAccountService.selectSyRevAccountById(id);
		mmap.put("syRevAccount", syRevAccount);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存平台收款账户
	 */
	@RequiresPermissions("system:syRevAccount:edit")
	@Log(title = "平台收款账户", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SyRevAccount syRevAccount)
	{		
		return toAjax(syRevAccountService.updateSyRevAccount(syRevAccount));
	}
	
	/**
	 * 删除平台收款账户
	 */
	@RequiresPermissions("system:syRevAccount:remove")
	@Log(title = "平台收款账户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(syRevAccountService.deleteSyRevAccountByIds(ids));
	}
	
}
