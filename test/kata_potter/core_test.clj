(ns kata-potter.core-test
  (:use midje.sweet)
  (:use [kata-potter.core]))

(facts
  "about descount book prices"
  (fact
    "without books"
    (price []) => 0.0)
  (fact
    "only first book"
    (price [:1st]) => 8.0)
  (fact
    "only second book"
    (price [:2nd]) => 8.0)
  (fact
    "only third book"
    (price [:3rd]) => 8.0)
  (fact
    "only fourth book"
    (price [:4th]) => 8.0)
  (fact
    "only fifth book"
    (price [:5th]) => 8.0)
  (fact
    "two different books"
    (price [:1st :2nd]) => (* 8 2 0.95))
  (fact
    "two same books"
    (price [:2nd :2nd]) => (* 8.0 2))
  (fact
    "multiple different books"
    (price [:1st :1st :2nd :3rd :3rd :4th]) => (+ (* 8 4 0.8) (* 8 2 0.95))
    (price [:1st :2nd :2nd :3rd :4th :5th]) => (+ 8 (* 8 5 0.75)))
  (fact
    "multiple different books with better discounts combining them different"
    (price [:1st :1st :2nd :2nd :3rd :3rd :4th :5th]) => (* 2 (* 8 4 0.8))
    ;(price [:1st :1st :1st :1st :1st
    ;        :2nd :2nd :2nd :2nd :2nd
    ;        :3rd :3rd :3rd :3rd
    ;        :4th :4th :4th :4th :4th
    ;        :5th :5th :5th :5th]) => (+ (* 3 (* 8 5 0.75)) (* 2 (* 8 4 0.8)))
    ))
