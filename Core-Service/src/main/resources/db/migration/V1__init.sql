CREATE TABLE IF NOT EXISTS teams (
                        id                       bigserial primary key,
                        title                    varchar(50) not null
);

INSERT INTO teams (title) VALUES ('eu-team'),
                                 ('rv-team'),
                                 ('us-dt-team'),
                                 ('us-nt1-team'),
                                 ('us-nt2-team');