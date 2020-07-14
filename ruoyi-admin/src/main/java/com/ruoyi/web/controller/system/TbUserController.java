package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.TbUser;
import com.ruoyi.system.service.ITbUserService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户 信息操作处理
 *
 * @author ruoyi
 * @date 2019-06-29
 */
@Controller
@RequestMapping("/system/tbUser")
public class TbUserController extends BaseController {
    private String prefix = "system/tbUser";

    @Autowired
    private ITbUserService tbUserService;

    @RequiresPermissions("system:tbUser:view")
    @GetMapping()
    public String tbUser() {
        return prefix + "/tbUser";
    }

    /**
     * 查询用户列表
     */
    @RequiresPermissions("system:tbUser:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbUser tbUser) {
        startPage();
        List<TbUser> list = tbUserService.selectTbUserList(tbUser);
        return getDataTable(list);
    }

    @GetMapping("/userModel")
    @ResponseBody
    public AjaxResult userModel() {
        AjaxResult ajax = new AjaxResult();
        List<TbUser> list = tbUserService.selectTbUserList(null);
        //只显示前十条记录
        if (CollectionUtils.isNotEmpty(list) && list.size() > 10) {
            list = list.subList(0, 10);
        }
        ajax.put("code", 200);
        ajax.put("value", list);
        return ajax;
    }


    /**
     * 导出用户列表
     */
    @RequiresPermissions("system:tbUser:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbUser tbUser) {
        List<TbUser> list = tbUserService.selectTbUserList(tbUser);
        ExcelUtil<TbUser> util = new ExcelUtil<TbUser>(TbUser.class);
        return util.exportExcel(list, "tbUser");
    }

    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存用户
     */
    @RequiresPermissions("system:tbUser:add")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbUser tbUser) {
        return toAjax(tbUserService.insertTbUser(tbUser));
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap) {
        TbUser tbUser = tbUserService.selectTbUserById(userId);
        mmap.put("tbUser", tbUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("system:tbUser:edit")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbUser tbUser) {
        return toAjax(tbUserService.updateTbUser(tbUser));
    }

    /**
     * 删除用户
     */
    @RequiresPermissions("system:tbUser:remove")
    @Log(title = "用户", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tbUserService.deleteTbUserByIds(ids));
    }

}
