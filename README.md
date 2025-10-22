# 📌 API 2do parcial de JAVA

Esta API permite gestionar **Profesores**, **Estudiantes** y **Cursos**.

---

## Profesores

**Crear un profesor**  
POST `http://localhost:8080/profesores`  
Body (JSON): { "nombre": "Jorge Martinez", "email": "jorge@mail.com" }

**Listar todos los profesores**  
GET `http://localhost:8080/profesores`

**Listar un profesor por ID**  
GET `http://localhost:8080/profesores/:idProfesor`

---

## Estudiantes

**Crear un estudiante**  
POST `http://localhost:8080/estudiantes`  
Body (JSON): { "nombre": "Carlos Gimenez", "matricula": 1003 }

**Listar todos los estudiantes**  
GET `http://localhost:8080/estudiantes`

**Listar un estudiante por ID**  
GET `http://localhost:8080/estudiantes/:idEstudiante`

---

## Cursos

> Nota: Para crear un curso es obligatorio que exista un profesor previamente.  
> Para asignar estudiantes a un curso, los estudiantes deben haber sido creados antes.

**Crear un curso**  
POST `http://localhost:8080/cursos`  
Body (JSON): { "nombre": "Backend 2", "profesorId": 2 }

**Asignar estudiantes a un curso**  
POST `http://localhost:8080/cursos/:idCurso/asignarEstudiante`  
Body (JSON - array de IDs): [1, 2]

**Listar todos los cursos**  
GET `http://localhost:8080/cursos`

**Traer curso por ID**  
GET `http://localhost:8080/cursos/:idCurso`

**Listar cursos en los que está un estudiante**  
GET `http://localhost:8080/cursos/estudiante/:idEstudiante`

---

### Servidor por defecto

La API corre en: `http://localhost:8080`
