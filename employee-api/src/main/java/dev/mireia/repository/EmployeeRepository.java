package dev.mireia.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.mireia.model.Employee;

/**
 * Interfaz que gestiona las operaciones con la base de datos para la entidad Employee.
 * Al heredar de JpaRepository, Spring Boot genera automáticamente métodos como:
 * - save() / saveAll() -> para guardar empleados
 * - findAll() -> para obtener todos los empleados
 * - findById() -> para buscar un empleado por su ID
 * - count() -> para saber cuántos empleados hay en la tabla
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // ¡No hace falta escribir código aquí dentro!
    // JpaRepository<Employee, Long> ya nos regala todas las operaciones CRUD básicas
    // indicando que gestiona objetos de tipo 'Employee' cuya clave primaria (@Id) es de tipo 'Long'.
}