INSERT INTO customer (customer_name,username,password,curr_location,created_at) VALUES ('Mahesh','maheshm','$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6',ST_GeomFromText('POINT(10.809003 54.097834)',4326),NOW());

INSERT INTO vehicle (vehicle_type,vehicle_current_location,service_area,vehicle_number,created_at,updated_at) VALUES 
('Sedan',ST_GeomFromText('POINT(10.809003 55.097834)',4326),ST_GeomFromText('POLYGON((1 2, 2 10, 10 55, 55 100, 1 2))',4326),'MH12RL7185',NOW(),NOW());

INSERT INTO vehicle (vehicle_type,vehicle_current_location,service_area,vehicle_number,created_at,updated_at) VALUES 
('Mini',ST_GeomFromText('POINT(10.809003 54.097834)',4326),ST_GeomFromText('POLYGON((1 2, 2 10, 10 55, 55 100, 1 2))',4326),'MH09CC8804',NOW(),NOW());

INSERT INTO booking (customer_id,vehicle_id,pickup_point,drop_point,booking_date_time,is_on_going_ride,created_at) VALUES (1,1,ST_GeomFromText('POINT(10.809003 52.097834)',4326),ST_GeomFromText('POINT(10.809003 54.097834)',4326),NOW(),false,NOW());



