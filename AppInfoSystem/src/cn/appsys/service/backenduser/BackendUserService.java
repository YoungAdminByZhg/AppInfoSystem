package cn.appsys.service.backenduser;

import cn.appsys.pojo.BackendUser;

public interface BackendUserService {

	/**
	 * ͨ��userCode��ѯ�û���Ϣ
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public BackendUser getBackendUserByUserCode(String userCode);
}
