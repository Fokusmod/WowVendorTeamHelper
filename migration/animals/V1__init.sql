CREATE TABLE IF NOT EXISTS animals (
                        id                          bigserial primary key,
                        username                    varchar(100) not null,
                        view_animal                 varchar(100) not null,
                        date_born                   varchar(100) not null,
                        gender                      varchar(100) not null,
                        nickname                    varchar(100) not null unique ,
                        created_at                  timestamp default current_timestamp,
                        updated_at                  timestamp default current_timestamp
);



INSERT INTO animals (username, view_animal, date_born, gender, nickname) VALUES ('admin','Кот','21-05-2021','муж','Васька'),
                                                                                ('admin','Кот','11-02-2011','муж','Арбузик'),
                                                                                ('admin','Собака','02-03-2008','муж','Рекс'),
                                                                                ('user','Попугай','21-05-2021','муж','Арчи'),
                                                                                ('user','Рыбка','11-03-2001','жен','Голди'),
                                                                                ('user','Змея','13-01-2003','жен','Шипучка'),
                                                                                ('manager','Ящерица','21-05-2021','муж','Flash'),
                                                                                ('manager','кот','25-01-2022','муж','Дымка');