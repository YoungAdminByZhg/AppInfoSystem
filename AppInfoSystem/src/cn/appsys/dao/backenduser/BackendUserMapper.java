package cn.appsys.dao.backenduser;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.BackendUser;

public interface BackendUserMapper {

	/**
	 * ͨ��userCode��ѯ�û���Ϣ
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public BackendUser getBackendUserByUserCode(@Param("userCode")String userCode) throws Exception;
}
