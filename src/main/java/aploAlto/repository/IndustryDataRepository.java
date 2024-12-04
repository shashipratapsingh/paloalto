package aploAlto.repository;

import aploAlto.Model.IndustryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndustryDataRepository extends JpaRepository<IndustryData,Long> {
}
