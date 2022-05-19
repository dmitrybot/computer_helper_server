package ru.computer.helper.computerhelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.computer.helper.computerhelper.entity.CPUEntity;
import ru.computer.helper.computerhelper.entity.GPUEntity;

public interface GPURepository extends JpaRepository<GPUEntity, Long> {
    GPUEntity findByModel(String model);
}
