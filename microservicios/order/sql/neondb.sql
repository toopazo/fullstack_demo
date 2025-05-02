-- //////////////////////////////////////////
-- Create tables
-- //////////////////////////////////////////


create table menu (
   id         serial primary key,
   name       varchar(255) unique not null,
   created_at timestamp not null default current_timestamp
);

create table dinner_table (
   id         serial primary key,
   capacity   int not null,
   notes      varchar(255),
   created_at timestamp not null default current_timestamp
);

create table dinner_order (
   id         serial primary key,
   menu_id    int not null,
   table_id   int not null,
   menu_count int not null,
   created_at timestamp not null default current_timestamp,
   foreign key ( menu_id )
      references menu ( id ),
   foreign key ( table_id )
      references dinner_table ( id )
);

-- //////////////////////////////////////////
-- Insert data
-- //////////////////////////////////////////

insert into menu (
   name,
   created_at
) values ( 'Papas fritas con pollo al jugo',
           current_timestamp );
insert into menu (
   name,
   created_at
) values ( 'Papas fritas con bistec',
           current_timestamp );
insert into menu (
   name,
   created_at
) values ( 'Ensalada de papas mayo con bistec',
           current_timestamp );


insert into dinner_table (
   capacity,
   notes
) values ( 5,
           'esquina izquierda' );


insert into dinner_order (
   menu_id,
   table_id,
   menu_count
) values ( 2,
           1,
           5 );


-- //////////////////////////////////////////
-- Read data
-- //////////////////////////////////////////


select *
  from user_tables;

select *
  from menu;

select *
  from dinner_table;

select *
  from dinner_order;


select *
  from menu
 where name like '%Papas%'
    or name like '%papas%';

desc menu;


  

-- """
-- Script para definir los servicios básicos de la db
-- """

-- # import json
-- # from datetime import datetime
-- from psycopg2.extras import execute_values


-- def create_table_video(connection):
--     with connection.cursor() as cursor:
--         query = """
--         CREATE TABLE video(
--             id SERIAL PRIMARY KEY,
--             name VARCHAR (255) UNIQUE NOT NULL,
--             path VARCHAR (255) UNIQUE NOT NULL,
--             created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
--         );
--         """
--         cursor.execute(query)
--         connection.commit()


-- def create_table_frame(connection):
--     with connection.cursor() as cursor:
--         query = """
--         CREATE TABLE frame(
--             id SERIAL PRIMARY KEY,
--             video_id INT NOT NULL,
--             count INT NOT NULL,
--             path VARCHAR (255) UNIQUE NOT NULL,
--             FOREIGN KEY (video_id) REFERENCES video(id)
--         );
--         """
--         cursor.execute(query)
--         connection.commit()


-- def create_table_inference(connection):
--     with connection.cursor() as cursor:
--         query = """
--         CREATE TABLE inference(
--             id SERIAL PRIMARY KEY,
--             frame_id INT NOT NULL,
--             bbox TEXT,
--             kps TEXT,
--             det_score FLOAT,
--             landmark_3d_68 TEXT,
--             pose TEXT,
--             landmark_2d_106 TEXT,
--             gender INT,
--             age INT,
--             embedding TEXT,
--             FOREIGN KEY (frame_id) REFERENCES frame(id)
--         );
--         """
--         cursor.execute(query)
--         connection.commit()


-- def create_table_sequence(connection):
--     with connection.cursor() as cursor:
--         query = """
--         CREATE TABLE sequence(
--             id SERIAL PRIMARY KEY,
--             frame_id INT NOT NULL,
--             inference_id INT NOT NULL,
--             name VARCHAR (255) NOT NULL,
--             FOREIGN KEY (frame_id) REFERENCES frame(id),
--             FOREIGN KEY (inference_id) REFERENCES inference(id)
--         );
--         """
--         cursor.execute(query)
--         connection.commit()


-- def insert_data_video(connection, row_list: list):
--     with connection.cursor() as cursor:
--         data_to_insert = []

--         for row in row_list:
--             data_to_insert.append(
--                 (
--                     row[0],  # name
--                     row[1],  # path
--                 )
--             )

--         query = """
--             INSERT INTO video (
--                 name, path
--             ) VALUES %s
--         """

--         execute_values(cursor, query, data_to_insert)
--         connection.commit()


-- def get_id_video_by_row(connection, row_list: list):
--     with connection.cursor() as cursor:
--         res_list = []
--         for row in row_list:
--             query = (
--                 f"SELECT id FROM video WHERE name = '{row[0]}' AND path = '{row[1]}';"
--             )
--             cursor.execute(query)
--             res = cursor.fetchall()
--             # print(res)
--             # [(1,)]
--             if len(res) > 0:
--                 res = int(res[0][0])
--                 res_list.append(res)
--     return res_list


-- def insert_data_frame(connection, row_list: list):
--     with connection.cursor() as cursor:
--         data_to_insert = []

--         for row in row_list:
--             data_to_insert.append(
--                 (
--                     row[0],  # video_id,
--                     row[1],  # count,
--                     row[2],  # path,
--                 )
--             )

--         query = """
--             INSERT INTO frame (
--                 video_id, count, path
--             ) VALUES %s
--         """

--         execute_values(cursor, query, data_to_insert)
--         connection.commit()


-- def get_id_frame_by_row(connection, row_list: list):
--     with connection.cursor() as cursor:
--         res_list = []
--         for row in row_list:
--             query = """
--                 SELECT id FROM frame
--                 WHERE
--                     video_id = %s AND
--                     count = %s AND
--                     path = %s;
--             """
--             cursor.execute(query, row)
--             res = cursor.fetchall()
--             # print(res)
--             # [(1,)]
--             if len(res) > 0:
--                 res = int(res[0][0])
--                 res_list.append(res)
--     return res_list


-- # def select_ident_current(connection, table: str):
-- #     with connection.cursor() as cursor:
-- #         query = f"SELECT IDENT_CURRENT('{table}') AS result FROM {table};"
-- #         cursor.execute(query)
-- #         row = cursor.fetchall()
-- #         # print(f"row {row}")
-- #         id = row[0]
-- #         return id


-- def insert_data_inference(connection, row_list: list):
--     with connection.cursor() as cursor:
--         data_to_insert = []

--         for row in row_list:
--             data_to_insert.append(
--                 (
--                     row[0],  # frame_id
--                     row[1],  # bbox,
--                     row[2],  # kps,
--                     row[3],  # det_score,
--                     row[4],  # landmark_3d_68,
--                     row[5],  # pose,
--                     row[6],  # landmark_2d_106,
--                     row[7],  # gender,
--                     row[8],  # age,
--                     row[9],  # embedding
--                 )
--             )

--         query = """
--             INSERT INTO inference (
--                 frame_id, bbox, kps, det_score, landmark_3d_68, pose, landmark_2d_106, gender, age, embedding
--             ) VALUES %s
--         """

--         execute_values(cursor, query, data_to_insert)
--         connection.commit()


-- def get_id_inference_by_row(connection, row_list: list):
--     with connection.cursor() as cursor:
--         res_list = []
--         for row in row_list:
--             query = """
--                 SELECT id FROM inference
--                 WHERE
--                     frame_id = %s AND
--                     bbox = %s AND
--                     kps = %s AND
--                     det_score = %s AND
--                     landmark_3d_68 = %s AND
--                     pose = %s AND
--                     landmark_2d_106 = %s AND
--                     gender = %s AND
--                     age = %s AND
--                     embedding = %s;
--             """
--             cursor.execute(query, row)
--             res = cursor.fetchall()
--             # print(res)
--             # [(1,)]
--             if len(res) > 0:
--                 res = int(res[0][0])
--                 res_list.append(res)
--     return res_list


-- def get_data_inference_by_id(connection, row_list: list):
--     with connection.cursor() as cursor:
--         res_list = []
--         for row in row_list:
--             query = """
--                 SELECT * FROM inference
--                 WHERE
--                     id = %s;
--             """
--             cursor.execute(query, row)
--             res = cursor.fetchall()
--             # print(res)
--             # [(1,)]
--             # if len(res) > 0:
--             #     res = int(res[0][0])
--             #     id_list.append(res)
--             res_list.append(res)
--     return res_list


-- def insert_data_sequence(connection, row_list: list):
--     with connection.cursor() as cursor:
--         data_to_insert = []

--         for row in row_list:
--             data_to_insert.append(
--                 (
--                     row[0],  # frame_id
--                     row[1],  # inference_id,
--                     row[2],  # name
--                 )
--             )

--         query = """
--             INSERT INTO sequence (
--                 frame_id, inference_id, name
--             ) VALUES %s
--         """

--         execute_values(cursor, query, data_to_insert)
--         connection.commit()


-- def get_data_sequence_by_name(connection, row_list: list):
--     with connection.cursor() as cursor:
--         id_list = []
--         for row in row_list:
--             query = """
--                 SELECT * FROM sequence
--                 WHERE
--                     name = %s;
--             """
--             cursor.execute(query, row)
--             res = cursor.fetchall()
--             # print(res)
--             # [(1,)]
--             # if len(res) > 0:
--             #     res = int(res[0][0])
--             #     id_list.append(res)
--             id_list.append(res)
--     return id_list


-- def get_available_sequence(connection, row_list: list):
--     with connection.cursor() as cursor:
--         res_list = []
--         for row in row_list:
--             query = """
--                 SELECT DISTINCT name
--                 FROM sequence;
--             """
--             cursor.execute(query, row)
--             res = cursor.fetchall()
--             # print(res)
--             # [(1,)]
--             # if len(res) > 0:
--             #     res = int(res[0][0])
--             #     id_list.append(res)
--             res_list.append(res)
--     return res_list