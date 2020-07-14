package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.UserFeedback;
import com.ruoyi.system.mapper.UserFeedbackMapper;
import com.ruoyi.system.service.IUserFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户反馈 服务层实现
 * 
 * @author ruoyi
 * @date 2019-12-28
 */
@Service
public class UserFeedbackServiceImpl implements IUserFeedbackService 
{
	@Autowired
	private UserFeedbackMapper userFeedbackMapper;

	/**
     * 查询用户反馈信息
     * 
     * @param id 用户反馈ID
     * @return 用户反馈信息
     */
    @Override
	public UserFeedback selectUserFeedbackById(Long id)
	{
	    return userFeedbackMapper.selectUserFeedbackById(id);
	}
	
	/**
     * 查询用户反馈列表
     * 
     * @param userFeedback 用户反馈信息
     * @return 用户反馈集合
     */
	@Override
	public List<UserFeedback> selectUserFeedbackList(UserFeedback userFeedback)
	{
	    return userFeedbackMapper.selectUserFeedbackList(userFeedback);
	}
	
    /**
     * 新增用户反馈
     * 
     * @param userFeedback 用户反馈信息
     * @return 结果
     */
	@Override
	public int insertUserFeedback(UserFeedback userFeedback)
	{
	    return userFeedbackMapper.insertUserFeedback(userFeedback);
	}
	
	/**
     * 修改用户反馈
     * 
     * @param userFeedback 用户反馈信息
     * @return 结果
     */
	@Override
	public int updateUserFeedback(UserFeedback userFeedback)
	{
		String replyContent = userFeedback.getReplayContent();
		if(StringUtils.isNotEmpty(replyContent)){
			userFeedback.setAnsTime(DateUtils.getNowDate());
		}
	    return userFeedbackMapper.updateUserFeedback(userFeedback);
	}

	/**
     * 删除用户反馈对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteUserFeedbackByIds(String ids)
	{
		return userFeedbackMapper.deleteUserFeedbackByIds(Convert.toStrArray(ids));
	}
	
}
