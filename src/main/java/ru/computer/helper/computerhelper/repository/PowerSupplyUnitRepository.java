package ru.computer.helper.computerhelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.computer.helper.computerhelper.entity.GPUEntity;
import ru.computer.helper.computerhelper.entity.PowerSupplyUnitEntity;

public interface PowerSupplyUnitRepository extends JpaRepository<PowerSupplyUnitEntity, Long> {
}