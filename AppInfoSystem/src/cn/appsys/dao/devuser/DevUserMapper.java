package cn.appsys.dao.devuser;

import org.apache.ibatis.annotations.Param;
import cn.appsys.pojo.DevUser;

public interface DevUserMapper {

	/**
	 * ͨ��DevUser��ѯ�û���Ϣ
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public DevUser getDevUserByUserCode(@Param("devCode")String devCode) throws Exception;
}
