package com.ruoyi.system.service;

import com.ruoyi.system.domain.UserFeedback;
import java.util.List;

/**
 * 用户反馈 服务层
 * 
 * @author ruoyi
 * @date 2019-12-28
 */
public interface IUserFeedbackService 
{
	/**
     * 查询用户反馈信息
     * 
     * @param id 用户反馈ID
     * @return 用户反馈信息
     */
	public UserFeedback selectUserFeedbackById(Long id);
	
	/**
     * 查询用户反馈列表
     * 
     * @param userFeedback 用户反馈信息
     * @return 用户反馈集合
     */
	public List<UserFeedback> selectUserFeedbackList(UserFeedback userFeedback);
	
	/**
     * 新增用户反馈
     * 
     * @param userFeedback 用户反馈信息
     * @return 结果
     */
	public int insertUserFeedback(UserFeedback userFeedback);
	
	/**
     * 修改用户反馈
     * 
     * @param userFeedback 用户反馈信息
     * @return 结果
     */
	public int updateUserFeedback(UserFeedback userFeedback);
		
	/**
     * 删除用户反馈信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteUserFeedbackByIds(String ids);
	
}
