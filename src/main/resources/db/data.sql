-- -----------------------------------------------------
-- Datos de ejemplo para poblar la base de datos
-- -----------------------------------------------------

-- Datos para la tabla `status`
INSERT INTO `status` (`status_name`) VALUES
('Completado'),
('En Progreso'),
('Planificado');

-- Datos para la tabla `technologies`
INSERT INTO `technologies` (`tech_name`) VALUES
('JavaScript'),
('Python'),
('Java'),
('C#'),
('React'),
('Node.js'),
('Unity'),
('MySQL'),
('MongoDB'),
('HTML/CSS'),
('PHP'),
('Swift'),
('Kotlin'),
('Vue.js'),
('Angular'),
('Express.js'),
('Django'),
('Spring Boot'),
('PostgreSQL'),
('Redis');

-- Datos para la tabla `developers`
INSERT INTO `developers` (`devname`, `dev_surname`, `email`, `linkedin_url`, `github_url`) VALUES
('Ana', 'García López', 'ana.garcia@email.com', 'https://linkedin.com/in/anagarcia', 'https://github.com/anagarcia'),
('Carlos', 'Martínez Ruiz', 'carlos.martinez@email.com', 'https://linkedin.com/in/carlosmartinez', 'https://github.com/carlosmartinez'),
('Elena', 'Rodríguez Santos', 'elena.rodriguez@email.com', 'https://linkedin.com/in/elenarodriguez', 'https://github.com/elenarodriguez'),
('David', 'Fernández Castro', 'david.fernandez@email.com', 'https://linkedin.com/in/davidfernandez', 'https://github.com/davidfernandez'),
('Laura', 'Pérez Mendoza', 'laura.perez@email.com', 'https://linkedin.com/in/lauraperez', 'https://github.com/lauraperez'),
('Miguel', 'Sánchez Ortega', 'miguel.sanchez@email.com', 'https://linkedin.com/in/miguelsanchez', 'https://github.com/miguelsanchez'),
('Sofía', 'Gómez Navarro', 'sofia.gomez@email.com', 'https://linkedin.com/in/sofiagomez', 'https://github.com/sofiagomez'),
('Javier', 'Hernández Díaz', 'javier.hernandez@email.com', 'https://linkedin.com/in/javierhernandez', 'https://github.com/javierhernandez');

-- Datos para la tabla `projects`
INSERT INTO `projects` (`project_name`, `description`, `start_date`, `end_date`, `demo_url`, `picture`, `status_status_id`) VALUES
('E-commerce Platform', 'Plataforma de comercio electrónico con carrito de compras y pasarela de pago', '2024-01-15', '2024-06-20', 'https://demo-ecommerce.example.com', '/images/ecommerce-platform.jpg', 1),
('Health Tracking App', 'Aplicación móvil para seguimiento de salud y ejercicios con estadísticas', '2024-02-01', '2024-08-15', 'https://demo-healthapp.example.com', '/images/health-app.jpg', 2),
('Task Management System', 'Sistema de gestión de tareas con colaboración en equipo y notificaciones', '2024-03-10', '2024-07-30', 'https://demo-tasks.example.com', '/images/task-management.jpg', 2),
('Social Network for Developers', 'Red social especializada para desarrolladores con portfolio integrado', '2024-04-01', '2024-09-30', 'https://demo-devnetwork.example.com', '/images/dev-network.jpg', 2),
('Real Estate Marketplace', 'Marketplace de bienes raíces con búsqueda avanzada y virtual tours', '2024-01-20', '2024-05-15', 'https://demo-realestate.example.com', '/images/real-estate.jpg', 1),
('Learning Management System', 'Sistema de gestión de aprendizaje con cursos online y certificaciones', '2024-05-01', '2024-11-30', 'https://demo-lms.example.com', '/images/lms-platform.jpg', 3),
('Food Delivery Service', 'Servicio de entrega de comida con seguimiento en tiempo real', '2024-02-15', '2024-07-10', 'https://demo-fooddelivery.example.com', '/images/food-delivery.jpg', 1),
('Budget Tracker App', 'Aplicación de seguimiento de gastos personales con informes mensuales', '2024-03-01', '2024-06-25', 'https://demo-budget.example.com', '/images/budget-tracker.jpg', 1);

-- Datos para la tabla `technologies_used_in_projects`
-- E-commerce Platform (ID: 1)
INSERT INTO `technologies_used_in_projects` (`tecnologia_tecnologia_id`, `projects_project_id`) VALUES
(1, 1), (2, 1), (6, 1), (8, 1), (10, 1), (14, 1);

-- Health Tracking App (ID: 2)
INSERT INTO `technologies_used_in_projects` (`tecnologia_tecnologia_id`, `projects_project_id`) VALUES
(4, 2), (7, 2), (12, 2), (13, 2), (19, 2);

-- Task Management System (ID: 3)
INSERT INTO `technologies_used_in_projects` (`tecnologia_tecnologia_id`, `projects_project_id`) VALUES
(1, 3), (5, 3), (6, 3), (9, 3), (16, 3);

-- Social Network for Developers (ID: 4)
INSERT INTO `technologies_used_in_projects` (`tecnologia_tecnologia_id`, `projects_project_id`) VALUES
(1, 4), (3, 4), (5, 4), (8, 4), (18, 4);

-- Real Estate Marketplace (ID: 5)
INSERT INTO `technologies_used_in_projects` (`tecnologia_tecnologia_id`, `projects_project_id`) VALUES
(2, 5), (11, 5), (8, 5), (10, 5), (17, 5);

-- Learning Management System (ID: 6)
INSERT INTO `technologies_used_in_projects` (`tecnologia_tecnologia_id`, `projects_project_id`) VALUES
(1, 6), (5, 6), (6, 6), (8, 6), (15, 6);

-- Food Delivery Service (ID: 7)
INSERT INTO `technologies_used_in_projects` (`tecnologia_tecnologia_id`, `projects_project_id`) VALUES
(4, 7), (7, 7), (12, 7), (13, 7), (20, 7);

-- Budget Tracker App (ID: 8)
INSERT INTO `technologies_used_in_projects` (`tecnologia_tecnologia_id`, `projects_project_id`) VALUES
(1, 8), (5, 8), (6, 8), (9, 8), (14, 8);

-- Datos para la tabla `developers_worked_on_projects`
-- E-commerce Platform (ID: 1)
INSERT INTO `developers_worked_on_projects` (`developer_dev_id`, `projects_project_id`) VALUES
(1, 1), (2, 1), (3, 1);

-- Health Tracking App (ID: 2)
INSERT INTO `developers_worked_on_projects` (`developer_dev_id`, `projects_project_id`) VALUES
(4, 2), (5, 2);

-- Task Management System (ID: 3)
INSERT INTO `developers_worked_on_projects` (`developer_dev_id`, `projects_project_id`) VALUES
(1, 3), (6, 3), (7, 3);

-- Social Network for Developers (ID: 4)
INSERT INTO `developers_worked_on_projects` (`developer_dev_id`, `projects_project_id`) VALUES
(2, 4), (4, 4), (8, 4);

-- Real Estate Marketplace (ID: 5)
INSERT INTO `developers_worked_on_projects` (`developer_dev_id`, `projects_project_id`) VALUES
(3, 5), (5, 5), (7, 5);

-- Learning Management System (ID: 6)
INSERT INTO `developers_worked_on_projects` (`developer_dev_id`, `projects_project_id`) VALUES
(1, 6), (6, 6), (8, 6);

-- Food Delivery Service (ID: 7)
INSERT INTO `developers_worked_on_projects` (`developer_dev_id`, `projects_project_id`) VALUES
(4, 7), (7, 7);

-- Budget Tracker App (ID: 8)
INSERT INTO `developers_worked_on_projects` (`developer_dev_id`, `projects_project_id`) VALUES
(2, 8), (5, 8), (8, 8);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;