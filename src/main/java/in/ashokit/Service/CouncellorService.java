package in.ashokit.Service;

import in.ashokit.Entity.Councellor;

public interface CouncellorService {

	public boolean saveCouncellor(Councellor councellor);

	public Councellor getCouncellor(String email, String pwd);

}
