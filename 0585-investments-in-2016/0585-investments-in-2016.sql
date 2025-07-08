with temp as(
    select  pid,TIV_2016,
    count(TIV_2015) over(partition by tiv_2015) as count1,
    count(concat(lat,lon)) over(partition by concat(lat,lon)) as location
    from insurance 
)
select round(sum(tiv_2016),2)as tiv_2016 from temp where count1!=1 and location=1 ;