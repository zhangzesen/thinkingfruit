package com.thinkingFruit.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.admin.entity.Member;
import com.ysdevelop.common.page.Pagination;


public interface MemberDao {
	/**
	 * @author wulei
	 *
	 * @date 2018年11月21日
	 *
	 * @package com.thinkingFruit.admin.mapper
	 *
	 * @description 代理会员
	 */

	//查询与遍历出所对应的数量
	Integer getCountByQuery(@Param(value="queryMap")Map<String, String> queryMap,@Param(value="nicknameReplace")byte[] nicknameReplace);

	//查询与遍历出所对应的信息
	List<Member> paginationSecondCategory(@Param(value="queryMap")Map<String, String> queryMap, @Param(value="pagination")Pagination<Member> pagination,@Param(value="nicknameReplace")byte[] nicknameReplace);

	//查询折扣信息
	Member memberLevelIdById(@Param(value="id")Long id);

    //修改代理信息
	Integer updataById(@Param(value="member") Member member);
	Integer updataById1(@Param(value="member") Member member);

	//删除代理
	Integer deleteById(@Param(value="id")Long id);


}
