package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HbApiUserMapper;
import com.ruoyi.system.domain.HbApiUser;
import com.ruoyi.system.service.IHbApiUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 火币用户授权 服务层实现
 * 
 * @author ruoyi
 * @date 2021-06-07
 */
@Service
public class HbApiUserServiceImpl implements IHbApiUserService 
{
	@Autowired
	private HbApiUserMapper hbApiUserMapper;

	/**
     * 查询火币用户授权信息
     * 
     * @param id 火币用户授权ID
     * @return 火币用户授权信息
     */
    @Override
	public HbApiUser selectHbApiUserById(Integer id)
	{
	    return hbApiUserMapper.selectHbApiUserById(id);
	}
	
	/**
     * 查询火币用户授权列表
     * 
     * @param hbApiUser 火币用户授权信息
     * @return 火币用户授权集合
     */
	@Override
	public List<HbApiUser> selectHbApiUserList(HbApiUser hbApiUser)
	{
	    return hbApiUserMapper.selectHbApiUserList(hbApiUser);
	}
	
    /**
     * 新增火币用户授权
     * 
     * @param hbApiUser 火币用户授权信息
     * @return 结果
     */
	@Override
	public int insertHbApiUser(HbApiUser hbApiUser)
	{
	    return hbApiUserMapper.insertHbApiUser(hbApiUser);
	}
	
	/**
     * 修改火币用户授权
     * 
     * @param hbApiUser 火币用户授权信息
     * @return 结果
     */
	@Override
	public int updateHbApiUser(HbApiUser hbApiUser)
	{
	    return hbApiUserMapper.updateHbApiUser(hbApiUser);
	}

	/**
     * 删除火币用户授权对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHbApiUserByIds(String ids)
	{
		return hbApiUserMapper.deleteHbApiUserByIds(Convert.toStrArray(ids));
	}
	
}
