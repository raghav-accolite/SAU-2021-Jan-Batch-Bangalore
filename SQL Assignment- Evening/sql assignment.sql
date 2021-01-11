create table teams(team_id int,team_name varchar(50));
create table players(player_id int,player_name varchar(50));

create table match_team(match_id int, team1_id int,team2_id int);
create table team_player(match_id int, team_id int,player_id int);
create table match_detail(match_id int,player_id int,team_id int,score int,wicket int);

insert into teams values(1,"india");
insert into teams values(2,"england");
insert into teams values(3,"south africa");

insert into players values(1,"sachin");
insert into players values(2,"Raghav");
insert into players values(3,"Ravi");

insert into players values(4,"jeff");
insert into players values(5,"levie");
insert into players values(6,"john");

insert into players values(7,"devi");
insert into players values(8,"dweayn");
insert into players values(9,"rock");

insert into match_team values(1,1,2);
insert into match_team values(2,2,3);
insert into match_team values(3,1,3);

create table team_player(match_id int, team_id int,player_id int);
insert into team_player values(1,1,1);
insert into team_player values(1,1,2);
insert into team_player values(1,1,3);
insert into team_player values(1,2,4);
insert into team_player values(1,2,5);
insert into team_player values(1,2,6);

insert into match_detail values(1,1,1,100,0);
insert into match_detail values(1,2,1,8,2);
insert into match_detail values(1,3,2,58,1);
insert into match_detail values(1,4,2,10,3);
insert into match_detail values(1,5,1,80,1);
insert into match_detail values(1,6,2,64,1);

insert into match_detail values(2,6,3,15,5);

select player_name from players where player_id in (select player_id from match_detail group by player_id order by sum(score) DESC limit 5);
select player_name from players where player_id in (select player_id from match_detail group by player_id order by sum(wicket) DESC limit 5);

select match_id,team_id,avg(score) from match_detail group by match_id,team_id;
update match_detail set score=score+10 where team_id in (select team_id from match_detail group by team_id order by sum(score) limit 1);

CREATE [OR REPLACE ] PROCEDURE gethighest ( @country varchar(50) ) 
as    
begin
select max(score) from match_detail where team_id in (select team_name from teams where team_name=@country)
end;

execute gethighest("india");


