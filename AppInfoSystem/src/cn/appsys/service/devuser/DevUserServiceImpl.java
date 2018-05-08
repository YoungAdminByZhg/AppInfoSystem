package cn.appsys.service.devuser;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.appsys.dao.devuser.DevUserMapper;
import cn.appsys.pojo.DevUser;

@Service
public class DevUserServiceImpl implements DevUserService {

	@Resource
	private DevUserMapper devUserMapper;
	
	@Override
	public DevUser getDevUserByUserCode(String devCode) {
		try {
			return devUserMapper.getDevUserByUserCode(devCode);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
