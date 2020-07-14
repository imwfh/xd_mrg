package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.InvestmentRet;
import com.ruoyi.system.domain.SyInvestment;
import com.ruoyi.system.service.ISyInvestmentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 用户投资 信息操作处理
 *
 * @author ruoyi
 * @date 2019-12-21
 */
@Controller
@RequestMapping("/system/syInvestment")
public class SyInvestmentController extends BaseController {
    private String prefix = "system/syInvestment";

    @Autowired
    private ISyInvestmentService syInvestmentService;

    @RequiresPermissions("system:syInvestment:view")
    @GetMapping()
    public String syInvestment() {
        return prefix + "/syInvestment";
    }

    /**
     * 查询用户投资列表
     */
    @RequiresPermissions("system:syInvestment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SyInvestment syInvestment) {
        startPage();
        InvestmentRet list = syInvestmentService.selectSyInvestmentList(syInvestment);
        TableDataInfo dataInfo = getDataTable(list.getListData());
        dataInfo.setObj(list.getTotalMoney());
        return dataInfo;
    }


    /**
     * 导出用户投资列表
     */
    @RequiresPermissions("system:syInvestment:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SyInvestment syInvestment) {
        InvestmentRet list = syInvestmentService.selectSyInvestmentList(syInvestment);
        ExcelUtil<SyInvestment> util = new ExcelUtil<SyInvestment>(SyInvestment.class);
        return util.exportExcel(list.getListData(), "syInvestment");
    }

    /**
     * 新增用户投资
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存用户投资
     */
    @RequiresPermissions("system:syInvestment:add")
    @Log(title = "用户投资", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SyInvestment syInvestment) {
        return toAjax(syInvestmentService.insertSyInvestment(syInvestment));
    }

    /**
     * 修改用户投资
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        SyInvestment syInvestment = syInvestmentService.selectSyInvestmentById(id);
        mmap.put("syInvestment", syInvestment);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户投资
     */
    @RequiresPermissions("system:syInvestment:edit")
    @Log(title = "用户投资", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SyInvestment syInvestment) {
        return toAjax(syInvestmentService.updateSyInvestment(syInvestment));
    }

    /**
     * 删除用户投资
     */
    @RequiresPermissions("system:syInvestment:remove")
    @Log(title = "用户投资", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(syInvestmentService.deleteSyInvestmentByIds(ids));
    }

}
