package in.ashokit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.Entity.Councellor;

public interface CouncellorRepository extends JpaRepository<Councellor, Integer> {

	public Councellor findByEmailAndPwd(String email, String pwd);

	public Councellor findByEmail(String email);
}
