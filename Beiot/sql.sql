use iot;

CREATE TABLE device (
    Id BIGINT AUTO_INCREMENT PRIMARY KEY,
    device_name NVARCHAR(50),
    Action NVARCHAR(10),
    action_time TIME(0),
    action_date DATE  
);

INSERT INTO device (device_name, Action, action_date, action_time)
VALUES
('Light', 'ON', '2024-10-01', '08:30:00'),
('Light', 'OFF', '2024-10-01', '09:30:00'),
('Fan', 'ON', '2024-10-01', '10:00:00'),
('Fan', 'OFF', '2024-10-01', '11:00:00'),
('AC', 'ON', '2024-10-01', '12:00:00'),
('AC', 'OFF', '2024-10-01', '13:00:00'),
('Light', 'ON', '2024-10-02', '08:30:00'),
('Light', 'OFF', '2024-10-02', '09:30:00'),
('Fan', 'ON', '2024-10-02', '10:00:00'),
('Fan', 'OFF', '2024-10-02', '11:00:00'),
('AC', 'ON', '2024-10-02', '12:00:00'),
-- Repeat similar pattern for additional 19 rows
('Light', 'ON', '2024-10-03', '08:30:00'),
('Light', 'OFF', '2024-10-03', '09:30:00'),
('Fan', 'ON', '2024-10-03', '10:00:00'),
('Fan', 'OFF', '2024-10-03', '11:00:00'),
('AC', 'ON', '2024-10-03', '12:00:00'),
('AC', 'OFF', '2024-10-03', '13:00:00'),
('Light', 'ON', '2024-10-04', '08:30:00'),
('Light', 'OFF', '2024-10-04', '09:30:00'),
('Fan', 'ON', '2024-10-04', '10:00:00'),
('Fan', 'OFF', '2024-10-04', '11:00:00'),
('AC', 'ON', '2024-10-04', '12:00:00'),
('AC', 'OFF', '2024-10-04', '13:00:00'),
('Light', 'ON', '2024-10-05', '08:30:00'),
('Light', 'OFF', '2024-10-05', '09:30:00'),
('Fan', 'ON', '2024-10-05', '10:00:00'),
('Fan', 'OFF', '2024-10-05', '11:00:00'),
('AC', 'ON', '2024-10-05', '12:00:00'),
('AC', 'OFF', '2024-10-05', '13:00:00'),
('AC', 'OFF', '2024-10-05', '14:00:00'),
('Light', 'ON', '2024-10-01', '08:30:00'),
('Light', 'OFF', '2024-10-01', '09:30:00'),
('Fan', 'ON', '2024-10-01', '10:00:00'),
('Fan', 'OFF', '2024-10-01', '11:00:00'),
('AC', 'ON', '2024-10-01', '12:00:00'),
('AC', 'OFF', '2024-10-01', '13:00:00'),
('Light', 'ON', '2024-10-02', '08:30:00'),
('Light', 'OFF', '2024-10-02', '09:30:00'),
('Fan', 'ON', '2024-10-02', '10:00:00'),
('Fan', 'OFF', '2024-10-02', '11:00:00'),
('AC', 'ON', '2024-10-02', '12:00:00'),
-- Repeat similar pattern for additional 19 rows
('Light', 'ON', '2024-10-03', '08:30:00'),
('Light', 'OFF', '2024-10-03', '09:30:00'),
('Fan', 'ON', '2024-10-03', '10:00:00'),
('Fan', 'OFF', '2024-10-03', '11:00:00'),
('AC', 'ON', '2024-10-03', '12:00:00'),
('AC', 'OFF', '2024-10-03', '13:00:00'),
('Light', 'ON', '2024-10-04', '08:30:00'),
('Light', 'OFF', '2024-10-04', '09:30:00'),
('Fan', 'ON', '2024-10-04', '10:00:00'),
('Fan', 'OFF', '2024-10-04', '11:00:00'),
('AC', 'ON', '2024-10-04', '12:00:00'),
('AC', 'OFF', '2024-10-04', '13:00:00'),
('Light', 'ON', '2024-10-05', '08:30:00'),
('Light', 'OFF', '2024-10-05', '09:30:00'),
('Fan', 'ON', '2024-10-05', '10:00:00'),
('Fan', 'OFF', '2024-10-05', '11:00:00'),
('AC', 'ON', '2024-10-05', '12:00:00'),
('AC', 'OFF', '2024-10-05', '13:00:00'),
('AC', 'OFF', '2024-10-05', '14:00:00');

CREATE TABLE measurement (
    Id BIGINT AUTO_INCREMENT PRIMARY KEY,
	temperature DECIMAL(4,1),
	bright DECIMAL(4,1),
	humidity DECIMAL(4,1),
    measure_date DATE,
    measure_time TIME(0)
);


INSERT INTO measurement (temperature, bright, humidity, measure_date, measure_time) 
VALUES

(25.6, 300.5, 65.2, '2024-10-01', '10:15:00'),
(22.8, 250.0, 60.1, '2024-10-01', '11:30:00'),
(26.4, 320.0, 68.4, '2024-10-01', '12:45:00'),
(23.0, 270.2, 61.5, '2024-10-01', '14:00:00'),
(27.1, 340.1, 70.0, '2024-10-01', '15:15:00'),
(24.5, 280.7, 63.7, '2024-10-02', '10:15:00'),
(25.3, 295.4, 64.1, '2024-10-02', '11:30:00'),
(28.0, 330.2, 71.2, '2024-10-02', '12:45:00'),
(21.6, 230.3, 59.8, '2024-10-02', '14:00:00'),
(26.7, 305.6, 66.9, '2024-10-02', '15:15:00'),
(23.8, 260.1, 62.4, '2024-10-03', '10:15:00'),
(22.5, 245.5, 60.0, '2024-10-03', '11:30:00'),
(27.4, 315.8, 69.5, '2024-10-03', '12:45:00'),
(24.0, 265.0, 63.0, '2024-10-03', '14:00:00'),
(25.9, 290.3, 65.5, '2024-10-03', '15:15:00'),
(22.9, 255.1, 60.7, '2024-10-04', '10:15:00'),
(23.7, 275.0, 61.3, '2024-10-04', '11:30:00'),
(26.2, 310.5, 67.4, '2024-10-04', '12:45:00'),
(24.2, 265.4, 62.0, '2024-10-04', '14:00:00'),
(27.0, 335.0, 69.9, '2024-10-04', '15:15:00'),
(23.1, 250.7, 61.2, '2024-10-05', '10:15:00'),
(25.0, 285.6, 64.5, '2024-10-05', '11:30:00'),
(28.1, 325.1, 71.6, '2024-10-05', '12:45:00'),
(21.8, 240.9, 59.6, '2024-10-05', '14:00:00'),
(26.5, 300.0, 66.7, '2024-10-05', '15:15:00'),
(23.9, 270.3, 62.5, '2024-10-06', '10:15:00'),
(22.6, 255.8, 60.3, '2024-10-06', '11:30:00'),
(27.3, 320.7, 69.0, '2024-10-06', '12:45:00'),
(24.1, 265.9, 62.9, '2024-10-06', '14:00:00'),
(25.8, 295.2, 65.8, '2024-10-06', '15:15:00'),
(25.8, 295.2, 65.8, '2024-10-06', '15:20:00');

select * from measurement;

SELECT * 
FROM device;
