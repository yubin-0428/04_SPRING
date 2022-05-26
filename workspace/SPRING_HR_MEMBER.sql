INSERT INTO hr_member (
    u_id,
    name,
    passwd
) VALUES (
    :v0,
    :v1,
    :v2
);

SELECT *
FROM HR_MEMBER
ORDER BY U_ID;

-- 단건 조회
SELECT
    u_id,
    name,
    passwd
FROM hr_member
WHERE u_id = :USER_ID;

delete from hr_member;

commit;