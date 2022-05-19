package ru.computer.helper.computerhelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.computer.helper.computerhelper.entity.CPUEntity;

public interface CPURepository extends JpaRepository<CPUEntity, Long> {
    CPUEntity findByModel(String model);
}
