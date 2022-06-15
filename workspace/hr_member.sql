SELECT A.*, B.*
FROM(
    SELECT TT1.rnum,
           TT1.u_id,
           TT1.name,
           TT1.passwd,
           TT1.u_level,
           TT1.recommend,
           TT1.email,
           --reg_dt가 당일이면 HH24:MI
           DECODE(TO_CHAR(SYSDATE, 'YYYYMMDD'),TO_CHAR(TT1.reg_dt,'YYYYMMDD')
                  ,TO_CHAR(TT1.reg_dt,'HH24:MI')
                  ,TO_CHAR(TT1.reg_dt,'YYYY-MM-DD')) reg_dt
    FROM(
        SELECT ROWNUM AS RNUM, T1.*
        FROM(
            SELECT *
            FROM hr_member
            --검색조건
            ORDER BY reg_dt DESC
        )T1
        WHERE ROWNUM <= 10
    )TT1
    WHERE rnum >= 1
)A
CROSS JOIN
(
    SELECT COUNT(*) AS totalCnt
    FROM hr_member
    --검색조건
)B
;