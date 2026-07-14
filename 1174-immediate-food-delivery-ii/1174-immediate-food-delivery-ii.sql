SELECT
ROUND(
    AVG(
        CASE
            WHEN d1.order_date = d1.customer_pref_delivery_date
            THEN 1
            ELSE 0
        END
    ) * 100,
2
) AS immediate_percentage

FROM Delivery d1

JOIN
(
    SELECT
        customer_id,
        MIN(order_date) AS first_order

    FROM Delivery

    GROUP BY customer_id
) d2

ON d1.customer_id = d2.customer_id
AND d1.order_date = d2.first_order;