(ns euler.problem2)

;; uses +' to promote to BigInt
(def fib (map first (iterate (fn [[a b]] [b (+' a b)]) [1 2])))

(apply + (filter even? (take-while #(< % 4000000) fib)))