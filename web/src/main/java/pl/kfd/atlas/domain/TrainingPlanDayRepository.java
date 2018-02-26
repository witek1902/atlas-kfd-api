package pl.kfd.atlas.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TrainingPlanDayRepository extends JpaRepository<TrainingPlanDay, Long> {
}
