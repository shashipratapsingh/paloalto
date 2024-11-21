package aploAlto.repository;

import aploAlto.Model.EmiCalculate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmiRepository extends JpaRepository<EmiCalculate,Integer> {
}
