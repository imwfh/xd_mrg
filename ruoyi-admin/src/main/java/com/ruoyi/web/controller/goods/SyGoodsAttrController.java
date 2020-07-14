package com.ruoyi.web.controller.goods;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SyGoodsAttr;
import com.ruoyi.system.service.ISyGoodsAttrService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品属性 信息操作处理
 *
 * @author ruoyi
 * @date 2019-08-02
 */
@Controller
@RequestMapping("/system/syGoodsAttr")
public class SyGoodsAttrController extends BaseController {
    private String prefix = "system/syGoodsAttr";

    @Autowired
    private ISyGoodsAttrService syGoodsAttrService;

    @RequiresPermissions("system:syGoodsAttr:view")
    @GetMapping()
    public String syGoodsAttr() {
        return prefix + "/syGoodsAttr";
    }

    /**
     * 查询商品属性列表
     */
    @RequiresPermissions("system:syGoodsAttr:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SyGoodsAttr syGoodsAttr) {
        startPage();
        List<SyGoodsAttr> list = syGoodsAttrService.selectSyGoodsAttrList(syGoodsAttr);
        return getDataTable(list);
    }


    /**
     * 导出商品属性列表
     */
    @RequiresPermissions("system:syGoodsAttr:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SyGoodsAttr syGoodsAttr) {
        List<SyGoodsAttr> list = syGoodsAttrService.selectSyGoodsAttrList(syGoodsAttr);
        ExcelUtil<SyGoodsAttr> util = new ExcelUtil<SyGoodsAttr>(SyGoodsAttr.class);
        return util.exportExcel(list, "syGoodsAttr");
    }

    /**
     * 新增商品属性
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存商品属性
     */
    @RequiresPermissions("system:syGoodsAttr:add")
    @Log(title = "商品属性", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SyGoodsAttr syGoodsAttr) {
        return toAjax(syGoodsAttrService.insertSyGoodsAttr(syGoodsAttr));
    }

    /**
     * 修改商品属性
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        SyGoodsAttr syGoodsAttr = syGoodsAttrService.selectSyGoodsAttrById(id);
        mmap.put("syGoodsAttr", syGoodsAttr);
        return prefix + "/edit";
    }

    /**
     * 修改商品属性
     */
    @GetMapping("/edit/one/{goodsSn}")
    public String editGoodsSn(@PathVariable("goodsSn") String goodsSn, ModelMap mmap) {
        SyGoodsAttr syGoodsAttr = syGoodsAttrService.selectSyGoodsAttrByGoodsSn(goodsSn);
        mmap.put("syGoodsAttr", null == syGoodsAttr ? new SyGoodsAttr() : syGoodsAttr);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品属性
     */
    @RequiresPermissions("system:syGoodsAttr:edit")
    @Log(title = "商品属性", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SyGoodsAttr syGoodsAttr) {
        return toAjax(syGoodsAttrService.updateSyGoodsAttr(syGoodsAttr));
    }

    @RequiresPermissions("system:syGoods:goodDetail")
    @Log(title = "商品属性详情获取", businessType = BusinessType.OTHER)
    @PostMapping("/get/one")
    @ResponseBody
    public SyGoodsAttr getAttr(String goodsSn, ModelMap mmap) {
        SyGoodsAttr syGoodsAttr = new SyGoodsAttr();
        syGoodsAttr.setGoodsSn(goodsSn);
        List<SyGoodsAttr> syGoodsAttrList = syGoodsAttrService.selectSyGoodsAttrList(syGoodsAttr);
        if (CollectionUtils.isNotEmpty(syGoodsAttrList)) {
            return syGoodsAttrList.get(0);
        }
        return null;
    }

    /**
     * 删除商品属性
     */
    @RequiresPermissions("system:syGoodsAttr:remove")
    @Log(title = "商品属性", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(syGoodsAttrService.deleteSyGoodsAttrByIds(ids));
    }

}
