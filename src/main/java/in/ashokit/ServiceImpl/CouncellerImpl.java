package in.ashokit.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.Entity.Councellor;
import in.ashokit.Repository.CouncellorRepository;
import in.ashokit.Service.CouncellorService;

@Service
public class CouncellerImpl implements CouncellorService {

	@Autowired
	private CouncellorRepository councellorRepo;

	@Override
	public boolean saveCouncellor(Councellor councellor) {
		Councellor byEmail = councellorRepo.findByEmail(councellor.getEmail());
		if (byEmail != null) {
			return false;
		} else {

			Councellor savedCouncellor = councellorRepo.save(councellor);

			return savedCouncellor.getCouncellorId() != null;
		}
	}

	@Override
	public Councellor getCouncellor(String email, String pwd) {
		return councellorRepo.findByEmailAndPwd(email, pwd);

	}

}
