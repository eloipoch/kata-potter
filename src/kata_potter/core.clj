(ns kata-potter.core
  (:require [clojure.math.combinatorics :as combo]))

(def ^:private book-price 8)

(def ^:private book-discounts
  {2 5/100
   3 10/100
   4 20/100
   5 25/100})

(defn- possible-combinations [books]
  (letfn [(unique-elems? [coll] (every? #(apply distinct? %) coll))]
    (filter unique-elems? (combo/partitions books))))

(defn- books-discount [books]
  (let [n-books (count books)
        discount (get book-discounts n-books 0)]
    (* n-books discount book-price)))

(defn- calc-discount [books-grouped]
  (double
    (reduce + (map books-discount books-grouped))))

(defn- better-discount [books]
  (apply max (map calc-discount (possible-combinations books))))

(defn price [books]
  (let [books-price (* (count books) book-price)
        better-discount (better-discount books)]
    (- books-price better-discount)))

